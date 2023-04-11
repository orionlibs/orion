package com.orion.admin.cryptology.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.cryptology.encryption.EncryptionAlgorithm;
import com.orion.core.cryptology.encryption.rsa.RSAEncryptionService;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DecryptDataTask extends Orion
{
    public static String run(String data, String decryptionAlgorithm) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException, InvalidKeySpecException, IOException
    {
        EncryptionAlgorithm encryptionAlgorithmToUse = EncryptionAlgorithm.getEnumForValue(decryptionAlgorithm);

        if(encryptionAlgorithmToUse.is(EncryptionAlgorithm.RSA))
        {
            return RSAEncryptionService.decryptFromRSA(data);
        }
        else if(encryptionAlgorithmToUse.is(EncryptionAlgorithm.RSANoPadding))
        {
            return RSAEncryptionService.decryptFromRSAWithoutPadding(data);
        }
        else
        {
            return "";
        }

    }
}