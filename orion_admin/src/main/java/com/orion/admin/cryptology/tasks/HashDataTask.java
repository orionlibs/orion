package com.orion.admin.cryptology.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.cryptology.hashing.HashingAlgorithm;
import com.orion.core.cryptology.hashing.md5.MD5HashingService;
import com.orion.core.cryptology.hashing.sha.SHAHashingService;
import com.orion.core.exception.InvalidArgumentException;
import java.security.NoSuchAlgorithmException;

public class HashDataTask extends Orion
{
    public static String run(String data, String hashingAlgorithm) throws InvalidArgumentException, NoSuchAlgorithmException
    {
        HashingAlgorithm hashingAlgorithmToUse = HashingAlgorithm.getEnumForValue(hashingAlgorithm);

        if(hashingAlgorithmToUse.is(HashingAlgorithm.MD5))
        {
            return MD5HashingService.encodeToMD5(data);
        }
        else if(hashingAlgorithmToUse.is(HashingAlgorithm.SHA1))
        {
            return SHAHashingService.encodeDataToSHA1(data);
        }
        else if(hashingAlgorithmToUse.is(HashingAlgorithm.SHA256))
        {
            return SHAHashingService.encodeDataToSHA256(data);
        }
        else
        {
            return "";
        }

    }
}