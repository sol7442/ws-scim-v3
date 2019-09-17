
package com.wowsanta.scim.repository;


public abstract class RepositorySessionFactory {
	private static RepositorySessionFactory instance = null;
	public static RepositorySessionFactory getInstance() {
		return instance;
	}
	public static void setInstance(RepositorySessionFactory factory) {
		instance = factory;
	}
	
	public abstract RepositorySession openSession();
	public abstract void close();
}
