package com.orion.analytics.user.tasks;

import com.orion.analytics.user.model.AnalyticsUserAggregatedDataModel;
import com.orion.core.abstraction.Orion;
import com.orion.data.user.address.UserAddressService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.authentication.login.data_access.OrionUserLoginsDAO;
import com.orion.user_management.email_validation.OrionEmailValidationService;
import com.orion.user_management.forgot_password.ForgotPasswordService;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserDetailsModel;
import com.orion.user_management.model.OrionUserModel;
import com.orion.user_management.model.OrionUserSettingsModel;

public class PopulateUserAggregatedDataModelTask extends Orion
{
    public static AnalyticsUserAggregatedDataModel run(OrionAuthorityModel authority)
    {
        OrionUserDetailsModel userDetails = UserAccountService.getUserDetailsByUserID(authority.getUserID());
        OrionUserModel user = UserAccountService.getUserByUserID(authority.getUserID());
        OrionUserSettingsModel userSettings = UserAccountService.getUserSettingsByUserID(authority.getUserID());
        AnalyticsUserAggregatedDataModel analyticsUserAggregatedDataModel = new AnalyticsUserAggregatedDataModel();

        if(user != null && userDetails != null && userSettings != null)
        {
            analyticsUserAggregatedDataModel.setUserID(authority.getUserID());
            analyticsUserAggregatedDataModel.setEmailAddress(authority.getUsername());
            analyticsUserAggregatedDataModel.setAuthorities(authority.getAuthorities());
            analyticsUserAggregatedDataModel.setPendingEmailValidation(OrionEmailValidationService.pendingEmailValidationByUserID(authority.getUserID()));
            analyticsUserAggregatedDataModel.setPendingResetPassword(ForgotPasswordService.pendingForgotPasswordByUserID(authority.getUserID()));
            analyticsUserAggregatedDataModel.setFullName(userDetails.getFullName());

            if(userDetails.getBirthdate() != null)
            {
                analyticsUserAggregatedDataModel.setBirthdate(userDetails.getBirthdate().toString());
            }

            if(userDetails.getMobileNumber() != null)
            {
                analyticsUserAggregatedDataModel.setMobileNumber(userDetails.getMobileNumber().toString());
            }

            analyticsUserAggregatedDataModel.setNationality(userDetails.getNationality());
            analyticsUserAggregatedDataModel.setAvatarURL(userSettings.getAvatarURL());
            analyticsUserAggregatedDataModel.setLoggedIn(userDetails.getLoggedIn());
            analyticsUserAggregatedDataModel.setEnabled(user.getEnabled());
            analyticsUserAggregatedDataModel.setNumberOfLogins(OrionUserLoginsDAO.getNumberOfLoginsByUserID(authority.getUserID()));
            analyticsUserAggregatedDataModel.setLastLogInDateTime(user.getLastLogInDateTimeAsString());
            analyticsUserAggregatedDataModel.setRegistrationDateTime(user.getRegistrationDateTimeAsString());
            analyticsUserAggregatedDataModel.setNumberOfAccountLockdowns(user.getNumberOfAccountLockdowns());
            analyticsUserAggregatedDataModel.setAddresses(UserAddressService.getUserAddressesByUserID(authority.getUserID()));
        }

        return analyticsUserAggregatedDataModel;
    }
}