package com.orion.core.cryptology.init.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.cryptology.encryption.EncryptionAlgorithm;
import com.orion.core.exception.Assert;
import com.orion.core.utility.OrionUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;

public class ReadPrivateRSAKeyFromFileStreamTask extends Orion
{
    public static PrivateKey run(InputStream privateRSAKeyStream) throws IOException, ClassNotFoundException, NoSuchAlgorithmException, InvalidKeySpecException
    {
        Assert.notNull(privateRSAKeyStream, "input privateRSAKeyStream cannot be null.");
        ObjectInputStream ois = null;

        try
        {
            ois = new ObjectInputStream(privateRSAKeyStream);
            BigInteger modulus = (BigInteger)ois.readObject();
            BigInteger exponent = (BigInteger)ois.readObject();
            RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(modulus, exponent);
            KeyFactory fact = KeyFactory.getInstance(EncryptionAlgorithm.RSA.get());
            return fact.generatePrivate(rsaPrivateKeySpec);
        }
        finally
        {
            OrionUtils.closeResource(ois);
            OrionUtils.closeResource(privateRSAKeyStream);
        }

    }
}