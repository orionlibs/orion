package com.orion.user_management.upgrade;

import com.orion.core.data.validation.Validator;
import com.orion.core.object.CloningService;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

// This class does not extend OrionRequest, because that inheritance does not
// allow
// the use of Lombok's @SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class OrionUpgradeRequestBean implements Cloneable, Serializable, Validator
{
    private String userID;


    public static OrionUpgradeRequestBean of()
    {
        return OrionUpgradeRequestBean.builder().build();
    }


    @Override
    public OrionUpgradeRequestBean clone()
    {
        return (OrionUpgradeRequestBean)CloningService.clone(this);
    }


    public OrionUpgradeRequestBean getCopy()
    {
        return this.clone();
    }
}