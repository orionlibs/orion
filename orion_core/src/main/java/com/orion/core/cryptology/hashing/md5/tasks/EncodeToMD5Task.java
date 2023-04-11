package com.orion.core.cryptology.hashing.md5.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.cryptology.hashing.HashingAlgorithm;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodeToMD5Task extends Orion
{
    public static byte[] run(String data, int offset, int length, byte[] signatureKeyBytes) throws NoSuchAlgorithmException, InvalidArgumentException
    {
        Assert.notEmpty(data, "The given data is null/empty.");
        Assert.isNonNegative(offset, "The given offset cannot be negative.");
        Assert.isNonNegative(length, "The given length cannot be negative.");
        Assert.notEmpty(signatureKeyBytes, "The given signatureKeyBytes is null/empty.");
        MessageDigest md5Digest = MessageDigest.getInstance(HashingAlgorithm.MD5.get());
        //Secret key bytes first
        md5Digest.update(signatureKeyBytes);
        //Data second
        md5Digest.update(data.getBytes(), offset, length);
        //Generate the digest
        return md5Digest.digest();
    }


    public static byte[] run(String data) throws NoSuchAlgorithmException, InvalidArgumentException
    {
        Assert.notEmpty(data, "The given data is null/empty.");
        MessageDigest md5Digest = MessageDigest.getInstance(HashingAlgorithm.MD5.get());
        md5Digest.update(data.getBytes());
        return md5Digest.digest();
    }
}