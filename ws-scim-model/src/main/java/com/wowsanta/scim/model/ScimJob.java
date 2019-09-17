package com.wowsanta.scim.model;

import javax.persistence.*;

import com.wowsatan.scim.PrimitiveObject;


@Entity
@Table(name = "SCIM_JOB")
@DiscriminatorValue("job")
public class ScimJob extends ScimGroup{

	@Override
	public void convert(PrimitiveObject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PrimitiveObject convert() {
		// TODO Auto-generated method stub
		return null;
	}

}
