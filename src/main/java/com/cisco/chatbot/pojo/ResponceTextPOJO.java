package com.cisco.chatbot.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class ResponceTextPOJO {
	private String responceText;

	public String getResponceText() {
		return responceText;
	}

	public void setResponceText(String responceText) {
		this.responceText = responceText;
	}
	

}
