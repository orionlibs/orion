package com.orion.admin.cryptology.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.cryptology.encoding.EncodingAlgorithm;
import com.orion.core.cryptology.encoding.alphabetical.AlphabeticalEncodingService;
import com.orion.core.cryptology.encoding.ascii.ASCIIEncodingService;
import com.orion.core.cryptology.encoding.base64.Base64EncodingService;
import com.orion.core.cryptology.encoding.xss.XSSEncodingService;

public class DecodeDataTask extends Orion
{
    public static String run(String encodedData, String decodingAlgorithm)
    {
        EncodingAlgorithm decodingAlgorithmToUse = EncodingAlgorithm.getEnumForValue(decodingAlgorithm);

        if(decodingAlgorithmToUse.is(EncodingAlgorithm.ALPHABETICAL))
        {
            return AlphabeticalEncodingService.decodeAlphanumericForNumber(encodedData);
        }
        else if(decodingAlgorithmToUse.is(EncodingAlgorithm.ASCII))
        {
            return ASCIIEncodingService.decodeASCII(encodedData);
        }
        else if(decodingAlgorithmToUse.is(EncodingAlgorithm.BASE64_FOR_STRING))
        {
            return Base64EncodingService.decodeBase64ForString(encodedData);
        }
        else if(decodingAlgorithmToUse.is(EncodingAlgorithm.BASE64_FOR_URL))
        {
            return Base64EncodingService.decodeBase64ForURL(encodedData);
        }
        else if(decodingAlgorithmToUse.is(EncodingAlgorithm.XSS))
        {
            return XSSEncodingService.decodeFromXSS(encodedData);
        }
        else
        {
            return "";
        }

    }
}