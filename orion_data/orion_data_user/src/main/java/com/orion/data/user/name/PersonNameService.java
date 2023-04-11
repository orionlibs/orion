package com.orion.data.user.name;

import com.orion.core.abstraction.OrionService;

public class PersonNameService extends OrionService
{
    public static String normaliseName(String name)
    {
        return PersonNameBO.of(name).normaliseName();
    }


    public static boolean isValidFirstName(String firstName)
    {
        return PersonNameBO.of(firstName).isValidName();
    }


    public static boolean isInvalidFirstName(String firstName)
    {
        return !isValidFirstName(firstName);
    }


    public static boolean isValidLastName(String lastName)
    {
        return PersonNameBO.of(lastName).isValidName();
    }


    public static boolean isInvalidLastName(String lastName)
    {
        return !isValidLastName(lastName);
    }


    public static boolean isValidFullName(String fullName)
    {

        if(fullName != null)
        {
            return !fullName.trim().isEmpty();
        }

        return false;
    }


    public static boolean isInvalidFullName(String fullName)
    {
        return !isValidFullName(fullName);
    }
}