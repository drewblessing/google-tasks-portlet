/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.drewblessing.googletasks.service.impl;

import java.util.Date;
import java.util.List;

import com.drewblessing.googletasks.NoSuchPortletCredentialException;
import com.drewblessing.googletasks.model.PortletCredential;
import com.drewblessing.googletasks.service.base.PortletCredentialLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

/**
 * The implementation of the portlet credential local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.drewblessing.googletasks.service.PortletCredentialLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Drew A. Blessing
 * @see com.drewblessing.googletasks.service.base.PortletCredentialLocalServiceBaseImpl
 * @see com.drewblessing.googletasks.service.PortletCredentialLocalServiceUtil
 */
public class PortletCredentialLocalServiceImpl
	extends PortletCredentialLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.drewblessing.googletasks.service.PortletCredentialLocalServiceUtil} to access the portlet credential local service.
	 */
	public PortletCredential addCredential(String googleId, long userId, String email, String picture,
			String accessToken, String refreshToken, long expires) throws SystemException {
		User user = userPersistence.fetchByPrimaryKey(userId);
		long id = counterLocalService.increment();
		PortletCredential credential = portletCredentialPersistence.create(id);
		
		Date date = new Date();
		
		credential.setCompanyId(user.getCompanyId());
		credential.setUserId(userId);
		credential.setUserName(user.getFullName());
		credential.setCreateDate(date);
		credential.setModifiedDate(date);
		
		credential.setGoogleId(googleId);
		credential.setUserEmail(email);
		credential.setUserPicture(picture);
		credential.setAccessToken(accessToken);
		credential.setRefreshToken(refreshToken);
		credential.setExpires(expires);
		
		return portletCredentialPersistence.update(credential, false);
	}
	
	public PortletCredential updateCredential(long credentialId, String googleId, long userId, String picture,
			String accessToken, long expires) 
			throws SystemException, NoSuchPortletCredentialException {
		User user = userPersistence.fetchByPrimaryKey(userId);
		
		PortletCredential credential = portletCredentialPersistence.fetchByPrimaryKey(credentialId);
		Date date = new Date();
		
		credential.setUserId(userId);
		credential.setUserName(user.getFullName());
		credential.setModifiedDate(date);
		
		credential.setUserPicture(picture);
		credential.setAccessToken(accessToken);
		credential.setExpires(expires);
		
		return portletCredentialPersistence.update(credential, true);
	}
	
	public PortletCredential deleteCredential(long userId, long companyId, String token)
			throws SystemException, NoSuchPortletCredentialException {
		List<PortletCredential> credentials = 
				portletCredentialPersistence.findByCompanyIdAndUserId(companyId, userId);
		boolean match = false;
		
		for (PortletCredential credential : credentials) {
			if (credential.getAccessToken().equals(token)) {
				match = true;
				portletCredentialPersistence.remove(credential);
				return credential;
			}
		}
		if (!match) {
			throw new NoSuchPortletCredentialException();
		}
		return null;
	}
	
	public List<PortletCredential> getCredentialByCompanyIdAndUserId(long companyId, long userId) 
			throws SystemException {
		return portletCredentialPersistence.findByCompanyIdAndUserId(companyId, userId);
	}
}