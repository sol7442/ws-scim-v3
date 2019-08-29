package com.wowsanta.scim.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

@Entity
@DiscriminatorValue("org")
public class ScimOrg extends ScimGroup {
	@Column(name="path")
	private String path;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.ALL})
	@JoinColumn(name="parent_id",foreignKey=@ForeignKey(name="FK_PARENT"))
	private ScimOrg parent;
	
//	@Expose
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="parent")	
//	private transient Set<ScimOrg> subGroups = new HashSet<ScimOrg>();
	
	
//	public void addSubGroups(ScimOrg group) {
//		subGroups.add(group);
//	}
//	public void removeSubGroups(ScimOrg group) {
//		subGroups.remove(group);
//	}
//	
//	public Set<ScimOrg> getSubGroups() {
//		return subGroups;
//	}
//
//	public void setSubGroups(Set<ScimOrg> subGroups) {
//		this.subGroups = subGroups;
//	}
	
	public ScimOrg getParent() {
		return parent;
	}

	public void setParent(ScimOrg parent) {
		this.parent = parent;
	}
}
