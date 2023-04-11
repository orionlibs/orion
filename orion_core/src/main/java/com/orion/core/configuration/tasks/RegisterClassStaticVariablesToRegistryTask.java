package com.orion.core.configuration.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.core.exception.Assert;
import com.orion.core.reflection.variable.retrieval.ReflectionInstanceVariablesRetrievalService;
import java.lang.reflect.Field;
import java.util.List;

public class RegisterClassStaticVariablesToRegistryTask extends Orion
{
    public static void run(Class<?> aClass)
    {
        Assert.notNull(aClass, "The given aClass input cannot be null.");
        List<Field> variables = ReflectionInstanceVariablesRetrievalService.getDeclaredStaticVariables(aClass);
        variables.forEach(variable ->
        {

            try
            {
                processVariable(variable);
            }
            catch(IllegalArgumentException e)
            {
                throw e;
            }
            catch(IllegalAccessException e)
            {
                //throw new InaccessibleException("The static variable is inaccessible.");
            }

        });
    }


    private static void processVariable(Field variable) throws IllegalArgumentException, IllegalAccessException
    {
        Object value = variable.get(null);
        String variableName = variable.getName();
        StringBuilder key = new StringBuilder();

        if(variableName.contains("_"))
        {
            ProcessStaticVariableNameWithUnderscoresTask.run(variableName, key);
        }
        else
        {
            ProcessStaticVariableNameWithCamelCaseTask.run(variableName, key);
        }

        InMemoryConfigurationService.registerObjectProp(key.toString(), value);
    }
}