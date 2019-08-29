package com.wowsanta.scim.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "SCIM_ATTRIBUTE")
public class ScimAttribute {
	
	public ScimAttribute() {
		
	}
	
	public ScimAttribute(ScimOrg org, ScimPos pos, ScimJob job) {
		StringBuffer buffer = new StringBuffer();
		
		this.org = org;
		this.pos = pos;
		this.job = job;

		if(this.org != null) {
			buffer.append(org.getId());
		}
		if(this.pos != null) {
			buffer.append(pos.getId());
		}
		if(this.job != null) {
			buffer.append(job.getId());
		}
		
		this.id = buffer.toString();
	}
	@Id
	private String id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})	
	private ScimOrg org;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})			
	private ScimPos pos;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})		
	private ScimJob job;
		
//	@Expose
//	@ManyToMany(fetch=FetchType.LAZY, cascade = { CascadeType.ALL })
//	@JoinTable(
//			name = "SCIM_USER_ATTRIBUTE", 
//			joinColumns = { @JoinColumn(name = "attr_id", foreignKey=@ForeignKey(name="FK_ATTRIBUTE_USER")) }, 
//			inverseJoinColumns = { @JoinColumn(name = "user_id") }
//	)
//	private transient Set<ScimUser> users = new HashSet<ScimUser>();
	
//------------------------------//	
	public ScimOrg getOrg() {
		return org;
	}

	public void setOrg(ScimOrg org) {
		this.org = org;
	}

	public ScimPos getPos() {
		return pos;
	}

	public void setPos(ScimPos pos) {
		this.pos = pos;
	}

	public ScimJob getJob() {
		return job;
	}

	public void setJob(ScimJob job) {
		this.job = job;
	}
}
