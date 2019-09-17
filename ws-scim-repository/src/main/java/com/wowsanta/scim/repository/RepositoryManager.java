package com.wowsanta.scim.repository;

public class RepositoryManager {

	private static RepositoryManager instance = null;
	public static RepositoryManager getInstance() {
		if(instance == null) {
			instance = new RepositoryManager();
		}
		return instance;
	}
}
