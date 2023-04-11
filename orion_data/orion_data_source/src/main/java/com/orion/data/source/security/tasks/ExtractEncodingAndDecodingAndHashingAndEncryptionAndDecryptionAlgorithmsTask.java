package com.orion.data.source.security.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.abstraction.OrionEnumeration;
import com.orion.core.cryptology.encoding.EncodingAlgorithm;
import com.orion.core.cryptology.encryption.EncryptionAlgorithm;
import com.orion.core.cryptology.hashing.HashingAlgorithm;
import com.orion.data.source.security.NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException;
import java.util.ArrayList;
import java.util.List;

public class ExtractEncodingAndDecodingAndHashingAndEncryptionAndDecryptionAlgorithmsTask extends Orion
{
    public static List<OrionEnumeration> run(String[] algorithmsToBeUsedInOrder) throws NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException
    {
        List<OrionEnumeration> algorithmsToBeUsedInOrderList = new ArrayList<>();

        for(String algorithm : algorithmsToBeUsedInOrder)
        {
            EncodingAlgorithm encodingDecodingAlgorithm = EncodingAlgorithm.getEnumForValue(algorithm);

            if(encodingDecodingAlgorithm != null)
            {
                algorithmsToBeUsedInOrderList.add(encodingDecodingAlgorithm);
            }
            else
            {
                HashingAlgorithm hashingAlgorithm = HashingAlgorithm.getEnumForValue(algorithm);

                if(hashingAlgorithm != null)
                {
                    algorithmsToBeUsedInOrderList.add(hashingAlgorithm);
                }
                else
                {
                    EncryptionAlgorithm encryptionDecryptionAlgorithm = EncryptionAlgorithm.getEnumForValue(algorithm);

                    if(encryptionDecryptionAlgorithm != null)
                    {
                        algorithmsToBeUsedInOrderList.add(encryptionDecryptionAlgorithm);
                    }

                }

            }

        }

        if(algorithmsToBeUsedInOrderList.isEmpty())
        {
            throw new NoEncodingAndEncryptionAlgorithmsForUsernameProvidedException();
        }

        return algorithmsToBeUsedInOrderList;
    }
}