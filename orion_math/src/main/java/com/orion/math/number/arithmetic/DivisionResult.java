package com.orion.math.number.arithmetic;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.math.number.ANumber;
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
public class DivisionResult extends Orion implements Cloneable
{
    private ANumber quotient;
    private ANumber remainder;


    public static DivisionResult of()
    {
        return DivisionResult.builder().build();
    }


    @Override
    public DivisionResult clone() throws CloneNotSupportedException
    {
        return (DivisionResult)CloningService.clone(this);
    }


    public DivisionResult getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}