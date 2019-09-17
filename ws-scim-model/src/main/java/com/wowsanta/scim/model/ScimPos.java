package com.wowsanta.scim.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wowsatan.scim.PrimitiveObject;


@Entity
@Table(name = "SCIM_POS")
@DiscriminatorValue("pos")
public class ScimPos extends ScimGroup{

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
