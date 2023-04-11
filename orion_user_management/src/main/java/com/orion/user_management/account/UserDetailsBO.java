package com.orion.user_management.account;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.data_access.OrionUserDetailsDAO;
import com.orion.user_management.model.OrionUserDetailsModel;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class UserDetailsBO extends Orion
{
    private String userID;
    private String phoneNumber;


    public static UserDetailsBO ofUserID(String userID)
    {
        return UserDetailsBO.builder().userID(userID.trim()).build();
    }


    public static UserDetailsBO ofPhoneNumber(String phoneNumber)
    {
        return UserDetailsBO.builder().phoneNumber(phoneNumber.trim()).build();
    }


    public OrionUserDetailsModel getUserDetailsByUserID()
    {
        return OrionUserDetailsDAO.getUserDetailsByUserID(userID);
    }


    public String getFirstNameByUserID()
    {
        return OrionUserDetailsDAO.getFirstNameByUserID(userID);
    }


    public String getFullNameByUserID()
    {
        return OrionUserDetailsDAO.getFullNameByUserID(userID);
    }


    public List<OrionUserDetailsModel> getUsersDetailsByPhoneNumber()
    {
        return OrionUserDetailsDAO.getUsersDetailsByPhoneNumber(phoneNumber);
    }


    public String getUserPhoneNumberByUserID()
    {
        return OrionUserDetailsDAO.getPhoneNumberByUserID(userID);
    }


    public String getUserEmailAddressByUserID()
    {
        return OrionUserDetailsDAO.getEmailAddressByUserID(userID);
    }


    public static int save(OrionUserDetailsModel model)
    {
        return OrionUserDetailsDAO.save(model);
    }


    public static int updateByUserID(OrionUserDetailsModel user)
    {
        return OrionUserDetailsDAO.update(user);
    }
}