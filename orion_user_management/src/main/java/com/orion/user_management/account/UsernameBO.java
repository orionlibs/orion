package com.orion.user_management.account;

import com.orion.core.abstraction.Orion;
import com.orion.data.user.email_address.EmailAddressService;
import com.orion.user_management.authentication.login.OrionLoginDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class UsernameBO extends Orion
{
    private String username;
    private Authentication authentication;
    private AuthenticationFailureBadCredentialsEvent event;


    public static UsernameBO of(String username)
    {
        return UsernameBO.builder().username(username.trim()).build();
    }


    public static UsernameBO ofAuthentication(Authentication authentication)
    {
        return UsernameBO.builder().authentication(authentication).build();
    }


    public static UsernameBO ofFailedAuthenticationEvent(AuthenticationFailureBadCredentialsEvent event)
    {
        return UsernameBO.builder().event(event).build();
    }


    public boolean doesUsernameExist()
    {

        if(EmailAddressService.isValidEmailAddress(username))
        {
            username = EmailAddressService.normaliseEmailAddress(username);
            return UserAccountService.doesUserExistByUsername(username);
        }
        else
        {
            return false;
        }

    }


    public String extractUsername()
    {
        String username = null;

        if(authentication.getDetails() instanceof OrionLoginDetails)
        {
            username = ((OrionLoginDetails)authentication.getDetails()).getUsername();
        }
        else if(authentication.getDetails() instanceof UserDetails)
        {
            username = ((UserDetails)authentication.getDetails()).getUsername();
        }
        else if(authentication.getDetails() instanceof User)
        {
            username = ((User)authentication.getDetails()).getUsername();
        }
        else
        {
            username = authentication.getDetails().toString();
        }

        return username;
    }


    public String extractUsernameFromAuthenticationEvent()
    {
        String username = null;

        if(event.getAuthentication().getPrincipal() instanceof User)
        {
            User user = (User)event.getAuthentication().getPrincipal();
            username = user.getUsername();
        }
        else if(event.getAuthentication().getPrincipal() instanceof String)
        {
            username = (String)event.getAuthentication().getPrincipal();
        }

        return username;
    }
}