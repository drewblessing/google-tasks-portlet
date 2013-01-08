<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%-- <%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %> --%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.google.api.client.auth.oauth2.Credential" %>


<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="com.liferay.portlet.PortletURLUtil" %>

<%@ page import="com.drewblessing.googletasks.model.PortletCredential" %>
<%-- <%@ page import="com.drewblessing.googletasks.portlet.ActionUtil" %> --%>
<%@ page import="com.drewblessing.googletasks.portlet.GoogleTasks" %>
<%@ page import="com.drewblessing.googletasks.portlet.util.PortletConstants" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>

<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.WindowState" %>

<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>

<portlet:defineObjects />

<%
// Check if we have authorization already
PortletCredential portletCredential = GoogleTasks.getPortletCredential(renderRequest, renderResponse);
Credential credential = GoogleTasks.getGoogleCredentialFromPortletCredential(portletCredential);

PortletMode portletMode = null;
PortletURL currentURLObj = null;
WindowState windowState = null;

if (renderRequest != null) {
	windowState = renderRequest.getWindowState();
	portletMode = renderRequest.getPortletMode();

	currentURLObj = PortletURLUtil.getCurrent(renderRequest, renderResponse);
}
else if (resourceRequest != null) {
	windowState = resourceRequest.getWindowState();
	portletMode = resourceRequest.getPortletMode();

	currentURLObj = PortletURLUtil.getCurrent(resourceRequest, resourceResponse);
}

String currentURL = currentURLObj.toString();
%>