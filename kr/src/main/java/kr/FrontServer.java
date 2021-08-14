package kr;

import static spark.Spark.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FrontServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		port(6969);
		get("info/:id",(request,response)
	->{ String id =request.params(":id");
	     String url = "http://localhost:6868/info/"+ id;
	     URL obj = new URL (url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     response.header("Content-Type", "application/json");
		return con.getInputStream();});
		
		get("search/:topic",(request,response)
			->{ String topic =request.params(":topic");
		 	   String url = "http://localhost:6868/Search/"+ topic;
			 URL obj = new URL (url);
		 	 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 	  BufferedReader in = new BufferedReader(
			             new InputStreamReader(con.getInputStream()));
			    String inputLine;
			    StringBuffer data = new StringBuffer();

			    while ((inputLine = in.readLine()) != null) {
			        data.append(inputLine);
			    }
		   return data;});
		
		get("purschase/:id",(request,response)
				->{ String id =request.params(":id");
				     String url = "http://localhost:6868/purschase/"+ id;
				     URL obj = new URL (url);
				     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					return con.getInputStream();});
	}//main
}