package com.orion.user_management.authentication.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class LoginResponseBean extends OrionLoginResponseBean
{
    private Boolean isCustomer;
    private Boolean isDriver;
    private Boolean isBusiness;
    private Boolean isStore;
    private Boolean isAdministrator;
    private Boolean isDispatcher;
    private Boolean isDriverDispatcher;
    private Boolean isDriverAdministratorController;
    private Boolean redirectToStep2OfRegistrationProcess;
    private String businessName;
    private String businessType;
    private Long storeDetailsID;


    public static LoginResponseBean of()
    {
        return LoginResponseBean.builder().build();
    }
}