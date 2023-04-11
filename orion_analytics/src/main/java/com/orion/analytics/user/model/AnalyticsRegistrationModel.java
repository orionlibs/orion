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
public class AnalyticsRegistrationModel implements OrionModel
{
    private String registrationDate;
    private String registrationTime;
    private DateTime registrationDateTime;


    public static AnalyticsRegistrationModel of()
    {
        return AnalyticsRegistrationModel.builder().build();
    }


    @Override
    public AnalyticsRegistrationModel clone()
    {
        return (AnalyticsRegistrationModel)CloningService.clone(this);
    }


    @Override
    public AnalyticsRegistrationModel getCopy()
    {
        return this.clone();
    }
}