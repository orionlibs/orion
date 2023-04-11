package com.orion.testing;

import com.orion.core.cryptology.init.tasks.LoadCryptologyConfigurationTask;
import com.orion.core.profile.Profile;
import com.orion.web.core.cookie.CookieName;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.springframework.http.ResponseCookie;

public abstract class OrionTestingBase
{
    public static boolean hasCryptologyConfigurationBeenLoaded;
    public static final String JWTTokenOfDefaultUser = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmYmMzOGM2YjIzNWU0YzQ2OGUwMjQ5NTdkZDhlMjRmYyIsInVzZXIuYXV0aG9yaXRpZXMiOiJBRE1JTklTVFJBVE9SLERSSVZFUiIsIm9yaW9uLnJlZnJlc2gudG9rZW4iOiI0YWI1Yjc0ODkwM2M0ZGEwYTU4NzUzODQyOTZhNjRkZTRiMTE1NTBkNDcxNTQwNDM5ZWM4YWRlNjI1YzgyYzdhZWZmYzliZjdlZDc1NDZlNWE0MmUzM2YwY2ZjNmJkMTEiLCJvcmlvbi5yZWZyZXNoLnRva2VuLmV4cGlyYXRpb24udGltZXN0YW1wLmluLmVwb2NoLm1pbGxpc2Vjb25kcyI6IjM2MjQyOTI1NDI4MzciLCJhdWQiOiJodHRwczovL2FwaS5vbmVsaXZlcnkuY28udWsiLCJpc3MiOiJodHRwczovL2FwaS5vbmVsaXZlcnkuY28udWsiLCJpYXQiOjE2MjQyOTI1NDIsImV4cCI6MzYyNDI5MjU0Mn0.CX35wh_aR9PzVhoKL-CxdxLHI5hbrN7jXJBlfAtkv8I41Fknff8F5YBjcU52DlEsQLhWYNd0PxD0Erc19ycYEg";
    public static final String JWTRefreshTokenOfDefaultUser = "4ab5b748903c4da0a5875384296a64de4b11550d471540439ec8ade625c82c7aeffc9bf7ed7546e5a42e33f0cfc6bd11";
    public static final String userIDOfDefaultUser = "fbc38c6b235e4c468e024957dd8e24fc";


    public static ResponseCookie getJWTCookieForDefaultUser()
    {
        ResponseCookie cookie = ResponseCookie.from(CookieName.JWTAccessToken.get(), OrionTestingBase.JWTTokenOfDefaultUser)
                        .domain(Profile.LocalhostProfile.get())
                        .httpOnly(true)
                        .maxAge(100000000)
                        .path("/")
                        .sameSite("None")
                        .secure(true)
                        .build();
        return cookie;
    }


    public OrionTestingBase()
    {

        if(!hasCryptologyConfigurationBeenLoaded)
        {
            loadCryptologyConfiguration();
        }

    }


    public static void loadCryptologyConfiguration()
    {

        try
        {
            LoadCryptologyConfigurationTask.run();
            hasCryptologyConfigurationBeenLoaded = true;
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch(InvalidKeySpecException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }


    public abstract void resetDatabase();


    public abstract void truncateAllDatabaseTables();


    public abstract void truncateNonEssentialDatabaseTables();


    public abstract void truncateUserRelatedDatabaseTables();
}