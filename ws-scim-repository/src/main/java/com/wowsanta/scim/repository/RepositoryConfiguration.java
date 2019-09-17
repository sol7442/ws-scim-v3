package com.wowsanta.scim.repository;

import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.wowsanta.scim.repository.jpa.HibernateSessonFactory;

public class RepositoryConfiguration {

	public enum REPOSITORY{
		JDBC,HIBERNATE
	}
	private REPOSITORY 		tyep;
	private String configPath;
	
	
	
	public String toString(boolean pretty) {
		try {
			GsonBuilder builder = new GsonBuilder().disableHtmlEscaping();
			if(pretty) {
				builder.setPrettyPrinting();
			}
			Gson gson = builder.create();

			return gson.toJson(this);
		}catch (Exception e) {
		}
		return "";
	}
	public void save(String file) {
		try {
			GsonBuilder builder = new GsonBuilder().disableHtmlEscaping();
			builder.setPrettyPrinting();			
			Gson gson = builder.create();

			FileWriter writer = new FileWriter(file);
			writer.write(gson.toJson(this));
			writer.close();
			
		}catch (Exception e) {
		}
	}
	public static RepositoryConfiguration load(String file) {
		try {
			Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
			JsonReader reader = new JsonReader(new FileReader(file));
			return gson.fromJson(reader, RepositoryConfiguration.class);
		} catch (Exception e) {
			
		}
		return null;
	}
	
	
	public REPOSITORY getTyep() {
		return tyep;
	}
	public void setTyep(REPOSITORY tyep) {
		this.tyep = tyep;
	}
	
	public RepositorySessionFactory build() {
		switch (this.tyep) {
		case JDBC:
			break;
		case HIBERNATE:
			RepositorySessionFactory.setInstance(new HibernateSessonFactory(this.configPath));
			break;
		default:
			break;
		}
		
		return RepositorySessionFactory.getInstance();
	}
	
	public String getConfigPath() {
		return configPath;
	}
	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}
}
