package com.wowsanta.scim.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("job")
public class ScimJob extends ScimGroup{

}
