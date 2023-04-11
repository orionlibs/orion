package com.orionplatform.test_webapp.model;

import com.orionplatform.core.object.CloningService;
import com.orionplatform.data.data_model.OrionUserDetailsModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class UserDetailsModel extends OrionUserDetailsModel
{
    @Override
    public UserDetailsModel clone()
    {
        return (UserDetailsModel)CloningService.clone(this);
    }
    
    
    @Override
    public UserDetailsModel getCopy()
    {
        return this.clone();
    }
}