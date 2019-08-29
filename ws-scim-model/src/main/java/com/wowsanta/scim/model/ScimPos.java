package com.wowsanta.scim.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("pos")
public class ScimPos extends ScimGroup{

}
