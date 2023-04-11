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
public class AnalyticsLoginModel implements OrionModel
{
    private String loginDate;
    private String loginTime;
    private DateTime loginDateTime;


    public static AnalyticsLoginModel of()
    {
        return AnalyticsLoginModel.builder().build();
    }


    @Override
    public AnalyticsLoginModel clone()
    {
        return (AnalyticsLoginModel)CloningService.clone(this);
    }


    @Override
    public AnalyticsLoginModel getCopy()
    {
        return this.clone();
    }
}