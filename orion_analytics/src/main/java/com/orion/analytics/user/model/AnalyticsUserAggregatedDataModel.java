package com.orion.analytics.user.model;

import com.orion.data.user.address.model.OrionUserAddressModel;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
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
public class AnalyticsUserAggregatedDataModel implements Serializable
{
    private String userID;
    private String emailAddress;
    private String businessName;
    private String fullName;
    private Set<String> authorities;
    private boolean pendingEmailValidation;
    private boolean pendingResetPassword;
    private String birthdate;
    private String mobileNumber;
    private String nationality;
    private String avatarURL;
    private boolean loggedIn;
    private boolean enabled;
    private long numberOfLogins;
    private String lastLogInDateTime;
    private String registrationDateTime;
    private int numberOfAccountLockdowns;
    private List<OrionUserAddressModel> addresses;
    private List<String> addressesFormatted;


    public static AnalyticsUserAggregatedDataModel of()
    {
        return AnalyticsUserAggregatedDataModel.builder().build();
    }
}