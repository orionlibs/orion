package com.orion.data.user.password;

import com.orion.core.abstraction.OrionService;
import com.orion.core.cryptology.encoding.base64.Base64EncodingService;
import com.orion.core.cryptology.encryption.bcrypt.BCryptEncryptionService;
import com.orion.core.string.StringsService;
import com.orion.data.source.configuration.ConfigurationService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordService extends OrionService
{
    public static String generate(int length, boolean useSymbols)
    {
        return StringsService.generateRandomString(length, useSymbols);
    }


    public static String encrypt(String rawPassword)
    {
        return BCryptEncryptionService.encrypt(rawPassword);
    }


    public static boolean doesPasswordMatchEncryptedOne(String rawPassword, String encryptedPassword)
    {
        return BCryptEncryptionService.matches(rawPassword, encryptedPassword);
    }


    public static boolean isValid(String password)
    {
        String passwordPattern = ConfigurationService.getProp("user.management.registration.password.pattern");
        String decodedPasswordPattern = Base64EncodingService.decodeBase64ForString(passwordPattern);
        Pattern pattern = Pattern.compile(decodedPasswordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}