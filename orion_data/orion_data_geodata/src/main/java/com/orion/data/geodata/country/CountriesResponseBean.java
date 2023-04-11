package com.orion.data.geodata.country;

import com.orion.core.abstraction.OrionResponse;
import com.orion.data.geodata.country.model.CountryModel;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class CountriesResponseBean extends OrionResponse
{
    private List<CountryModel> countries;


    public static CountriesResponseBean of()
    {
        return CountriesResponseBean.builder().build();
    }
}