package com.wowsanta.scim;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class ModelConfiguration {
	private String userPrimitiveClass;
	private String userPresentClass;
	
	
	private Map<String,String> groupPrimitiveClass = new HashMap<String, String>();
	private Map<String,String> groupPresentClass = new HashMap<String, String>();
	
	
	public static ModelConfiguration load(String file_name) throws FileNotFoundException {
		Gson gson = new GsonBuilder().create();
		JsonReader reader = new JsonReader(new FileReader(file_name));
		return gson.fromJson(reader,ModelConfiguration.class);
	}
	
	public ModelFactory build() {
		ModelFactory manager = ModelFactory.getInstance();
		
		return manager;
	}

	public String getUserPrimitiveClass() {
		return userPrimitiveClass;
	}

	public void setUserPrimitiveClass(String userPrimitiveClass) {
		this.userPrimitiveClass = userPrimitiveClass;
	}

	public String getUserPresentClass() {
		return userPresentClass;
	}

	public void setUserPresentClass(String userPresentClass) {
		this.userPresentClass = userPresentClass;
	}

	public void addGroupPrimitiveClass(String type, String clazz) {
		this.groupPrimitiveClass.put(type, clazz);
	}
	public Map<String,String> getGroupPrimitiveClass() {
		return groupPrimitiveClass;
	}
	
	public void setGroupPrimitiveClass(Map<String,String> groupPrimitiveClass) {
		this.groupPrimitiveClass = groupPrimitiveClass;
	}
	public void addGroupPresentClass(String type, String clazz) {
		this.groupPresentClass.put(type, clazz);
	}
	public Map<String,String> getGroupPresentClass() {
		return groupPresentClass;
	}

	public void setGroupPresentClass(Map<String,String> groupPresentClass) {
		this.groupPresentClass = groupPresentClass;
	}
}
