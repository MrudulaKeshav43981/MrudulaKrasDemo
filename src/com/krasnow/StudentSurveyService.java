package com.krasnow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dbobjects.DatabaseMapper;
import pojos.Student;



@Path("/studentSurveyService")
public class StudentSurveyService {
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save")
	public String saveStudent(Student studentData)
	{
		DatabaseMapper mapper=new DatabaseMapper();
		try
	    {
	       
	        mapper.saveStudents(studentData);

	    } catch (Exception e)
	    {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

	    return "{\"success\":true}";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get")
	public List<Student> getStudents()
	{
		
		 Map<String, String> studentMap = new HashMap<String, String>();
		DatabaseMapper mapper=new DatabaseMapper();
		List<Student> students=new ArrayList<Student>();
		try {
		
		students=mapper.getStudents();
		
		
		
		
		
		
		
		
		
		
		}
		
		catch(Exception e)
		{
			// TODO Auto-generated catch block
	        e.printStackTrace();
			
		}
		
		return students;
	}
	
	
	
	
	
	
	
	
	

}
