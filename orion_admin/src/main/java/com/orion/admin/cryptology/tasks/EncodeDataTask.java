package com.orion.admin.cryptology.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.cryptology.encoding.EncodingAlgorithm;
import com.orion.core.cryptology.encoding.alphabetical.AlphabeticalEncodingService;
import com.orion.core.cryptology.encoding.ascii.ASCIIEncodingService;
import com.orion.core.cryptology.encoding.base64.Base64EncodingService;
import com.orion.core.cryptology.encoding.xss.XSSEncodingService;

public class EncodeDataTask extends Orion
{
    public static String run(String data, String encodingAlgorithm)
    {
        EncodingAlgorithm encodingAlgorithmToUse = EncodingAlgorithm.getEnumForValue(encodingAlgorithm);

        if(encodingAlgorithmToUse.is(EncodingAlgorithm.ALPHABETICAL))
        {
            return AlphabeticalEncodingService.encodeAlphanumericForNumber(data);
        }
        else if(encodingAlgorithmToUse.is(EncodingAlgorithm.ASCII))
        {
            return ASCIIEncodingService.encodeToASCII(data);
        }
        else if(encodingAlgorithmToUse.is(EncodingAlgorithm.BASE64_FOR_STRING))
        {
            return Base64EncodingService.encodeBase64ForString(data);
        }
        else if(encodingAlgorithmToUse.is(EncodingAlgorithm.BASE64_FOR_URL))
        {
            return Base64EncodingService.encodeBase64ForURL(data);
        }
        else if(encodingAlgorithmToUse.is(EncodingAlgorithm.XSS))
        {
            return XSSEncodingService.encodeWithXSS(data);
        }
        else
        {
            return "";
        }

    }
}