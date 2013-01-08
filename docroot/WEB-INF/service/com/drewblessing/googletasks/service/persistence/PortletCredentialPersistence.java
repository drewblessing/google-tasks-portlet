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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the portlet credential service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew A. Blessing
 * @see PortletCredentialPersistenceImpl
 * @see PortletCredentialUtil
 * @generated
 */
public interface PortletCredentialPersistence extends BasePersistence<PortletCredential> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PortletCredentialUtil} to access the portlet credential persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the portlet credential in the entity cache if it is enabled.
	*
	* @param portletCredential the portlet credential
	*/
	public void cacheResult(
		com.drewblessing.googletasks.model.PortletCredential portletCredential);

	/**
	* Caches the portlet credentials in the entity cache if it is enabled.
	*
	* @param portletCredentials the portlet credentials
	*/
	public void cacheResult(
		java.util.List<com.drewblessing.googletasks.model.PortletCredential> portletCredentials);

	/**
	* Creates a new portlet credential with the primary key. Does not add the portlet credential to the database.
	*
	* @param id the primary key for the new portlet credential
	* @return the new portlet credential
	*/
	public com.drewblessing.googletasks.model.PortletCredential create(long id);

	/**
	* Removes the portlet credential with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the portlet credential
	* @return the portlet credential that was removed
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a portlet credential with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.drewblessing.googletasks.model.PortletCredential remove(long id)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.drewblessing.googletasks.model.PortletCredential updateImpl(
		com.drewblessing.googletasks.model.PortletCredential portletCredential,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portlet credential with the primary key or throws a {@link com.drewblessing.googletasks.NoSuchPortletCredentialException} if it could not be found.
	*
	* @param id the primary key of the portlet credential
	* @return the portlet credential
	* @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a portlet credential with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.drewblessing.googletasks.model.PortletCredential findByPrimaryKey(
		long id)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the portlet credential with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the portlet credential
	* @return the portlet credential, or <code>null</code> if a portlet credential with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.drewblessing.googletasks.model.PortletCredential fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portlet credentials where companyId = &#63; and googleId = &#63;.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @return the matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndGoogleId(
		long companyId, java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndGoogleId(
		long companyId, java.lang.String googleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndGoogleId(
		long companyId, java.lang.String googleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.drewblessing.googletasks.model.PortletCredential findByCompanyIdAndGoogleId_First(
		long companyId, java.lang.String googleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first portlet credential in the ordered set where companyId = &#63; and googleId = &#63;.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet credential, or <code>null</code> if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.drewblessing.googletasks.model.PortletCredential fetchByCompanyIdAndGoogleId_First(
		long companyId, java.lang.String googleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.drewblessing.googletasks.model.PortletCredential findByCompanyIdAndGoogleId_Last(
		long companyId, java.lang.String googleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last portlet credential in the ordered set where companyId = &#63; and googleId = &#63;.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet credential, or <code>null</code> if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.drewblessing.googletasks.model.PortletCredential fetchByCompanyIdAndGoogleId_Last(
		long companyId, java.lang.String googleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.drewblessing.googletasks.model.PortletCredential[] findByCompanyIdAndGoogleId_PrevAndNext(
		long id, long companyId, java.lang.String googleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portlet credentials where companyId = &#63; and userEmail = &#63;.
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @return the matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndUserEmail(
		long companyId, java.lang.String userEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndUserEmail(
		long companyId, java.lang.String userEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndUserEmail(
		long companyId, java.lang.String userEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.drewblessing.googletasks.model.PortletCredential findByCompanyIdAndUserEmail_First(
		long companyId, java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first portlet credential in the ordered set where companyId = &#63; and userEmail = &#63;.
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet credential, or <code>null</code> if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.drewblessing.googletasks.model.PortletCredential fetchByCompanyIdAndUserEmail_First(
		long companyId, java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.drewblessing.googletasks.model.PortletCredential findByCompanyIdAndUserEmail_Last(
		long companyId, java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last portlet credential in the ordered set where companyId = &#63; and userEmail = &#63;.
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet credential, or <code>null</code> if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.drewblessing.googletasks.model.PortletCredential fetchByCompanyIdAndUserEmail_Last(
		long companyId, java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.drewblessing.googletasks.model.PortletCredential[] findByCompanyIdAndUserEmail_PrevAndNext(
		long id, long companyId, java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portlet credentials where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndUserId(
		long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndUserId(
		long companyId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.drewblessing.googletasks.model.PortletCredential> findByCompanyIdAndUserId(
		long companyId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.drewblessing.googletasks.model.PortletCredential findByCompanyIdAndUserId_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first portlet credential in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching portlet credential, or <code>null</code> if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.drewblessing.googletasks.model.PortletCredential fetchByCompanyIdAndUserId_First(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.drewblessing.googletasks.model.PortletCredential findByCompanyIdAndUserId_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last portlet credential in the ordered set where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching portlet credential, or <code>null</code> if a matching portlet credential could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.drewblessing.googletasks.model.PortletCredential fetchByCompanyIdAndUserId_Last(
		long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.drewblessing.googletasks.model.PortletCredential[] findByCompanyIdAndUserId_PrevAndNext(
		long id, long companyId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.drewblessing.googletasks.NoSuchPortletCredentialException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the portlet credentials.
	*
	* @return the portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.drewblessing.googletasks.model.PortletCredential> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.drewblessing.googletasks.model.PortletCredential> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.drewblessing.googletasks.model.PortletCredential> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the portlet credentials where companyId = &#63; and googleId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyIdAndGoogleId(long companyId,
		java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the portlet credentials where companyId = &#63; and userEmail = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyIdAndUserEmail(long companyId,
		java.lang.String userEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the portlet credentials where companyId = &#63; and userId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyIdAndUserId(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the portlet credentials from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portlet credentials where companyId = &#63; and googleId = &#63;.
	*
	* @param companyId the company ID
	* @param googleId the google ID
	* @return the number of matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyIdAndGoogleId(long companyId,
		java.lang.String googleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portlet credentials where companyId = &#63; and userEmail = &#63;.
	*
	* @param companyId the company ID
	* @param userEmail the user email
	* @return the number of matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyIdAndUserEmail(long companyId,
		java.lang.String userEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portlet credentials where companyId = &#63; and userId = &#63;.
	*
	* @param companyId the company ID
	* @param userId the user ID
	* @return the number of matching portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyIdAndUserId(long companyId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of portlet credentials.
	*
	* @return the number of portlet credentials
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}