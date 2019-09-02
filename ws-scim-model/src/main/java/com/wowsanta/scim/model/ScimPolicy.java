package com.wowsanta.scim.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "SCIM_POLICY")
public class ScimPolicy {
	@Id
	@Column(name="id", columnDefinition = "VARCHAR(64)")
	private String id;
	
	@Column(name="name", columnDefinition = "VARCHAR(64)")
	private String name;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(
			name = "SCIM_POLICY_ATTRIBUTE", 
			joinColumns = { @JoinColumn(name = "policy_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_POLICY_ATTRIBUTE")) }, 
			inverseJoinColumns = { @JoinColumn(name = "attr_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_ATTRIBUTE_POLICY")) }
	)
	private Set<ScimAttribute> attribues = new HashSet<ScimAttribute>();

	@ManyToMany(fetch=FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(
			name = "SCIM_POLICY_RESOURCE", 
			joinColumns = { @JoinColumn(name = "policy_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_POLICY_ATTRIBUTE")) }, 
			inverseJoinColumns = { @JoinColumn(name = "resource_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_RESOURCE_POLICY")) }
	)
	private Set<ScimSystemResource> resources = new HashSet<ScimSystemResource>();
	
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

	public Set<ScimAttribute> getAttribues() {
		return attribues;
	}

	public void setAttribues(Set<ScimAttribute> attribues) {
		this.attribues = attribues;
	}
	
	
}
