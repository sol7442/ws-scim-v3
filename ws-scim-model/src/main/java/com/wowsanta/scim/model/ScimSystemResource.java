package com.wowsanta.scim.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "SCIM_SYSTEM_RESOURCE")
public class ScimSystemResource {
	@Id
	@Column(name="id", columnDefinition = "VARCHAR(64)")
	private String id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "system_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_SYSTEM"))
	private ScimSystem system;
	
	@Column(name="value", columnDefinition = "VARCHAR(128)")
	private String value;
	
}
