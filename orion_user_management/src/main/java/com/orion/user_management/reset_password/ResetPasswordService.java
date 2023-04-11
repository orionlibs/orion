package com.orion.user_management.reset_password;

import com.orion.core.abstraction.OrionService;
import com.orion.user_management.account.PasswordBO;
import com.orion.user_management.account.UserManagementAccountPasswordRequestBean;
import com.orion.user_management.reset_password.data_access.OrionUserOldPaswordsDAO;
import com.orion.user_management.reset_password.exception.CannotSaveUsersOldPasswordException;
import com.orion.user_management.reset_password.model.OrionUserOldPasswordModel;
import com.orion.user_management.reset_password.reset.using_code.ResetPasswordUsingForgotPasswordCodeData;
import com.orion.user_management.reset_password.reset.using_code.ResetPasswordUsingForgotPasswordCodeManager;
import com.orion.user_management.reset_password.reset.using_code.ResetPasswordValidationData;
import com.orion.user_management.reset_password.reset.without_code.ResetPasswordWithoutForgotPasswordCodeManager;
import com.orion.user_management.reset_password.storefront_api.request.ResetPasswordRequestValidator;
import com.orion.user_management.reset_password.storefront_api.request.ResetPasswordValidationResult;
import java.util.List;

public class ResetPasswordService extends OrionService
{
    public static ResetPasswordValidationResult isValidRequest(ResetPasswordValidationData requestData)
    {
        return ResetPasswordRequestValidator.isValidRequest(requestData);
    }


    public static ResetPasswordResult resetPasswordUsingForgotPasswordCode(ResetPasswordUsingForgotPasswordCodeData requestData)
    {
        return ResetPasswordUsingForgotPasswordCodeManager.resetPassword(requestData);
    }


    public static ResetPasswordResult resetPasswordWithoutForgotPasswordCode(String userID, UserManagementAccountPasswordRequestBean resetPasswordRequestBean)
    {
        return ResetPasswordWithoutForgotPasswordCodeManager.resetPassword(userID, resetPasswordRequestBean);
    }


    public static boolean doesNewPasswordMatchOldPasswords(String userID, String newPassword)
    {
        return PasswordBO.ofUserID(userID, newPassword).doesNewPasswordMatchOldPassword();
    }


    public static List<OrionUserOldPasswordModel> getUserOldPasswordsByUserID(String userID)
    {
        return OrionUserOldPaswordsDAO.getUserOldPasswordsByUserID(userID);
    }


    public static int saveUserOldPassword(OrionUserOldPasswordModel model)
    {
        return OrionUserOldPaswordsDAO.saveUserOldPassword(model);
    }


    public static void saveUserOldPassword(String userID) throws CannotSaveUsersOldPasswordException
    {
        UserOldPasswordProcessor.of(userID).saveOldUserPassword();
    }
}