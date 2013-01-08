package com.drewblessing.googletasks.portlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.drewblessing.googletasks.NoSuchPortletCredentialException;
import com.drewblessing.googletasks.model.PortletCredential;
import com.drewblessing.googletasks.portlet.util.PortletConstants;
import com.drewblessing.googletasks.portlet.util.PropsValues;
import com.drewblessing.googletasks.service.PortletCredentialLocalServiceUtil;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.GoogleUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleRefreshTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class GoogleTasks extends MVCPortlet {
	public static void authorize(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws IOException {
			// Get current URL and trim off any params
			String currentUrl = PortalUtil.getCurrentURL(actionRequest);
			String currentUrlTrimmed = currentUrl.substring(0,currentUrl.indexOf("?"));
			
			String callbackUrl = PortalUtil.getPortalURL(actionRequest) + PortletConstants.CALLBACK_PATH;
			
			String url = new GoogleAuthorizationCodeRequestUrl(
					PropsValues.GOOGLE_TASKS_OAUTH_CLIENT_ID, callbackUrl, 
					Arrays.asList(
			        	"https://www.googleapis.com/auth/tasks",
			        	"https://www.googleapis.com/auth/userinfo.profile",
			        	"https://www.googleapis.com/auth/userinfo.email")
			        ).setState(currentUrlTrimmed).setAccessType("offline")
			        .setApprovalPrompt("auto").build();
			
			actionResponse.sendRedirect(url);
		}
		
		private static PortletCredential refreshCredential(
				long userId, PortletCredential credential) {
			HttpTransport transport = new NetHttpTransport();
		    JacksonFactory jsonFactory = new JacksonFactory();
		    GoogleTokenResponse tokenResponse = null;
			try {
				tokenResponse = new GoogleRefreshTokenRequest(
						transport, jsonFactory, credential.getRefreshToken(), 
						"952031463655-io2h951ruhb7806nu4cndbd7h13kp7sd.apps.googleusercontent.com", 
						"pE5MW-q1klNWHS38yY0U8sVx").execute();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// TODO: Make a method to get GoogleCredential from PortletCredential
			if (Validator.isNotNull(tokenResponse)) {
				Credential googleCredential = new GoogleCredential.Builder()
				.setClientSecrets("952031463655-io2h951ruhb7806nu4cndbd7h13kp7sd.apps.googleusercontent.com", 
						"pE5MW-q1klNWHS38yY0U8sVx")
				.setJsonFactory(jsonFactory).setTransport(transport).build()
		        .setAccessToken(tokenResponse.getAccessToken()).setRefreshToken(tokenResponse.getRefreshToken())
		        .setExpiresInSeconds(tokenResponse.getExpiresInSeconds());
				
				try {
					return PortletCredentialLocalServiceUtil.updateCredential(
							credential.getId(), credential.getGoogleId(), userId, credential.getUserPicture(),
							googleCredential.getAccessToken(), googleCredential.getExpirationTimeMilliseconds());
				} catch (SystemException e) {
					e.printStackTrace();
				} catch (NoSuchPortletCredentialException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			return null;
		}
		
		public static void revokeGoogleToken(ActionRequest actionRequest, ActionResponse actionResponse) {
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			String token = ParamUtil.getString(actionRequest, "token");
			HttpTransport transport = new NetHttpTransport();
			
	        GoogleUrl url = new GoogleUrl("https://accounts.google.com/o/oauth2/revoke?token=" + token);
	        HttpRequest request = null;
	        HttpResponse response = null;
			try {
				request = transport.createRequestFactory().buildGetRequest(url);
		        response = request.execute();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Remove from our store
			//if (response.getStatusCode())
			try {
				PortletCredentialLocalServiceUtil.deleteCredential(userId, themeDisplay.getCompanyId(), token);
			} catch (NoSuchPortletCredentialException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Response: " + response.getStatusCode());
		}
		
		public static PortletCredential getPortletCredential(
				PortletRequest request, PortletResponse response) {
			Date date = new Date();
		    long currentTime = date.getTime();
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			List<PortletCredential> portletCredentials = null;
			PortletCredential portletCredential = null;
			
			try {
				portletCredentials = PortletCredentialLocalServiceUtil.getCredentialByCompanyIdAndUserId(
						themeDisplay.getCompanyId(), userId);

				// Refresh credentials if access token has expired
				if (portletCredentials.size() == 1) {
					if((currentTime > portletCredentials.get(0).getExpires()) 
						&& (Validator.isNotNull(portletCredentials.get(0).getRefreshToken()))) {
						portletCredential = refreshCredential(userId, portletCredentials.get(0));
					} else {
						portletCredential = portletCredentials.get(0);
					}
				}
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return portletCredential; 
		}
		
		public static Credential getGoogleCredentialFromPortletCredential(PortletCredential portletCredential) {
			HttpTransport transport = new NetHttpTransport();
		    JacksonFactory jsonFactory = new JacksonFactory();
		    
			if (Validator.isNotNull(portletCredential) &&
					Validator.isNotNull(portletCredential.getAccessToken())) {
				return new GoogleCredential.Builder().setClientSecrets(
						PropsValues.GOOGLE_TASKS_OAUTH_CLIENT_ID, PropsValues.GOOGLE_TASKS_OAUTH_CLIENT_SECRET
					).setJsonFactory(jsonFactory).setTransport(transport).build()
			        .setAccessToken(portletCredential.getAccessToken()).setRefreshToken(portletCredential.getRefreshToken())
			        .setExpiresInSeconds(portletCredential.getExpires());
			}		
			return null;
		}
}
