
package com.as.rest.challenge.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.as.rest.challenge.ws.PersionsWS;
import com.as.rest.challenge.ws.StatisticWS;


@ApplicationPath("/rs")
public class RestEasyServices extends Application
{
	private Set<Object> singeltons = new HashSet<Object>();

	public RestEasyServices()
	{
		StatisticService statisticService = new StatisticService();
		statisticService.createStatistic();

		singeltons.add( new PersionsWS());
		singeltons.add( new StatisticWS());
	}

	@Override
	public Set<Object> getSingletons()
	{
		return singeltons;
	}
}
