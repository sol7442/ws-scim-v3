package com.wowsanta.scim.repository;


public interface ScimSession {

	public ScimTransaction beginTransaction();
	public void close();
	public void save(Object object);
}
