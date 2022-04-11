
package com.as.rest.challenge.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;

import com.as.rest.challenge.model.Statistic;
import com.as.rest.challenge.service.StatisticService;


@Path("/statistics")
public class StatisticWS
{
	StatisticService statisticService;

	public StatisticWS()
	{
		statisticService = new StatisticService();
	}

	@GET
	public Response getStatistics()
	{
		Statistic statistic = statisticService.getStatistic();
		return Response.status( HttpStatus.SC_OK).entity( statistic).build();
	}
}
