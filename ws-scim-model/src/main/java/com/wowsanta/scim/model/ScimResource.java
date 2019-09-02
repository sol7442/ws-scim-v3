package com.wowsanta.scim.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SCIM_RESOURCE")
@DiscriminatorValue("src")
public class ScimResource extends ScimSystem{

}
