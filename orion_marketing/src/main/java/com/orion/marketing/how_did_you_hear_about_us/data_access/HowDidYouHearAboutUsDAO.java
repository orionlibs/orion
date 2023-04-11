package com.orion.marketing.how_did_you_hear_about_us.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.marketing.how_did_you_hear_about_us.model.HowDidYouHearAboutUsModel;
import com.orion.marketing.model.MarketingDatabaseModel;
import java.util.Arrays;

public class HowDidYouHearAboutUsDAO extends OrionDAO
{
    public static HowDidYouHearAboutUsModel getByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        HowDidYouHearAboutUsModel model = HowDidYouHearAboutUsModel.of(userID);
        return (HowDidYouHearAboutUsModel)Database.getOneModel(model,
                        MarketingDatabaseModel.tableHowDidYouHearAboutUs,
                        Database.marketingDatabaseName,
                        Arrays.asList(MarketingDatabaseModel.userID));
    }


    public static int save(HowDidYouHearAboutUsModel model)
    {
        return Database.saveModel(model,
                        MarketingDatabaseModel.tableHowDidYouHearAboutUs,
                        Database.marketingDatabaseName);
    }


    public static int update(HowDidYouHearAboutUsModel model)
    {
        return Database.updateModel(model,
                        MarketingDatabaseModel.tableHowDidYouHearAboutUs,
                        Database.marketingDatabaseName,
                        Arrays.asList(MarketingDatabaseModel.userID));
    }
}