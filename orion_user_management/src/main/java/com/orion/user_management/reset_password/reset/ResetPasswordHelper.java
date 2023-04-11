package com.orion.user_management.reset_password.reset;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.model.OrionUserModel;

public class ResetPasswordHelper extends Orion
{
    public static void updateUserAfterPasswordReset(String userID)
    {
        OrionUserModel user = UserAccountService.getUserByUserID(userID);
        user.setNeedsReauthentication(Boolean.FALSE);
        user.setEnabled(Boolean.TRUE);
        user.setLastAccountUpdateDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp());
        UserAccountService.updateUserByUserID(user);
    }
}