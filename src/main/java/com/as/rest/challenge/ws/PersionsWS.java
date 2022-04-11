
package com.as.rest.challenge.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;

import com.as.rest.challenge.service.PersonService;
import com.as.rest.challenge.service.StatisticService;


@Path("/persons")
public class PersionsWS
{
	PersonService		personService;
	StatisticService	statisticService;

	public PersionsWS()
	{
		personService = new PersonService();
		statisticService = new StatisticService();
	}

	@GET
	public Response getPersons()
	{
		statisticService.addValidRequests( 1);
		return Response.status( HttpStatus.SC_OK).entity( personService.getPersons()).build();
	}

	@POST
	@Path("/add")
	@Produces(MediaType.TEXT_PLAIN)
	public Response addPerson(String xmlString)
	{
		int httpStatus = HttpStatus.SC_OK;
		String message;
		try
		{
			int count = personService.validateAndAddPersion( xmlString);
			statisticService.addPersonsAndRequests( count, 1);
			message = count + " person added";
		}
		catch( Exception ex)
		{
			message = ex.getMessage();
			httpStatus = HttpStatus.SC_BAD_REQUEST;
		}

		return Response.status( httpStatus).entity( message).build();
	}

	@POST
	@Path("/edit")
	@Produces(MediaType.TEXT_PLAIN)
	public Response editPerson(String xmlString)
	{
		int httpStatus = HttpStatus.SC_OK;
		String message;
		try
		{
			int count = personService.validateAndEditPersion( xmlString);
			statisticService.addValidRequests( 1);
			message = count + " persons edited";
		}
		catch( Exception ex)
		{
			httpStatus = HttpStatus.SC_BAD_REQUEST;
			message = ex.getMessage();
		}
		return Response.status( httpStatus).entity( message).build();
	}
}
