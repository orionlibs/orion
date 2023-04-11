package com.orion.user_management.change_email_address_email_validation;

import com.orion.core.abstraction.OrionCheckedException;

public class ChangeEmailAddressEmailValidationCodeHasExpiredException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "The given email validation code has expired.";


    public ChangeEmailAddressEmailValidationCodeHasExpiredException()
    {
        super(DefaultErrorMessage);
    }


    public ChangeEmailAddressEmailValidationCodeHasExpiredException(String message)
    {
        super(message);
    }


    public ChangeEmailAddressEmailValidationCodeHasExpiredException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public ChangeEmailAddressEmailValidationCodeHasExpiredException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public ChangeEmailAddressEmailValidationCodeHasExpiredException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}