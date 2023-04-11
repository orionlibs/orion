package com.orion.testing.cucumber.glue.steps.internal;

import com.orion.core.content.MIMEType;
import com.orion.core.profile.Profile;
import com.orion.testing.cucumber.CucumberAPICall;
import com.orion.testing.cucumber.CucumberAPICallRequestParameter;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.Cookie;
import lombok.NonNull;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseCookie;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class APICucumberStepsWorld
{
    private MockMvc mockMvc;
    public CucumberAPICall apiCall;
    private APICucumberVerifier verifier;


    public APICucumberStepsWorld(MockMvc mockMvc, CucumberAPICall apiCall, APICucumberVerifier verifier)
    {
        this.mockMvc = mockMvc;
        this.apiCall = apiCall;
        this.verifier = verifier;
    }


    public MockHttpServletResponse makeAPICallAndVerifyResponseStatusCode(String expectedResponseHTTPStatusCode)
    {
        MockHttpServletResponse response = makeAPICallAndGetResponse();
        apiCall.apiResponse = response;
        assertHTTPStatusCode(expectedResponseHTTPStatusCode, response);
        return response;
    }


    public MockHttpServletResponse makeAPICallAndVerifyResponseStatusCodeAndResponseBody(String expectedResponseHTTPStatusCode, String expectedResponseBody)
    {
        MockHttpServletResponse response = makeAPICallAndGetResponse();
        apiCall.apiResponse = response;
        assertHTTPStatusCode(expectedResponseHTTPStatusCode, response);
        verifier.assertResponseBody(expectedResponseBody, response);
        return response;
    }


    public MockHttpServletResponse makeAPICallAndVerifyResponseStatusCodeAndPartialResponseBody(String expectedResponseHTTPStatusCode, String expectedResponseBody)
    {
        MockHttpServletResponse response = makeAPICallAndGetResponse();
        apiCall.apiResponse = response;
        assertHTTPStatusCode(expectedResponseHTTPStatusCode, response);
        verifier.assertResponseBodyContains(expectedResponseBody, response);
        return response;
    }


    public MockHttpServletResponse makeAPICallAndVerifyResponseStatusCodeAndPartialJSONResponseBody(String expectedResponseHTTPStatusCode, String expectedResponseBody)
    {
        MockHttpServletResponse response = makeAPICallAndGetResponse();
        apiCall.apiResponse = response;
        assertHTTPStatusCode(expectedResponseHTTPStatusCode, response);
        verifier.assertResponseBodyContainsJSON(expectedResponseBody, response);
        return response;
    }


    public void verifyAPICallResponseHasPartialJSONResponseBody(String expectedResponseBody, MockHttpServletResponse response)
    {
        verifier.assertResponseBodyContainsJSON(expectedResponseBody, response);
    }


    public void verifyAPICallResponseHasJSONResponseBody(String expectedResponseBody, MockHttpServletResponse response)
    {
        verifier.assertResponseBody(expectedResponseBody, response);
    }


    public void assertHTTPStatusCode(@NonNull String expectedResponseHTTPStatusCode, MockHttpServletResponse response)
    {
        verifier.assertHTTPStatusCode(expectedResponseHTTPStatusCode, response);
    }


    public void assertResponseBodyContainsNonEmptyFields(List<String> expectedNonEmptyFields, MockHttpServletResponse response)
    {
        verifier.assertResponseBodyContainsNonEmptyFields(expectedNonEmptyFields, response);
    }


    public void assertResponseFieldValueStartsWith(String field, String valuePrefix, MockHttpServletResponse response)
    {
        verifier.assertResponseFieldValueStartsWith(field, valuePrefix, response);
    }


    public void assertResponseFieldValueContaining(String field, String valueInfix, MockHttpServletResponse response)
    {
        verifier.assertResponseFieldValueContaining(field, valueInfix, response);
    }


    public void assertResponseFieldValue(String field, String value, MockHttpServletResponse response)
    {
        verifier.assertResponseFieldValue(field, value, response);
    }


    public void assertResponseBodyContainsFields(List<String> expectedFields, MockHttpServletResponse response)
    {
        verifier.assertResponseBodyContainsFields(expectedFields, response);
    }


    @SuppressWarnings("deprecation")
    public MockHttpServletResponse makeAPICallAndGetResponse()
    {
        HttpMethod httpMethod = HttpMethod.valueOf(apiCall.apiCallDetails.httpMethod);
        String endpointURL = CucumberAPICall.endpointPrefix + apiCall.apiCallDetails.authOrNoauth + apiCall.apiCallDetails.endpoint;
        MockHttpServletResponse response = null;

        if(apiCall.jsonRequestBody == null || apiCall.jsonRequestBody.isEmpty())
        {
            apiCall.jsonRequestBody = "{}";
        }

        try
        {
            MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.request(httpMethod, endpointURL)
                            .accept(MIMEType.applicationJSON)
                            .contentType(MIMEType.applicationJSON)
                            .content(apiCall.jsonRequestBody)
                            .headers(apiCall.buildHTTPHeaders());

            if(apiCall.requestParameters != null && !apiCall.requestParameters.isEmpty())
            {

                for(CucumberAPICallRequestParameter requestParameter : apiCall.requestParameters)
                {
                    requestBuilder = requestBuilder.requestAttr(requestParameter.name, requestParameter.value);
                    requestBuilder = requestBuilder.queryParam(requestParameter.name, requestParameter.value);
                }

            }

            if(apiCall.cookies != null && !apiCall.cookies.isEmpty())
            {

                for(ResponseCookie cookie : apiCall.cookies)
                {
                    Cookie cookie1 = new Cookie(cookie.getName(), cookie.getValue());
                    cookie1.setDomain(Profile.LocalhostProfile.get());
                    cookie1.setHttpOnly(true);
                    cookie1.setMaxAge(100000000);
                    cookie1.setPath("/");
                    cookie1.setSecure(true);
                    requestBuilder = requestBuilder.cookie(cookie1);
                }

            }

            response = mockMvc.perform(requestBuilder).andReturn().getResponse();
        }
        catch(Exception e)
        {
            response = new MockHttpServletResponse();

            try
            {
                response.sendError(500, "Internal problem. Probably not the API endpoint itself. Original error: " + e.getMessage());
            }
            catch(IOException e1)
            {
                response.setStatus(500, "Internal problem. Probably not the API endpoint itself. Original error: " + e1.getMessage());
            }

        }

        return response;
    }
}