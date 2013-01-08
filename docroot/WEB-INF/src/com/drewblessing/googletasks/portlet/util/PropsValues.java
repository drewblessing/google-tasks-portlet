package com.drewblessing.googletasks.portlet.util;

import com.liferay.util.portlet.PortletProps;

/**
 * Property values from portlet.properties
 * 
 * @author Drew A. Blessing
 *
 */
public class PropsValues {
	public static final String GOOGLE_TASKS_OAUTH_CLIENT_ID = PortletProps.get(PropsKeys.GOOGLE_TASKS_OAUTH_CLIENT_ID);
	
	public static final String GOOGLE_TASKS_OAUTH_CLIENT_SECRET = PortletProps.get(PropsKeys.GOOGLE_TASKS_OAUTH_CLIENT_SECRET);
}
