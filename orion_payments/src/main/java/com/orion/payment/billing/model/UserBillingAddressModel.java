package com.orion.payment.billing.model;

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
public class UserBillingAddressModel implements OrionModel
{
    private String userBillingAddressID;
    private String addressID;


    public static UserBillingAddressModel of()
    {
        return UserBillingAddressModel.builder().build();
    }


    public static UserBillingAddressModel of(String userBillingAddressID)
    {
        return UserBillingAddressModel.builder().userBillingAddressID(userBillingAddressID).build();
    }


    @Override
    public UserBillingAddressModel clone()
    {
        return (UserBillingAddressModel)CloningService.clone(this);
    }


    @Override
    public UserBillingAddressModel getCopy()
    {
        return this.clone();
    }
}