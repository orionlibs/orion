package com.orion.testing.cucumber.glue.steps.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.UnsupportedEncodingException;
import java.util.List;
import lombok.NonNull;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;

public class APICucumberVerifier
{
    public void verifyAPICallResponseHasPartialJSONResponseBody(String expectedResponseBody, MockHttpServletResponse response)
    {
        assertResponseBodyContainsJSON(expectedResponseBody, response);
    }


    public void assertHTTPStatusCode(@NonNull String expectedResponseHTTPStatusCode, MockHttpServletResponse response)
    {
        assertEquals("returned HTTP code", expectedResponseHTTPStatusCode, HttpStatus.valueOf(response.getStatus()).toString());
    }


    public void assertResponseBodyContains(String expectedResponseBody, MockHttpServletResponse response)
    {

        try
        {
            assertTrue(response.getContentAsString().contains(expectedResponseBody));
        }
        catch(UnsupportedEncodingException e)
        {
            throw new RuntimeException("Bug in tests.", e);
        }
        catch(AssertionError e)
        {
            throw new RuntimeException("expected response to contain " + expectedResponseBody + " but it does not", e);
        }

    }


    public void assertResponseBodyContainsJSON(String expectedResponseBody, MockHttpServletResponse response)
    {
        String actualResponseBody = "";

        try
        {
            actualResponseBody = response.getContentAsString();
            JSONAssert.assertEquals(expectedResponseBody, actualResponseBody, JSONCompareMode.LENIENT);
        }
        catch(UnsupportedEncodingException e)
        {
            throw new RuntimeException("expected JSON:\n\n" + expectedResponseBody + "\n\nactual JSON:\n\n" + actualResponseBody, e);
        }
        catch(JSONException e)
        {
            throw new RuntimeException("expected JSON:\n\n" + expectedResponseBody + "\n\nactual JSON:\n\n" + actualResponseBody, e);
        }
        catch(AssertionError e)
        {
            throw new RuntimeException("expected JSON:\n\n" + expectedResponseBody + "\n\nactual JSON:\n\n" + actualResponseBody, e);
            //throw new RuntimeException("expected JSON\n\n" + expectedResponseBody + " to exist in the response but it does not. The actual JSON response is:\n\n" + actualResponseBody, e);
            //e.printStackTrace();
        }

    }


    public void assertResponseBodyContainsNonEmptyFields(List<String> expectedNonEmptyFields, MockHttpServletResponse response)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedNonEmptyFieldTemp = "";

        try
        {
            JsonNode actualResponseJSON = objectMapper.readValue(response.getContentAsString(), JsonNode.class);

            for(String expectedNonEmptyField : expectedNonEmptyFields)
            {
                expectedNonEmptyFieldTemp = expectedNonEmptyField;
                assertTrue(actualResponseJSON.hasNonNull(expectedNonEmptyField));
            }

        }
        catch(UnsupportedEncodingException e)
        {
            throw new RuntimeException("Bug in tests.", e);
        }
        catch(JsonMappingException e)
        {
            throw new RuntimeException(e);
        }
        catch(JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
        catch(AssertionError e)
        {
            throw new RuntimeException("expected field " + expectedNonEmptyFieldTemp + " to exist but it does not", e);
        }

    }


    public void assertResponseFieldValueStartsWith(String field, String valuePrefix, MockHttpServletResponse response)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String actualValue = "";

        try
        {
            JsonNode actualResponseJSON = objectMapper.readValue(response.getContentAsString(), JsonNode.class);
            actualValue = actualResponseJSON.findValue(field).asText();
            assertTrue(actualValue.startsWith(valuePrefix));
        }
        catch(UnsupportedEncodingException e)
        {
            throw new RuntimeException("Bug in tests.", e);
        }
        catch(JsonMappingException e)
        {
            throw new RuntimeException(e);
        }
        catch(JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
        catch(AssertionError e)
        {
            throw new RuntimeException("expected field " + field + " to start with value " + valuePrefix + " but its actual value is " + actualValue, e);
        }

    }


    public void assertResponseFieldValueContaining(String field, String valueInfix, MockHttpServletResponse response)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String actualValue = "";

        try
        {
            JsonNode actualResponseJSON = objectMapper.readValue(response.getContentAsString(), JsonNode.class);
            actualValue = actualResponseJSON.findValue(field).asText();
            assertTrue(actualValue.contains(valueInfix));
        }
        catch(UnsupportedEncodingException e)
        {
            throw new RuntimeException("Bug in tests.", e);
        }
        catch(JsonMappingException e)
        {
            throw new RuntimeException(e);
        }
        catch(JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
        catch(AssertionError e)
        {
            throw new RuntimeException("expected field " + field + " to include in its value " + valueInfix + " but its actual value is " + actualValue, e);
        }

    }


    public void assertResponseFieldValue(String field, String value, MockHttpServletResponse response)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String actualValue = "";

        try
        {
            JsonNode actualResponseJSON = objectMapper.readValue(response.getContentAsString(), JsonNode.class);
            actualValue = actualResponseJSON.findValue(field).asText();
            assertTrue(actualValue.equals(value));
        }
        catch(UnsupportedEncodingException e)
        {
            throw new RuntimeException("Bug in tests.", e);
        }
        catch(JsonMappingException e)
        {
            throw new RuntimeException(e);
        }
        catch(JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
        catch(AssertionError e)
        {
            throw new RuntimeException("expected " + value + " but got " + actualValue, e);
        }

    }


    public void assertResponseBodyContainsFields(List<String> expectedFields, MockHttpServletResponse response)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedFieldTemp = "";

        try
        {
            JsonNode actualResponseJSON = objectMapper.readValue(response.getContentAsString(), JsonNode.class);

            for(String expectedField : expectedFields)
            {
                expectedFieldTemp = expectedField;
                assertTrue(actualResponseJSON.has(expectedField));
            }

        }
        catch(UnsupportedEncodingException e)
        {
            throw new RuntimeException("Bug in tests.", e);
        }
        catch(JsonMappingException e)
        {
            throw new RuntimeException(e);
        }
        catch(JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
        catch(AssertionError e)
        {
            throw new RuntimeException("expected " + expectedFieldTemp + " but it does not exist in the response", e);
        }

    }


    public void assertResponseBody(String expectedResponseBody, MockHttpServletResponse response)
    {
        ObjectMapper objectMapper = new ObjectMapper();

        try
        {
            JsonNode jsonNode = objectMapper.readValue(expectedResponseBody, JsonNode.class);
            assertEquals(jsonNode.toString(), response.getContentAsString());
        }
        catch(UnsupportedEncodingException e)
        {
            throw new RuntimeException("Bug in tests.", e);
        }
        catch(JsonMappingException e)
        {
            throw new RuntimeException(e);
        }
        catch(JsonProcessingException e)
        {
            throw new RuntimeException(e);
        }
        catch(AssertionError e)
        {

            try
            {
                throw new RuntimeException("expected " + expectedResponseBody + " but got " + response.getContentAsString(), e);
            }
            catch(UnsupportedEncodingException e1)
            {
                throw new RuntimeException("Bug in tests.", e1);
            }

        }

    }
}