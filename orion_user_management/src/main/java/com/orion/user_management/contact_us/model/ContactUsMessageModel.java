package com.orion.user_management.contact_us.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import com.orion.data.source.database.IgnoreForORM;
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
public class ContactUsMessageModel implements OrionModel
{
    @IgnoreForORM
    private long contactUsMessageID;
    private String messageID;


    public static ContactUsMessageModel of()
    {
        return ContactUsMessageModel.builder().build();
    }


    public static ContactUsMessageModel of(long contactUsMessageID)
    {
        return ContactUsMessageModel.builder().contactUsMessageID(contactUsMessageID).build();
    }


    @Override
    public ContactUsMessageModel clone()
    {
        return (ContactUsMessageModel)CloningService.clone(this);
    }


    @Override
    public ContactUsMessageModel getCopy()
    {
        return this.clone();
    }
}