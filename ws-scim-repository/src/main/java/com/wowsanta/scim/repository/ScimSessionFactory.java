
package com.wowsanta.scim.repository;

public interface ScimSessionFactory {
	public ScimSession openSession();
	public void close();
}
