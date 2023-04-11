package com.orion.testing.cucumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orion.core.calendar.CalendarService;
import com.orion.core.uuid.UUIDSecurityService;
import com.orion.testing.cucumber.glue.steps.internal.CucumberStepsWorld;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class CucumberService
{
    public static String getCellValue(Map<String, String> row, String columnName)
    {
        return new CucumberStepDataTable(row).getCellValue(columnName);
    }


    public static String getCellValueOrDefault(Map<String, String> row, String columnName, String defaultValueIfEmpty)
    {
        return StringUtils.isBlank(row.get(columnName)) ? defaultValueIfEmpty : row.get(columnName);
    }


    public static String getCellValueForKey(Map<String, String> rows, String key)
    {
        return new CucumberStepDataTable(rows).getCellValueForKey(key);
    }


    public static String getCellValueForKeyOrDefault(Map<String, String> rows, String key, String defaultValueIfEmpty)
    {
        return new CucumberStepDataTable(rows).getCellValueForKeyOrDefault(key, defaultValueIfEmpty);
    }


    public static String applyCurrentDateInternalFunction(String input)
    {
        String prefix = "@@getCurrentDate()@@";

        if(input.indexOf(prefix) < 0)
        {
            return input;
        }
        else
        {
            String currentDate = CalendarService.getCurrentDateAdjustingForDaylightSavings().getDateStringSplitByHyphensYearFirst();
            return input.replace(prefix, currentDate);
        }

    }


    public static String applyUUIDInternalFunction(String input)
    {
        String prefix = "@@getUUID()@@";

        if(input.indexOf(prefix) < 0)
        {
            return input;
        }
        else
        {
            return input.replace(prefix, UUIDSecurityService.generateUUIDWithoutHyphens());
        }

    }


    public static String applyTimestampInternalFunction(String input)
    {
        String prefix = "@@getTimestamp()@@";

        if(input.indexOf(prefix) < 0)
        {
            return input;
        }
        else
        {
            return input.replace(prefix, Long.toString(System.currentTimeMillis()));
        }

    }


    public static String applyPlaceholderUsingInternalMapperOfAPIResponses(String input, CucumberStepsWorld stepsWorld, boolean includeDoubleQuotesForStrings)
    {
        String prefix = "@@InternalMapper(";
        int index = -1;
        String newInput = "";

        if(input.indexOf(prefix) < 0)
        {
            newInput = new String(input);
        }
        else
        {

            while((index = input.indexOf(prefix)) != -1)
            {
                newInput += input.substring(0, index);
                String key = input.substring(index + prefix.length());
                key = key.substring(0, key.indexOf("@@") - 1);
                String[] tokens = key.split("\\.");
                key = tokens[0];
                String fieldNameToGet = tokens[tokens.length - 1];
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode cachedResponseJSON = null;

                try
                {
                    cachedResponseJSON = objectMapper.readValue(stepsWorld.keyToAPICallResponseMapper.get(key).getContentAsString(), JsonNode.class);

                    if(includeDoubleQuotesForStrings)
                    {
                        newInput += cachedResponseJSON.findValue(fieldNameToGet).toString();
                    }
                    else
                    {
                        String fieldValue = cachedResponseJSON.findValue(fieldNameToGet).toString();
                        newInput += fieldValue.substring(1, fieldValue.length() - 1);
                    }

                    String stringToDeleteFromOriginalInput = prefix + key + "." + fieldNameToGet + ")@@";
                    input = input.replace(stringToDeleteFromOriginalInput, "");

                    if(index < input.length() - 1)
                    {
                        input = input.substring(index);
                    }
                    else
                    {
                        input = "";
                    }

                }
                catch(JsonMappingException e)
                {
                    e.printStackTrace();
                }
                catch(JsonProcessingException e)
                {
                    e.printStackTrace();
                }
                catch(UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }

            }

            newInput += input;
        }

        return newInput;
    }
}