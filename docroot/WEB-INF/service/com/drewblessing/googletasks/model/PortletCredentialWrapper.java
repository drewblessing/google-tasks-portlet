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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PortletCredential}.
 * </p>
 *
 * @author    Drew A. Blessing
 * @see       PortletCredential
 * @generated
 */
public class PortletCredentialWrapper implements PortletCredential,
	ModelWrapper<PortletCredential> {
	public PortletCredentialWrapper(PortletCredential portletCredential) {
		_portletCredential = portletCredential;
	}

	public Class<?> getModelClass() {
		return PortletCredential.class;
	}

	public String getModelClassName() {
		return PortletCredential.class.getName();
	}

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

	/**
	* Returns the primary key of this portlet credential.
	*
	* @return the primary key of this portlet credential
	*/
	public long getPrimaryKey() {
		return _portletCredential.getPrimaryKey();
	}

	/**
	* Sets the primary key of this portlet credential.
	*
	* @param primaryKey the primary key of this portlet credential
	*/
	public void setPrimaryKey(long primaryKey) {
		_portletCredential.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this portlet credential.
	*
	* @return the ID of this portlet credential
	*/
	public long getId() {
		return _portletCredential.getId();
	}

	/**
	* Sets the ID of this portlet credential.
	*
	* @param id the ID of this portlet credential
	*/
	public void setId(long id) {
		_portletCredential.setId(id);
	}

	/**
	* Returns the company ID of this portlet credential.
	*
	* @return the company ID of this portlet credential
	*/
	public long getCompanyId() {
		return _portletCredential.getCompanyId();
	}

	/**
	* Sets the company ID of this portlet credential.
	*
	* @param companyId the company ID of this portlet credential
	*/
	public void setCompanyId(long companyId) {
		_portletCredential.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this portlet credential.
	*
	* @return the user ID of this portlet credential
	*/
	public long getUserId() {
		return _portletCredential.getUserId();
	}

	/**
	* Sets the user ID of this portlet credential.
	*
	* @param userId the user ID of this portlet credential
	*/
	public void setUserId(long userId) {
		_portletCredential.setUserId(userId);
	}

	/**
	* Returns the user uuid of this portlet credential.
	*
	* @return the user uuid of this portlet credential
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portletCredential.getUserUuid();
	}

	/**
	* Sets the user uuid of this portlet credential.
	*
	* @param userUuid the user uuid of this portlet credential
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_portletCredential.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this portlet credential.
	*
	* @return the user name of this portlet credential
	*/
	public java.lang.String getUserName() {
		return _portletCredential.getUserName();
	}

	/**
	* Sets the user name of this portlet credential.
	*
	* @param userName the user name of this portlet credential
	*/
	public void setUserName(java.lang.String userName) {
		_portletCredential.setUserName(userName);
	}

	/**
	* Returns the create date of this portlet credential.
	*
	* @return the create date of this portlet credential
	*/
	public java.util.Date getCreateDate() {
		return _portletCredential.getCreateDate();
	}

	/**
	* Sets the create date of this portlet credential.
	*
	* @param createDate the create date of this portlet credential
	*/
	public void setCreateDate(java.util.Date createDate) {
		_portletCredential.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this portlet credential.
	*
	* @return the modified date of this portlet credential
	*/
	public java.util.Date getModifiedDate() {
		return _portletCredential.getModifiedDate();
	}

	/**
	* Sets the modified date of this portlet credential.
	*
	* @param modifiedDate the modified date of this portlet credential
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_portletCredential.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the google ID of this portlet credential.
	*
	* @return the google ID of this portlet credential
	*/
	public java.lang.String getGoogleId() {
		return _portletCredential.getGoogleId();
	}

	/**
	* Sets the google ID of this portlet credential.
	*
	* @param googleId the google ID of this portlet credential
	*/
	public void setGoogleId(java.lang.String googleId) {
		_portletCredential.setGoogleId(googleId);
	}

	/**
	* Returns the user email of this portlet credential.
	*
	* @return the user email of this portlet credential
	*/
	public java.lang.String getUserEmail() {
		return _portletCredential.getUserEmail();
	}

	/**
	* Sets the user email of this portlet credential.
	*
	* @param userEmail the user email of this portlet credential
	*/
	public void setUserEmail(java.lang.String userEmail) {
		_portletCredential.setUserEmail(userEmail);
	}

	/**
	* Returns the user picture of this portlet credential.
	*
	* @return the user picture of this portlet credential
	*/
	public java.lang.String getUserPicture() {
		return _portletCredential.getUserPicture();
	}

	/**
	* Sets the user picture of this portlet credential.
	*
	* @param userPicture the user picture of this portlet credential
	*/
	public void setUserPicture(java.lang.String userPicture) {
		_portletCredential.setUserPicture(userPicture);
	}

	/**
	* Returns the access token of this portlet credential.
	*
	* @return the access token of this portlet credential
	*/
	public java.lang.String getAccessToken() {
		return _portletCredential.getAccessToken();
	}

	/**
	* Sets the access token of this portlet credential.
	*
	* @param accessToken the access token of this portlet credential
	*/
	public void setAccessToken(java.lang.String accessToken) {
		_portletCredential.setAccessToken(accessToken);
	}

	/**
	* Returns the refresh token of this portlet credential.
	*
	* @return the refresh token of this portlet credential
	*/
	public java.lang.String getRefreshToken() {
		return _portletCredential.getRefreshToken();
	}

	/**
	* Sets the refresh token of this portlet credential.
	*
	* @param refreshToken the refresh token of this portlet credential
	*/
	public void setRefreshToken(java.lang.String refreshToken) {
		_portletCredential.setRefreshToken(refreshToken);
	}

	/**
	* Returns the expires of this portlet credential.
	*
	* @return the expires of this portlet credential
	*/
	public long getExpires() {
		return _portletCredential.getExpires();
	}

	/**
	* Sets the expires of this portlet credential.
	*
	* @param expires the expires of this portlet credential
	*/
	public void setExpires(long expires) {
		_portletCredential.setExpires(expires);
	}

	public boolean isNew() {
		return _portletCredential.isNew();
	}

	public void setNew(boolean n) {
		_portletCredential.setNew(n);
	}

	public boolean isCachedModel() {
		return _portletCredential.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_portletCredential.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _portletCredential.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _portletCredential.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_portletCredential.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _portletCredential.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_portletCredential.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortletCredentialWrapper((PortletCredential)_portletCredential.clone());
	}

	public int compareTo(
		com.drewblessing.googletasks.model.PortletCredential portletCredential) {
		return _portletCredential.compareTo(portletCredential);
	}

	@Override
	public int hashCode() {
		return _portletCredential.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.drewblessing.googletasks.model.PortletCredential> toCacheModel() {
		return _portletCredential.toCacheModel();
	}

	public com.drewblessing.googletasks.model.PortletCredential toEscapedModel() {
		return new PortletCredentialWrapper(_portletCredential.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _portletCredential.toString();
	}

	public java.lang.String toXmlString() {
		return _portletCredential.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_portletCredential.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PortletCredential getWrappedPortletCredential() {
		return _portletCredential;
	}

	public PortletCredential getWrappedModel() {
		return _portletCredential;
	}

	public void resetOriginalValues() {
		_portletCredential.resetOriginalValues();
	}

	private PortletCredential _portletCredential;
}