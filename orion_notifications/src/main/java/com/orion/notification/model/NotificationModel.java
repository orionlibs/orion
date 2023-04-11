package com.orion.notification.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.SQLTimestamp;
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
public class NotificationModel implements OrionModel
{
    private String userID;
    private String message;
    private String messageSender;
    private SQLTimestamp datetime;
    private Boolean seen;


    public static NotificationModel of()
    {
        return NotificationModel.builder().build();
    }


    @Override
    public NotificationModel clone()
    {
        return (NotificationModel)CloningService.clone(this);
    }


    @Override
    public NotificationModel getCopy()
    {
        return this.clone();
    }
}