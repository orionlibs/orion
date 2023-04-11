package com.orion.user_management.registration.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RegistrationValidationServiceTest
{
    /*
     * @Test public void isValidEmailAddress() { boolean result =
     * RegistrationValidationService.isValidEmailAddress(""); assertFalse(result);
     * result = RegistrationValidationService.isValidEmailAddress("efthymiou");
     * assertFalse(result); result =
     * RegistrationValidationService.isValidEmailAddress("efthymiou.dimitrios");
     * assertFalse(result); result =
     * RegistrationValidationService.isValidEmailAddress("efthymiou.dimitrios@");
     * assertFalse(result); result =
     * RegistrationValidationService.isValidEmailAddress("efthymiou.dimitrios@gmail"
     * ); assertFalse(result); result =
     * RegistrationValidationService.isValidEmailAddress(
     * "efthymiou.dimitrios@gmail.com"); assertTrue(result); }
     */
    /*
     * @Test public void isValidPassword() {
     * InMemoryConfigurationService.registerProp(
     * "user.management.registration.password.pattern",
     * "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,}$"); boolean
     * result = RegistrationValidationService.isValidPassword("");
     * assertFalse(result); result =
     * RegistrationValidationService.isValidPassword("bunkzh"); assertFalse(result);
     * result = RegistrationValidationService.isValidPassword("bunkzh3Z");
     * assertFalse(result); result =
     * RegistrationValidationService.isValidPassword("bunkzh3Z!");
     * assertTrue(result); }
     */
    @Test
    public void isValidMobileNumber()
    {
        boolean result = RegistrationValidationService.isValidMobileNumber("", "GB");
        assertFalse(result);
        result = RegistrationValidationService.isValidMobileNumber("0789662021", "GB");
        assertFalse(result);
        result = RegistrationValidationService.isValidMobileNumber("07896620211", "GB");
        assertTrue(result);
        result = RegistrationValidationService.isValidMobileNumber("+44789662021", "GB");
        assertFalse(result);
        result = RegistrationValidationService.isValidMobileNumber("+447896620211", "GB");
        assertTrue(result);
        result = RegistrationValidationService.isValidMobileNumber("0044789662021", "GB");
        assertFalse(result);
        result = RegistrationValidationService.isValidMobileNumber("00447896620211", "GB");
        assertTrue(result);
    }
}