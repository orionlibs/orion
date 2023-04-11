package com.orion.user_management.authorisation;

import java.util.List;

public class CSRFConfiguration
{
    public static List<String> URLsThatDoNotNeedCSRFToken;
    public static List<String> URLsThatDoNotNeedAuthentication;
    public static List<String> nonAPIURLs;
}