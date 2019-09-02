
package com.wowsanta.scim.repository;

public interface ScimRepositoryFactory {
	public ScimSession openSession();
	public void close();
}
