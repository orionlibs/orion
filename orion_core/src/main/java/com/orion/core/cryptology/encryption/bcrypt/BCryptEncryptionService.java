package com.orion.core.cryptology.encryption.bcrypt;

import com.orion.core.abstraction.OrionService;
import com.orion.core.exception.Assert;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptEncryptionService extends OrionService
{
    public static String encrypt(String data)
    {

        if(data != null && !data.isEmpty())
        {
            return new BCryptPasswordEncoder().encode(data);
        }
        else
        {
            return "";
        }

    }


    public static boolean matches(String rawData, String encodedData)
    {
        Assert.notEmpty(rawData, "Input rawData is null/empty.");
        Assert.notEmpty(encodedData, "Input encodedData is null/empty.");
        return new BCryptPasswordEncoder().matches(rawData, encodedData);
    }
}