package com.orion.user_management.authentication.logout.model;

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
public class OrionUserLogoutCauseModel implements OrionModel
{
    private int logoutCauseID;
    private String logoutCause;


    public static OrionUserLogoutCauseModel of()
    {
        return OrionUserLogoutCauseModel.builder().build();
    }


    public static OrionUserLogoutCauseModel of(int logoutCauseID)
    {
        return OrionUserLogoutCauseModel.builder().logoutCauseID(logoutCauseID).build();
    }


    @Override
    public OrionUserLogoutCauseModel clone()
    {
        return (OrionUserLogoutCauseModel)CloningService.clone(this);
    }


    @Override
    public OrionUserLogoutCauseModel getCopy()
    {
        return this.clone();
    }
}