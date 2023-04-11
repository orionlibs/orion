package com.orion.user_management.account;

import com.orion.core.abstraction.OrionErrorMessages;

public class UserAccountErrors extends OrionErrorMessages
{
    public static final String ErrorWithAccountDeactivation = "Problem with deactivation of account of userID: ";
    public static final String ErrorWithAccountCredit = "Problem with account credit of userID: ";
    public static final String ErrorWithAccountProfileDataUpdate = "Problem with updating profile data of userID: ";
    public static final String ErrorWithGettingAccountProfileData = "Problem with getting profile data of userID: ";
    public static final String ErrorWithGettingDirectDebitData = "Problem with getting direct debit data of userID: ";
    public static final String ErrorWithAccountProfileNewEmailAddressValidation = "Problem with validating new email address of userID: ";
    public static final String ErrorWithAccountProfileResendValidationCodeToNewEmailAddress = "Problem with resending validation code to new email address of userID: ";
    public static final String ErrorWithAccountNewsletterEnablement = "Problem with enabling newsletters for userID: ";
    public static final String ErrorWithAccountNewsletterDisablement = "Problem with disabling newsletters for userID: ";
    public static final String ErrorWithAccountPasswordReset = "Problem with resetting account password of userID: ";
    public static final String ErrorWithPreparingAccountDetailsForDownload = "Problem with the preparation of account details for download of userID: ";
    public static final String ErrorWithSendingChangeEmailAddressEmail = "Problem with sending validation email for new email address";
    public static final String ErrorWithSendingAccountReactivationEmail = "Problem with sending validation email for account reactivation";
    public static final String ErrorWithSendingAccountDeactivationEmail = "Problem with sending email for account deactivation";
    public static final String ErrorWithSendingAccountIsEnabledEmailToUser = "Problem with sending the account is enabled email to the user";
    public static final String ErrorWithSendingAccountIsValidatedEmailToUser = "Problem with sending the account is validated email to the user";
}