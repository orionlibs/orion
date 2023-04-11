package com.orion.payment;

import com.orion.core.abstraction.OrionCheckedException;

public class PaymentNotCompletedException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Someone tried to set the payment as successful before payment was completed.";


    public PaymentNotCompletedException()
    {
        super(DefaultErrorMessage);
    }


    public PaymentNotCompletedException(String message)
    {
        super(message);
    }


    public PaymentNotCompletedException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public PaymentNotCompletedException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public PaymentNotCompletedException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}