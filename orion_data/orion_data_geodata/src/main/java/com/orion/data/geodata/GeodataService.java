package com.orion.data.geodata;

import com.orion.core.abstraction.OrionService;
import com.orion.data.geodata.postcode.data_access.DistancesBetweenPostcodesDAO;
import com.orion.data.geodata.postcode.data_access.PostcodeVotersDAO;
import com.orion.data.geodata.postcode.model.DistanceBetweenPostcodesModel;
import com.orion.data.geodata.postcode.model.PostcodeVoterModel;
import java.util.List;

public class GeodataService extends OrionService
{
    public static boolean voteForPostcode(String postcodeToVoteFor, String postcodePrefix, String emailAddressOfVoter)
    {
        return PostcodeVoteBO.of(postcodeToVoteFor, postcodePrefix, emailAddressOfVoter).vote();
    }


    public static List<PostcodeVoterModel> getAllVotesForPostcodes()
    {
        return PostcodeVotersDAO.getPostcodeVoters();
    }


    public static DistanceBetweenPostcodesModel getDistanceBetweenPostcodesByPostcodes(String postcode1, String postcode2)
    {
        return DistancesBetweenPostcodesDAO.getByPostcodes(postcode1, postcode2);
    }


    public static int saveDistanceBetweenPostcodes(DistanceBetweenPostcodesModel model)
    {
        return DistancesBetweenPostcodesDAO.save(model);
    }


    public static int updateDistanceBetweenPostcodes(DistanceBetweenPostcodesModel model)
    {
        return DistancesBetweenPostcodesDAO.update(model);
    }
}