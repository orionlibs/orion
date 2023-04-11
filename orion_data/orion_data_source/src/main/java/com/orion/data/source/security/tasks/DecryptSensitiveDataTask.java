package com.orion.data.source.security.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.abstraction.OrionEnumeration;
import com.orion.core.cryptology.encoding.EncodingAlgorithm;
import com.orion.core.cryptology.encoding.alphabetical.AlphabeticalEncodingService;
import com.orion.core.cryptology.encoding.ascii.ASCIIEncodingService;
import com.orion.core.cryptology.encoding.base64.Base64EncodingService;
import com.orion.core.cryptology.encryption.EncryptionAlgorithm;
import com.orion.core.cryptology.encryption.rsa.RSAEncryptionException;
import com.orion.core.cryptology.encryption.rsa.RSAEncryptionService;
import com.orion.core.cryptology.hashing.md5.MD5HashingException;
import com.orion.core.exception.Assert;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DecryptSensitiveDataTask extends Orion
{
    public static String run(String encryptedData, List<OrionEnumeration> decodingAndDecryptionAlgorithmsToBeUsedInOrder) throws MD5HashingException, RSAEncryptionException
    {

        if(encryptedData == null || encryptedData.isEmpty())
        {
            return encryptedData;
        }
        else
        {
            Assert.notEmpty(decodingAndDecryptionAlgorithmsToBeUsedInOrder, "The decodingAndDecryptionAlgorithmsToBeUsedInOrder input cannot be null/empty.");
            String rawData = encryptedData;

            for(OrionEnumeration algorithm : decodingAndDecryptionAlgorithmsToBeUsedInOrder)
            {

                if(algorithm instanceof EncodingAlgorithm)
                {
                    rawData = decodeData(algorithm, rawData);
                }
                else if(algorithm instanceof EncryptionAlgorithm)
                {
                    rawData = decryptData(algorithm, rawData);
                }

            }

            return rawData;
        }

    }


    private static String decodeData(OrionEnumeration algorithm, String data) throws MD5HashingException
    {
        EncodingAlgorithm encodingAlgorithm = (EncodingAlgorithm)algorithm;

        if(encodingAlgorithm.is(EncodingAlgorithm.ALPHABETICAL))
        {
            return AlphabeticalEncodingService.decodeAlphanumericForNumber(data);
        }
        else if(encodingAlgorithm.is(EncodingAlgorithm.ASCII))
        {
            return ASCIIEncodingService.decodeASCII(data);
        }
        else if(encodingAlgorithm.is(EncodingAlgorithm.BASE64_FOR_STRING))
        {
            return Base64EncodingService.decodeBase64ForString(data);
        }
        else if(encodingAlgorithm.is(EncodingAlgorithm.BASE64_FOR_URL))
        {
            return Base64EncodingService.decodeBase64ForURL(data);
        }

        return data;
    }


    private static String decryptData(OrionEnumeration algorithm, String data) throws RSAEncryptionException
    {
        EncryptionAlgorithm encryptionAlgorithm = (EncryptionAlgorithm)algorithm;

        if(encryptionAlgorithm.is(EncryptionAlgorithm.RSA))
        {

            try
            {
                return RSAEncryptionService.decryptFromRSA(data);
            }
            catch(InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | ClassNotFoundException | InvalidKeySpecException | IOException e)
            {
                throw new RSAEncryptionException(e, "Problem with the decryption of the data.");
            }

        }
        else if(encryptionAlgorithm.is(EncryptionAlgorithm.RSANoPadding))
        {

            try
            {
                return RSAEncryptionService.decryptFromRSAWithoutPadding(data);
            }
            catch(InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | ClassNotFoundException | InvalidKeySpecException | IOException e)
            {
                throw new RSAEncryptionException(e, "Problem with the decryption of the data.");
            }

        }

        return data;
    }
}