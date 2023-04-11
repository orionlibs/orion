package com.orion.analytics.user.general.model;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserGeneralAnalyticsModel extends Orion implements Cloneable
{
    private long numberOfRegisteredUsers;
    private long numberOfAdministratorUsers;
    private long numberOfAnonymousUsers;
    private long numberOfNonAdministratorUsers;
    private Map<String, Long> authoritiesToNumberOfUsersMapper;
    private long numberOfEnabledAccounts;
    private long numberOfDisabledAccounts;
    private long numberOfLoggedInUsers;
    private long numberOfLoggedOutUsers;
    private long numberOfAccountLockdowns;
    private long numberOfUserLogins;
    private long numberOfUserLogouts;
    private long numberOfUsersWithFailedLoginAttempts;
    private long numberOfAccountsYetToBeValidated;
    private long numberOfResetPasswordRequests;
    private Set<String> authorities;
    private BigDecimal percentageOfEnabledAccountsOfAllAccounts;
    private BigDecimal percentageOfDisabledAccountsOfAllAccounts;
    private BigDecimal percentageOfAccountsYetToBeValidatedOfAllAccounts;


    public static UserGeneralAnalyticsModel of()
    {
        return UserGeneralAnalyticsModel.builder().build();
    }


    @Override
    public UserGeneralAnalyticsModel clone()
    {
        return (UserGeneralAnalyticsModel)CloningService.clone(this);
    }


    public UserGeneralAnalyticsModel getCopy()
    {
        return this.clone();
    }
}