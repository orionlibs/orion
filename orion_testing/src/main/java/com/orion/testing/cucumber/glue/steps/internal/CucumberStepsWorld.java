package com.orion.testing.cucumber.glue.steps.internal;

import com.orion.testing.cucumber.CucumberAPICall;
import com.orion.user_management.authorisation.jwt.filter.JWTTokenFilter;
import com.orion.web.core.filter.JavaThreadIDGeneratorFilter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class CucumberStepsWorld
{
    protected final MockMvc mockMvc;
    public CucumberAPICall apiCall;
    protected APICucumberVerifier verifier;
    public Map<String, MockHttpServletResponse> keyToAPICallResponseMapper;
    public String currentUserID;
    protected APICucumberStepsWorld apiCucumberStepsWorld;


    public CucumberStepsWorld(WebApplicationContext webApplicationContext)
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                        .addFilters(new JavaThreadIDGeneratorFilter())
                        .addFilters(new JWTTokenFilter())
                        .build();
        verifier = new APICucumberVerifier();
        keyToAPICallResponseMapper = new HashMap<>();
        currentUserID = "SomeUserID";
    }


    public void resetForNewScenarioRun()
    {
        apiCall = new CucumberAPICall();
    }


    public void makeAPICall()
    {
        apiCucumberStepsWorld = new APICucumberStepsWorld(mockMvc, apiCall, verifier);
        apiCall.apiResponse = apiCucumberStepsWorld.makeAPICallAndGetResponse();
    }


    public MockHttpServletResponse makeAPICallAndVerifyResponseStatusCode(String expectedResponseHTTPStatusCode)
    {
        apiCucumberStepsWorld = new APICucumberStepsWorld(mockMvc, apiCall, verifier);
        return apiCucumberStepsWorld.makeAPICallAndVerifyResponseStatusCode(expectedResponseHTTPStatusCode);
    }


    public void verifyAPICallResponseStatusCode(String expectedResponseHTTPStatusCode)
    {
        apiCucumberStepsWorld.assertHTTPStatusCode(expectedResponseHTTPStatusCode, apiCall.apiResponse);
    }


    public MockHttpServletResponse makeAPICallAndVerifyResponseStatusCodeAndResponseBody(String expectedResponseHTTPStatusCode, String expectedResponseBody)
    {
        apiCucumberStepsWorld = new APICucumberStepsWorld(mockMvc, apiCall, verifier);
        return apiCucumberStepsWorld.makeAPICallAndVerifyResponseStatusCodeAndResponseBody(expectedResponseHTTPStatusCode, expectedResponseBody);
    }


    public MockHttpServletResponse makeAPICallAndVerifyResponseStatusCodeAndPartialResponseBody(String expectedResponseHTTPStatusCode, String expectedPartialResponseBody)
    {
        apiCucumberStepsWorld = new APICucumberStepsWorld(mockMvc, apiCall, verifier);
        return apiCucumberStepsWorld.makeAPICallAndVerifyResponseStatusCodeAndPartialResponseBody(expectedResponseHTTPStatusCode, expectedPartialResponseBody);
    }


    public MockHttpServletResponse makeAPICallAndVerifyResponseStatusCodeAndPartialJSONResponseBody(String expectedResponseHTTPStatusCode, String expectedPartialResponseBody)
    {
        apiCucumberStepsWorld = new APICucumberStepsWorld(mockMvc, apiCall, verifier);
        return apiCucumberStepsWorld.makeAPICallAndVerifyResponseStatusCodeAndPartialJSONResponseBody(expectedResponseHTTPStatusCode, expectedPartialResponseBody);
    }


    public void verifyAPICallResponseHasPartialJSONResponseBody(String expectedPartialResponseBody)
    {
        apiCucumberStepsWorld.verifyAPICallResponseHasPartialJSONResponseBody(expectedPartialResponseBody, apiCall.apiResponse);
    }


    public void verifyAPICallResponseHasJSONResponseBody(String expectedResponseBody)
    {
        apiCucumberStepsWorld.verifyAPICallResponseHasJSONResponseBody(expectedResponseBody, apiCall.apiResponse);
    }


    public void verifyAPICallResponseIncludesNonEmptyFields(List<String> expectedNonEmptyFields)
    {
        apiCucumberStepsWorld.assertResponseBodyContainsNonEmptyFields(expectedNonEmptyFields, apiCall.apiResponse);
    }


    public void verifyAPICallResponseIncludesFieldsWithValueStartingWith(String field, String valuePrefix)
    {
        apiCucumberStepsWorld.assertResponseFieldValueStartsWith(field, valuePrefix, apiCall.apiResponse);
    }


    public void verifyAPICallResponseIncludesFieldsWithValueContaining(String field, String valueInfix)
    {
        apiCucumberStepsWorld.assertResponseFieldValueContaining(field, valueInfix, apiCall.apiResponse);
    }


    public void verifyAPICallResponseIncludesFieldsWithValue(String field, String value)
    {
        apiCucumberStepsWorld.assertResponseFieldValue(field, value, apiCall.apiResponse);
    }


    public void verifyAPICallResponseIncludesFields(List<String> expectedFields)
    {
        apiCucumberStepsWorld.assertResponseBodyContainsFields(expectedFields, apiCall.apiResponse);
    }
}