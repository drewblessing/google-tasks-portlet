create table GT_PortletCredential (
	id_ LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	googleId VARCHAR(75) null,
	userEmail VARCHAR(75) null,
	userPicture VARCHAR(200) null,
	accessToken VARCHAR(75) null,
	refreshToken VARCHAR(75) null,
	expires LONG
);