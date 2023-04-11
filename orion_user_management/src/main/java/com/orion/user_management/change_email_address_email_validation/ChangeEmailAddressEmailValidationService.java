package com.orion.user_management.change_email_address_email_validation;

import com.orion.core.abstraction.OrionService;
import com.orion.core.exception.Assert;
import com.orion.user_management.change_email_address_email_validation.data_access.ChangeEmailAddressEmailValidationCodesDAO;
import com.orion.user_management.change_email_address_email_validation.model.ChangeEmailAddressEmailValidationCodeModel;
import com.orion.user_management.email_validation.EmailValidationCodeForUserDoesNotExistException;
import com.orion.user_management.exception.UserDoesNotExistException;

public class ChangeEmailAddressEmailValidationService extends OrionService
{
    public static ChangeEmailAddressEmailValidationResponseBean validateEmail(ChangeEmailAddressEmailValidationCodeModel model) throws UserDoesNotExistException, ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException, EmailValidationCodeForUserDoesNotExistException
    {
        return ChangeEmailAddressBO.of(model).validateCode();
    }


    public static ChangeEmailAddressEmailValidationResponseBean validateEmail(String emailValidationCode) throws UserDoesNotExistException, ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException, EmailValidationCodeForUserDoesNotExistException
    {
        Assert.notEmpty(emailValidationCode, "The emailValidationCode input cannot be null/empty.");
        return ChangeEmailAddressBO.of(ChangeEmailAddressEmailValidationService.getEmailValidationCodeModelByCode(emailValidationCode)).validateCode();
    }


    public static ChangeEmailAddressEmailValidationCodeModel getEmailValidationCodeModelByCode(String emailValidationCode)
    {
        return ChangeEmailAddressEmailValidationCodesDAO.getEmailValidationCodeModelByCode(emailValidationCode);
    }


    public static long getNumberOfAccountsYetToBeValidated()
    {
        return ChangeEmailAddressEmailValidationCodesDAO.getNumberOfAccountsYetToBeValidated();
    }


    public static ChangeEmailAddressEmailValidationCodeModel getEmailValidationCodeByUserID(String userID)
    {
        return ChangeEmailAddressEmailValidationCodesDAO.getEmailValidationCodeModelByUserID(userID);
    }


    public static boolean pendingEmailValidationByUserID(String userID)
    {
        return ChangeEmailAddressEmailValidationCodesDAO.pendingEmailValidationByUserID(userID);
    }


    public static int deleteEmailValidationCodeByUserID(String userID)
    {
        return ChangeEmailAddressEmailValidationCodesDAO.deleteEmailValidationCodeByUserID(userID);
    }


    public static int saveEmailValidationCode(ChangeEmailAddressEmailValidationCodeModel model)
    {
        return ChangeEmailAddressEmailValidationCodesDAO.saveEmailValidationCode(model);
    }


    public static int updateEmailValidationCode(ChangeEmailAddressEmailValidationCodeModel model)
    {
        return ChangeEmailAddressEmailValidationCodesDAO.updateEmailValidationCode(model);
    }
}