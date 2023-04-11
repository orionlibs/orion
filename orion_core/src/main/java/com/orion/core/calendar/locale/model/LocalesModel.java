package com.orion.core.calendar.locale.model;

import java.io.Serializable;
import java.util.List;
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
public class LocalesModel implements Serializable
{
    private List<LocaleModel> locales;


    public static LocalesModel of()
    {
        return LocalesModel.builder().build();
    }


    public static LocalesModel of(List<LocaleModel> locales)
    {
        return LocalesModel.builder().locales(locales).build();
    }
}