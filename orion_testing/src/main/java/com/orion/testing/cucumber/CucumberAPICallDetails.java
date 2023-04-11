package com.orion.testing.cucumber;

import lombok.Builder;
import lombok.NonNull;

@Builder
public class CucumberAPICallDetails
{
    public final String authOrNoauth;
    @NonNull
    public final String httpMethod;
    @NonNull
    public final String endpoint;
}
