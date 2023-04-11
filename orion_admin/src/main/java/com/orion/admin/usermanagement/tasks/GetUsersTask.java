package com.orion.admin.usermanagement.tasks;

import com.orion.admin.usermanagement.UserSearchOptions;
import com.orion.analytics.user.UserAnalyticsService;
import com.orion.analytics.user.model.AnalyticsUserAggregatedDataModel;
import com.orion.core.abstraction.Orion;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.data_access.OrionUserDetailsDAO;
import com.orion.user_management.email_validation.OrionEmailValidationService;
import com.orion.user_management.email_validation.model.OrionEmailValidationCodeModel;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.forgot_password.ForgotPasswordService;
import com.orion.user_management.forgot_password.model.OrionForgotPasswordCodesModel;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserDetailsModel;
import java.util.ArrayList;
import java.util.List;

public class GetUsersTask extends Orion
{
    public static List<AnalyticsUserAggregatedDataModel> run(String query, int searchOption) throws UserHasNoAuthorityException
    {
        List<AnalyticsUserAggregatedDataModel> usersData = new ArrayList<>();

        if(searchOption == UserSearchOptions.UserID)
        {
            OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(query);

            if(authority != null)
            {
                usersData.add(UserAnalyticsService.populateUserAggregatedDataModel(authority));
            }

        }
        else if(searchOption == UserSearchOptions.EmailAddress)
        {
            OrionAuthorityModel authority = UserAccountService.getAuthorityByUsername(query);

            if(authority != null)
            {
                usersData.add(UserAnalyticsService.populateUserAggregatedDataModel(authority));
            }

        }
        else if(searchOption == UserSearchOptions.PhoneNumber)
        {
            List<OrionUserDetailsModel> users = UserAccountService.getUsersDetailsByPhoneNumber(query);

            if(users != null && !users.isEmpty())
            {

                for(OrionUserDetailsModel user : users)
                {
                    OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(user.getUserID());

                    if(authority != null)
                    {
                        usersData.add(UserAnalyticsService.populateUserAggregatedDataModel(authority));
                    }

                }

            }

        }
        else if(searchOption == UserSearchOptions.EmailValidationCode)
        {
            OrionEmailValidationCodeModel model = OrionEmailValidationService.getEmailValidationCodeByCode(query);

            if(model != null)
            {
                OrionUserDetailsModel user = OrionUserDetailsDAO.getUserDetailsByUserID(model.getUserID());

                if(user != null)
                {
                    OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(user.getUserID());

                    if(authority != null)
                    {
                        usersData.add(UserAnalyticsService.populateUserAggregatedDataModel(authority));
                    }

                }

            }

        }
        else if(searchOption == UserSearchOptions.ForgotPasswordCode)
        {
            OrionForgotPasswordCodesModel model = ForgotPasswordService.getForgotPasswordCodeByCode(query);

            if(model != null)
            {
                OrionUserDetailsModel user = OrionUserDetailsDAO.getUserDetailsByUserID(model.getUserID());

                if(user != null)
                {
                    OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(user.getUserID());

                    if(authority != null)
                    {
                        usersData.add(UserAnalyticsService.populateUserAggregatedDataModel(authority));
                    }

                }

            }

        }

        return usersData;
    }
}