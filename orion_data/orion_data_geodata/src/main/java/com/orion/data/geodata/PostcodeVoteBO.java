package com.orion.data.geodata;

import com.orion.core.abstraction.Orion;
import com.orion.data.geodata.postcode.data_access.PostcodePrefixVotesDAO;
import com.orion.data.geodata.postcode.data_access.PostcodeVotersDAO;
import com.orion.data.geodata.postcode.data_access.PostcodeVotesDAO;
import com.orion.data.geodata.postcode.model.PostcodePrefixVoteModel;
import com.orion.data.geodata.postcode.model.PostcodeVoteModel;
import com.orion.data.geodata.postcode.model.PostcodeVoterModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class PostcodeVoteBO extends Orion
{
    private String postcodeToVoteFor;
    private String postcodePrefix;
    private String emailAddressOfVoter;


    public static PostcodeVoteBO of(String postcodeToVoteFor, String postcodePrefix, String emailAddressOfVoter)
    {
        return PostcodeVoteBO.builder()
                        .postcodeToVoteFor(postcodeToVoteFor)
                        .postcodePrefix(postcodePrefix)
                        .emailAddressOfVoter(emailAddressOfVoter)
                        .build();
    }


    public boolean vote()
    {
        String postcodeWithoutSpace = postcodeToVoteFor.trim().toUpperCase().replace(" ", "");
        PostcodeVoteModel postcodeVote = PostcodeVoteModel.builder()
                        .postcodeWithoutSpace(postcodeWithoutSpace)
                        .postcodePrefix(postcodePrefix)
                        .numberOfVotes(1L)
                        .build();
        PostcodePrefixVoteModel postcodePrefixVote = PostcodePrefixVoteModel.builder()
                        .postcodePrefix(postcodePrefix)
                        .numberOfVotes(1L)
                        .build();
        PostcodeVoterModel postcodeVoter = PostcodeVoterModel.builder()
                        .postcodeWithoutSpace(postcodeWithoutSpace)
                        .postcodePrefix(postcodePrefix)
                        .emailAddress(emailAddressOfVoter)
                        .build();

        if(postcodePrefix != null)
        {

            if(PostcodeVotesDAO.doesRowExistByPostcodeWithoutSpace(postcodeVote))
            {
                PostcodeVotesDAO.incrementVoteByPostcodeWithoutSpace(postcodeVote);
            }
            else
            {
                PostcodeVotesDAO.savePostcodeVote(postcodeVote);
            }

            if(PostcodePrefixVotesDAO.doesRowExistByPostcodePrefix(postcodePrefixVote))
            {
                PostcodePrefixVotesDAO.incrementVoteByPostcodePrefix(postcodePrefixVote);
            }
            else
            {
                PostcodePrefixVotesDAO.savePostcodePrefixVote(postcodePrefixVote);
            }

            if(PostcodeVotersDAO.doesRowNotExistByEmailAddressAndPostcodeWithoutSpace(postcodeVoter))
            {
                PostcodeVotersDAO.save(postcodeVoter);
            }

            return true;
        }
        else
        {
            return false;
        }

    }
}