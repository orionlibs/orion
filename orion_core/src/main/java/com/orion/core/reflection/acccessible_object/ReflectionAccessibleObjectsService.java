package com.orion.core.reflection.acccessible_object;

import com.orion.core.abstraction.OrionService;
import com.orion.core.reflection.acccessible_object.tasks.GetAllAccessibleObjectsArrayTask;
import com.orion.core.reflection.acccessible_object.tasks.GetDeclaredAccessibleObjectsArrayTask;
import com.orion.core.reflection.acccessible_object.tasks.GetInherittedAccessibleObjectsArrayTask;
import java.lang.reflect.AccessibleObject;
import java.util.Arrays;
import java.util.List;

public class ReflectionAccessibleObjectsService extends OrionService
{
    public static AccessibleObject[] getDeclaredAccessibleObjectsArray(Class<?> aClass)
    {
        return GetDeclaredAccessibleObjectsArrayTask.run(aClass);
    }


    public static AccessibleObject[] getDeclaredAccessibleObjectsArray(Object object)
    {
        return GetDeclaredAccessibleObjectsArrayTask.run(object);
    }


    public static List<AccessibleObject> getDeclaredAccessibleObjects(Class<?> aClass)
    {
        return Arrays.asList(getDeclaredAccessibleObjectsArray(aClass));
    }


    public static List<AccessibleObject> getDeclaredAccessibleObjects(Object object)
    {
        return Arrays.asList(getDeclaredAccessibleObjectsArray(object));
    }


    public static AccessibleObject[] getInherittedAccessibleObjectsArray(Class<?> aClass)
    {
        return GetInherittedAccessibleObjectsArrayTask.run(aClass);
    }


    public static AccessibleObject[] getInherittedAccessibleObjectsArray(Object object)
    {
        return GetInherittedAccessibleObjectsArrayTask.run(object);
    }


    public static List<AccessibleObject> getInherittedAccessibleObjects(Class<?> aClass)
    {
        return Arrays.asList(getInherittedAccessibleObjectsArray(aClass));
    }


    public static List<AccessibleObject> getInherittedAccessibleObjects(Object object)
    {
        return Arrays.asList(getInherittedAccessibleObjectsArray(object));
    }


    public static AccessibleObject[] getAllAccessibleObjectsArray(Class<?> aClass)
    {
        return GetAllAccessibleObjectsArrayTask.run(aClass);
    }


    public static AccessibleObject[] getAllAccessibleObjectsArray(Object object)
    {
        return GetAllAccessibleObjectsArrayTask.run(object);
    }


    public static List<AccessibleObject> getAllAccessibleObjects(Class<?> aClass)
    {
        return Arrays.asList(getInherittedAccessibleObjectsArray(aClass));
    }


    public static List<AccessibleObject> getAllAccessibleObjects(Object object)
    {
        return Arrays.asList(getInherittedAccessibleObjectsArray(object));
    }
}