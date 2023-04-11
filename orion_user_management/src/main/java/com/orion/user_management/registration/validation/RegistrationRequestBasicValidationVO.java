package com.orion.user_management.registration.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class RegistrationRequestBasicValidationVO
{
    private boolean isValidFirstName;
    private boolean isValidLastName;
    private boolean isValidFullName;
    private boolean isValidEmailAddress;
    private boolean isValidPassword;
    private boolean isValidMobileNumber;


    public static RegistrationRequestBasicValidationVO of()
    {
        return RegistrationRequestBasicValidationVO.builder().build();
    }


    public boolean areInputsValid()
    {
        return (isValidFullName || (isValidFirstName && isValidLastName))
                        && isValidEmailAddress && isValidPassword && isValidMobileNumber;
    }


    public boolean areInputsInvalid()
    {
        return !areInputsValid();
    }
}