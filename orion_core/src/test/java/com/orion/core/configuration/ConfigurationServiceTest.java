package com.orion.core.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.orion.core.exception.ResourceException;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class ConfigurationServiceTest
{
    @Test
    public void testGetSystemProperty()
    {
        assertEquals("Java(TM) SE Runtime Environment", InMemoryConfigurationService.getProp("java.runtime.name"));
    }


    @Test
    public void testLoadPropsAsInputStream() throws ResourceException
    {
        InMemoryConfigurationService.loadProps(getClass().getResourceAsStream("/test.prop"));
        assertEquals("test property", InMemoryConfigurationService.getProp("test.property"));
    }


    @Test
    public void testRegisterProp()
    {
        InMemoryConfigurationService.registerProp("test.property", "test property");
        assertEquals("test property", InMemoryConfigurationService.getProp("test.property"));
    }


    @Test
    public void testUpdateProp()
    {
        InMemoryConfigurationService.registerProp("test.property", "test property");
        InMemoryConfigurationService.updateProp("test.property", "updated test property");
        assertEquals("updated test property", InMemoryConfigurationService.getProp("test.property"));
    }


    @Test
    public void testDeleteProp()
    {
        InMemoryConfigurationService.registerProp("test.property", "test property");
        assertEquals("test property", InMemoryConfigurationService.getProp("test.property"));
        InMemoryConfigurationService.deleteProp("test.property");
        assertNull(InMemoryConfigurationService.getProp("test.property"));
    }


    @Test
    public void testGetIntegerProp()
    {
        InMemoryConfigurationService.registerProp("test.property", "4");
        assertEquals(Integer.valueOf("4"), InMemoryConfigurationService.getIntegerProp("test.property"));
    }


    @Test
    public void testGetDoubleProp()
    {
        InMemoryConfigurationService.registerProp("test.property", "-4.56");
        assertEquals(Double.valueOf("-4.56"), InMemoryConfigurationService.getDoubleProp("test.property"));
    }


    @Test
    public void testGetBooleanProp()
    {
        InMemoryConfigurationService.registerProp("test.property", "true");
        assertEquals(Boolean.TRUE, InMemoryConfigurationService.getBooleanProp("test.property"));
    }
}