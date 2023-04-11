package com.orion.admin.cryptology;

import com.orion.admin.cryptology.tasks.DecodeDataTask;
import com.orion.admin.cryptology.tasks.DecryptDataTask;
import com.orion.admin.cryptology.tasks.EncodeDataTask;
import com.orion.admin.cryptology.tasks.EncryptDataTask;
import com.orion.admin.cryptology.tasks.HashDataTask;
import com.orion.core.abstraction.OrionService;
import com.orion.core.exception.InvalidArgumentException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class AdminCryptologyService extends OrionService
{
    public static String encodeData(String data, String encodingAlgorithm)
    {
        return EncodeDataTask.run(data, encodingAlgorithm);
    }


    public static String decodeData(String encodedData, String decodingAlgorithm)
    {
        return DecodeDataTask.run(encodedData, decodingAlgorithm);
    }


    public static String hashData(String data, String hashingAlgorithm) throws InvalidArgumentException, NoSuchAlgorithmException
    {
        return HashDataTask.run(data, hashingAlgorithm);
    }


    public static String encryptData(String data, String encryptionAlgorithm) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException, InvalidKeySpecException, IOException
    {
        return EncryptDataTask.run(data, encryptionAlgorithm);
    }


    public static String decryptData(String data, String decryptionAlgorithm) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException, InvalidKeySpecException, IOException
    {
        return DecryptDataTask.run(data, decryptionAlgorithm);
    }
}