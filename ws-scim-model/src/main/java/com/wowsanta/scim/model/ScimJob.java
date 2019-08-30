package com.wowsanta.scim.model;

import javax.persistence.*;

@Entity
@Table(name = "SCIM_JOB")
@DiscriminatorValue("job")
public class ScimJob extends ScimGroup{

}
