
package com.as.rest.challenge.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "persons")
public class Persons implements Serializable
{
	private static final long					serialVersionUID	= 6995888131898045158L;

	@XmlElement(name = "person") List<Person>	personList			= new ArrayList<Person>();

	public List<Person> getPersonList()
	{
		return personList;
	}

	public void addPerson(Person person)
	{
		this.personList.add( person);
	}

	public void setPersonList(List<Person> personList)
	{
		this.personList = personList;
	}
}
