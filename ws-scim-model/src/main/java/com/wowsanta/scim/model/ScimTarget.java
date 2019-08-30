package com.wowsanta.scim.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "SCIM_TARGET")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public abstract class ScimTarget {
	@Id
	@Column(name = "id", columnDefinition = "VARCHAR(64)")	
	private String id;

	@Column(name = "name")
	private String name;
}
