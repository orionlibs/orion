package com.orion.user_management.authorisation.jwt;

import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.calendar.time.Time;
import java.util.Date;
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
public class JWTTokenExpiration
{
    private DateTime tokenExpirationDatetime;


    public static JWTTokenExpiration of()
    {
        return JWTTokenExpiration.builder().build();
    }


    @SuppressWarnings("deprecation")
    public Date getExpirationDate()
    {
        com.orion.core.calendar.date.Date tokenExpirationDate = tokenExpirationDatetime.getDate();
        Time tokenExpirationTime = tokenExpirationDatetime.getTime();
        int tokenExpirationYear = tokenExpirationDate.getYear() - 1900;
        int tokenExpirationMonth = tokenExpirationDate.getMonth() - 1;
        int tokenExpirationDay = tokenExpirationDate.getDay();
        return new java.util.Date(tokenExpirationYear, tokenExpirationMonth, tokenExpirationDay, tokenExpirationTime.getHours(), tokenExpirationTime.getMinutes(), tokenExpirationTime.getSeconds());
    }
}