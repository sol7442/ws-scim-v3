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
	@Column(name="id", columnDefinition = "VARCHAR(256)")
	private String id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})
	@JoinColumn(name = "org_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_ORG"))
	private ScimOrg org;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})
	@JoinColumn(name = "pos_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_POS"))
	private ScimPos pos;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})		
	@JoinColumn(name = "job_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_JOB"))
	private ScimJob job;
	
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
