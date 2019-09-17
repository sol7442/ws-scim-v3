package com.wowsanta.scim.service.scimv3;

import com.wowsanta.scim.ModelFactory;
import com.wowsanta.scim.service.UserService;
import com.wowsatan.scim.PresentObject;
import com.wowsatan.scim.PrimitiveObject;

import spark.Request;
import spark.Response;
import spark.Route;

public class UserGet implements Route {

	private ModelFactory modelFactory;
	private UserService userService;
	
	@Override
	public Object handle(Request request, Response response) throws Exception {
		try {
			String id = request.params("id");
			PresentObject db_user = userService.get(id);
			PrimitiveObject js_user = db_user.convert();
		
			return js_user.build();
		}catch (Exception e) {
			
			
			throw e;
		}		
	}
}
