<%@ include file="/html/portlet/init.jsp" %>

<liferay-util:include page="<%=PortletConstants.PORTLET_HEADER_JSP %>" servletContext="<%=this.getServletContext() %>" />
<%
List<TaskList> taskLists = GoogleTasks.getTaskLists(credential);
%>
<c:if test="<%= portletName.equals(PortletKeys.GOOGLETASKS) %>">
	<div class="portlet-msg-info settings-msg"><liferay-ui:message key="after-saving-these-preferences-you-may-remove-this-portlet-from-the-page-settings-will-remain-in-effect" /></div>
</c:if>
<aui:layout cssClass="import-export">
	<aui:column columnWidth="50" first="true">
		<aui:input type="checkbox" name="import" label="import-tasks-from-google" />
	</aui:column>
	<aui:column columnWidth="50" last="true">
		<aui:input type="checkbox" name="export" label="export-tasks-from-google" />
	</aui:column>
</aui:layout>
<aui:select name="list" label="default-task-list">
	<%
	for (TaskList taskList : taskLists) {
	%>
		<aui:option value='<%=taskList.getId() %>'><%=taskList.getTitle() %></aui:option>
	<%
	}
	%>
</aui:select>

<aui:button-row>
	<aui:button type="submit" />
</aui:button-row>