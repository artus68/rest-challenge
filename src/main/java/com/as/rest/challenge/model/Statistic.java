
package com.as.rest.challenge.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "statistic")
public class Statistic implements Serializable
{
	private static final long								serialVersionUID	= -6543124038455617095L;

	@XmlElement(name = "countAddPersons") private int		countAddPersons;
	@XmlElement(name = "countAddRequests") private int		countAddRequests;
	@XmlElement(name = "countValidRequests") private int	countValidRequests;

	public int getCountAddPersons()
	{
		return countAddPersons;
	}

	public void setCountAddPersons(int countAddPersons)
	{
		this.countAddPersons = countAddPersons;
	}

	public int getCountAddRequests()
	{
		return countAddRequests;
	}

	public void setCountAddRequests(int countAddRequests)
	{
		this.countAddRequests = countAddRequests;
	}

	public int getCountValidRequests()
	{
		return countValidRequests;
	}

	public void setCountValidRequests(int countValidRequests)
	{
		this.countValidRequests = countValidRequests;
	}
}
