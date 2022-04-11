
package com.as.rest.challenge.service;

import com.as.rest.challenge.model.Statistic;


public class StatisticService
{
	XmlService xmlService;

	public StatisticService()
	{
		xmlService = new XmlService();
	}

	public void createStatistic()
	{
		Statistic newStatistic = new Statistic();
		xmlService.saveStatisticToFile( newStatistic);
	}

	public void addPersonsAndRequests(int personCount, int addRequestCount)
	{
		xmlService.addPersonAndRequestToStatistic( personCount, addRequestCount);
	}

	public void addValidRequests(int addRequestCount)
	{
		xmlService.addValidRequests( addRequestCount);
	}

	public Statistic getStatistic()
	{
		return xmlService.getStatisticFromFile();
	}
}
