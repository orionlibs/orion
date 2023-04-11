package com.orion.testing.cucumber;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.mock.web.MockHttpServletResponse;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CucumberAPICall
{
    public static final String endpointPrefix = "/api/v1/";
    public List<CucumberAPICallHeader> httpHeaders;
    @NonNull
    public CucumberAPICallDetails apiCallDetails;
    public String jsonRequestBody;
    public List<CucumberAPICallRequestParameter> requestParameters;
    public MockHttpServletResponse apiResponse;
    public List<ResponseCookie> cookies;


    public HttpHeaders buildHTTPHeaders()
    {
        HttpHeaders httpHeadersForAPICall = new HttpHeaders();

        if(httpHeaders != null && !httpHeaders.isEmpty())
        {
            httpHeaders.forEach(field -> httpHeadersForAPICall.add(field.name, field.value));
        }

        return httpHeadersForAPICall;
    }
}
