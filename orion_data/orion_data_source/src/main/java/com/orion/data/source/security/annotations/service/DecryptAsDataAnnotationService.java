package com.orion.data.source.security.annotations.service;

import com.orion.core.abstraction.OrionEnumeration;
import com.orion.core.cryptology.encryption.rsa.RSAEncryptionException;
import com.orion.core.cryptology.hashing.md5.MD5HashingException;
import com.orion.core.exception.InaccessibleException;
import com.orion.data.source.security.annotations.DecryptAsData;
import java.lang.reflect.Field;
import java.util.List;

public class DecryptAsDataAnnotationService extends EncryptionDecryptionAnnotationService
{
    public void decryptObject(Object objectToDecrypt, List<Field> instanceVariablesOfObject, List<OrionEnumeration> decodingAndDecryptionAlgorithmsForDataToBeUsedInOrder)
    {
        processInputs(objectToDecrypt, decodingAndDecryptionAlgorithmsForDataToBeUsedInOrder);
        instanceVariablesOfObject.parallelStream().forEach(field ->
        {

            try
            {
                processInstanceVariableForDecryption(field);
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
            catch(MD5HashingException e)
            {
                //
            }
            catch(RSAEncryptionException e)
            {
                //
            }

        });
    }


    private void processInstanceVariableForDecryption(Field instanceVariable) throws IllegalArgumentException, IllegalAccessException, InaccessibleException, MD5HashingException, RSAEncryptionException
    {

        if(instanceVariable.getAnnotation(DecryptAsData.class) != null)
        {
            decryptData(instanceVariable);
        }

    }
}