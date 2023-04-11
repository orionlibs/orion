package com.orion.user_management.authentication.login;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.user_management.authentication.security.data_access.OrionUserFailedLoginAttemptsDAO;
import com.orion.user_management.authentication.security.model.OrionUserFailedLoginAttemptModel;
import com.orion.user_management.model.OrionAuthorityModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class FailedLoginAttemptBO extends Orion
{
    private OrionAuthorityModel authority;


    public static FailedLoginAttemptBO of(OrionAuthorityModel authority)
    {
        return FailedLoginAttemptBO.builder().authority(authority).build();
    }


    public void processFailedLoginAttempt()
    {
        boolean enableMonitoringOfFailedLoginAttempts = InMemoryConfigurationService.getBooleanProp("user.management.login.failed.enable.monitoring");
        int maximumNumberOfAllowedFailedLoginAttempts = InMemoryConfigurationService.getIntegerProp("user.management.login.failed.maximum.number.of.allowed.attempts");

        if(enableMonitoringOfFailedLoginAttempts)
        {
            DateTime currentDatetime = CalendarService.getCurrentDatetime();
            OrionUserFailedLoginAttemptModel failedLoginAttempts = OrionUserFailedLoginAttemptsDAO.getByUserID(authority.getUserID());

            if(failedLoginAttempts != null)
            {
                processAndUpdateFailedLoginAttemptOfRegisteredUser("", currentDatetime, authority, failedLoginAttempts, maximumNumberOfAllowedFailedLoginAttempts);
            }
            else
            {
                saveFailedLoginAttempt("", currentDatetime, authority);
            }

        }

    }


    private void saveFailedLoginAttempt(String IPAddress, DateTime currentDatetime, OrionAuthorityModel authority)
    {
        OrionUserFailedLoginAttemptModel model = new OrionUserFailedLoginAttemptModel();
        model.setUserID(authority.getUserID());
        model.setFailedLoginAttempts(1);
        model.setFirstFailedLoginAttemptDateTime(currentDatetime.toOrionSQLTimestamp());
        model.setIPAddress(IPAddress);
        model.setAccountDisabled(false);
        OrionUserFailedLoginAttemptsDAO.save(model);
    }


    private void processAndUpdateFailedLoginAttemptOfRegisteredUser(String IPAddress, DateTime currentDatetime, OrionAuthorityModel authority, OrionUserFailedLoginAttemptModel failedLoginAttempts, int maximumNumberOfAllowedFailedLoginAttempts)
    {
        DateTime firstFailedLoginAttemptDatetime = DateTime.of(failedLoginAttempts.getFirstFailedLoginAttemptDateTime());
        DateTime datetimeToStopMonitoringFailedLoginAttempts = CalendarService.addMinutesToDatetime(firstFailedLoginAttemptDatetime, maximumNumberOfAllowedFailedLoginAttempts);
        boolean isCurrentDatetimeBetweenFirstFailedLoginAttemptAndTimeToStopMonitoring = CalendarService.isDateWithinRange(currentDatetime, firstFailedLoginAttemptDatetime, datetimeToStopMonitoringFailedLoginAttempts);

        if(isCurrentDatetimeBetweenFirstFailedLoginAttemptAndTimeToStopMonitoring)
        {
            failedLoginAttempts.setUserID(authority.getUserID());
            failedLoginAttempts.setIPAddress(IPAddress);

            if(failedLoginAttempts.getFailedLoginAttempts() == maximumNumberOfAllowedFailedLoginAttempts - 1)
            {
                //failedLoginAttempts.setFailedLoginAttempts(0);
                //failedLoginAttempts.setAccountDisabled(true);
                failedLoginAttempts.setAccountDisabled(false);
                failedLoginAttempts.setFailedLoginAttempts(failedLoginAttempts.getFailedLoginAttempts() + 1);
                OrionFailedLoginService.emailUserAboutFailedLoginAttempts(authority.getUsername());
                //UserAccountService.disableUserAccountByUserID(authority.getUserID());
            }
            else
            {
                failedLoginAttempts.setFailedLoginAttempts(failedLoginAttempts.getFailedLoginAttempts() + 1);
                failedLoginAttempts.setAccountDisabled(false);
            }

            OrionUserFailedLoginAttemptsDAO.update(failedLoginAttempts);
        }

    }
}