package com.wowsanta.scim.model;


import javax.persistence.*;

import com.wowsatan.scim.PresentObject;

@Entity
@Table(name = "SCIM_GROUP")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public abstract class ScimGroup implements PresentObject {

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

