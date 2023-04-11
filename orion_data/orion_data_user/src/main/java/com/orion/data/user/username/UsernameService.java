package com.orion.data.user.username;

import com.orion.core.abstraction.OrionEnumeration;
import com.orion.core.abstraction.OrionService;
import com.orion.core.cryptology.encryption.rsa.RSAEncryptionException;
import com.orion.core.cryptology.hashing.md5.MD5HashingException;
import com.orion.data.source.security.DataSecurityService;
import com.orion.data.source.security.NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException;
import java.util.List;

public class UsernameService extends OrionService
{
    public static String encryptUsername(String rawUsername) throws MD5HashingException, RSAEncryptionException, NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        return DataSecurityService.encryptUsername(rawUsername);
    }


    public static String encryptUsername(String rawUsername, List<OrionEnumeration> encodingAndEncryptionAlgorithmsToBeUsedInOrder) throws MD5HashingException, RSAEncryptionException
    {
        return DataSecurityService.encryptData(rawUsername, encodingAndEncryptionAlgorithmsToBeUsedInOrder);
    }


    public static String decryptUsername(String encryptedUsername) throws MD5HashingException, RSAEncryptionException, NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        return DataSecurityService.decryptUsername(encryptedUsername);
    }


    public static String decryptUsername(String encryptedUsername, List<OrionEnumeration> decodingAndDecryptionAlgorithmsToBeUsedInOrder) throws MD5HashingException, RSAEncryptionException
    {
        return DataSecurityService.decryptData(encryptedUsername, decodingAndDecryptionAlgorithmsToBeUsedInOrder);
    }
}