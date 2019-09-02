package com.wowsanta.scim.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SCIM_PROVIDER")
@DiscriminatorValue("pro")
public class ScimProvider extends ScimSystem{

}
