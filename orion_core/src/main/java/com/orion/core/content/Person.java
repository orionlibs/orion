package com.orion.core.content;

import com.orion.core.abstraction.Orion;

public class Person extends Orion
{
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;


    public Person()
    {
    }


    public static Person of()
    {
        return new Person();
    }


    public String getFirstName()
    {
        return this.firstName;
    }


    public Person setFirstName(String firstName)
    {
        PersonRules.isFirstNameValid(firstName);
        this.firstName = firstName;
        return this;
    }


    public String getMiddleName()
    {
        return this.middleName;
    }


    public Person setMiddleName(String middleName)
    {
        PersonRules.isMiddleNameValid(middleName);
        this.middleName = middleName;
        return this;
    }


    public String getLastName()
    {
        return this.lastName;
    }


    public Person setLastName(String lastName)
    {
        PersonRules.isLastNameValid(lastName);
        this.lastName = lastName;
        return this;
    }


    public int getAge()
    {
        return this.age;
    }


    public Person setAge(int age)
    {
        PersonRules.isAgeValid(age);
        this.age = age;
        return this;
    }
}