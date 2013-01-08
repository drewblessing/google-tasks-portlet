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

package com.drewblessing.googletasks.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the portlet credential local service. This utility wraps {@link com.drewblessing.googletasks.service.impl.PortletCredentialLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Drew A. Blessing
 * @see PortletCredentialLocalService
 * @see com.drewblessing.googletasks.service.base.PortletCredentialLocalServiceBaseImpl
 * @see com.drewblessing.googletasks.service.impl.PortletCredentialLocalServiceImpl
 * @generated
 */
public class PortletCredentialLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.drewblessing.googletasks.service.impl.PortletCredentialLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the portlet credential to the database. Also notifies the appropriate model listeners.
	*
	* @param portletCredential the portlet credential
	* @return the portlet credential that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential addPortletCredential(
		com.drewblessing.googletasks.model.PortletCredential portletCredential)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPortletCredential(portletCredential);
	}

	/**
	* Creates a new portlet credential with the primary key. Does not add the portlet credential to the database.
	*
	* @param id the primary key for the new portlet credential
	* @return the new portlet credential
	*/
	public static com.drewblessing.googletasks.model.PortletCredential createPortletCredential(
		long id) {
		return getService().createPortletCredential(id);
	}

	/**
	* Deletes the portlet credential with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the portlet credential
	* @return the portlet credential that was removed
	* @throws PortalException if a portlet credential with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential deletePortletCredential(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePortletCredential(id);
	}

	/**
	* Deletes the portlet credential from the database. Also notifies the appropriate model listeners.
	*
	* @param portletCredential the portlet credential
	* @return the portlet credential that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential deletePortletCredential(
		com.drewblessing.googletasks.model.PortletCredential portletCredential)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePortletCredential(portletCredential);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.drewblessing.googletasks.model.PortletCredential fetchPortletCredential(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPortletCredential(id);
	}

	/**
	* Returns the portlet credential with the primary key.
	*
	* @param id the primary key of the portlet credential
	* @return the portlet credential
	* @throws PortalException if a portlet credential with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential getPortletCredential(
		long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortletCredential(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the portlet credentials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet credentials
	* @param end the upper bound of the range of portlet credentials (not inclusive)
	* @return the range of portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> getPortletCredentials(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortletCredentials(start, end);
	}

	/**
	* Returns the number of portlet credentials.
	*
	* @return the number of portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static int getPortletCredentialsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortletCredentialsCount();
	}

	/**
	* Updates the portlet credential in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portletCredential the portlet credential
	* @return the portlet credential that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential updatePortletCredential(
		com.drewblessing.googletasks.model.PortletCredential portletCredential)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePortletCredential(portletCredential);
	}

	/**
	* Updates the portlet credential in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portletCredential the portlet credential
	* @param merge whether to merge the portlet credential with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the portlet credential that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential updatePortletCredential(
		com.drewblessing.googletasks.model.PortletCredential portletCredential,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePortletCredential(portletCredential, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.drewblessing.googletasks.model.PortletCredential addCredential(
		java.lang.String googleId, long userId, java.lang.String email,
		java.lang.String picture, java.lang.String accessToken,
		java.lang.String refreshToken, long expires)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCredential(googleId, userId, email, picture,
			accessToken, refreshToken, expires);
	}

	public static com.drewblessing.googletasks.model.PortletCredential updateCredential(
		long credentialId, java.lang.String googleId, long userId,
		java.lang.String picture, java.lang.String accessToken, long expires)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCredential(credentialId, googleId, userId, picture,
			accessToken, expires);
	}

	public static com.drewblessing.googletasks.model.PortletCredential deleteCredential(
		long userId, long companyId, java.lang.String token)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCredential(userId, companyId, token);
	}

	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> getCredentialByCompanyIdAndUserId(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCredentialByCompanyIdAndUserId(companyId, userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PortletCredentialLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PortletCredentialLocalService.class.getName());

			if (invokableLocalService instanceof PortletCredentialLocalService) {
				_service = (PortletCredentialLocalService)invokableLocalService;
			}
			else {
				_service = new PortletCredentialLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PortletCredentialLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(PortletCredentialLocalService service) {
	}

	private static PortletCredentialLocalService _service;
}