package com.orion.data.source.security.annotations.service;

import com.orion.core.abstraction.OrionService;
import com.orion.core.cryptology.encoding.base64.Base64EncodingService;
import com.orion.core.exception.InaccessibleException;
import com.orion.core.reflection.variable.access.ReflectionInstanceVariablesAccessService;
import com.orion.data.source.security.annotations.EncodeBase64ForString;
import java.lang.reflect.Field;
import java.util.List;

public class EncodeBase64ForStringAnnotationService extends OrionService
{
    public static void encryptObject(Object objectToEncrypt, List<Field> instanceVariablesOfObject)
    {
        instanceVariablesOfObject.forEach(field ->
        {

            try
            {
                processInstanceVariable(field, objectToEncrypt);
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

        if(instanceVariable.getAnnotation(EncodeBase64ForString.class) != null)
        {
            encryptData(instanceVariable, object);
        }

    }


    private static void encryptData(Field instanceVariable, Object object) throws IllegalArgumentException, IllegalAccessException, InaccessibleException
    {
        ReflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(instanceVariable);
        String data = (String)instanceVariable.get(object);
        String encryptedData = Base64EncodingService.encodeBase64ForString(data);
        ReflectionInstanceVariablesAccessService.injectStringToInstanceVariable(object, encryptedData, instanceVariable);
    }
}