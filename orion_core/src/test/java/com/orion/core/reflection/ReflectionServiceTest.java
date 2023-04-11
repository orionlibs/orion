package com.orion.core.reflection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.orion.core.exception.InaccessibleException;
import com.orion.core.reflection.classes.ReflectionClassesService;
import com.orion.core.reflection.variable.retrieval.ReflectionInstanceVariablesRetrievalService;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class ReflectionServiceTest
{
    @Test
    public void test_InstantiateClass() throws InvocationTargetException, InaccessibleException
    {
        TestClass testClass = (TestClass)ReflectionClassesService.instantiateClass(TestClass.class, new Class<?>[] {}, new Object[] {});
        assertNotNull(testClass);
        testClass = (TestClass)ReflectionClassesService.instantiateClass("com.orion.core.reflection.TestClass", new Class<?>[] {}, new Object[] {});
        assertNotNull(testClass);
    }


    @Test
    public void test_getDeclaredInstanceVariablesArray() throws InvocationTargetException, IllegalArgumentException, IllegalAccessException
    {
        TestClass testClass = new TestClass();
        Field[] variables = ReflectionInstanceVariablesRetrievalService.getDeclaredStaticVariablesArray(testClass);
        assertNotNull(variables);
        assertThat(variables.length).isEqualTo(1);
        assertThat(variables[0].getName()).isEqualTo("hello");
        assertThat(variables[0].get(null)).isEqualTo(16);
        variables = ReflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariablesArray(TestClass.class);
        assertNotNull(variables);
        assertThat(variables.length).isEqualTo(1);
        assertThat(variables[0].getName()).isEqualTo("world");
        variables[0].setAccessible(true);
        assertThat(variables[0].get(testClass)).isEqualTo("hello world!");
    }


    @Test
    public void test_getDeclaredInstanceVariables() throws InvocationTargetException, IllegalArgumentException, IllegalAccessException
    {
        TestClass testClass = new TestClass();
        List<Field> variables = ReflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariables(testClass);
        assertNotNull(variables);
        assertThat(variables.size()).isEqualTo(1);
        variables.get(0).setAccessible(true);
        assertThat(variables.get(0).getName()).isEqualTo("world");
        assertThat(variables.get(0).get(testClass)).isEqualTo("hello world!");
        variables = ReflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariables(TestClass.class);
        assertNotNull(variables);
        variables.get(0).setAccessible(true);
        assertThat(variables.size()).isEqualTo(1);
        assertThat(variables.get(0).getName()).isEqualTo("world");
        assertThat(variables.get(0).get(testClass)).isEqualTo("hello world!");
    }
}