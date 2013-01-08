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

package com.drewblessing.googletasks.model;

import com.drewblessing.googletasks.service.PortletCredentialLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Drew A. Blessing
 */
public class PortletCredentialClp extends BaseModelImpl<PortletCredential>
	implements PortletCredential {
	public PortletCredentialClp() {
	}

	public Class<?> getModelClass() {
		return PortletCredential.class;
	}

	public String getModelClassName() {
		return PortletCredential.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("googleId", getGoogleId());
		attributes.put("userEmail", getUserEmail());
		attributes.put("userPicture", getUserPicture());
		attributes.put("accessToken", getAccessToken());
		attributes.put("refreshToken", getRefreshToken());
		attributes.put("expires", getExpires());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String googleId = (String)attributes.get("googleId");

		if (googleId != null) {
			setGoogleId(googleId);
		}

		String userEmail = (String)attributes.get("userEmail");

		if (userEmail != null) {
			setUserEmail(userEmail);
		}

		String userPicture = (String)attributes.get("userPicture");

		if (userPicture != null) {
			setUserPicture(userPicture);
		}

		String accessToken = (String)attributes.get("accessToken");

		if (accessToken != null) {
			setAccessToken(accessToken);
		}

		String refreshToken = (String)attributes.get("refreshToken");

		if (refreshToken != null) {
			setRefreshToken(refreshToken);
		}

		Long expires = (Long)attributes.get("expires");

		if (expires != null) {
			setExpires(expires);
		}
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getGoogleId() {
		return _googleId;
	}

	public void setGoogleId(String googleId) {
		_googleId = googleId;
	}

	public String getUserEmail() {
		return _userEmail;
	}

	public void setUserEmail(String userEmail) {
		_userEmail = userEmail;
	}

	public String getUserPicture() {
		return _userPicture;
	}

	public void setUserPicture(String userPicture) {
		_userPicture = userPicture;
	}

	public String getAccessToken() {
		return _accessToken;
	}

	public void setAccessToken(String accessToken) {
		_accessToken = accessToken;
	}

	public String getRefreshToken() {
		return _refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		_refreshToken = refreshToken;
	}

	public long getExpires() {
		return _expires;
	}

	public void setExpires(long expires) {
		_expires = expires;
	}

	public BaseModel<?> getPortletCredentialRemoteModel() {
		return _portletCredentialRemoteModel;
	}

	public void setPortletCredentialRemoteModel(
		BaseModel<?> portletCredentialRemoteModel) {
		_portletCredentialRemoteModel = portletCredentialRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PortletCredentialLocalServiceUtil.addPortletCredential(this);
		}
		else {
			PortletCredentialLocalServiceUtil.updatePortletCredential(this);
		}
	}

	@Override
	public PortletCredential toEscapedModel() {
		return (PortletCredential)Proxy.newProxyInstance(PortletCredential.class.getClassLoader(),
			new Class[] { PortletCredential.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortletCredentialClp clone = new PortletCredentialClp();

		clone.setId(getId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setGoogleId(getGoogleId());
		clone.setUserEmail(getUserEmail());
		clone.setUserPicture(getUserPicture());
		clone.setAccessToken(getAccessToken());
		clone.setRefreshToken(getRefreshToken());
		clone.setExpires(getExpires());

		return clone;
	}

	public int compareTo(PortletCredential portletCredential) {
		int value = 0;

		if (getUserId() < portletCredential.getUserId()) {
			value = -1;
		}
		else if (getUserId() > portletCredential.getUserId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		PortletCredentialClp portletCredential = null;

		try {
			portletCredential = (PortletCredentialClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = portletCredential.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", googleId=");
		sb.append(getGoogleId());
		sb.append(", userEmail=");
		sb.append(getUserEmail());
		sb.append(", userPicture=");
		sb.append(getUserPicture());
		sb.append(", accessToken=");
		sb.append(getAccessToken());
		sb.append(", refreshToken=");
		sb.append(getRefreshToken());
		sb.append(", expires=");
		sb.append(getExpires());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.drewblessing.googletasks.model.PortletCredential");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>googleId</column-name><column-value><![CDATA[");
		sb.append(getGoogleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userEmail</column-name><column-value><![CDATA[");
		sb.append(getUserEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userPicture</column-name><column-value><![CDATA[");
		sb.append(getUserPicture());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessToken</column-name><column-value><![CDATA[");
		sb.append(getAccessToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>refreshToken</column-name><column-value><![CDATA[");
		sb.append(getRefreshToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expires</column-name><column-value><![CDATA[");
		sb.append(getExpires());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _googleId;
	private String _userEmail;
	private String _userPicture;
	private String _accessToken;
	private String _refreshToken;
	private long _expires;
	private BaseModel<?> _portletCredentialRemoteModel;
}