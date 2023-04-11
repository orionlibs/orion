package com.orion.user_management.authentication.login;

import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.authentication.security.tasks.EmailUserAboutFailedLoginAttemptsTask;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserModel;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class OrionFailedLoginService implements UserDetailsService
{
    private boolean enableMonitoringOfFailedLoginAttempts;
    private int maximumNumberOfMinutesToMonitorFailedLoginAttempts;
    private int maximumNumberOfAllowedFailedLoginAttempts;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        OrionAuthorityModel authority;

        try
        {
            authority = UserAccountService.getAuthorityByUsername(username);

            if(authority != null)
            {
                FailedLoginAttemptBO.of(authority).processFailedLoginAttempt();
                OrionUserModel user = UserAccountService.getUserByUserIDAndEnabled(authority.getUserID());
                UserBuilder builder = null;

                if(user != null)
                {
                    builder = User.withUsername(username);
                    builder.password(user.getPassword());
                    builder.roles(authority.getAuthoritiesAsArray());
                }
                else
                {
                    throw new UsernameNotFoundException("User not found.");
                }

                return builder.build();
            }
            else
            {
                throw new UsernameNotFoundException("User not found.");
            }

        }
        catch(UserHasNoAuthorityException e)
        {
            throw new UsernameNotFoundException("User not found.");
        }

    }


    public static void emailUserAboutFailedLoginAttempts(String emailAddress)
    {
        EmailUserAboutFailedLoginAttemptsTask.run(emailAddress);
    }


    public int getMaximumNumberOfMinutesToMonitorFailedLoginAttempts()
    {
        return this.maximumNumberOfMinutesToMonitorFailedLoginAttempts;
    }


    public void setMaximumNumberOfMinutesToMonitorFailedLoginAttempts(int maximumNumberOfMinutesToMonitorFailedLoginAttempts)
    {
        this.maximumNumberOfMinutesToMonitorFailedLoginAttempts = maximumNumberOfMinutesToMonitorFailedLoginAttempts;
    }


    public boolean isEnableMonitoringOfFailedLoginAttempts()
    {
        return this.enableMonitoringOfFailedLoginAttempts;
    }


    public void setEnableMonitoringOfFailedLoginAttempts(boolean enableMonitoringOfFailedLoginAttempts)
    {
        this.enableMonitoringOfFailedLoginAttempts = enableMonitoringOfFailedLoginAttempts;
    }


    public int getMaximumNumberOfAllowedFailedLoginAttempts()
    {
        return this.maximumNumberOfAllowedFailedLoginAttempts;
    }


    public void setMaximumNumberOfAllowedFailedLoginAttempts(int maximumNumberOfAllowedFailedLoginAttempts)
    {
        this.maximumNumberOfAllowedFailedLoginAttempts = maximumNumberOfAllowedFailedLoginAttempts;
    }
}