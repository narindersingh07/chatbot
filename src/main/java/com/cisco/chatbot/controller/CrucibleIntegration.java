package com.cisco.chatbot.controller;



import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

//import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class CrucibleIntegration {
	public static void main(String[] args) {
		try{
			URL url = new URL("https://github.com/Padmaja7/newApp/commits/master");
			URLConnection con = url.openConnection();
			InputStream in = con.getInputStream();
			String encoding = con.getContentType();  // ** WRONG: should use "con.getContentType()" instead but it returns something like "text/html; charset=UTF-8" so this value must be parsed to extract the actual encoding
			if (encoding == null)
				encoding = "UTF-8";
			else
				encoding = "UTF-8";
			//String body = IOUtils.toString(in, encoding);
			//System.out.println(body);
			Document doc = Jsoup.connect("https://github.com/Padmaja7/newApp/commits/master").get();
			//System.out.println(doc.select(".commit-title a"));
			//Elements contents = doc.getElementsByClass("message");			
			Elements contents = doc.select(".commits-list-item");
			int i=0;
			for(Element content: contents)
			{
				System.out.println("Commit ID :"+ content.getElementsByClass("sha").text());
				System.out.println("Commit Message :"+ content.getElementsByClass("message").text());
				System.out.println("Committed by :"+ content.getElementsByClass("user-mention").text());								
				String path="https://github.com"+content.getElementsByClass("sha").attr("href");
				Document commitDoc=Jsoup.connect(path).get();
				System.out.println("Chnaged Files Count :"+ commitDoc.getElementsByClass("js-details-target").text().split("changed")[0]);
				i=i+1;
				if(i>0)
				{
					break;
				}
			}	
			System.out.println("Committed at :"+ doc.getElementsByClass("commit-group-title").text().split("on")[1]);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
