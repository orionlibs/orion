package com.orion.user_management.authentication.security.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.SQLTimestamp;
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
public class OrionUserFailedLoginAttemptModel implements OrionModel
{
    private String userID;
    private String IPAddress;
    private SQLTimestamp firstFailedLoginAttemptDateTime;
    private int failedLoginAttempts;
    private Boolean accountDisabled;


    public static OrionUserFailedLoginAttemptModel of()
    {
        return OrionUserFailedLoginAttemptModel.builder().build();
    }


    public static OrionUserFailedLoginAttemptModel of(String userID)
    {
        return OrionUserFailedLoginAttemptModel.builder().userID(userID).build();
    }


    public String getFirstFailedLoginAttemptDateTimeAsString()
    {
        return getFirstFailedLoginAttemptDateTime().printInInternationalFormat();
    }


    @Override
    public OrionUserFailedLoginAttemptModel clone()
    {
        return (OrionUserFailedLoginAttemptModel)CloningService.clone(this);
    }


    @Override
    public OrionUserFailedLoginAttemptModel getCopy()
    {
        return this.clone();
    }
}