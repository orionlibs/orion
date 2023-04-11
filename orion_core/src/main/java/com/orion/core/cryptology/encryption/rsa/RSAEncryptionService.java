package com.orion.core.cryptology.encryption.rsa;

import com.orion.core.abstraction.OrionService;
import com.orion.core.cryptology.encryption.EncryptionAlgorithm;
import com.orion.core.cryptology.encryption.rsa.tasks.DecryptFromRSATask;
import com.orion.core.cryptology.encryption.rsa.tasks.EncryptToRSATask;
import com.orion.core.cryptology.encryption.rsa.tasks.GenerateRSAKeyTask;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAEncryptionService extends OrionService
{
    public static String publicKeyFile = "D:/temp/publicRSAKey";
    public static String privateKeyFile = "D:/temp/privateRSAKey";


    public static void main(String[] args) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException, InvalidKeySpecException
    {
        generateRSAKey();
        String username = "efthymiou.dimitrios1@gmail.com";
        String encrypted = encryptToRSAWithoutPadding(username);
        System.out.println(encrypted);
        System.out.println("------------------");
        System.out.println(decryptFromRSAWithoutPadding(encrypted));
    }


    public static void generateRSAKey()
    {
        GenerateRSAKeyTask.run(2048);
    }


    public static String encryptToRSA(String data) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException, InvalidKeySpecException
    {
        return EncryptToRSATask.run(data);
    }


    public static String encryptToRSAWithoutPadding(String data) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException, InvalidKeySpecException
    {
        return EncryptToRSATask.run(data, EncryptionAlgorithm.RSANoPadding);
    }


    public static String decryptFromRSAWithoutPadding(String data) throws IOException, InvalidKeyException, ClassNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
    {
        return DecryptFromRSATask.run(data, EncryptionAlgorithm.RSANoPadding);
    }


    public static String decryptFromRSA(String data) throws IOException, InvalidKeyException, ClassNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
    {
        return DecryptFromRSATask.run(data);
    }
}