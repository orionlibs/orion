package com.orion.admin.usermanagement.userdetails.tasks;

import com.orion.analytics.user.model.AnalyticsUserAggregatedDataModel;
import com.orion.core.abstraction.Orion;
import com.orion.core.document.csv.CSVWriterService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetUserDataAsCSVTask extends Orion
{
    public static String run(AnalyticsUserAggregatedDataModel user)
    {
        CSVWriterService csvService = new CSVWriterService();
        csvService.buildHeader(Arrays.asList("userID", "Email Address", "Authorities", "Pending Email Validation",
                        "Pending Reset Password", "Full Name", "Birthdate", "Mobile Number", "Nationality",
                        "Avatar URL", "LoggedIn", "Enabled", "Number Of Logins", "Last Login DateTime", "Registration DateTime",
                        "Number Of Account Lockdowns"));
        List<List<String>> data = new ArrayList<List<String>>();
        data.add(Arrays.asList(user.getUserID(), user.getEmailAddress(), user.getAuthorities().toString(),
                        Boolean.toString(user.isPendingEmailValidation()), Boolean.toString(user.isPendingResetPassword()),
                        user.getFullName(), user.getBirthdate(), user.getMobileNumber(),
                        user.getNationality(), user.getAvatarURL(), Boolean.toString(user.isLoggedIn()), Boolean.toString(user.isEnabled()),
                        Long.toString(user.getNumberOfLogins()), user.getLastLogInDateTime(), user.getRegistrationDateTime(),
                        Integer.toString(user.getNumberOfAccountLockdowns())));
        csvService.buildBody(data);
        return csvService.getCSV();
    }
}
