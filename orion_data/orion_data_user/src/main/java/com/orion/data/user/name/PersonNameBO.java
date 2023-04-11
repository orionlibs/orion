package com.orion.data.user.name;

import com.orion.core.abstraction.Orion;
import com.orion.core.string.StringsService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class PersonNameBO extends Orion
{
    private String name;


    public static PersonNameBO of(String name)
    {
        return PersonNameBO.builder().name(name).build();
    }


    public String normaliseName()
    {

        if(name != null && !name.isEmpty())
        {
            return StringsService.convertFirstCharacterToUppercase(name.trim());
        }
        else
        {
            return "";
        }

    }


    public boolean isValidName()
    {
        String temp = name;

        if(temp == null)
        {
            return false;
        }
        else
        {
            temp = temp.trim();

            if(temp.isEmpty())
            {
                return false;
            }

        }

        return true;
    }
}