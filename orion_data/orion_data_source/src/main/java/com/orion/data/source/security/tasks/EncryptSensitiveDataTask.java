package com.orion.data.source.security.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.abstraction.OrionEnumeration;
import com.orion.core.cryptology.encoding.EncodingAlgorithm;
import com.orion.core.cryptology.encoding.alphabetical.AlphabeticalEncodingService;
import com.orion.core.cryptology.encoding.ascii.ASCIIEncodingService;
import com.orion.core.cryptology.encoding.base64.Base64EncodingService;
import com.orion.core.cryptology.encryption.EncryptionAlgorithm;
import com.orion.core.cryptology.encryption.bcrypt.BCryptEncryptionService;
import com.orion.core.cryptology.encryption.rsa.RSAEncryptionException;
import com.orion.core.cryptology.encryption.rsa.RSAEncryptionService;
import com.orion.core.cryptology.hashing.HashingAlgorithm;
import com.orion.core.cryptology.hashing.md5.MD5HashingException;
import com.orion.core.cryptology.hashing.md5.MD5HashingService;
import com.orion.core.cryptology.hashing.sha.SHAHashingService;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptSensitiveDataTask extends Orion
{
    public static String run(String rawData, List<OrionEnumeration> encodingAndHashingAndEncryptionAlgorithmsToBeUsedInOrder) throws MD5HashingException, RSAEncryptionException
    {
        Assert.notEmpty(encodingAndHashingAndEncryptionAlgorithmsToBeUsedInOrder, "The encodingAndHashingAndEncryptionAlgorithmsToBeUsedInOrder input cannot be null/empty.");

        if(rawData == null || rawData.isEmpty())
        {
            return rawData;
        }
        else
        {
            String encryptedData = rawData;

            for(OrionEnumeration algorithm : encodingAndHashingAndEncryptionAlgorithmsToBeUsedInOrder)
            {

                if(algorithm instanceof EncodingAlgorithm)
                {
                    encryptedData = encodeData(algorithm, encryptedData);
                }
                else if(algorithm instanceof HashingAlgorithm)
                {
                    encryptedData = hashData(algorithm, encryptedData);
                }
                else if(algorithm instanceof EncryptionAlgorithm)
                {
                    encryptedData = encryptData(algorithm, encryptedData);
                }

            }

            return encryptedData;
        }

    }


    private static String encodeData(OrionEnumeration algorithm, String data) throws MD5HashingException
    {
        EncodingAlgorithm encodingAlgorithm = (EncodingAlgorithm)algorithm;

        if(encodingAlgorithm.is(EncodingAlgorithm.ALPHABETICAL))
        {
            return AlphabeticalEncodingService.encodeAlphanumericForNumber(data);
        }
        else if(encodingAlgorithm.is(EncodingAlgorithm.ASCII))
        {
            return ASCIIEncodingService.encodeToASCII(data);
        }
        else if(encodingAlgorithm.is(EncodingAlgorithm.BASE64_FOR_STRING))
        {
            return Base64EncodingService.encodeBase64ForString(data);
        }
        else if(encodingAlgorithm.is(EncodingAlgorithm.BASE64_FOR_URL))
        {
            return Base64EncodingService.encodeBase64ForURL(data);
        }

        return data;
    }


    private static String hashData(OrionEnumeration algorithm, String data) throws MD5HashingException
    {
        EncodingAlgorithm encodingAlgorithm = (EncodingAlgorithm)algorithm;

        if(encodingAlgorithm.is(HashingAlgorithm.MD5))
        {

            try
            {
                return MD5HashingService.encodeToMD5(data);
            }
            catch(InvalidArgumentException | NoSuchAlgorithmException e)
            {
                throw new MD5HashingException(e);
            }

        }
        else if(encodingAlgorithm.is(HashingAlgorithm.SHA1))
        {
            return SHAHashingService.encodeDataToSHA1(data);
        }
        else if(encodingAlgorithm.is(HashingAlgorithm.SHA256))
        {
            return SHAHashingService.encodeDataToSHA256(data);
        }

        return data;
    }


    private static String encryptData(OrionEnumeration algorithm, String data) throws RSAEncryptionException
    {
        EncryptionAlgorithm encryptionAlgorithm = (EncryptionAlgorithm)algorithm;

        if(encryptionAlgorithm.is(EncryptionAlgorithm.RSA))
        {

            try
            {
                return RSAEncryptionService.encryptToRSA(data);
            }
            catch(InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | ClassNotFoundException | InvalidKeySpecException | IOException e)
            {
                throw new RSAEncryptionException(e, "Problem with the encryption of the data.");
            }

        }
        else if(encryptionAlgorithm.is(EncryptionAlgorithm.RSANoPadding))
        {

            try
            {
                return RSAEncryptionService.encryptToRSAWithoutPadding(data);
            }
            catch(InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | ClassNotFoundException | InvalidKeySpecException | IOException e)
            {
                throw new RSAEncryptionException(e, "Problem with the encryption of the data.");
            }

        }
        else if(encryptionAlgorithm.is(EncryptionAlgorithm.BCrypt))
        {
            return BCryptEncryptionService.encrypt(data);
        }

        return data;
    }
}