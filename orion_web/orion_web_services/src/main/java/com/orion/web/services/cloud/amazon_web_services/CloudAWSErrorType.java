package com.orion.web.services.cloud.amazon_web_services;

import com.orion.core.abstraction.OrionEnumeration;

public enum CloudAWSErrorType implements OrionEnumeration
{
    AWSEC2("aws.ec2"),
    AWSS3("aws.s3"),
    AWSRDS("aws.rds");


    private String name;


    private CloudAWSErrorType(String name)
    {
        setName(name);
    }


    @Override
    public String get()
    {
        return getName();
    }


    public String getName()
    {
        return this.name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    @Override
    public boolean is(OrionEnumeration other)
    {
        return other instanceof CloudAWSErrorType && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof CloudAWSErrorType && this != other;
    }


    public static boolean valueExists(String other)
    {
        CloudAWSErrorType[] values = values();

        for(CloudAWSErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return true;
            }

        }

        return false;
    }


    public static CloudAWSErrorType getEnumForValue(String other)
    {
        CloudAWSErrorType[] values = values();

        for(CloudAWSErrorType value : values)
        {

            if(value.get().equals(other))
            {
                return value;
            }

        }

        return null;
    }
}