package com.drewblessing.googletasks.hook.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drewblessing.googletasks.portlet.util.PortletConstants;
import com.drewblessing.googletasks.portlet.util.PropsValues;
import com.drewblessing.googletasks.service.PortletCredentialLocalServiceUtil;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfo;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PortalUtil;

public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		// Not Applicable

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpTransport transport = new NetHttpTransport();
	    JacksonFactory jsonFactory = new JacksonFactory();
	    Long userId = (Long)request.getAttribute(WebKeys.USER_ID);
		String url = request.getParameter("state");
		String code = request.getParameter("code");
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		if (request instanceof HttpServletRequest) {
			httpRequest = (HttpServletRequest)request;
		}
		if (response instanceof HttpServletResponse) {
			httpResponse = (HttpServletResponse)response;
		}
		
		String callbackUrl = PortalUtil.getPortalURL(httpRequest) + PortletConstants.CALLBACK_PATH;
		
		GoogleTokenResponse tokenResponse =
		        new GoogleAuthorizationCodeTokenRequest(transport, jsonFactory, 
		        		PropsValues.GOOGLE_TASKS_OAUTH_CLIENT_ID, PropsValues.GOOGLE_TASKS_OAUTH_CLIENT_SECRET,
		        		code, callbackUrl
		        ).execute();
		
		// Turn info into credential object.  Helps us get back expires in epoch
		Credential credential = new GoogleCredential.Builder().setClientSecrets(
					PropsValues.GOOGLE_TASKS_OAUTH_CLIENT_ID, PropsValues.GOOGLE_TASKS_OAUTH_CLIENT_SECRET
				).setJsonFactory(jsonFactory).setTransport(transport).build()
		        .setAccessToken(tokenResponse.getAccessToken()).setRefreshToken(tokenResponse.getRefreshToken())
		        .setExpiresInSeconds(tokenResponse.getExpiresInSeconds());
		
		Userinfo userinfo = getUserInfo(credential);
		
		// Persist auth info
		// TODO: Check if exists first
		try {
			PortletCredentialLocalServiceUtil.addCredential(
					userinfo.getId(), userId.longValue(), userinfo.getEmail(), 
					userinfo.getPicture(), credential.getAccessToken(), credential.getRefreshToken(), 
					credential.getExpirationTimeMilliseconds());
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		httpResponse.sendRedirect(url);		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// Not applicable
	}

	public AuthenticationFilter() {
		super();
	}
	
	static Userinfo getUserInfo(Credential credential) {
	    Oauth2 userInfoService =
	        new Oauth2.Builder(new NetHttpTransport(), new JacksonFactory(), credential).build();
	    Userinfo userInfo = null;
	    try {
	      userInfo = userInfoService.userinfo().get().execute();
	    } catch (IOException e) {
	      System.err.println("An error occurred: " + e);
	    }
	    if (userInfo != null && userInfo.getId() != null) {
	      return userInfo;
	    } else {
	      return null;
	      //throw new NoUserIdException();
	    }
	  }
}
