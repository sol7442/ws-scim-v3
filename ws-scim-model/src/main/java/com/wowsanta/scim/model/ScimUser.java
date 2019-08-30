package com.wowsanta.scim.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "SCIM_USER")
public class ScimUser  {

	@Id
	@Column(name="id", columnDefinition = "VARCHAR(64)")
	private String id;
	
	@Column(name="name", columnDefinition = "VARCHAR(64)")
	private String name;
	
	@Column(name="active")
	private Boolean active;
	
	@Column(name="modifyTime")
	private Date modifyTime;
	
	@Column(name="createTime")
	private Date createTime;
	

	@ManyToMany(fetch=FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(
			name = "SCIM_USER_ATTRIBUTE", 
			joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_USER_ATTRIBUTE")) }, 
			inverseJoinColumns = { @JoinColumn(name = "attr_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_ATTRIBUTE_USER")) }
	)
	private Set<ScimAttribute> attribues = new HashSet<ScimAttribute>();
	
	public void addAttribute(ScimAttribute attr) {
		this.attribues.add(attr);
	}
	public Set<ScimAttribute> getAttributes() {
		return attribues;
	}

	public void setAttributes(Set<ScimAttribute> attrs) {
		this.attribues = attrs;
	}

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
