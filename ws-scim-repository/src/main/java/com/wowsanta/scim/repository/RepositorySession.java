package com.wowsanta.scim.repository;


public interface RepositorySession {

	public RepositoryTransaction beginTransaction();
	public void close();
	public void save(Object object);
}
