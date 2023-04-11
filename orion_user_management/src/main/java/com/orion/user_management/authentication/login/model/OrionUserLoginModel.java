package com.orion.user_management.authentication.login.model;

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
public class OrionUserLoginModel implements OrionModel
{
    @IgnoreForORM
    private long id1;
    private String userID;
    private String loginDate;
    private SQLTimestamp loginDateTime;


    public static OrionUserLoginModel of()
    {
        return OrionUserLoginModel.builder().build();
    }


    public static OrionUserLoginModel of(String userID)
    {
        return OrionUserLoginModel.builder().userID(userID).build();
    }


    public String getLoginDateTimeAsString()
    {
        return getLoginDateTime().printInInternationalFormat();
    }


    @Override
    public OrionUserLoginModel clone()
    {
        return (OrionUserLoginModel)CloningService.clone(this);
    }


    @Override
    public OrionUserLoginModel getCopy()
    {
        return this.clone();
    }
}