package com.wowsanta.scim.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "SCIM_GROUP")
public class ScimGroup {
	
	@Id
	@Column(name="id", columnDefinition = "VARCHAR(64)")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	@Column(name="path")
	private String path;
	
	@Column(name="`order`")
	private int order;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.ALL})
	@JoinColumn(name="parent_id",foreignKey=@ForeignKey(name="FK_PARENT"))
	private ScimGroup parent;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.ALL})
	@JoinColumn(name="root_id", foreignKey=@ForeignKey(name="FK_ROOT"))
	private ScimGroup root;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="parent")	
	private Set<ScimGroup> subGroups = new HashSet<ScimGroup>();
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(
			name = "SCIM_USER_GROUP", 
			joinColumns = { @JoinColumn(name = "group_id", foreignKey=@ForeignKey(name="FK_GROUP_USER")) }, 
			inverseJoinColumns = { @JoinColumn(name = "user_id", foreignKey=@ForeignKey(name="FK_USER_GROUP")) }
	)
	private Set<ScimUser> users = new HashSet<ScimUser>();
	
	public Set<ScimGroup> getSubGroups() {
		return subGroups;
	}

	public void setSubGroups(Set<ScimGroup> subGroups) {
		this.subGroups = subGroups;
	}
	public void removeUser(ScimUser user) {
		this.users.remove(user);
	}
	public void addUser(ScimUser user) {
		this.users.add(user);
	}
	public Set<ScimUser> getUsers() {
		return users;
	}

	public void setUsers(Set<ScimUser> users) {
		this.users = users;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public ScimGroup getParent() {
		return parent;
	}

	public void setParent(ScimGroup parent) {
		this.parent = parent;
	}

//	public ScimGroup getRoot() {
//		return root;
//	}
//
//	public void setRoot(ScimGroup root) {
//		this.root = root;
//	}

//	public Set<ScimGroup> getSubGroups() {
//		return subGroups;
//	}
//
//	public void setSubGroups(Set<ScimGroup> subGroups) {
//		this.subGroups = subGroups;
//	}

//	public Set<ScimUser> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<ScimUser> users) {
//		this.users = users;
//	}	
}
