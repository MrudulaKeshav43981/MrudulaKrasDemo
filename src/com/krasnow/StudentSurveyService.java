package com.krasnow;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import pojos.Student;


@Path("/studentSurveyService")
public class StudentSurveyService {
	
	private static Map<Integer, String> zipAndStateMap = new HashMap<Integer, String>();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save")
	public String getName(Student studentData)
	{
		try
	    {
	        System.out.println("Name  "+studentData.getFirstName());
	        System.out.println("Address  "+studentData.getStreetAddress());

	    } catch (Exception e)
	    {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

	    return "{\"success\":true}";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{zip}")
	public String getName(@Context HttpHeaders header, @PathParam("zip") String zipCode)
	{
		Integer zip = Integer.parseInt(zipCode);
		return StateAndCity(zip);
	}
	
	private String StateAndCity(int zipCode){
		if(zipAndStateMap.isEmpty()){
			zipAndStateMap.put(22312, "Alexandria,VA");
			zipAndStateMap.put(22030, "Fairfax,VA");
			zipAndStateMap.put(22301, "Tysons Corner,VA");
			zipAndStateMap.put(20148, "Ashburn,VA");
		}
		
		if(zipAndStateMap.containsKey(zipCode))
			return zipAndStateMap.get(zipCode);
		
		return "Please enter a valid Zip code.";
	}
	
	
	
	
	
	
	

}
