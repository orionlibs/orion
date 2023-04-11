package com.orion.admin.cryptology.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.cryptology.encryption.EncryptionAlgorithm;
import com.orion.core.cryptology.encryption.bcrypt.BCryptEncryptionService;
import com.orion.core.cryptology.encryption.rsa.RSAEncryptionService;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptDataTask extends Orion
{
    public static String run(String data, String encryptionAlgorithm) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException, InvalidKeySpecException, IOException
    {
        EncryptionAlgorithm encryptionAlgorithmToUse = EncryptionAlgorithm.getEnumForValue(encryptionAlgorithm);

        if(encryptionAlgorithmToUse.is(EncryptionAlgorithm.RSA))
        {
            return RSAEncryptionService.encryptToRSA(data);
        }
        else if(encryptionAlgorithmToUse.is(EncryptionAlgorithm.RSANoPadding))
        {
            return RSAEncryptionService.encryptToRSAWithoutPadding(data);
        }
        else if(encryptionAlgorithmToUse.is(EncryptionAlgorithm.BCrypt))
        {
            return BCryptEncryptionService.encrypt(data);
        }
        else
        {
            return "";
        }

    }
}