package com.wowsanta.scim;

import com.wowsatan.scim.PrimitiveObject;

import java.util.HashMap;
import java.util.Map;

import com.wowsatan.scim.PresentObject;

public class ModelFactory {
	private static ModelFactory instance = null;
	
	private Class<PrimitiveObject> userPrimitiveClass;
	private Class<PresentObject> userPresentClass;
	
	private Map<String,Class<PrimitiveObject>> groupPrimitiveClass = new HashMap<String, Class<PrimitiveObject>>();
	private Map<String,Class<PresentObject>> groupPresentClass = new HashMap<String, Class<PresentObject>>();
	
	public static ModelFactory getInstance() {
		if(instance == null) {
			instance = new ModelFactory();
		}
		return instance;
	}
	
	public PrimitiveObject newPrimiteUser() throws InstantiationException, IllegalAccessException {
		return this.userPrimitiveClass.newInstance();
	}
	
	public PresentObject newPresentUser() throws InstantiationException, IllegalAccessException {
		return this.userPresentClass.newInstance();
	}
	
	public PrimitiveObject newPrimitiveGroup(String type) throws InstantiationException, IllegalAccessException {
		return this.groupPrimitiveClass.get(type).newInstance();
	}
	
	public PresentObject newPrisentGroupd(String type) throws InstantiationException, IllegalAccessException {
		return this.groupPresentClass.get(type).newInstance();
	}
	
	public Class<PresentObject> getUserPresentClass() {
		return userPresentClass;
	}

	public void setUserPresentClass(Class<PresentObject> userPresentClass) {
		this.userPresentClass = userPresentClass;
	}

	public Class<PrimitiveObject> getUserPrimitiveClass() {
		return userPrimitiveClass;
	}

	public void setUserPrimitiveClass(Class<PrimitiveObject> userPrimitiveClass) {
		this.userPrimitiveClass = userPrimitiveClass;
	}

	public Map<String,Class<PrimitiveObject>> getGroupPrimitiveClass() {
		return groupPrimitiveClass;
	}
	public void addGroupPrimitiveClass(String type, Class<PrimitiveObject> clzz) {
		this.groupPrimitiveClass.put(type, clzz);
	}
	public void setGroupPrimitiveClass(Map<String,Class<PrimitiveObject>> groupPrimitiveClass) {
		this.groupPrimitiveClass = groupPrimitiveClass;
	}
	public void addGroupPresentClass(String type, Class<PresentObject> clzz) {
		this.groupPresentClass.put(type, clzz);
	}
	
	public Map<String,Class<PresentObject>> getGroupPresentClass() {
		return groupPresentClass;
	}
	public void setGroupPresentClass(Map<String,Class<PresentObject>> groupPresentClass) {
		this.groupPresentClass = groupPresentClass;
	}
}
