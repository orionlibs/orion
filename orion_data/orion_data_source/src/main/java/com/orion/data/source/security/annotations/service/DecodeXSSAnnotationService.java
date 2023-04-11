package com.orion.data.source.security.annotations.service;

import com.orion.core.abstraction.OrionService;
import com.orion.core.cryptology.encoding.xss.XSSEncodingService;
import com.orion.core.exception.InaccessibleException;
import com.orion.core.reflection.variable.access.ReflectionInstanceVariablesAccessService;
import com.orion.data.source.security.annotations.DecodeXSS;
import java.lang.reflect.Field;
import java.util.List;

public class DecodeXSSAnnotationService extends OrionService
{
    public static void decryptObject(Object objectToDecrypt, List<Field> instanceVariablesOfObject)
    {
        instanceVariablesOfObject.forEach(field ->
        {

            try
            {
                processInstanceVariable(field, objectToDecrypt);
            }
            catch(IllegalArgumentException e)
            {
                throw e;
            }
            catch(IllegalAccessException e)
            {
                //throw new InaccessibleException("The instance variable is inaccessible.");
            }
            catch(InaccessibleException e)
            {
                //
            }

        });
    }


    private static void processInstanceVariable(Field instanceVariable, Object object) throws IllegalArgumentException, IllegalAccessException, InaccessibleException
    {

        if(instanceVariable.getAnnotation(DecodeXSS.class) != null)
        {
            decryptData(instanceVariable, object);
        }

    }


    private static void decryptData(Field instanceVariable, Object object) throws IllegalArgumentException, IllegalAccessException, InaccessibleException
    {
        ReflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(instanceVariable);
        String data = (String)instanceVariable.get(object);
        String encryptedData = XSSEncodingService.decodeFromXSS(data);
        ReflectionInstanceVariablesAccessService.injectStringToInstanceVariable(object, encryptedData, instanceVariable);
    }
}