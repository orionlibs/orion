package com.orion.marketing.how_did_you_hear_about_us.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// This class does not extend OrionModel, because that inheritance does not
// allow
// the use of Lombok's @SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class HowDidYouHearAboutUsModel implements OrionModel
{
    private String userID;
    private int howDidYouHearAboutUsOptionID;
    private String howDidYouHearAboutUs;


    public static HowDidYouHearAboutUsModel of()
    {
        return HowDidYouHearAboutUsModel.builder().build();
    }


    public static HowDidYouHearAboutUsModel of(String userID)
    {
        return HowDidYouHearAboutUsModel.builder().userID(userID).build();
    }


    @Override
    public HowDidYouHearAboutUsModel clone()
    {
        return (HowDidYouHearAboutUsModel)CloningService.clone(this);
    }


    @Override
    public HowDidYouHearAboutUsModel getCopy()
    {
        return this.clone();
    }
}