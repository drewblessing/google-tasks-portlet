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

import com.drewblessing.googletasks.NoSuchPortletCredentialException;
import com.drewblessing.googletasks.model.PortletCredential;
import com.drewblessing.googletasks.model.impl.PortletCredentialImpl;
import com.drewblessing.googletasks.model.impl.PortletCredentialModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the portlet credential service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Drew A. Blessing
 * @see PortletCredentialPersistence
 * @see PortletCredentialUtil
 * @generated
 */
public class PortletCredentialPersistenceImpl extends BasePersistenceImpl<PortletCredential>
	implements PortletCredentialPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PortletCredentialUtil} to access the portlet credential persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PortletCredentialImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGOOGLEID =
		new FinderPath(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialModelImpl.FINDER_CACHE_ENABLED,
			PortletCredentialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyIdAndGoogleId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGOOGLEID =
		new FinderPath(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialModelImpl.FINDER_CACHE_ENABLED,
			PortletCredentialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyIdAndGoogleId",
			new String[] { Long.class.getName(), String.class.getName() },
			PortletCredentialModelImpl.COMPANYID_COLUMN_BITMASK |
			PortletCredentialModelImpl.GOOGLEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDGOOGLEID = new FinderPath(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyIdAndGoogleId",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDUSEREMAIL =
		new FinderPath(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialModelImpl.FINDER_CACHE_ENABLED,
			PortletCredentialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCompanyIdAndUserEmail",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSEREMAIL =
		new FinderPath(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialModelImpl.FINDER_CACHE_ENABLED,
			PortletCredentialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyIdAndUserEmail",
			new String[] { Long.class.getName(), String.class.getName() },
			PortletCredentialModelImpl.COMPANYID_COLUMN_BITMASK |
			PortletCredentialModelImpl.USEREMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDUSEREMAIL = new FinderPath(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyIdAndUserEmail",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDUSERID =
		new FinderPath(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialModelImpl.FINDER_CACHE_ENABLED,
			PortletCredentialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyIdAndUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSERID =
		new FinderPath(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialModelImpl.FINDER_CACHE_ENABLED,
			PortletCredentialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCompanyIdAndUserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			PortletCredentialModelImpl.COMPANYID_COLUMN_BITMASK |
			PortletCredentialModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYIDANDUSERID = new FinderPath(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCompanyIdAndUserId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialModelImpl.FINDER_CACHE_ENABLED,
			PortletCredentialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialModelImpl.FINDER_CACHE_ENABLED,
			PortletCredentialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the portlet credential in the entity cache if it is enabled.
	 *
	 * @param portletCredential the portlet credential
	 */
	public void cacheResult(PortletCredential portletCredential) {
		EntityCacheUtil.putResult(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialImpl.class, portletCredential.getPrimaryKey(),
			portletCredential);

		portletCredential.resetOriginalValues();
	}

	/**
	 * Caches the portlet credentials in the entity cache if it is enabled.
	 *
	 * @param portletCredentials the portlet credentials
	 */
	public void cacheResult(List<PortletCredential> portletCredentials) {
		for (PortletCredential portletCredential : portletCredentials) {
			if (EntityCacheUtil.getResult(
						PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
						PortletCredentialImpl.class,
						portletCredential.getPrimaryKey()) == null) {
				cacheResult(portletCredential);
			}
			else {
				portletCredential.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all portlet credentials.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PortletCredentialImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PortletCredentialImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the portlet credential.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PortletCredential portletCredential) {
		EntityCacheUtil.removeResult(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialImpl.class, portletCredential.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PortletCredential> portletCredentials) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PortletCredential portletCredential : portletCredentials) {
			EntityCacheUtil.removeResult(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
				PortletCredentialImpl.class, portletCredential.getPrimaryKey());
		}
	}

	/**
	 * Creates a new portlet credential with the primary key. Does not add the portlet credential to the database.
	 *
	 * @param id the primary key for the new portlet credential
	 * @return the new portlet credential
	 */
	public PortletCredential create(long id) {
		PortletCredential portletCredential = new PortletCredentialImpl();

		portletCredential.setNew(true);
		portletCredential.setPrimaryKey(id);

		return portletCredential;
	}

	/**
	 * Removes the portlet credential with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the portlet credential
	 * @return the portlet credential that was removed
	 * @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a portlet credential with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletCredential remove(long id)
		throws NoSuchPortletCredentialException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the portlet credential with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the portlet credential
	 * @return the portlet credential that was removed
	 * @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a portlet credential with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletCredential remove(Serializable primaryKey)
		throws NoSuchPortletCredentialException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PortletCredential portletCredential = (PortletCredential)session.get(PortletCredentialImpl.class,
					primaryKey);

			if (portletCredential == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPortletCredentialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(portletCredential);
		}
		catch (NoSuchPortletCredentialException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PortletCredential removeImpl(PortletCredential portletCredential)
		throws SystemException {
		portletCredential = toUnwrappedModel(portletCredential);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, portletCredential);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(portletCredential);

		return portletCredential;
	}

	@Override
	public PortletCredential updateImpl(
		com.drewblessing.googletasks.model.PortletCredential portletCredential,
		boolean merge) throws SystemException {
		portletCredential = toUnwrappedModel(portletCredential);

		boolean isNew = portletCredential.isNew();

		PortletCredentialModelImpl portletCredentialModelImpl = (PortletCredentialModelImpl)portletCredential;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, portletCredential, merge);

			portletCredential.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PortletCredentialModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((portletCredentialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGOOGLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portletCredentialModelImpl.getOriginalCompanyId()),
						
						portletCredentialModelImpl.getOriginalGoogleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGOOGLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGOOGLEID,
					args);

				args = new Object[] {
						Long.valueOf(portletCredentialModelImpl.getCompanyId()),
						
						portletCredentialModelImpl.getGoogleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGOOGLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGOOGLEID,
					args);
			}

			if ((portletCredentialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSEREMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portletCredentialModelImpl.getOriginalCompanyId()),
						
						portletCredentialModelImpl.getOriginalUserEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDUSEREMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSEREMAIL,
					args);

				args = new Object[] {
						Long.valueOf(portletCredentialModelImpl.getCompanyId()),
						
						portletCredentialModelImpl.getUserEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDUSEREMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSEREMAIL,
					args);
			}

			if ((portletCredentialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(portletCredentialModelImpl.getOriginalCompanyId()),
						Long.valueOf(portletCredentialModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSERID,
					args);

				args = new Object[] {
						Long.valueOf(portletCredentialModelImpl.getCompanyId()),
						Long.valueOf(portletCredentialModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYIDANDUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSERID,
					args);
			}
		}

		EntityCacheUtil.putResult(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
			PortletCredentialImpl.class, portletCredential.getPrimaryKey(),
			portletCredential);

		return portletCredential;
	}

	protected PortletCredential toUnwrappedModel(
		PortletCredential portletCredential) {
		if (portletCredential instanceof PortletCredentialImpl) {
			return portletCredential;
		}

		PortletCredentialImpl portletCredentialImpl = new PortletCredentialImpl();

		portletCredentialImpl.setNew(portletCredential.isNew());
		portletCredentialImpl.setPrimaryKey(portletCredential.getPrimaryKey());

		portletCredentialImpl.setId(portletCredential.getId());
		portletCredentialImpl.setCompanyId(portletCredential.getCompanyId());
		portletCredentialImpl.setUserId(portletCredential.getUserId());
		portletCredentialImpl.setUserName(portletCredential.getUserName());
		portletCredentialImpl.setCreateDate(portletCredential.getCreateDate());
		portletCredentialImpl.setModifiedDate(portletCredential.getModifiedDate());
		portletCredentialImpl.setGoogleId(portletCredential.getGoogleId());
		portletCredentialImpl.setUserEmail(portletCredential.getUserEmail());
		portletCredentialImpl.setUserPicture(portletCredential.getUserPicture());
		portletCredentialImpl.setAccessToken(portletCredential.getAccessToken());
		portletCredentialImpl.setRefreshToken(portletCredential.getRefreshToken());
		portletCredentialImpl.setExpires(portletCredential.getExpires());

		return portletCredentialImpl;
	}

	/**
	 * Returns the portlet credential with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the portlet credential
	 * @return the portlet credential
	 * @throws com.liferay.portal.NoSuchModelException if a portlet credential with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletCredential findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the portlet credential with the primary key or throws a {@link com.drewblessing.googletasks.NoSuchPortletCredentialException} if it could not be found.
	 *
	 * @param id the primary key of the portlet credential
	 * @return the portlet credential
	 * @throws com.drewblessing.googletasks.NoSuchPortletCredentialException if a portlet credential with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletCredential findByPrimaryKey(long id)
		throws NoSuchPortletCredentialException, SystemException {
		PortletCredential portletCredential = fetchByPrimaryKey(id);

		if (portletCredential == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchPortletCredentialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return portletCredential;
	}

	/**
	 * Returns the portlet credential with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the portlet credential
	 * @return the portlet credential, or <code>null</code> if a portlet credential with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortletCredential fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the portlet credential with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the portlet credential
	 * @return the portlet credential, or <code>null</code> if a portlet credential with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PortletCredential fetchByPrimaryKey(long id)
		throws SystemException {
		PortletCredential portletCredential = (PortletCredential)EntityCacheUtil.getResult(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
				PortletCredentialImpl.class, id);

		if (portletCredential == _nullPortletCredential) {
			return null;
		}

		if (portletCredential == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				portletCredential = (PortletCredential)session.get(PortletCredentialImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (portletCredential != null) {
					cacheResult(portletCredential);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PortletCredentialModelImpl.ENTITY_CACHE_ENABLED,
						PortletCredentialImpl.class, id, _nullPortletCredential);
				}

				closeSession(session);
			}
		}

		return portletCredential;
	}

	/**
	 * Returns all the portlet credentials where companyId = &#63; and googleId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param googleId the google ID
	 * @return the matching portlet credentials
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletCredential> findByCompanyIdAndGoogleId(long companyId,
		String googleId) throws SystemException {
		return findByCompanyIdAndGoogleId(companyId, googleId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<PortletCredential> findByCompanyIdAndGoogleId(long companyId,
		String googleId, int start, int end) throws SystemException {
		return findByCompanyIdAndGoogleId(companyId, googleId, start, end, null);
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
	public List<PortletCredential> findByCompanyIdAndGoogleId(long companyId,
		String googleId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDGOOGLEID;
			finderArgs = new Object[] { companyId, googleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDGOOGLEID;
			finderArgs = new Object[] {
					companyId, googleId,
					
					start, end, orderByComparator
				};
		}

		List<PortletCredential> list = (List<PortletCredential>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortletCredential portletCredential : list) {
				if ((companyId != portletCredential.getCompanyId()) ||
						!Validator.equals(googleId,
							portletCredential.getGoogleId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PORTLETCREDENTIAL_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDGOOGLEID_COMPANYID_2);

			if (googleId == null) {
				query.append(_FINDER_COLUMN_COMPANYIDANDGOOGLEID_GOOGLEID_1);
			}
			else {
				if (googleId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_COMPANYIDANDGOOGLEID_GOOGLEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_COMPANYIDANDGOOGLEID_GOOGLEID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PortletCredentialModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (googleId != null) {
					qPos.add(googleId);
				}

				list = (List<PortletCredential>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public PortletCredential findByCompanyIdAndGoogleId_First(long companyId,
		String googleId, OrderByComparator orderByComparator)
		throws NoSuchPortletCredentialException, SystemException {
		PortletCredential portletCredential = fetchByCompanyIdAndGoogleId_First(companyId,
				googleId, orderByComparator);

		if (portletCredential != null) {
			return portletCredential;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", googleId=");
		msg.append(googleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletCredentialException(msg.toString());
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
	public PortletCredential fetchByCompanyIdAndGoogleId_First(long companyId,
		String googleId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PortletCredential> list = findByCompanyIdAndGoogleId(companyId,
				googleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public PortletCredential findByCompanyIdAndGoogleId_Last(long companyId,
		String googleId, OrderByComparator orderByComparator)
		throws NoSuchPortletCredentialException, SystemException {
		PortletCredential portletCredential = fetchByCompanyIdAndGoogleId_Last(companyId,
				googleId, orderByComparator);

		if (portletCredential != null) {
			return portletCredential;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", googleId=");
		msg.append(googleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletCredentialException(msg.toString());
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
	public PortletCredential fetchByCompanyIdAndGoogleId_Last(long companyId,
		String googleId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyIdAndGoogleId(companyId, googleId);

		List<PortletCredential> list = findByCompanyIdAndGoogleId(companyId,
				googleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public PortletCredential[] findByCompanyIdAndGoogleId_PrevAndNext(long id,
		long companyId, String googleId, OrderByComparator orderByComparator)
		throws NoSuchPortletCredentialException, SystemException {
		PortletCredential portletCredential = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PortletCredential[] array = new PortletCredentialImpl[3];

			array[0] = getByCompanyIdAndGoogleId_PrevAndNext(session,
					portletCredential, companyId, googleId, orderByComparator,
					true);

			array[1] = portletCredential;

			array[2] = getByCompanyIdAndGoogleId_PrevAndNext(session,
					portletCredential, companyId, googleId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortletCredential getByCompanyIdAndGoogleId_PrevAndNext(
		Session session, PortletCredential portletCredential, long companyId,
		String googleId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETCREDENTIAL_WHERE);

		query.append(_FINDER_COLUMN_COMPANYIDANDGOOGLEID_COMPANYID_2);

		if (googleId == null) {
			query.append(_FINDER_COLUMN_COMPANYIDANDGOOGLEID_GOOGLEID_1);
		}
		else {
			if (googleId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPANYIDANDGOOGLEID_GOOGLEID_3);
			}
			else {
				query.append(_FINDER_COLUMN_COMPANYIDANDGOOGLEID_GOOGLEID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(PortletCredentialModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (googleId != null) {
			qPos.add(googleId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletCredential);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletCredential> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet credentials where companyId = &#63; and userEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userEmail the user email
	 * @return the matching portlet credentials
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletCredential> findByCompanyIdAndUserEmail(long companyId,
		String userEmail) throws SystemException {
		return findByCompanyIdAndUserEmail(companyId, userEmail,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<PortletCredential> findByCompanyIdAndUserEmail(long companyId,
		String userEmail, int start, int end) throws SystemException {
		return findByCompanyIdAndUserEmail(companyId, userEmail, start, end,
			null);
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
	public List<PortletCredential> findByCompanyIdAndUserEmail(long companyId,
		String userEmail, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSEREMAIL;
			finderArgs = new Object[] { companyId, userEmail };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDUSEREMAIL;
			finderArgs = new Object[] {
					companyId, userEmail,
					
					start, end, orderByComparator
				};
		}

		List<PortletCredential> list = (List<PortletCredential>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortletCredential portletCredential : list) {
				if ((companyId != portletCredential.getCompanyId()) ||
						!Validator.equals(userEmail,
							portletCredential.getUserEmail())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PORTLETCREDENTIAL_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDUSEREMAIL_COMPANYID_2);

			if (userEmail == null) {
				query.append(_FINDER_COLUMN_COMPANYIDANDUSEREMAIL_USEREMAIL_1);
			}
			else {
				if (userEmail.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_COMPANYIDANDUSEREMAIL_USEREMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_COMPANYIDANDUSEREMAIL_USEREMAIL_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PortletCredentialModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (userEmail != null) {
					qPos.add(userEmail);
				}

				list = (List<PortletCredential>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public PortletCredential findByCompanyIdAndUserEmail_First(long companyId,
		String userEmail, OrderByComparator orderByComparator)
		throws NoSuchPortletCredentialException, SystemException {
		PortletCredential portletCredential = fetchByCompanyIdAndUserEmail_First(companyId,
				userEmail, orderByComparator);

		if (portletCredential != null) {
			return portletCredential;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userEmail=");
		msg.append(userEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletCredentialException(msg.toString());
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
	public PortletCredential fetchByCompanyIdAndUserEmail_First(
		long companyId, String userEmail, OrderByComparator orderByComparator)
		throws SystemException {
		List<PortletCredential> list = findByCompanyIdAndUserEmail(companyId,
				userEmail, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public PortletCredential findByCompanyIdAndUserEmail_Last(long companyId,
		String userEmail, OrderByComparator orderByComparator)
		throws NoSuchPortletCredentialException, SystemException {
		PortletCredential portletCredential = fetchByCompanyIdAndUserEmail_Last(companyId,
				userEmail, orderByComparator);

		if (portletCredential != null) {
			return portletCredential;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userEmail=");
		msg.append(userEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletCredentialException(msg.toString());
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
	public PortletCredential fetchByCompanyIdAndUserEmail_Last(long companyId,
		String userEmail, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyIdAndUserEmail(companyId, userEmail);

		List<PortletCredential> list = findByCompanyIdAndUserEmail(companyId,
				userEmail, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public PortletCredential[] findByCompanyIdAndUserEmail_PrevAndNext(
		long id, long companyId, String userEmail,
		OrderByComparator orderByComparator)
		throws NoSuchPortletCredentialException, SystemException {
		PortletCredential portletCredential = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PortletCredential[] array = new PortletCredentialImpl[3];

			array[0] = getByCompanyIdAndUserEmail_PrevAndNext(session,
					portletCredential, companyId, userEmail, orderByComparator,
					true);

			array[1] = portletCredential;

			array[2] = getByCompanyIdAndUserEmail_PrevAndNext(session,
					portletCredential, companyId, userEmail, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortletCredential getByCompanyIdAndUserEmail_PrevAndNext(
		Session session, PortletCredential portletCredential, long companyId,
		String userEmail, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETCREDENTIAL_WHERE);

		query.append(_FINDER_COLUMN_COMPANYIDANDUSEREMAIL_COMPANYID_2);

		if (userEmail == null) {
			query.append(_FINDER_COLUMN_COMPANYIDANDUSEREMAIL_USEREMAIL_1);
		}
		else {
			if (userEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_COMPANYIDANDUSEREMAIL_USEREMAIL_3);
			}
			else {
				query.append(_FINDER_COLUMN_COMPANYIDANDUSEREMAIL_USEREMAIL_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(PortletCredentialModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (userEmail != null) {
			qPos.add(userEmail);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletCredential);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletCredential> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet credentials where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the matching portlet credentials
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletCredential> findByCompanyIdAndUserId(long companyId,
		long userId) throws SystemException {
		return findByCompanyIdAndUserId(companyId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<PortletCredential> findByCompanyIdAndUserId(long companyId,
		long userId, int start, int end) throws SystemException {
		return findByCompanyIdAndUserId(companyId, userId, start, end, null);
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
	public List<PortletCredential> findByCompanyIdAndUserId(long companyId,
		long userId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYIDANDUSERID;
			finderArgs = new Object[] { companyId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYIDANDUSERID;
			finderArgs = new Object[] {
					companyId, userId,
					
					start, end, orderByComparator
				};
		}

		List<PortletCredential> list = (List<PortletCredential>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortletCredential portletCredential : list) {
				if ((companyId != portletCredential.getCompanyId()) ||
						(userId != portletCredential.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PORTLETCREDENTIAL_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDUSERID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYIDANDUSERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(PortletCredentialModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				list = (List<PortletCredential>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public PortletCredential findByCompanyIdAndUserId_First(long companyId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchPortletCredentialException, SystemException {
		PortletCredential portletCredential = fetchByCompanyIdAndUserId_First(companyId,
				userId, orderByComparator);

		if (portletCredential != null) {
			return portletCredential;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletCredentialException(msg.toString());
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
	public PortletCredential fetchByCompanyIdAndUserId_First(long companyId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PortletCredential> list = findByCompanyIdAndUserId(companyId,
				userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public PortletCredential findByCompanyIdAndUserId_Last(long companyId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchPortletCredentialException, SystemException {
		PortletCredential portletCredential = fetchByCompanyIdAndUserId_Last(companyId,
				userId, orderByComparator);

		if (portletCredential != null) {
			return portletCredential;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortletCredentialException(msg.toString());
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
	public PortletCredential fetchByCompanyIdAndUserId_Last(long companyId,
		long userId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCompanyIdAndUserId(companyId, userId);

		List<PortletCredential> list = findByCompanyIdAndUserId(companyId,
				userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public PortletCredential[] findByCompanyIdAndUserId_PrevAndNext(long id,
		long companyId, long userId, OrderByComparator orderByComparator)
		throws NoSuchPortletCredentialException, SystemException {
		PortletCredential portletCredential = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PortletCredential[] array = new PortletCredentialImpl[3];

			array[0] = getByCompanyIdAndUserId_PrevAndNext(session,
					portletCredential, companyId, userId, orderByComparator,
					true);

			array[1] = portletCredential;

			array[2] = getByCompanyIdAndUserId_PrevAndNext(session,
					portletCredential, companyId, userId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortletCredential getByCompanyIdAndUserId_PrevAndNext(
		Session session, PortletCredential portletCredential, long companyId,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTLETCREDENTIAL_WHERE);

		query.append(_FINDER_COLUMN_COMPANYIDANDUSERID_COMPANYID_2);

		query.append(_FINDER_COLUMN_COMPANYIDANDUSERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(PortletCredentialModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portletCredential);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortletCredential> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the portlet credentials.
	 *
	 * @return the portlet credentials
	 * @throws SystemException if a system exception occurred
	 */
	public List<PortletCredential> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<PortletCredential> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<PortletCredential> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<PortletCredential> list = (List<PortletCredential>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PORTLETCREDENTIAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PORTLETCREDENTIAL.concat(PortletCredentialModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PortletCredential>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PortletCredential>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the portlet credentials where companyId = &#63; and googleId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param googleId the google ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyIdAndGoogleId(long companyId, String googleId)
		throws SystemException {
		for (PortletCredential portletCredential : findByCompanyIdAndGoogleId(
				companyId, googleId)) {
			remove(portletCredential);
		}
	}

	/**
	 * Removes all the portlet credentials where companyId = &#63; and userEmail = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userEmail the user email
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyIdAndUserEmail(long companyId, String userEmail)
		throws SystemException {
		for (PortletCredential portletCredential : findByCompanyIdAndUserEmail(
				companyId, userEmail)) {
			remove(portletCredential);
		}
	}

	/**
	 * Removes all the portlet credentials where companyId = &#63; and userId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyIdAndUserId(long companyId, long userId)
		throws SystemException {
		for (PortletCredential portletCredential : findByCompanyIdAndUserId(
				companyId, userId)) {
			remove(portletCredential);
		}
	}

	/**
	 * Removes all the portlet credentials from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PortletCredential portletCredential : findAll()) {
			remove(portletCredential);
		}
	}

	/**
	 * Returns the number of portlet credentials where companyId = &#63; and googleId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param googleId the google ID
	 * @return the number of matching portlet credentials
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyIdAndGoogleId(long companyId, String googleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, googleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGOOGLEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PORTLETCREDENTIAL_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDGOOGLEID_COMPANYID_2);

			if (googleId == null) {
				query.append(_FINDER_COLUMN_COMPANYIDANDGOOGLEID_GOOGLEID_1);
			}
			else {
				if (googleId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_COMPANYIDANDGOOGLEID_GOOGLEID_3);
				}
				else {
					query.append(_FINDER_COLUMN_COMPANYIDANDGOOGLEID_GOOGLEID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (googleId != null) {
					qPos.add(googleId);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYIDANDGOOGLEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of portlet credentials where companyId = &#63; and userEmail = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userEmail the user email
	 * @return the number of matching portlet credentials
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyIdAndUserEmail(long companyId, String userEmail)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, userEmail };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYIDANDUSEREMAIL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PORTLETCREDENTIAL_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDUSEREMAIL_COMPANYID_2);

			if (userEmail == null) {
				query.append(_FINDER_COLUMN_COMPANYIDANDUSEREMAIL_USEREMAIL_1);
			}
			else {
				if (userEmail.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_COMPANYIDANDUSEREMAIL_USEREMAIL_3);
				}
				else {
					query.append(_FINDER_COLUMN_COMPANYIDANDUSEREMAIL_USEREMAIL_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (userEmail != null) {
					qPos.add(userEmail);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYIDANDUSEREMAIL,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of portlet credentials where companyId = &#63; and userId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param userId the user ID
	 * @return the number of matching portlet credentials
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyIdAndUserId(long companyId, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { companyId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYIDANDUSERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PORTLETCREDENTIAL_WHERE);

			query.append(_FINDER_COLUMN_COMPANYIDANDUSERID_COMPANYID_2);

			query.append(_FINDER_COLUMN_COMPANYIDANDUSERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYIDANDUSERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of portlet credentials.
	 *
	 * @return the number of portlet credentials
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PORTLETCREDENTIAL);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the portlet credential persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.drewblessing.googletasks.model.PortletCredential")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PortletCredential>> listenersList = new ArrayList<ModelListener<PortletCredential>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PortletCredential>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PortletCredentialImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = PortletCredentialPersistence.class)
	protected PortletCredentialPersistence portletCredentialPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PORTLETCREDENTIAL = "SELECT portletCredential FROM PortletCredential portletCredential";
	private static final String _SQL_SELECT_PORTLETCREDENTIAL_WHERE = "SELECT portletCredential FROM PortletCredential portletCredential WHERE ";
	private static final String _SQL_COUNT_PORTLETCREDENTIAL = "SELECT COUNT(portletCredential) FROM PortletCredential portletCredential";
	private static final String _SQL_COUNT_PORTLETCREDENTIAL_WHERE = "SELECT COUNT(portletCredential) FROM PortletCredential portletCredential WHERE ";
	private static final String _FINDER_COLUMN_COMPANYIDANDGOOGLEID_COMPANYID_2 = "portletCredential.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYIDANDGOOGLEID_GOOGLEID_1 = "portletCredential.googleId IS NULL";
	private static final String _FINDER_COLUMN_COMPANYIDANDGOOGLEID_GOOGLEID_2 = "portletCredential.googleId = ?";
	private static final String _FINDER_COLUMN_COMPANYIDANDGOOGLEID_GOOGLEID_3 = "(portletCredential.googleId IS NULL OR portletCredential.googleId = ?)";
	private static final String _FINDER_COLUMN_COMPANYIDANDUSEREMAIL_COMPANYID_2 =
		"portletCredential.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYIDANDUSEREMAIL_USEREMAIL_1 =
		"portletCredential.userEmail IS NULL";
	private static final String _FINDER_COLUMN_COMPANYIDANDUSEREMAIL_USEREMAIL_2 =
		"portletCredential.userEmail = ?";
	private static final String _FINDER_COLUMN_COMPANYIDANDUSEREMAIL_USEREMAIL_3 =
		"(portletCredential.userEmail IS NULL OR portletCredential.userEmail = ?)";
	private static final String _FINDER_COLUMN_COMPANYIDANDUSERID_COMPANYID_2 = "portletCredential.companyId = ? AND ";
	private static final String _FINDER_COLUMN_COMPANYIDANDUSERID_USERID_2 = "portletCredential.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "portletCredential.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PortletCredential exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PortletCredential exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PortletCredentialPersistenceImpl.class);
	private static PortletCredential _nullPortletCredential = new PortletCredentialImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PortletCredential> toCacheModel() {
				return _nullPortletCredentialCacheModel;
			}
		};

	private static CacheModel<PortletCredential> _nullPortletCredentialCacheModel =
		new CacheModel<PortletCredential>() {
			public PortletCredential toEntityModel() {
				return _nullPortletCredential;
			}
		};
}