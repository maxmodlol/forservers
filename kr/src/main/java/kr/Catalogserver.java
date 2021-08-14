package kr;

//package com.code.spark;
import static spark.Spark.*;

import com.google.gson.Gson;
public class Catalogserver {

	static String path = "D:/Desktop/Books.xlsx";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		port(6868);
		Gson gson = new Gson();
  	get("info/:id",( req,res)->{double ID = Double.parseDouble(req.params(":id"));
		res.header("Content-Type", "application/json");
  		return gson.toJson(Reader.infoFromExcel(path, ID));			
  	});
  	
  	get("Search/:topic",( req,res)->{String topic = req.params(":topic");
  		return gson.toJson(Reader.SearchFromExcel(path, topic));			
  	});

	}

}