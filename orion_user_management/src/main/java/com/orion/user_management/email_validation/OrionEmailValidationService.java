package com.orion.user_management.email_validation;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.exception.Assert;
import com.orion.user_management.email_validation.data_access.OrionEmailValidationCodesDAO;
import com.orion.user_management.email_validation.model.OrionEmailValidationCodeModel;
import com.orion.user_management.email_validation.tasks.RequestNewEmailValidationTask;
import com.orion.user_management.exception.UserDoesNotExistException;
import com.orion.user_management.exception.UserHasNoAuthorityException;

public class OrionEmailValidationService extends OrionService
{
    public static UserManagementEmailValidationResponseBean validateUserEmail(String emailValidationCode)
    {
        return UserEmailAddressValidatorBO.ofCode(emailValidationCode).validateByCode();
    }


    public static OrionEmailValidationResponseBean validateEmail(OrionEmailValidationCodeModel model) throws UserDoesNotExistException, EmailValidationCodeForUserDoesNotExistException, UserHasNoAuthorityException
    {
        return UserEmailAddressValidatorBO.ofModel(model).validateByModel();
    }


    public static OrionEmailValidationResponseBean validateEmail(String emailValidationCode) throws UserDoesNotExistException, EmailValidationCodeForUserDoesNotExistException, UserHasNoAuthorityException
    {
        Assert.notEmpty(emailValidationCode, "The emailValidationCode input cannot be null/empty.");
        return UserEmailAddressValidatorBO.ofModel(OrionEmailValidationService.getEmailValidationCodeByCode(emailValidationCode)).validateByModel();
    }


    public static OrionEmailValidationCodeModel getEmailValidationCodeByCode(String emailValidationCode)
    {
        return OrionEmailValidationCodesDAO.getEmailValidationCodeByCode(emailValidationCode);
    }


    public static OrionEmailValidationCodeModel getEmailValidationCodeByUserID(String userID)
    {
        return OrionEmailValidationCodesDAO.getEmailValidationCodeByUserID(userID);
    }


    public static long getNumberOfAccountsYetToBeValidated()
    {
        return OrionEmailValidationCodesDAO.getNumberOfAccountsYetToBeValidated();
    }


    public static boolean pendingEmailValidationByUserID(String userID)
    {
        return OrionEmailValidationCodesDAO.pendingEmailValidationByUserID(userID);
    }


    public static int deleteEmailValidationCodeByUserID(String userID)
    {
        return OrionEmailValidationCodesDAO.deleteEmailValidationCodeByUserID(userID);
    }


    public static int saveEmailValidationCode(OrionEmailValidationCodeModel model)
    {
        return OrionEmailValidationCodesDAO.saveEmailValidationCode(model);
    }


    public static int updateEmailValidationCode(OrionEmailValidationCodeModel model)
    {
        return OrionEmailValidationCodesDAO.updateEmailValidationCode(model);
    }


    public static boolean requestNewEmailValidation(String emailAddress) throws AccountIsAlreadyValidatedException, InvalidDateException, UserHasNoAuthorityException
    {
        return RequestNewEmailValidationTask.run(emailAddress);
    }


    public static UserManagementEmailValidationResponseBean validateAccountReactivation(String emailValidationCode)
    {
        return UserAccountReactivationBO.ofCode(emailValidationCode).validateAccountReactivationCode();
    }


    public static boolean requestNewAccountReactivationEmailValidation(String emailAddress) throws UserHasNoAuthorityException
    {
        return UserAccountReactivationBO.ofEmailAddress(emailAddress).requestNewAccountReactivationValidationCode();
    }
}