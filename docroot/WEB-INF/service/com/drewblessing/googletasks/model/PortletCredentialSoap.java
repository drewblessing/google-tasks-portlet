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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Drew A. Blessing
 * @generated
 */
public class PortletCredentialSoap implements Serializable {
	public static PortletCredentialSoap toSoapModel(PortletCredential model) {
		PortletCredentialSoap soapModel = new PortletCredentialSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGoogleId(model.getGoogleId());
		soapModel.setUserEmail(model.getUserEmail());
		soapModel.setUserPicture(model.getUserPicture());
		soapModel.setAccessToken(model.getAccessToken());
		soapModel.setRefreshToken(model.getRefreshToken());
		soapModel.setExpires(model.getExpires());

		return soapModel;
	}

	public static PortletCredentialSoap[] toSoapModels(
		PortletCredential[] models) {
		PortletCredentialSoap[] soapModels = new PortletCredentialSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortletCredentialSoap[][] toSoapModels(
		PortletCredential[][] models) {
		PortletCredentialSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortletCredentialSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortletCredentialSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortletCredentialSoap[] toSoapModels(
		List<PortletCredential> models) {
		List<PortletCredentialSoap> soapModels = new ArrayList<PortletCredentialSoap>(models.size());

		for (PortletCredential model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortletCredentialSoap[soapModels.size()]);
	}

	public PortletCredentialSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	private long _id;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _googleId;
	private String _userEmail;
	private String _userPicture;
	private String _accessToken;
	private String _refreshToken;
	private long _expires;
}