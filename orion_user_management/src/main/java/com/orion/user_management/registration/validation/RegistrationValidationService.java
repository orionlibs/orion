package com.orion.user_management.registration.validation;

import com.orion.core.abstraction.OrionService;
import com.orion.core.cryptology.encoding.base64.Base64EncodingService;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.data.user.address.UserAddressService;
import com.orion.data.user.email_address.EmailAddressService;
import com.orion.data.user.name.PersonNameService;
import com.orion.data.user.password.PasswordService;
import com.orion.data.user.phone_number.PhoneNumberService;
import com.orion.data.user.phone_number.model.PhoneNumberRegionCode;
import com.orion.user_management.registration.OrionRegistrationRequestBean;

public class RegistrationValidationService extends OrionService
{
    public static final String AtLeast8CharactersWithDigits = "^(?=.*[0-9]).{8,}$";
    public static final String AtLeast8CharactersWithDigitsAndSymbolAndUppercase = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,}$";


    public static RegistrationRequestBasicValidationVO doBasicValidation(OrionRegistrationRequestBean registrationRequestBean, PhoneNumberRegionCode phoneNumberRegionCode)
    {
        return RegistrationRequestBasicValidationVO.builder()
                        .isValidFirstName(PersonNameService.isValidFirstName(registrationRequestBean.getFirstName()))
                        .isValidLastName(PersonNameService.isValidLastName(registrationRequestBean.getLastName()))
                        .isValidFullName(PersonNameService.isValidFullName(registrationRequestBean.getFullName()))
                        .isValidEmailAddress(isValidEmailAddress(registrationRequestBean.getUsername()))
                        .isValidPassword(isValidPassword(registrationRequestBean.getPassword()))
                        .isValidMobileNumber(isValidMobileNumber(registrationRequestBean.getMobileNumber(), phoneNumberRegionCode.get()))
                        .build();
    }


    public static boolean isValidEmailAddress(String emailAddress)
    {
        return EmailAddressService.isValidEmailAddress(emailAddress);
    }


    public static boolean isValidPassword(String password)
    {
        return PasswordService.isValid(password);
    }


    public static boolean isValidMobileNumber(String mobileNumber, String regionCode)
    {
        return PhoneNumberService.isValidPhoneNumber(mobileNumber, regionCode);
    }


    public static boolean isValidPostcode(String postcode)
    {
        String postcodePattern = ConfigurationService.getProp("user.management.registration.postcode.pattern.uk");
        String decodedPostcodePattern = Base64EncodingService.decodeBase64ForString(postcodePattern);
        return UserAddressService.isValidPostcode(postcode, decodedPostcodePattern);
    }


    public static boolean isValidPostcode(String postcode, String postcodePattern)
    {
        return UserAddressService.isValidPostcode(postcode, postcodePattern);
    }
}