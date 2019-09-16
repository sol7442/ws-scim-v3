package com.wowsanta.scim.service.before;

import spark.Filter;
import spark.Request;
import spark.Response;

public class AccessFilter implements Filter {

	@Override
	public void handle(Request request, Response response) throws Exception {
		System.out.println("access ------ ");
	}

}
