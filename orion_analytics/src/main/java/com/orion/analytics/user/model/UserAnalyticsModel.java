package com.orion.analytics.user.model;

import com.orion.analytics.user.authentication.model.UserAuthenticationAnalyticsModel;
import com.orion.analytics.user.general.model.UserGeneralAnalyticsModel;
import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
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
public class UserAnalyticsModel implements OrionModel
{
    private UserGeneralAnalyticsModel userGeneralAnalyticsModel;
    private UserAuthenticationAnalyticsModel userAuthenticationAnalyticsModel;
    private AnalyticsAuthorityStatisticsModel userAuthorityStatisticsModel;


    public static UserAnalyticsModel of()
    {
        return UserAnalyticsModel.builder().build();
    }


    @Override
    public UserAnalyticsModel clone()
    {
        return (UserAnalyticsModel)CloningService.clone(this);
    }


    @Override
    public UserAnalyticsModel getCopy()
    {
        return this.clone();
    }
}