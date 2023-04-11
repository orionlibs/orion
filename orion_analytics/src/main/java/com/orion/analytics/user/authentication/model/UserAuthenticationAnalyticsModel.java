package com.orion.analytics.user.authentication.model;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import java.math.BigDecimal;
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
public class UserAuthenticationAnalyticsModel extends Orion implements Cloneable
{
    private BigDecimal percentageOfLoggedInUsersOfAllUsers;
    private BigDecimal percentageOfLoggedOutUsersOfAllUsers;
    private BigDecimal percentageOfAdministratorUsersOfAllUsers;
    private BigDecimal percentageOfAnonymousUsersOfAllUsers;
    private BigDecimal percentageOfNonAdministratorUsersOfAllUsers;


    public static UserAuthenticationAnalyticsModel of()
    {
        return UserAuthenticationAnalyticsModel.builder().build();
    }


    @Override
    public UserAuthenticationAnalyticsModel clone()
    {
        return (UserAuthenticationAnalyticsModel)CloningService.clone(this);
    }


    public UserAuthenticationAnalyticsModel getCopy()
    {
        return this.clone();
    }
}