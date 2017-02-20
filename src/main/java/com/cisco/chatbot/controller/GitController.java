package com.cisco.chatbot.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.chatbot.pojo.ChatbotPOJO;
import com.cisco.chatbot.pojo.ResponceTextPOJO;
import com.cisco.chatbot.services.GitService;

@ResponseBody
@RestController
public class GitController {
	
	@RequestMapping("/git_details")
	public ResponceTextPOJO gitDetails(@RequestBody ChatbotPOJO chatbotPojo){
		ResponceTextPOJO description = new ResponceTextPOJO();
		//description.setDescription("hello");
		GitService gitService = new GitService();
		description.setResponceText(gitService.getResponse(chatbotPojo.getUrl(),"gitDetails"));
		return description;
		
	}

}
