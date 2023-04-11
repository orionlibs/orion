package com.orion.core.string.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class StringBuilderServiceTest
{
    @Test
    public void testBuilder()
    {
        String result = new StringBuilderService().add("test ").add("string").reverse().toString();
        assertEquals("gnirts tset", result);
    }


    @Test
    public void testInsertAtPosition()
    {
        String result = new StringBuilderService().add("test").insertAtPosition(2, "abc").toString();
        assertEquals("tabcest", result);
        result = new StringBuilderService().add("test").add(4).toString();
        assertEquals("test4", result);
    }


    @Test
    public void testInsertAtPosition2()
    {
        String result = new StringBuilderService().add("test").insertAtPosition(0, "abc").toString();
        assertEquals("abctest", result);
        result = new StringBuilderService().add("test").insertAtPosition(1, "abc").toString();
        assertEquals("abctest", result);
        result = new StringBuilderService().add("test").insertAtPosition(5, "abc").toString();
        assertEquals("testabc", result);
    }


    @Test
    public void testInsertAfterPosition()
    {
        String result = new StringBuilderService().add("test").insertAfterPosition(0, "abc").toString();
        assertEquals("tabcest", result);
        result = new StringBuilderService().add("test").insertAfterPosition(4, "abc").toString();
        assertEquals("testabc", result);
    }


    @Test
    public void testReplaceAtPosition()
    {
        String result = new StringBuilderService().add("test").replaceAtPosition(0, "abc").toString();
        assertEquals("abc", result);
        result = new StringBuilderService().add("test").replaceAtPosition(1, "abc").toString();
        assertEquals("abc", result);
        result = new StringBuilderService().add("test").replaceAtPosition(3, "abc").toString();
        assertEquals("teabc", result);
        result = new StringBuilderService().add("test").replaceAtPosition(4, "abc").toString();
        assertEquals("tesabc", result);
    }


    @Test
    public void testSubstring()
    {
        String result = new StringBuilderService().add("test").substring(0).toString();
        assertEquals("test", result);
        result = new StringBuilderService().add("test").substring(1).toString();
        assertEquals("est", result);
        result = new StringBuilderService().add("test").substring(3).toString();
        assertEquals("t", result);
        result = new StringBuilderService().add("test").substring(4).toString();
        assertEquals("", result);
    }


    @Test
    public void testGetCharacterAtPosition()
    {
        char result = new StringBuilderService().add("test").getCharacterAtPosition(1);
        assertEquals('e', result);
    }
}