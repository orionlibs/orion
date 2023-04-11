package com.orion.core.reflection.variable.retrieval;

import com.orion.core.abstraction.OrionService;
import com.orion.core.reflection.variable.retrieval.tasks.GetDeclaredInstanceVariableTask;
import com.orion.core.reflection.variable.retrieval.tasks.GetDeclaredProtectedInstanceVariableTask;
import com.orion.core.reflection.variable.retrieval.tasks.GetDeclaredPublicInstanceVariableTask;
import com.orion.core.reflection.variable.retrieval.tasks.GetInherittedInstanceVariableTask;
import com.orion.core.reflection.variable.retrieval.tasks.GetPrivateInstanceVariableTask;
import com.orion.core.reflection.variable.retrieval.tasks.IsPrivateVariableTask;
import com.orion.core.reflection.variable.retrieval.tasks.IsProtectedVariableTask;
import com.orion.core.reflection.variable.retrieval.tasks.IsPublicVariableTask;
import java.lang.reflect.Field;

public class ReflectionInstanceVariableRetrievalService extends OrionService
{
    public static Field getDeclaredInstanceVariable(String instanceVariableName, Object object) throws NoSuchFieldException, SecurityException
    {
        return GetDeclaredInstanceVariableTask.run(instanceVariableName, object);
    }


    public static Field getDeclaredInstanceVariable(String instanceVariableName, Class<?> aClass) throws NoSuchFieldException, SecurityException
    {
        return GetDeclaredInstanceVariableTask.run(instanceVariableName, aClass);
    }


    public static Field getPrivateInstanceVariable(String instanceVariableName, Object object) throws NoSuchFieldException, SecurityException
    {
        return GetPrivateInstanceVariableTask.run(instanceVariableName, object);
    }


    public static Field getPrivateInstanceVariable(String instanceVariableName, Class<?> aClass) throws NoSuchFieldException, SecurityException
    {
        return GetPrivateInstanceVariableTask.run(instanceVariableName, aClass);
    }


    public static Field getDeclaredPublicInstanceVariable(String instanceVariableName, Object object) throws NoSuchFieldException, SecurityException
    {
        return GetDeclaredPublicInstanceVariableTask.run(instanceVariableName, object);
    }


    public static Field getDeclaredPublicInstanceVariable(String instanceVariableName, Class<?> aClass) throws NoSuchFieldException, SecurityException
    {
        return GetDeclaredPublicInstanceVariableTask.run(instanceVariableName, aClass);
    }


    public static Field getDeclaredProtectedInstanceVariable(String instanceVariableName, Object object) throws NoSuchFieldException, SecurityException
    {
        return GetDeclaredProtectedInstanceVariableTask.run(instanceVariableName, object);
    }


    public static Field getDeclaredProtectedInstanceVariable(String instanceVariableName, Class<?> aClass) throws NoSuchFieldException, SecurityException
    {
        return GetDeclaredProtectedInstanceVariableTask.run(instanceVariableName, aClass);
    }


    public static Field getInherittedInstanceVariable(String instanceVariableName, Object object) throws NoSuchFieldException, SecurityException
    {
        return GetInherittedInstanceVariableTask.run(instanceVariableName, object);
    }


    public static Field getInherittedInstanceVariable(String instanceVariableName, Class<?> aClass) throws NoSuchFieldException, SecurityException
    {
        return GetInherittedInstanceVariableTask.run(instanceVariableName, aClass);
    }


    public static boolean isPrivateInstanceVariable(Field instanceVariable)
    {
        return IsPrivateVariableTask.run(instanceVariable);
    }


    public static boolean isProtectedInstanceVariable(Field instanceVariable)
    {
        return IsProtectedVariableTask.run(instanceVariable);
    }


    public static boolean isPublicInstanceVariable(Field instanceVariable)
    {
        return IsPublicVariableTask.run(instanceVariable);
    }
}