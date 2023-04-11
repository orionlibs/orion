package com.orion.user_management.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.data.source.security.annotations.DecryptAsUsername;
import com.orion.data.source.security.annotations.EncryptAsUsername;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrionAuthorityModel implements OrionModel
{
    private String userID;
    @EncryptAsUsername
    @DecryptAsUsername
    private String username;
    // this is populated if the user has only one role
    private String authority;
    private Boolean isDeleted;
    private Boolean isDeactivated;
    private Boolean isDriver;
    private Boolean isTestUser;
    private Boolean isSendDriverEmails;
    @EncryptAsUsername
    @DecryptAsUsername
    private String newUsername;


    public static OrionAuthorityModel of()
    {
        return OrionAuthorityModel.builder().build();
    }


    public static OrionAuthorityModel of(String userID)
    {
        return OrionAuthorityModel.builder().userID(userID).build();
    }


    public boolean isAdministrator()
    {

        for(String auth : getAuthorities())
        {

            if(auth.equals(OrionUserAuthority.Administrator.get()))
            {
                return true;
            }

        }

        return false;
    }


    public boolean isAnonymous()
    {

        for(String auth : getAuthorities())
        {

            if(auth.equals(OrionUserAuthority.Anonymous.get()))
            {
                return true;
            }

        }

        return false;
    }


    public boolean hasAuthority(String authorityToCheck)
    {

        for(String auth : getAuthorities())
        {

            if(auth.equals(authorityToCheck))
            {
                return true;
            }

        }

        return false;
    }


    public boolean doesNotHaveAuthority(String authorityToCheck)
    {
        return !hasAuthority(authorityToCheck);
    }


    public OrionSet<String> getAuthorities()
    {
        String[] authorities = getAuthority().split(",");
        return OrionHashSet.<String>of(authorities);
    }


    public OrionList<GrantedAuthority> getAuthoritiesAsGrantedAuthorities()
    {
        OrionList<GrantedAuthority> authoritiesTemp = OrionArrayList.<GrantedAuthority>of();
        getAuthorities().forAll(auth -> authoritiesTemp.add(new SimpleGrantedAuthority(auth)));
        return authoritiesTemp;
    }


    public List<GrantedAuthority> getAuthoritiesAsGrantedAuthoritiesAsList()
    {
        return getAuthoritiesAsGrantedAuthorities().getAsList();
    }


    public String[] getAuthoritiesAsArray()
    {
        return getAuthorities().toArray(new String[0]);
    }


    @Override
    public OrionAuthorityModel clone()
    {
        return (OrionAuthorityModel)CloningService.clone(this);
    }


    @Override
    public OrionAuthorityModel getCopy()
    {
        return this.clone();
    }
}