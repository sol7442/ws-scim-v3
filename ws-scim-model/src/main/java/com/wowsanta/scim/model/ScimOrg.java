package com.wowsanta.scim.model;


import javax.persistence.*;


@Entity
@Table(name = "SCIM_ORG")
@DiscriminatorValue("org")
public class ScimOrg extends ScimGroup {
	@Column(name="path")
	private String path;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.ALL})
	@JoinColumn(name="parent_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_PARENT"))
	private ScimOrg parent;
	
	public ScimOrg getParent() {
		return parent;
	}

	public void setParent(ScimOrg parent) {
		this.parent = parent;
	}
}
