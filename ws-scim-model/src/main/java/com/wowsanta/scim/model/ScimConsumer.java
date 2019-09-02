package com.wowsanta.scim.model;

import javax.persistence.*;

@Entity
@Table(name = "SCIM_CONSUMER")
@DiscriminatorValue("con")
public class ScimConsumer extends ScimSystem {

}
