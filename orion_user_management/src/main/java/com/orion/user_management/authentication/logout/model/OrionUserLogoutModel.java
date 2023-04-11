package com.orion.user_management.authentication.logout.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.object.CloningService;
import com.orion.data.source.database.IgnoreForORM;
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
public class OrionUserLogoutModel implements OrionModel
{
    @IgnoreForORM
    private long logoutID;
    private String userID;
    private String logoutDate;
    private SQLTimestamp logoutDateTime;
    private int logoutCauseID;


    public static OrionUserLogoutModel of()
    {
        return OrionUserLogoutModel.builder().build();
    }


    public static OrionUserLogoutModel of(String userID)
    {
        return OrionUserLogoutModel.builder().userID(userID).build();
    }


    public String getLogoutDateTimeAsString()
    {
        return getLogoutDateTime().printInInternationalFormat();
    }


    @Override
    public OrionUserLogoutModel clone()
    {
        return (OrionUserLogoutModel)CloningService.clone(this);
    }


    @Override
    public OrionUserLogoutModel getCopy()
    {
        return this.clone();
    }
}