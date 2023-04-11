package com.orionplatform.test_webapp.pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.orionplatform.web.core.app.pages.OrionPageService;

@Controller
public class RegistrationPageService extends OrionPageService
{
    @GetMapping(value = "/registration")
    public String openRegistrationPage(HttpServletRequest request, HttpServletResponse response, Model model)
    {
        return "registration/registration";
    }
}