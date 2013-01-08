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

package com.drewblessing.googletasks.model.impl;

import com.drewblessing.googletasks.model.PortletCredential;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing PortletCredential in entity cache.
 *
 * @author Drew A. Blessing
 * @see PortletCredential
 * @generated
 */
public class PortletCredentialCacheModel implements CacheModel<PortletCredential>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", googleId=");
		sb.append(googleId);
		sb.append(", userEmail=");
		sb.append(userEmail);
		sb.append(", userPicture=");
		sb.append(userPicture);
		sb.append(", accessToken=");
		sb.append(accessToken);
		sb.append(", refreshToken=");
		sb.append(refreshToken);
		sb.append(", expires=");
		sb.append(expires);
		sb.append("}");

		return sb.toString();
	}

	public PortletCredential toEntityModel() {
		PortletCredentialImpl portletCredentialImpl = new PortletCredentialImpl();

		portletCredentialImpl.setId(id);
		portletCredentialImpl.setCompanyId(companyId);
		portletCredentialImpl.setUserId(userId);

		if (userName == null) {
			portletCredentialImpl.setUserName(StringPool.BLANK);
		}
		else {
			portletCredentialImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			portletCredentialImpl.setCreateDate(null);
		}
		else {
			portletCredentialImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			portletCredentialImpl.setModifiedDate(null);
		}
		else {
			portletCredentialImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (googleId == null) {
			portletCredentialImpl.setGoogleId(StringPool.BLANK);
		}
		else {
			portletCredentialImpl.setGoogleId(googleId);
		}

		if (userEmail == null) {
			portletCredentialImpl.setUserEmail(StringPool.BLANK);
		}
		else {
			portletCredentialImpl.setUserEmail(userEmail);
		}

		if (userPicture == null) {
			portletCredentialImpl.setUserPicture(StringPool.BLANK);
		}
		else {
			portletCredentialImpl.setUserPicture(userPicture);
		}

		if (accessToken == null) {
			portletCredentialImpl.setAccessToken(StringPool.BLANK);
		}
		else {
			portletCredentialImpl.setAccessToken(accessToken);
		}

		if (refreshToken == null) {
			portletCredentialImpl.setRefreshToken(StringPool.BLANK);
		}
		else {
			portletCredentialImpl.setRefreshToken(refreshToken);
		}

		portletCredentialImpl.setExpires(expires);

		portletCredentialImpl.resetOriginalValues();

		return portletCredentialImpl;
	}

	public long id;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String googleId;
	public String userEmail;
	public String userPicture;
	public String accessToken;
	public String refreshToken;
	public long expires;
}