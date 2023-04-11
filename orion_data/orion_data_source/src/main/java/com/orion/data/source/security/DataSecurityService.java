package com.orion.data.source.security;

import com.orion.core.abstraction.OrionEnumeration;
import com.orion.core.abstraction.OrionService;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.core.cryptology.encryption.rsa.RSAEncryptionException;
import com.orion.core.cryptology.hashing.md5.MD5HashingException;
import com.orion.core.reflection.variable.access.ReflectionInstanceVariablesAccessService;
import com.orion.core.reflection.variable.retrieval.ReflectionInstanceVariablesRetrievalService;
import com.orion.data.source.security.annotations.service.DecodeBase64ForStringAnnotationService;
import com.orion.data.source.security.annotations.service.DecodeBase64ForURLAnnotationService;
import com.orion.data.source.security.annotations.service.DecodeXSSAnnotationService;
import com.orion.data.source.security.annotations.service.DecryptAsDataAnnotationService;
import com.orion.data.source.security.annotations.service.DecryptAsUsernameAnnotationService;
import com.orion.data.source.security.annotations.service.EncodeBase64ForStringAnnotationService;
import com.orion.data.source.security.annotations.service.EncodeBase64ForURLAnnotationService;
import com.orion.data.source.security.annotations.service.EncodeXSSAnnotationService;
import com.orion.data.source.security.annotations.service.EncryptAsDataAnnotationService;
import com.orion.data.source.security.annotations.service.EncryptAsUsernameAnnotationService;
import com.orion.data.source.security.tasks.DecryptSensitiveDataTask;
import com.orion.data.source.security.tasks.EncryptSensitiveDataTask;
import com.orion.data.source.security.tasks.ExtractEncodingAndDecodingAndHashingAndEncryptionAndDecryptionAlgorithmsTask;
import java.lang.reflect.Field;
import java.util.List;

public class DataSecurityService extends OrionService
{
    public static List<OrionEnumeration> getEncodingAndEncryptionAlgorithmsForUsername() throws NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        String[] algorithmsToBeUsedInOrder = InMemoryConfigurationService.getProp("data.security.encoding.and.encryption.algorithms.to.use.for.username").split(",");
        return extractEncodingAndEncryptionAlgorithms(algorithmsToBeUsedInOrder);
    }


    public static List<OrionEnumeration> getDecodingAndDecryptionAlgorithmsForUsername() throws NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        String[] algorithmsToBeUsedInOrder = InMemoryConfigurationService.getProp("data.security.decoding.and.decryption.algorithms.to.use.for.username").split(",");
        return extractDecodingAndDecryptionAlgorithms(algorithmsToBeUsedInOrder);
    }


    public static List<OrionEnumeration> getEncodingAndHashingAndEncryptionAlgorithmsForSensitiveUserData() throws NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        String[] algorithmsToBeUsedInOrder = InMemoryConfigurationService.getProp("data.security.encoding.and.encryption.algorithms.to.use.for.sensitive.user.data").split(",");
        return extractEncodingAndEncryptionAlgorithms(algorithmsToBeUsedInOrder);
    }


    public static List<OrionEnumeration> getDecodingAndDecryptionAlgorithmsForSensitiveUserData() throws NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        String[] algorithmsToBeUsedInOrder = InMemoryConfigurationService.getProp("data.security.decoding.and.decryption.algorithms.to.use.for.sensitive.user.data").split(",");
        return extractDecodingAndDecryptionAlgorithms(algorithmsToBeUsedInOrder);
    }


    public static String encryptUsername(String rawData) throws MD5HashingException, RSAEncryptionException, NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        return encryptUsername(rawData, getEncodingAndEncryptionAlgorithmsForUsername());
    }


    public static String encryptUsername(String rawData, List<OrionEnumeration> encodingAndEncryptionAlgorithmsForUsername) throws MD5HashingException, RSAEncryptionException
    {
        return encryptData(rawData, encodingAndEncryptionAlgorithmsForUsername);
    }


    public static String encryptData(String rawData, List<OrionEnumeration> encodingAndHashingAndEncryptionAlgorithmsToBeUsedInOrder) throws MD5HashingException, RSAEncryptionException
    {
        return EncryptSensitiveDataTask.run(rawData, encodingAndHashingAndEncryptionAlgorithmsToBeUsedInOrder);
    }


    public static String decryptUsername(String encryptedData) throws MD5HashingException, RSAEncryptionException, NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        return decryptData(encryptedData, getDecodingAndDecryptionAlgorithmsForUsername());
    }


    public static String decryptData(String encryptedData, List<OrionEnumeration> decodingAndDecryptionAlgorithmsToBeUsedInOrder) throws MD5HashingException, RSAEncryptionException
    {
        return DecryptSensitiveDataTask.run(encryptedData, decodingAndDecryptionAlgorithmsToBeUsedInOrder);
    }


    public static void encryptObject(Object objectToEncrypt, List<OrionEnumeration> encodingAndEncryptionAlgorithmsForUsernameToBeUsedInOrder, List<OrionEnumeration> encodingAndHashingAndEncryptionAlgorithmsForDataToBeUsedInOrder)
    {
        List<Field> instanceVariables = ReflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariables(objectToEncrypt);
        instanceVariables.forEach(instanceVariable -> ReflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(instanceVariable));
        new EncryptAsUsernameAnnotationService().encryptObject(objectToEncrypt, instanceVariables, encodingAndEncryptionAlgorithmsForUsernameToBeUsedInOrder);
        new EncryptAsDataAnnotationService().encryptObject(objectToEncrypt, instanceVariables, encodingAndHashingAndEncryptionAlgorithmsForDataToBeUsedInOrder);
        EncodeBase64ForStringAnnotationService.encryptObject(objectToEncrypt, instanceVariables);
        EncodeBase64ForURLAnnotationService.encryptObject(objectToEncrypt, instanceVariables);
        EncodeXSSAnnotationService.encryptObject(objectToEncrypt, instanceVariables);
    }


    public static void encryptObject(Object objectToEncrypt) throws NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        encryptObject(objectToEncrypt, getEncodingAndEncryptionAlgorithmsForUsername(), getEncodingAndHashingAndEncryptionAlgorithmsForSensitiveUserData());
    }


    public static void decryptObject(Object objectToDecrypt, List<OrionEnumeration> decodingAndDecryptionAlgorithmsForUsernameToBeUsedInOrder, List<OrionEnumeration> decodingAndDecryptionAlgorithmsForDataToBeUsedInOrder)
    {
        List<Field> instanceVariables = ReflectionInstanceVariablesRetrievalService.getDeclaredInstanceVariables(objectToDecrypt);
        instanceVariables.forEach(instanceVariable -> ReflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(instanceVariable));
        new DecryptAsUsernameAnnotationService().decryptObject(objectToDecrypt, instanceVariables, decodingAndDecryptionAlgorithmsForUsernameToBeUsedInOrder);
        new DecryptAsDataAnnotationService().decryptObject(objectToDecrypt, instanceVariables, decodingAndDecryptionAlgorithmsForDataToBeUsedInOrder);
        DecodeBase64ForStringAnnotationService.decryptObject(objectToDecrypt, instanceVariables);
        DecodeBase64ForURLAnnotationService.decryptObject(objectToDecrypt, instanceVariables);
        DecodeXSSAnnotationService.decryptObject(objectToDecrypt, instanceVariables);
    }


    public static void decryptObject(Object objectToDecrypt) throws NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        decryptObject(objectToDecrypt, getDecodingAndDecryptionAlgorithmsForUsername(), getDecodingAndDecryptionAlgorithmsForSensitiveUserData());
    }


    public static List<OrionEnumeration> extractEncodingAndEncryptionAlgorithms(String[] encodingAndEncryptionAlgorithmsToBeUsedInOrder) throws NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        return ExtractEncodingAndDecodingAndHashingAndEncryptionAndDecryptionAlgorithmsTask.run(encodingAndEncryptionAlgorithmsToBeUsedInOrder);
    }


    public static List<OrionEnumeration> extractDecodingAndDecryptionAlgorithms(String[] decodingAndDecryptionAlgorithmsToBeUsedInOrder) throws NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        return ExtractEncodingAndDecodingAndHashingAndEncryptionAndDecryptionAlgorithmsTask.run(decodingAndDecryptionAlgorithmsToBeUsedInOrder);
    }
}