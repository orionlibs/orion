package com.orion.web.services.cloud.amazon_web_services.ec2;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
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
public class AWSEC2DetailsModel implements OrionModel
{
    private int numberOfInstances;
    private String operatingSystemName;


    public static AWSEC2DetailsModel of()
    {
        return AWSEC2DetailsModel.builder().build();
    }


    @Override
    public AWSEC2DetailsModel clone()
    {
        return (AWSEC2DetailsModel)CloningService.clone(this);
    }


    @Override
    public AWSEC2DetailsModel getCopy()
    {
        return this.clone();
    }
}