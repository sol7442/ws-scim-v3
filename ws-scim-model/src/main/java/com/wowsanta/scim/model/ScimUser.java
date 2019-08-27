package com.wowsanta.scim.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCIM_USER")
public class ScimUser  {

	@Id
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="active")
	private Boolean active;
	
	@Column(name="modifyTime")
	private Date modifyTime;
	
	@Column(name="createTime")
	private Date createTime;
	

	public ScimUser() {
	}
	
	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public ScimUser(String id) {
		this.id = id;
	}

	public ScimUser(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
