package com.orion.analytics.user.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.datetime.DateTime;
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
public class AnalyticsLogoutModel implements OrionModel
{
    private String logoutDate;
    private String logoutTime;
    private DateTime logoutDateTime;


    public static AnalyticsLogoutModel of()
    {
        return AnalyticsLogoutModel.builder().build();
    }


    @Override
    public AnalyticsLogoutModel clone()
    {
        return (AnalyticsLogoutModel)CloningService.clone(this);
    }


    @Override
    public AnalyticsLogoutModel getCopy()
    {
        return this.clone();
    }
}