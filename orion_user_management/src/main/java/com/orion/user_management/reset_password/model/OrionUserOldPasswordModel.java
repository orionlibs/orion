package com.orion.user_management.reset_password.model;

import com.orion.core.abstraction.OrionModel;
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
public class OrionUserOldPasswordModel implements OrionModel
{
    @IgnoreForORM
    private long oldPasswordID;
    private String userID;
    private String password;


    public static OrionUserOldPasswordModel of()
    {
        return OrionUserOldPasswordModel.builder().build();
    }


    public static OrionUserOldPasswordModel of(String userID)
    {
        return OrionUserOldPasswordModel.builder().userID(userID).build();
    }


    @Override
    public OrionUserOldPasswordModel clone()
    {
        return (OrionUserOldPasswordModel)CloningService.clone(this);
    }


    @Override
    public OrionUserOldPasswordModel getCopy()
    {
        return this.clone();
    }
}