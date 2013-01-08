<%@ include file="/html/portlet/init.jsp" %>

<portlet:actionURL name="authorize" var="authorizeUrl" />

<div class="portlet-msg-info">
	<a href="<%=authorizeUrl.toString() %>"><liferay-ui:message key="authorize-with-google" /></a> <liferay-ui:message key="to-set-up-task-integration" />
	<liferay-ui:icon image="help" />
	<!-- TODO: Create tooltip or help page -->
</div>