package com.orion.marketing.how_did_you_hear_about_us;

import com.orion.core.abstraction.OrionService;
import com.orion.marketing.how_did_you_hear_about_us.data_access.HowDidYouHearAboutUsDAO;
import com.orion.marketing.how_did_you_hear_about_us.model.HowDidYouHearAboutUsModel;

public class HowDidYouHearAboutUsService extends OrionService
{
    public static int saveHowDidYouHearAboutUs(HowDidYouHearAboutUsModel model)
    {
        return HowDidYouHearAboutUsDAO.save(model);
    }
}