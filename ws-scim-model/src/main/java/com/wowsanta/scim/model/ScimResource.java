package com.wowsanta.scim.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "SCIM_RESOURCE")
public class ScimResource {
	@Id
	@Column(name="id", columnDefinition = "VARCHAR(64)")
	private String id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "target_id", referencedColumnName = "id", foreignKey=@ForeignKey(name="FK_TARGET"))
	private ScimTarget target;
	
	@Column(name="value", columnDefinition = "VARCHAR(128)")
	private String value;
	
}
