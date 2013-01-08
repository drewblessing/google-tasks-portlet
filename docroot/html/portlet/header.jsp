<%@ include file="/html/portlet/init.jsp" %>

<portlet:actionURL name="revokeGoogleToken" var="revokeGoogleTokenURL">
	<portlet:param name="token" value="<%=portletCredential.getAccessToken() %>" />
</portlet:actionURL>

<div class="user-info-header right">
	<aui:layout>
		<aui:column columnWidth="75">
			<div class=""><%=portletCredential.getUserEmail() %></div>
			<div>
				<a href="<%=revokeGoogleTokenURL.toString() %>"><liferay-ui:message key="sign-out-of-google" /></a>
			</div>
		</aui:column>
		<aui:column columnWidth="25">
			<img src='<%=portletCredential.getUserPicture() %>' />
		</aui:column>
	</aui:layout>
</div>