package com.orion.admin.usermanagement.userdetails.tasks;

import com.orion.analytics.user.model.AnalyticsUserAggregatedDataModel;
import com.orion.core.abstraction.Orion;
import com.orion.core.document.csv.CSVWriterService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllUsersDataAsCSVTask extends Orion
{
    public static String run(List<AnalyticsUserAggregatedDataModel> usersData)
    {
        CSVWriterService csvService = new CSVWriterService();
        csvService.buildHeader(Arrays.asList("userID", "Email Address", "Business Name", "Authorities", "Pending Email Validation",
                        "Pending Reset Password", "Full Name", "Birthdate", "Mobile Number", "Nationality",
                        "Avatar URL", "LoggedIn", "Enabled", "Number Of Logins", "Last Login DateTime", "Registration DateTime",
                        "Number Of Account Lockdowns"));
        List<List<String>> data = new ArrayList<List<String>>();

        for(AnalyticsUserAggregatedDataModel userData : usersData)
        {
            data.add(Arrays.asList(userData.getUserID(), userData.getEmailAddress(), userData.getBusinessName(), userData.getAuthorities().toString(),
                            Boolean.toString(userData.isPendingEmailValidation()), Boolean.toString(userData.isPendingResetPassword()),
                            userData.getFullName(), userData.getBirthdate(), userData.getMobileNumber(),
                            userData.getNationality(), userData.getAvatarURL(), Boolean.toString(userData.isLoggedIn()), Boolean.toString(userData.isEnabled()),
                            Long.toString(userData.getNumberOfLogins()), userData.getLastLogInDateTime(), userData.getRegistrationDateTime(),
                            Integer.toString(userData.getNumberOfAccountLockdowns())));
        }

        csvService.buildBody(data);
        return csvService.getCSV();
    }
}
