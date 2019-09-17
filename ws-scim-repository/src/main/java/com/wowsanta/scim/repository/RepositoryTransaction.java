package com.wowsanta.scim.repository;

public interface RepositoryTransaction {

	public void commit();
	public void rollback();
}
