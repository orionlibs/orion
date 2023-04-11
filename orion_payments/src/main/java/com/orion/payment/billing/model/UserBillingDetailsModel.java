package com.orion.payment.billing.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import com.orion.data.source.security.annotations.DecryptAsData;
import com.orion.data.source.security.annotations.EncryptAsData;
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
public class UserBillingDetailsModel implements OrionModel
{
    private String userBillingDetailsID;
    private String userBillingAddressID;
    @EncryptAsData
    @DecryptAsData
    private String firstName;
    @EncryptAsData
    @DecryptAsData
    private String lastName;
    @EncryptAsData
    @DecryptAsData
    private String emailAddress;
    @EncryptAsData
    @DecryptAsData
    private String phoneNumber;


    public static UserBillingDetailsModel of()
    {
        return UserBillingDetailsModel.builder().build();
    }


    public static UserBillingDetailsModel of(String userBillingDetailsID)
    {
        return UserBillingDetailsModel.builder().userBillingDetailsID(userBillingDetailsID).build();
    }


    @Override
    public UserBillingDetailsModel clone()
    {
        return (UserBillingDetailsModel)CloningService.clone(this);
    }


    @Override
    public UserBillingDetailsModel getCopy()
    {
        return this.clone();
    }
}