package com.orion.testing.cucumber;

import lombok.Builder;
import lombok.NonNull;

@Builder
public class CucumberAPICallHeader
{
    @NonNull
    public final String name;
    @NonNull
    public final String value;
}
