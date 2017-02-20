package com.cisco.chatbot.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class JenkinsResponsePOJO {
	private String user;
	private String workspace;
	private String testsResult;
	private String buildStatus;
	private String responseText;
	private Boolean isSonarEnabled;
	private String sonarUrl;
	private String buildTime;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getWorkspace() {
		return workspace;
	}
	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}
	public String getTestsResult() {
		return testsResult;
	}
	public void setTestsResult(String testsResult) {
		this.testsResult = testsResult;
	}
	public String getBuildStatus() {
		return buildStatus;
	}
	public void setBuildStatus(String buildStatus) {
		this.buildStatus = buildStatus;
	}
	public String getResponseText() {
		return responseText;
	}
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
	public Boolean getIsSonarEnabled() {
		return isSonarEnabled;
	}
	public void setIsSonarEnabled(Boolean isSonarEnabled) {
		this.isSonarEnabled = isSonarEnabled;
	}
	public String getSonarUrl() {
		return sonarUrl;
	}
	public void setSonarUrl(String sonarUrl) {
		this.sonarUrl = sonarUrl;
	}
	public String getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}
}
