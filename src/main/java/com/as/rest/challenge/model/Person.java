
package com.as.rest.challenge.model;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "person")
public class Person implements Serializable
{
	private static final long					serialVersionUID	= 6562883031434207240L;

	@XmlElement(name = "name") private String	name;
	@XmlElement(name = "gender") private String	gender;
	@XmlElement(name = "age") private int		age;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	@Override
	public boolean equals(Object o)
	{
		if( this == o)
			return true;
		if( o == null || getClass() != o.getClass())
			return false;
		Person that = (Person)o;
		return Objects.equals( hashCode(), that.hashCode());
	}

	@Override
	public int hashCode()
	{
		return Objects.hash( name);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append( "class Person {\n");
		sb.append( "    name: ").append( name).append( "\n");
		sb.append( "    gender: ").append( gender).append( "\n");
		sb.append( "    age: ").append( age).append( "\n");
		sb.append( "}");
		return sb.toString();
	}
}
