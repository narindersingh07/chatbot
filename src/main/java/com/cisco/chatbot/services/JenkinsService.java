package com.cisco.chatbot.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

public class JenkinsService {
	
	public String getResponse(String url1,String response){
		String result = "";
		
		try{
			String user = "admin"; // username
		      String pass = "admin"; // password or API token
		      String authStr = user +":"+  pass; 	
		      
			 String encoding = DatatypeConverter.printBase64Binary(authStr.getBytes("utf-8"));
		      
		      URL url = new URL(url1);
		      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		      connection.setRequestMethod("POST");
		      connection.setDoOutput(true);
		      connection.setRequestProperty("Authorization", "Basic " + encoding);
		      InputStream content = connection.getInputStream();
		      List<String> list = new ArrayList<String>();	
		      BufferedReader in   =
		          new BufferedReader (new InputStreamReader (content));
		      String line;
		     if(response.equals("getUser")){
		      while ((line = in.readLine()) != null) {
		    	  list.add(line);
		    	  if(line.matches(".*Started by user.*")){
		    		  result= line;
		    	  }
		      }
		     }
		      if(response.equals("getReport")){
			      while ((line = in.readLine()) != null) {
			    	  list.add(line);
			    	  if(line.matches(".*Started by user.*")){
			    		  result += line+"\n";
			    	  }
			    	  if((line.matches(".*Building in workspace.* "))){
						    result +=line+"\n";
						}
			    	  if((line.matches("Running.*"))||(line.matches("Tests.*"))){
						    result +=line+"\n";
						}
			    	  if(line.equals("Finished: SUCCESS")){
			    		  result += line;
			    	  }else if(line.equals("Finished: FAILURE")){
			    		  result +=line;
			    	  }
			    	  
			      }
		      }
			   if(response.equals("buildStatus")){
				   
				      while ((line = in.readLine()) != null) {
				    	  list.add(line);
				    	  if(line.equals("Finished: SUCCESS")){
				    		  result= line;
				    	  }else if(line.equals("Finished: FAILURE")){
				    		  result =line;
				    	  }
				      }
			   }
			   if(response.equals("testsStatus")){
				 while ((line = in.readLine()) != null) {
					   list.add(line);
					if((line.matches("Running.*"))||(line.matches("Tests.*"))){
					    result +=line+"\n";
					}
			    }
			   }
				 if(response.equals("getWorkspace")){
					 
					 while ((line = in.readLine()) != null) {
						   list.add(line);
						if(line.matches(".*Building.*workspace.*") && !(line.matches(".*jar.*"))){
							System.out.println("inside work");
						    result =line;
						}
				    }
				 
				 }
				 if(response.equals("getTotalTime")){
					 
					 while ((line = in.readLine()) != null) {
						   list.add(line);
						if(line.matches(".*Total time.*")){
							System.out.println("inside work");
						    result =line.substring(7);
						}
				    }
				 
				 }
			   
		        
		      
		    } catch(Exception e) {
		      e.printStackTrace();
		    }
		  return result;
		}
		
		
	}


