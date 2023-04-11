package com.orion.user_management.forgot_password;

import com.orion.core.abstraction.OrionService;
import com.orion.core.exception.ResourceException;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.forgot_password.data_access.OrionForgotPasswordCodesDAO;
import com.orion.user_management.forgot_password.model.OrionForgotPasswordCodesModel;

public class ForgotPasswordService extends OrionService
{
    public static ForgotPasswordResponseBean generateForgotPasswordEmailHTML(String username, String userID) throws ResourceException
    {
        return ForgotPasswordBO.of(username, userID).generateForgotPasswordEmailHTML();
    }
    /*
     * private static void deleteForgotPasswordCodeForUserToCreateNewOne(String
     * userID) {
     * OrionForgotPasswordCodesDAO.deleteForgotPasswordCodeByUserID(userID); }
     */


    public static OrionForgotPasswordCodesModel getForgotPasswordCodeByCode(String forgotPasswordCode)
    {
        return OrionForgotPasswordCodesDAO.getForgotPasswordCodeByCode(forgotPasswordCode);
    }


    public static long getNumberOfResetPasswordRequests()
    {
        return OrionForgotPasswordCodesDAO.getNumberOfResetPasswordRequests();
    }


    public static boolean pendingForgotPasswordByUserID(String userID)
    {
        return OrionForgotPasswordCodesDAO.pendingForgotPasswordByUserID(userID);
    }


    public static int deleteForgotPasswordCodeByUserID(String userID)
    {
        return OrionForgotPasswordCodesDAO.deleteByUserID(userID);
    }


    public static ForgotPasswordResponseBean processForgotPasswordRequest(OrionForgotPasswordRequestBean forgotPasswordRequestBean) throws UserHasNoAuthorityException
    {
        return ForgotPasswordBO.ofRequest(forgotPasswordRequestBean).processForgotPasswordRequest();
    }
}