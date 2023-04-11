package com.orion.core.abstraction;

public class OrionUserCredentials extends Orion
{
    private String userID;
    private String username;


    public OrionUserCredentials(String userID, String username)
    {
        super();
        this.userID = userID;
        this.username = username;
    }


    public String getUserID()
    {
        return this.userID;
    }


    public void setUserID(String userID)
    {
        this.userID = userID;
    }


    public String getUsername()
    {
        return this.username;
    }


    public void setUsername(String username)
    {
        this.username = username;
    }
}