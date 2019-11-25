
package com.OrganisationRegistration.controllers;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.OrganisationRegistration.webservices.EmployeeServices;
import com.OrganisationRegistration.Dao.OrganisationDao;
import com.OrganisationRegistration.bean.Employee;
import com.OrganisationRegistration.bean.Organisation;
import com.google.gson.Gson;



@Path("/org")
public class OrganisationController
{
	private Gson gson=new Gson();
	private EmployeeServices emp=new EmployeeServices();
	public static class Status<T>{
		T result;
		Status(T result)
		{this.result = result;}
	}
//    @GET
//    @Path("/")
//    @Produces(MediaType.APPLICATION_JSON)
//	public Response ViewOrg(@QueryParam(value="id") Integer id)
//	{
//    	List<Organisation> list=org.View(id);
//    	return Response.ok(gson.toJson(list),MediaType.APPLICATION_JSON).build();
//	}
    
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response.ok AddOrg(String json)
//    {
//    	
//    }
	  @GET
      @Path("/verifyuser")
	  @Produces(MediaType.APPLICATION_JSON)
      public Response loginVerify(@QueryParam (value="id") String email,@QueryParam (value="key") String password)
      {
    	  return Response.ok(gson.toJson(new Status<>(emp.verifyUser(email,password))),MediaType.APPLICATION_JSON).build();
      }
	  

}
