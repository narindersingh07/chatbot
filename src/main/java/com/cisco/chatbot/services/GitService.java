package com.cisco.chatbot.services;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class GitService {
	public String getResponse(String url1,String response){
	String result = "";
	try{
		Document doc = Jsoup.connect(url1).get();
		Elements contents = doc.select(".commits-list-item");
		int i=0;
		for(Element content: contents)
		{
			result ="Commit ID :"+ content.getElementsByClass("sha").text();
			result = result + "\n Commit Message :"+ content.getElementsByClass("message").text();
			result = result + "\n Committed by :"+ content.getElementsByClass("user-mention").text();
			
			
			String path="https://github.com"+content.getElementsByClass("sha").attr("href");
			Document commitDoc=Jsoup.connect(path).get();
			result = result + "\n Changed Files Count :"+ commitDoc.getElementsByClass("js-details-target").text().split("changed")[0];
			i=i+1;
			if(i>0)
			{
				break;
			}
		}	
		
		result = result + "\n Committed at :"+ doc.getElementsByClass("commit-group-title").text().split("on")[1];
		result = result.substring(0, result.length()-9);
	
		
	}
	catch(Exception e ){
		e.printStackTrace();
	}
	return result;
	}
}
