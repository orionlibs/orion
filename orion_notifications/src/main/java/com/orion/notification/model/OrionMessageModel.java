package com.orion.notification.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.object.CloningService;
import com.orion.data.source.security.annotations.DecodeBase64ForString;
import com.orion.data.source.security.annotations.DecodeXSS;
import com.orion.data.source.security.annotations.DecryptAsData;
import com.orion.data.source.security.annotations.EncodeBase64ForString;
import com.orion.data.source.security.annotations.EncodeXSS;
import com.orion.data.source.security.annotations.EncryptAsData;
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
public class OrionMessageModel implements OrionModel
{
    private String messageID;
    private String userID;
    @EncryptAsData
    @DecryptAsData
    private String fullName;
    @EncryptAsData
    @DecryptAsData
    private String emailAddress;
    @EncryptAsData
    @DecryptAsData
    private String phoneNumber;
    @EncodeXSS
    @EncodeBase64ForString
    @DecodeXSS
    @DecodeBase64ForString
    private String message;
    private SQLTimestamp messageDateTime;
    private Boolean hasBeenRead;


    public static OrionMessageModel of()
    {
        return OrionMessageModel.builder().build();
    }


    public static OrionMessageModel of(String messageID)
    {
        return OrionMessageModel.builder().messageID(messageID).build();
    }


    @Override
    public OrionMessageModel clone()
    {
        return (OrionMessageModel)CloningService.clone(this);
    }


    @Override
    public OrionMessageModel getCopy()
    {
        return this.clone();
    }
}