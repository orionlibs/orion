package com.orion.data.geodata.postcode.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import com.orion.data.source.database.IgnoreForORM;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PostcodeVoterModel implements OrionModel
{
    @IgnoreForORM
    private long postcodeVoterID;
    private String postcodeWithoutSpace;
    private String postcodePrefix;
    private String emailAddress;


    public static PostcodeVoterModel of()
    {
        return PostcodeVoterModel.builder().build();
    }


    public static PostcodeVoterModel of(long postcodeVoterID)
    {
        return PostcodeVoterModel.builder().postcodeVoterID(postcodeVoterID).build();
    }


    @Override
    public PostcodeVoterModel clone()
    {
        return (PostcodeVoterModel)CloningService.clone(this);
    }


    @Override
    public PostcodeVoterModel getCopy()
    {
        return this.clone();
    }
}