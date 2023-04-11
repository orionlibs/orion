package com.orion.analytics.user.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import java.util.Map;
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
public class AnalyticsAuthorityStatisticsModel implements OrionModel
{
    private Map<String, Long> authoritiesToNumberOfUsersMapper;
    private long numberOfAdministrators;


    public static AnalyticsAuthorityStatisticsModel of()
    {
        return AnalyticsAuthorityStatisticsModel.builder().build();
    }


    @Override
    public AnalyticsAuthorityStatisticsModel clone()
    {
        return (AnalyticsAuthorityStatisticsModel)CloningService.clone(this);
    }


    @Override
    public AnalyticsAuthorityStatisticsModel getCopy()
    {
        return this.clone();
    }
}