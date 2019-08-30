package com.wowsanta.scim.model;


import javax.persistence.*;

@Entity
@Table(name = "SCIM_GROUP")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public abstract class ScimGroup {

	@Id
	@Column(name = "id", columnDefinition = "VARCHAR(64)")	
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "`order`")
	private int order;

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

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
}
//	
//	@Column(name="code")
//	private String code;
//	

//	


//	
//	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.ALL})
//	@JoinColumn(name="root_id", foreignKey=@ForeignKey(name="FK_ROOT"))
//	private ScimGroup root;
//	

//	
//	@ManyToMany(fetch=FetchType.LAZY, cascade = { CascadeType.ALL })
//	@JoinTable(
//			name = "SCIM_USER_GROUP", 
//			joinColumns = { @JoinColumn(name = "group_id", foreignKey=@ForeignKey(name="FK_GROUP_USER"))}, 
//			inverseJoinColumns = { @JoinColumn(name = "user_id") }
//	)
//	private Set<ScimUser> users = new HashSet<ScimUser>();
//	

//	public void removeUser(ScimUser user) {
//		this.users.remove(user);
//	}
//	public void addUser(ScimUser user) {
//		this.users.add(user);
//	}
//	public Set<ScimUser> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<ScimUser> users) {
//		this.users = users;
//	}
//

//
//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	public String getPath() {
//		return path;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}
//
//	public int getOrder() {
//		return order;
//	}
//
//	public void setOrder(int order) {
//		this.order = order;
//	}
//


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
//}
