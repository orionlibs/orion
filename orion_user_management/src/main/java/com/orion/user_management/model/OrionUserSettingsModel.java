package com.orion.user_management.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

// This class does not extend OrionModel, because that inheritance does not
// allow
// the use of Lombok's @SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class OrionUserSettingsModel implements OrionModel
{
    private String userID;
    private String avatarURL;
    private String selectedTheme;
    private Boolean receiveSpecialOffersByEmail;
    private Boolean receiveSpecialOffersBySMS;


    public static OrionUserSettingsModel of()
    {
        return OrionUserSettingsModel.builder().build();
    }


    public static OrionUserSettingsModel of(String userID)
    {
        return OrionUserSettingsModel.builder().userID(userID).build();
    }


    @Override
    public OrionUserSettingsModel clone()
    {
        return (OrionUserSettingsModel)CloningService.clone(this);
    }


    public OrionUserSettingsModel getCopy()
    {
        return this.clone();
    }
}