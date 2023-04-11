package com.orion.analytics.user.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import com.orion.user_management.authentication.security.model.OrionUserFailedLoginAttemptModel;
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
public class AnalyticsFailedLoginAttemptsModel implements OrionModel
{
    private OrionUserFailedLoginAttemptModel model;


    public static AnalyticsFailedLoginAttemptsModel of()
    {
        return AnalyticsFailedLoginAttemptsModel.builder().build();
    }


    @Override
    public AnalyticsFailedLoginAttemptsModel clone()
    {
        return (AnalyticsFailedLoginAttemptsModel)CloningService.clone(this);
    }


    @Override
    public AnalyticsFailedLoginAttemptsModel getCopy()
    {
        return this.clone();
    }
}