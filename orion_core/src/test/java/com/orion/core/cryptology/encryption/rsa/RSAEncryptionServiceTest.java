package com.orion.core.cryptology.encryption.rsa;

import com.orion.core.cryptology.init.tasks.LoadCryptologyConfigurationTask;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class RSAEncryptionServiceTest
{
    @Test
    @Disabled
    public void test_buildIPAddress() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException, InvalidKeySpecException, IOException
    {
        LoadCryptologyConfigurationTask.run();
        String result = RSAEncryptionService.encryptToRSAWithoutPadding("efthymiou.dimitrios1@gmail.com");
        System.out.println(result);
        result = RSAEncryptionService.decryptFromRSAWithoutPadding(result);
        System.out.println(result);
    }
}