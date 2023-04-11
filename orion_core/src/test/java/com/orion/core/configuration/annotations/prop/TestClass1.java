package com.orion.core.configuration.annotations.prop;

import com.orion.core.abstraction.Orion;

public class TestClass1 extends Orion
{
    @Prop(key = "java.runtime.name")
    private String propertyValue;
    private String propertyValue2;


    public String getPropertyValue()
    {
        return this.propertyValue;
    }


    public String getPropertyValue2()
    {
        return this.propertyValue2;
    }


    @Prop(key = "java.runtime.name")
    public void setPropertyValue2(String propertyValue2)
    {
        this.propertyValue2 = propertyValue2 + " extra string";
    }
}