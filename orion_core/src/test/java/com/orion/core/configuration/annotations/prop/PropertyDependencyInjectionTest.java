package com.orion.core.configuration.annotations.prop;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

// @RunWith(ConcurrentJUnitRunner.class)
@TestInstance(Lifecycle.PER_CLASS)
public class PropertyDependencyInjectionTest
{
    @BeforeAll
    public void setUp() throws Exception
    {
    }


    @Test
    @Disabled
    public void testPropertyDependencyInjection()
    {
        TestClass1 testClass1 = new TestClass1();
        Assert.assertEquals("Java(TM) SE Runtime Environment", testClass1.getPropertyValue());
        Assert.assertEquals("Java(TM) SE Runtime Environment extra string", testClass1.getPropertyValue2());
    }
}