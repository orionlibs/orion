package com.orion.user_management.account;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.data_access.OrionUserSettingsDAO;
import com.orion.user_management.model.OrionUserSettingsModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class UserSettingsBO extends Orion
{
    private String userID;


    public static UserSettingsBO of(String userID)
    {
        return UserSettingsBO.builder().userID(userID.trim()).build();
    }


    public String getUserSelectedThemeByUserID()
    {
        return OrionUserSettingsDAO.getSelectedThemeByUserID(userID);
    }


    public OrionUserSettingsModel getUserSettingsByUserID()
    {
        return OrionUserSettingsDAO.getByUserID(userID);
    }


    public int updateUserSelectedThemeByUserID(String selectedTheme)
    {
        return OrionUserSettingsDAO.updateSelectedThemeByUserID(selectedTheme, userID);
    }
}