package com.orion.analytics.user.tasks;

import com.orion.analytics.user.model.AnalyticsUserAggregatedDataModel;
import com.orion.core.abstraction.Orion;
import com.orion.data.user.address.UserAddressService;
import com.orion.data.user.address.model.OrionUserAddressModel;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserDetailsModel;
import java.util.ArrayList;
import java.util.List;

public class PopulateUserAggregatedDataModelForUserTask extends Orion
{
    public static AnalyticsUserAggregatedDataModel run(OrionAuthorityModel authority)
    {
        OrionUserDetailsModel userDetails = UserAccountService.getUserDetailsByUserID(authority.getUserID());
        AnalyticsUserAggregatedDataModel analyticsUserAggregatedDataModel = new AnalyticsUserAggregatedDataModel();
        analyticsUserAggregatedDataModel.setEmailAddress(authority.getUsername());
        analyticsUserAggregatedDataModel.setFullName(userDetails.getFullName());

        if(userDetails.getMobileNumber() != null)
        {
            analyticsUserAggregatedDataModel.setMobileNumber(userDetails.getMobileNumber().toString());
        }
        else
        {
            analyticsUserAggregatedDataModel.setMobileNumber("-");
        }

        List<OrionUserAddressModel> addresses = UserAddressService.getUserAddressesByUserID(authority.getUserID());

        if(addresses != null && !addresses.isEmpty())
        {
            List<String> addressesFormatted = new ArrayList<>();

            for(int i = 0; i < addresses.size(); i++)
            {
                addressesFormatted.add(UserAddressService.formatAddressIn1Line(addresses.get(i).getAddressID()));
            }

            analyticsUserAggregatedDataModel.setAddressesFormatted(addressesFormatted);
        }

        return analyticsUserAggregatedDataModel;
    }
}