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

package com.drewblessing.googletasks.service.persistence;

import com.drewblessing.googletasks.model.PortletCredential;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the portlet credential service. This utility wraps {@link PortletCredentialPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew A. Blessing
 * @see PortletCredentialPersistence
 * @see PortletCredentialPersistenceImpl
 * @generated
 */
public class PortletCredentialUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(PortletCredential portletCredential) {
		getPersistence().clearCache(portletCredential);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PortletCredential> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PortletCredential> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PortletCredential> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PortletCredential update(
		PortletCredential portletCredential, boolean merge)
		throws SystemException {
		return getPersistence().update(portletCredential, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PortletCredential update(
		PortletCredential portletCredential, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(portletCredential, merge, serviceContext);
	}

	/**
	* Caches the portlet credential in the entity cache if it is enabled.
	*
	* @param portletCredential the portlet credential
	*/
	public static void cacheResult(
		com.drewblessing.googletasks.model.PortletCredential portletCredential) {
		getPersistence().cacheResult(portletCredential);
	}

	/**
	* Caches the portlet credentials in the entity cache if it is enabled.
	*
	* @param portletCredentials the portlet credentials
	*/
	public static void cacheResult(
		java.util.List<com.drewblessing.googletasks.model.PortletCredential> portletCredentials) {
		getPersistence().cacheResult(portletCredentials);
	}

	/**
	* Creates a new portlet credential with the primary key. Does not add the portlet credential to the database.
	*
	* @param id the primary key for the new portlet credential
	* @return the new portlet credential
	*/
	public static com.drewblessing.googletasks.model.PortletCredential create(
		long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the portlet credential with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the portlet credential
	* @return the portlet credential that was removed
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a portlet credential with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential remove(
		long id)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static com.drewblessing.googletasks.model.PortletCredential updateImpl(
		com.drewblessing.googletasks.model.PortletCredential portletCredential,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(portletCredential, merge);
	}

	/**
	* Returns the portlet credential with the primary key or throws a {@link com.drewblessing.googletasks.NoSuchPortletCredentialException} if it could not be found.
	*
	* @param id the primary key of the portlet credential
	* @return the portlet credential
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a portlet credential with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential findByPrimaryKey(
		long id)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the portlet credential with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the portlet credential
	* @return the portlet credential, or <code>null</code> if a portlet credential with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the portlet credentials where companyId = &#63; and googleId = &#63;.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @return the matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndGoogleId(
		long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyIdAndGoogleId(companyId, googleId);
	}

	/**
	* Returns a range of all the portlet credentials where companyId = &#63; and googleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @param start the lower bound of the range of portlet credentials
	* @param end the upper bound of the range of portlet credentials (not inclusive)
	* @return the range of matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndGoogleId(
		long companyId, java.lang.String googleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndGoogleId(companyId, googleId, start, end);
	}

	/**
	* Returns an ordered range of all the portlet credentials where companyId = &#63; and googleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @param start the lower bound of the range of portlet credentials
	* @param end the upper bound of the range of portlet credentials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndGoogleId(
		long companyId, java.lang.String googleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndGoogleId(companyId, googleId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first portlet credential in the ordered set where companyId = &#63; and googleId = &#63;.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet credential
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential findByCompanyIdAndGoogleId_First(
		long companyId, java.lang.String googleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndGoogleId_First(companyId, googleId,
			orderByComparator);
	}

	/**
	* Returns the first portlet credential in the ordered set where companyId = &#63; and googleId = &#63;.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet credential, or <code>null</code> if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential fetchByCompanyIdAndGoogleId_First(
		long companyId, java.lang.String googleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyIdAndGoogleId_First(companyId, googleId,
			orderByComparator);
	}

	/**
	* Returns the last portlet credential in the ordered set where companyId = &#63; and googleId = &#63;.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet credential
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential findByCompanyIdAndGoogleId_Last(
		long companyId, java.lang.String googleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndGoogleId_Last(companyId, googleId,
			orderByComparator);
	}

	/**
	* Returns the last portlet credential in the ordered set where companyId = &#63; and googleId = &#63;.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet credential, or <code>null</code> if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential fetchByCompanyIdAndGoogleId_Last(
		long companyId, java.lang.String googleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyIdAndGoogleId_Last(companyId, googleId,
			orderByComparator);
	}

	/**
	* Returns the portlet credentials before and after the current portlet credential in the ordered set where companyId = &#63; and googleId = &#63;.
	*
	* @param id the primary key of the current portlet credential
	* @param companyId the company ID
	* @param googleId the google ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet credential
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a portlet credential with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential[] findByCompanyIdAndGoogleId_PrevAndNext(
		long id, long companyId, java.lang.String googleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndGoogleId_PrevAndNext(id, companyId,
			googleId, orderByComparator);
	}

	/**
	* Returns all the portlet credentials where companyId = &#63; and userEmail = &#63;.
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @return the matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndUserEmail(
		long companyId, java.lang.String userEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyIdAndUserEmail(companyId, userEmail);
	}

	/**
	* Returns a range of all the portlet credentials where companyId = &#63; and userEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @param start the lower bound of the range of portlet credentials
	* @param end the upper bound of the range of portlet credentials (not inclusive)
	* @return the range of matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndUserEmail(
		long companyId, java.lang.String userEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndUserEmail(companyId, userEmail, start, end);
	}

	/**
	* Returns an ordered range of all the portlet credentials where companyId = &#63; and userEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @param start the lower bound of the range of portlet credentials
	* @param end the upper bound of the range of portlet credentials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndUserEmail(
		long companyId, java.lang.String userEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndUserEmail(companyId, userEmail, start,
			end, orderByComparator);
	}

	/**
	* Returns the first portlet credential in the ordered set where companyId = &#63; and userEmail = &#63;.
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet credential
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential findByCompanyIdAndUserEmail_First(
		long companyId, java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndUserEmail_First(companyId, userEmail,
			orderByComparator);
	}

	/**
	* Returns the first portlet credential in the ordered set where companyId = &#63; and userEmail = &#63;.
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet credential, or <code>null</code> if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential fetchByCompanyIdAndUserEmail_First(
		long companyId, java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyIdAndUserEmail_First(companyId, userEmail,
			orderByComparator);
	}

	/**
	* Returns the last portlet credential in the ordered set where companyId = &#63; and userEmail = &#63;.
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet credential
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential findByCompanyIdAndUserEmail_Last(
		long companyId, java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndUserEmail_Last(companyId, userEmail,
			orderByComparator);
	}

	/**
	* Returns the last portlet credential in the ordered set where companyId = &#63; and userEmail = &#63;.
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet credential, or <code>null</code> if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential fetchByCompanyIdAndUserEmail_Last(
		long companyId, java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyIdAndUserEmail_Last(companyId, userEmail,
			orderByComparator);
	}

	/**
	* Returns the portlet credentials before and after the current portlet credential in the ordered set where companyId = &#63; and userEmail = &#63;.
	*
	* @param id the primary key of the current portlet credential
	* @param companyId the company ID
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet credential
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a portlet credential with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential[] findByCompanyIdAndUserEmail_PrevAndNext(
		long id, long companyId, java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndUserEmail_PrevAndNext(id, companyId,
			userEmail, orderByComparator);
	}

	/**
	* Returns all the portlet credentials where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndUserId(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyIdAndUserId(companyId, userId);
	}

	/**
	* Returns a range of all the portlet credentials where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of portlet credentials
	* @param end the upper bound of the range of portlet credentials (not inclusive)
	* @return the range of matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndUserId(
		long companyId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndUserId(companyId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the portlet credentials where companyId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param start the lower bound of the range of portlet credentials
	* @param end the upper bound of the range of portlet credentials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndUserId(
		long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndUserId(companyId, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first portlet credential in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet credential
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential findByCompanyIdAndUserId_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndUserId_First(companyId, userId,
			orderByComparator);
	}

	/**
	* Returns the first portlet credential in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet credential, or <code>null</code> if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential fetchByCompanyIdAndUserId_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyIdAndUserId_First(companyId, userId,
			orderByComparator);
	}

	/**
	* Returns the last portlet credential in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet credential
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential findByCompanyIdAndUserId_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndUserId_Last(companyId, userId,
			orderByComparator);
	}

	/**
	* Returns the last portlet credential in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet credential, or <code>null</code> if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential fetchByCompanyIdAndUserId_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyIdAndUserId_Last(companyId, userId,
			orderByComparator);
	}

	/**
	* Returns the portlet credentials before and after the current portlet credential in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param id the primary key of the current portlet credential
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next portlet credential
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a portlet credential with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.drewblessing.googletasks.model.PortletCredential[] findByCompanyIdAndUserId_PrevAndNext(
		long id, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyIdAndUserId_PrevAndNext(id, companyId, userId,
			orderByComparator);
	}

	/**
	* Returns all the portlet credentials.
	*
	* @return the portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the portlet credentials.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of portlet credentials
	* @param end the upper bound of the range of portlet credentials (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.drewblessing.googletasks.model.PortletCredential> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the portlet credentials where companyId = &#63; and googleId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyIdAndGoogleId(long companyId,
		java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyIdAndGoogleId(companyId, googleId);
	}

	/**
	* Removes all the portlet credentials where companyId = &#63; and userEmail = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyIdAndUserEmail(long companyId,
		java.lang.String userEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyIdAndUserEmail(companyId, userEmail);
	}

	/**
	* Removes all the portlet credentials where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyIdAndUserId(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyIdAndUserId(companyId, userId);
	}

	/**
	* Removes all the portlet credentials from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of portlet credentials where companyId = &#63; and googleId = &#63;.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @return the number of matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyIdAndGoogleId(long companyId,
		java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyIdAndGoogleId(companyId, googleId);
	}

	/**
	* Returns the number of portlet credentials where companyId = &#63; and userEmail = &#63;.
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @return the number of matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyIdAndUserEmail(long companyId,
		java.lang.String userEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCompanyIdAndUserEmail(companyId, userEmail);
	}

	/**
	* Returns the number of portlet credentials where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyIdAndUserId(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyIdAndUserId(companyId, userId);
	}

	/**
	* Returns the number of portlet credentials.
	*
	* @return the number of portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PortletCredentialPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PortletCredentialPersistence)PortletBeanLocatorUtil.locate(com.drewblessing.googletasks.service.ClpSerializer.getServletContextName(),
					PortletCredentialPersistence.class.getName());

			ReferenceRegistry.registerReference(PortletCredentialUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PortletCredentialPersistence persistence) {
	}

	private static PortletCredentialPersistence _persistence;
}