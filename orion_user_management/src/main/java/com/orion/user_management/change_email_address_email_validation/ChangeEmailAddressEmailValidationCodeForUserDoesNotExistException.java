package com.orion.user_management.change_email_address_email_validation;

import com.orion.core.abstraction.OrionCheckedException;

public class ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Invalid email validation code.";


    public ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException()
    {
        super(DefaultErrorMessage);
    }


    public ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException(String message)
    {
        super(message);
    }


    public ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}