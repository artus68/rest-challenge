
package com.as.rest.challenge.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.xml.sax.SAXException;

import com.as.rest.challenge.model.Person;
import com.as.rest.challenge.model.Persons;


public class PersonService
{
	XmlService xmlService;

	public PersonService()
	{
		xmlService = new XmlService();
	}

	public int validateAndAddPersion(String xmlString) throws SAXException, IOException
	{
		if( xmlService.validateAgainstXSD( xmlString))
		{
			Persons persons = xmlService.getPersons( xmlString);
			return addPersons( persons.getPersonList());
		}

		return 0;
	}

	private int addPersons(List<Person> personList)
	{
		int countOfAddedPersons = 0;
		Persons existPersons = xmlService.getPersonsFromFile();
		if( existPersons != null)
		{
			List<Person> existPersionList = existPersons.getPersonList();
			List<Person> newPersonList = personList.stream().filter( person -> !hasPersion( existPersionList, person))
				.collect( Collectors.toList());

			if( !newPersonList.isEmpty())
			{
				countOfAddedPersons = newPersonList.size();
				newPersonList.stream().forEach( persion -> existPersons.addPerson( persion));
				xmlService.savePersonsToFile( existPersons);
			}
		}
		else
		{
			countOfAddedPersons = personList.size();
			createAndSavePersionList( personList);
		}
		return countOfAddedPersons;
	}

	public int validateAndEditPersion(String xmlString) throws SAXException, IOException
	{
		if( xmlService.validateAgainstXSD( xmlString))
		{
			Persons persons = xmlService.getPersons( xmlString);
			return editPersons( persons.getPersonList());
		}

		return 0;
	}

	private int editPersons(List<Person> personList)
	{
		AtomicInteger countOfEditedPersons = new AtomicInteger( 0);
		Persons existPersons = xmlService.getPersonsFromFile();
		if( existPersons != null)
		{
			List<Person> existPersionList = existPersons.getPersonList();
			personList.stream().forEach( person -> {
				Person existPerson = findPerson( existPersionList, person);
				if( existPerson != null)
				{
					existPerson.setAge( person.getAge());
					existPerson.setGender( person.getGender());
					countOfEditedPersons.addAndGet( 1);
				}
			});
			xmlService.savePersonsToFile( existPersons);
		}

		return countOfEditedPersons.get();
	}

	public Persons getPersons()
	{
		return xmlService.getPersonsFromFile();
	}

	private void createAndSavePersionList(List<Person> personList)
	{
		Persons newPersionList = new Persons();
		newPersionList.setPersonList( personList);
		xmlService.savePersonsToFile( newPersionList);
	}

	private boolean hasPersion(List<Person> personList, Person person)
	{
		return personList.contains( person);
	}

	private Person findPerson(List<Person> personList, Person person)
	{
		return personList.stream().filter( p -> p.equals( person)).findAny().orElse( null);
	}
}
