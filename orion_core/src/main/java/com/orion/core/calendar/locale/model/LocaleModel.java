package com.orion.core.calendar.locale.model;

import java.io.Serializable;
import java.util.Locale;
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
public class LocaleModel implements Serializable
{
    private Locale locale;
    private String underscoreTag;
    private String displayLanguage;
    private String displayCountry;


    public static LocaleModel of()
    {
        return LocaleModel.builder().build();
    }
}