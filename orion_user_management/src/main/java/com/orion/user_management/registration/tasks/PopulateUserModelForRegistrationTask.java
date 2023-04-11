package com.orion.user_management.registration.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.user_management.model.OrionUserModel;

public class PopulateUserModelForRegistrationTask extends Orion
{
    public static void run(OrionUserModel user)
    {
        user.setMustChangePassword(false);
        user.setPendingEmailAddressValidation(false);
        user.setEnabled(false);
        user.setLoggedIn(false);
        user.setAcceptedTermsAndConditionsAndPrivacyNotice(true);
        SQLTimestamp currentDatetime = CalendarService.getCurrentDatetimeAsSQLTimestamp();
        user.setRegistrationDate(currentDatetime.toLocalDateTime().toLocalDate().toString());
        user.setRegistrationDateTime(currentDatetime);
        user.setLastAccountUpdateDateTime(currentDatetime);
        user.setNumberOfAccountLockdowns(0);
        user.setTimezone("UTC");
    }
}