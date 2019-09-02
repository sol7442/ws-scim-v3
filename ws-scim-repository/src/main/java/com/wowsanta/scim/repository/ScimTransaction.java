package com.wowsanta.scim.repository;

public interface ScimTransaction {

	public void commit();
	public void rollback();
}
