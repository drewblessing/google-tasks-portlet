<%@ include file="/html/portlet/init.jsp" %>

<c:choose>
	<c:when test="<%=Validator.isNull(credential) %>">
		<!-- Display login and help links -->
		<liferay-util:include
				page="<%=PortletConstants.PORTLET_SIGN_IN_JSP %>"
				servletContext="<%=this.getServletContext() %>" />
	</c:when>
	<c:otherwise>	
		<%
		PortletURL portletURL = renderResponse.createRenderURL();
		pageContext.setAttribute("portletURL",portletURL);
		%>	
		
		<portlet:renderURL var="renderURL" copyCurrentRenderParameters="true" 
				windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
			<portlet:param name="jspPage" value="<%=PortletConstants.PORTLET_AUTHORIZED_VIEW_JSP %>" />
		</portlet:renderURL>
		
		<aui:script use="aui-io">
			var tasksWrapper = A.one('#<portlet:namespace />tasksWrapper');
			if (tasksWrapper) {
				tasksWrapper.plug(A.Plugin.IO, { uri: '<%=renderURL.toString() %>' });
			}
		</aui:script>
		
		<aui:form method="get" name="fm">
			<liferay-portlet:renderURLParams varImpl="portletURL" />
			<div id="<portlet:namespace />tasksWrapper" class="tasks-wrapper"></div>
		</aui:form>
	</c:otherwise>
</c:choose>