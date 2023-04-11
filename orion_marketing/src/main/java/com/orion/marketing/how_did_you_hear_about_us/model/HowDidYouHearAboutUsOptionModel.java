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
public class HowDidYouHearAboutUsOptionModel implements OrionModel
{
    private int howDidYouHearAboutUsOptionID;
    private String howDidYouHearAboutUsOption;


    public static HowDidYouHearAboutUsOptionModel of()
    {
        return HowDidYouHearAboutUsOptionModel.builder().build();
    }


    public static HowDidYouHearAboutUsOptionModel of(int howDidYouHearAboutUsOptionID)
    {
        return HowDidYouHearAboutUsOptionModel.builder().howDidYouHearAboutUsOptionID(howDidYouHearAboutUsOptionID).build();
    }


    @Override
    public HowDidYouHearAboutUsOptionModel clone()
    {
        return (HowDidYouHearAboutUsOptionModel)CloningService.clone(this);
    }


    @Override
    public HowDidYouHearAboutUsOptionModel getCopy()
    {
        return this.clone();
    }
}