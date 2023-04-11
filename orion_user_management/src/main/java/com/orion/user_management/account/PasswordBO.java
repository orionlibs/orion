package com.orion.user_management.account;

import com.orion.core.abstraction.Orion;
import com.orion.core.cryptology.encryption.bcrypt.BCryptEncryptionService;
import com.orion.core.exception.Assert;
import com.orion.user_management.reset_password.ResetPasswordService;
import com.orion.user_management.reset_password.model.OrionUserOldPasswordModel;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class PasswordBO extends Orion
{
    private String password;
    private String passwordPattern;
    private String userID;


    public static PasswordBO of(String password, String passwordPattern)
    {
        return PasswordBO.builder().password(password).passwordPattern(passwordPattern).build();
    }


    public static PasswordBO ofUserID(String userID, String password)
    {
        return PasswordBO.builder().userID(userID).password(password).build();
    }


    public boolean isValid()
    {
        Pattern pattern = Pattern.compile(passwordPattern);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


    public boolean doesNewPasswordMatchOldPassword()
    {
        Assert.notEmpty(password, "The password input cannot be null/empty.");
        List<OrionUserOldPasswordModel> oldPasswords = ResetPasswordService.getUserOldPasswordsByUserID(userID);

        if(oldPasswords != null && !oldPasswords.isEmpty())
        {
            return oldPasswords.stream()
                            .anyMatch(oldPassword -> BCryptEncryptionService.matches(password, oldPassword.getPassword()));
        }

        return false;
    }
}