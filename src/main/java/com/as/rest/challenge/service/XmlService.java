
package com.as.rest.challenge.service;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.as.rest.challenge.model.Persons;
import com.as.rest.challenge.model.Statistic;


public class XmlService
{
	private static final String	PERSONS_XSD_FILENAME	= "persons.xsd";
	private static final String	PERSONS_XML_FILENAME	= "persons.xml";
	private static final String	STATISTIC_XML_FILENAME	= "statistic.xml";

	public boolean validateAgainstXSD(String xmlString) throws SAXException, IOException
	{
		File xsdFile = new File( getClass().getResource( PERSONS_XSD_FILENAME).getFile());

		SchemaFactory sf = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema personsSchema = sf.newSchema( xsdFile);
		Validator validator = personsSchema.newValidator();
		validator.validate( new StreamSource( new StringReader( xmlString)));

		return true;
	}

	public void savePersonsToFile(Persons person)
	{
		try
		{
			File file = new File( PERSONS_XML_FILENAME);

			JAXBContext jaxbContext = JAXBContext.newInstance( Persons.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal( person, file);
		}
		catch( Exception e)
		{
			System.out.println( "savePersonsToFile: " + e);
		}
	}

	public Persons getPersons(String xmlString)
	{
		JAXBContext jaxbContext;
		try
		{
			jaxbContext = JAXBContext.newInstance( Persons.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			return (Persons)jaxbUnmarshaller.unmarshal( new StringReader( xmlString));
		}
		catch( JAXBException e)
		{
			System.err.println( "getPersons " + e);
		}

		return null;
	}

	public Persons getPersonsFromFile()
	{
		try
		{
			File file = new File( PERSONS_XML_FILENAME);
			if( file.exists())
			{
				JAXBContext jaxbContext = JAXBContext.newInstance( Persons.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				return (Persons)unmarshaller.unmarshal( file);
			}
		}
		catch( Exception e)
		{
			System.out.println( "getPersonFromFile: " + e);
		}

		return new Persons();
	}

	public void addPersonAndRequestToStatistic(int personCount, int addRequestCount)
	{
		Statistic statistic = getStatisticFromFile();
		statistic.setCountAddPersons( statistic.getCountAddPersons() + personCount);
		statistic.setCountAddRequests( statistic.getCountAddRequests() + addRequestCount);
		statistic.setCountValidRequests( statistic.getCountValidRequests() + addRequestCount);
		saveStatisticToFile( statistic);
	}

	public void addValidRequests(int addRequestCount)
	{
		Statistic statistic = getStatisticFromFile();
		statistic.setCountValidRequests( statistic.getCountValidRequests() + addRequestCount);
		saveStatisticToFile( statistic);
	}

	public void saveStatisticToFile(Statistic statistic)
	{
		try
		{
			File file = new File( STATISTIC_XML_FILENAME);

			JAXBContext jaxbContext = JAXBContext.newInstance( Statistic.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal( statistic, file);
		}
		catch( Exception e)
		{
			System.out.println( "saveStatisticToFile: " + e);
		}
	}

	public Statistic getStatisticFromFile()
	{
		try
		{
			File file = new File( STATISTIC_XML_FILENAME);
			if( file.exists())
			{
				JAXBContext jaxbContext = JAXBContext.newInstance( Statistic.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				return (Statistic)unmarshaller.unmarshal( file);
			}
		}
		catch( Exception e)
		{
			System.out.println( "getStatisticFromFile: " + e);
		}

		return new Statistic();
	}
}
