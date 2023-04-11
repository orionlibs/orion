package com.orion.core.data.validation;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.validation.annotation.InRange;
import com.orion.core.data.validation.annotation.NotBlank;
import com.orion.core.data.validation.annotation.NotEmpty;
import com.orion.core.data.validation.annotation.NotNull;
import com.orion.core.data.validation.annotation.NotNullOrBlank;
import com.orion.core.reflection.variable.access.ReflectionInstanceVariablesAccessService;
import com.orion.core.reflection.variable.retrieval.ReflectionInstanceVariablesRetrievalService;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class ValidationBO extends Orion
{
    private Object object;


    public static ValidationBO of(Object object)
    {
        return ValidationBO.builder().object(object).build();
    }


    public InvalidFields validate()
    {
        Set<String> invalidInstanceVariableNames = new HashSet<>();

        if(object != null)
        {
            List<Field> instanceVariables = ReflectionInstanceVariablesRetrievalService.getAllInstanceVariables(object);
            instanceVariables.forEach(field ->
            {

                try
                {

                    if(!isInstanceVariableValid(field, object))
                    {
                        invalidInstanceVariableNames.add(field.getName());
                    }

                }
                catch(IllegalArgumentException e)
                {
                    throw e;
                }
                catch(IllegalAccessException e)
                {
                    //throw new InaccessibleException("The instance variable is inaccessible.");
                }

            });
        }

        return InvalidFields.builder()
                        .fields(invalidInstanceVariableNames)
                        .build();
    }


    @SuppressWarnings("rawtypes")
    private static boolean isInstanceVariableValid(Field instanceVariable, Object object) throws IllegalArgumentException, IllegalAccessException
    {
        boolean isInstanceVariableValid = true;
        ReflectionInstanceVariablesAccessService.makeInstanceVariableAccessible(instanceVariable);
        Object data = instanceVariable.get(object);
        NotNullOrBlank notNullOrBlankAnnotation = instanceVariable.getAnnotation(NotNullOrBlank.class);
        NotNull notNullAnnotation = instanceVariable.getAnnotation(NotNull.class);
        NotEmpty notEmptyAnnotation = instanceVariable.getAnnotation(NotEmpty.class);
        NotBlank notBlankAnnotation = instanceVariable.getAnnotation(NotBlank.class);
        InRange inRangeAnnotation = instanceVariable.getAnnotation(InRange.class);

        if(notNullOrBlankAnnotation != null)
        {

            if(data == null)
            {
                isInstanceVariableValid = false;
            }
            else if(data instanceof String)
            {
                String dataString = (String)data;
                isInstanceVariableValid = isInstanceVariableValid && dataString != null && !dataString.trim().isEmpty();
            }

        }

        if(notNullAnnotation != null)
        {
            isInstanceVariableValid = isInstanceVariableValid && data != null;
        }

        if(notEmptyAnnotation != null && isInstanceVariableValid)
        {

            if(data instanceof String)
            {
                String dataString = (String)data;
                isInstanceVariableValid = isInstanceVariableValid && dataString != null && !dataString.isEmpty();
            }
            else if(data instanceof List)
            {
                List dataList = (List)data;
                isInstanceVariableValid = isInstanceVariableValid && dataList != null && !dataList.isEmpty();
            }
            else
            {
                isInstanceVariableValid = false;
            }

        }

        if(notBlankAnnotation != null && isInstanceVariableValid)
        {

            if(data instanceof String)
            {
                String dataString = (String)data;
                isInstanceVariableValid = isInstanceVariableValid && dataString != null && !dataString.trim().isEmpty();
            }
            else
            {
                isInstanceVariableValid = false;
            }

        }

        if(inRangeAnnotation != null)
        {
            BigDecimal tempData = null;

            if(data instanceof Number)
            {
                tempData = new BigDecimal(((Number)data).toString());
            }
            else if(data instanceof String)
            {
                tempData = new BigDecimal(((String)data).toString());
            }

            BigDecimal inRangeMinimumValue = new BigDecimal(inRangeAnnotation.min());
            BigDecimal inRangeMaximumValue = new BigDecimal(inRangeAnnotation.max());

            if(tempData.compareTo(inRangeMinimumValue) >= 0 && tempData.compareTo(inRangeMaximumValue) <= 0)
            {
                isInstanceVariableValid = true;
            }
            else
            {
                isInstanceVariableValid = false;
            }

        }

        return isInstanceVariableValid;
    }
}