package com.cisco.chatbot.controller;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.chatbot.pojo.ChatbotPOJO;
import com.cisco.chatbot.pojo.JenkinsResponsePOJO;
import com.cisco.chatbot.pojo.ResponceTextPOJO;
import com.cisco.chatbot.services.JenkinsService;

@ResponseBody
@RestController
public class JenkinsController {
	

	/*@RequestMapping("/hello")
	public String hello(@RequestParam String name) {
		return "Hello "+name;
	}*/
	
	
	@RequestMapping("/jenkins_getUser")
	public ResponceTextPOJO getUser(@RequestBody ChatbotPOJO jenkinsPojo){
		ResponceTextPOJO description = new ResponceTextPOJO();
		//description.setDescription("hello");
		JenkinsService service = new JenkinsService();
		description.setResponceText(service.getResponse(jenkinsPojo.getUrl(),"getUser"));
		return description;
		
	}
	@RequestMapping("/jenkins_getWorkspace")
	public ResponceTextPOJO getWorkspace(@RequestBody ChatbotPOJO jenkinsPojo){
		ResponceTextPOJO description = new ResponceTextPOJO();
		//description.setDescription("hello");
		JenkinsService service = new JenkinsService();
		description.setResponceText(service.getResponse(jenkinsPojo.getUrl(),"getWorkspace"));
		return description;
		
	}
	@RequestMapping("/jenkins_getReport")
	public JenkinsResponsePOJO getReport(@RequestBody ChatbotPOJO jenkinsPojo){
		JenkinsResponsePOJO description = new JenkinsResponsePOJO();
		boolean sonar =false;
		//description.setDescription("hello");
		JenkinsService service = new JenkinsService();
		description.setUser(service.getResponse(jenkinsPojo.getUrl(),"getUser"));
		description.setWorkspace(service.getResponse(jenkinsPojo.getUrl(),"getWorkspace"));
		description.setTestsResult(service.getResponse(jenkinsPojo.getUrl(),"testsStatus"));
		description.setBuildStatus(service.getResponse(jenkinsPojo.getUrl(),"buildStatus"));
		description.setResponseText("");
		description.setIsSonarEnabled(sonar);
		description.setSonarUrl("");
		description.setBuildTime(service.getResponse(jenkinsPojo.getUrl(),"getTotalTime"));
		return description;
		
	}
	@RequestMapping("/jenkins_buildStatus")
	public ResponceTextPOJO buildStatus(@RequestBody ChatbotPOJO jenkinsPojo){
		ResponceTextPOJO description = new ResponceTextPOJO();
		//description.setDescription("hello");
		JenkinsService service = new JenkinsService();
		description.setResponceText(service.getResponse(jenkinsPojo.getUrl(),"buildStatus"));
		return description;
		 
	}
	@RequestMapping("/jenkins_testsStatus")
	public ResponceTextPOJO testsStatus(@RequestBody ChatbotPOJO jenkinsPojo){
		ResponceTextPOJO description = new ResponceTextPOJO();
		//description.setDescription("hello");
		JenkinsService service = new JenkinsService();
		description.setResponceText(service.getResponse(jenkinsPojo.getUrl(),"testsStatus"));
		return description;
		
	}
	
	
}

