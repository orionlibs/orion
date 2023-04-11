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
public class AnalyticsDateTimeModel implements OrionModel
{
    private String date;
    private String time;
    private DateTime dateTime;


    public static AnalyticsDateTimeModel of()
    {
        return AnalyticsDateTimeModel.builder().build();
    }


    @Override
    public AnalyticsDateTimeModel clone()
    {
        return (AnalyticsDateTimeModel)CloningService.clone(this);
    }


    @Override
    public AnalyticsDateTimeModel getCopy()
    {
        return this.clone();
    }
}