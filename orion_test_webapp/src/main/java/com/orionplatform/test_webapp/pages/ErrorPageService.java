package com.orionplatform.test_webapp.pages;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.orionplatform.web.core.app.pages.OrionPageService;

@Controller
public class ErrorPageService extends OrionPageService
{
    private static final String ERROR_CODE = "errorCode";


    @GetMapping(value = "/error/403")
    public String open403ErrorPage(HttpServletRequest request, Model model)
    {
        model.addAttribute(ERROR_CODE, "403");
        return "error/error";
    }


    @GetMapping(value = "/error/404")
    public String open404ErrorPage(HttpServletRequest request, Model model)
    {
        model.addAttribute(ERROR_CODE, "404");
        return "error/error";
    }
    
    
    @GetMapping(value = "/error/405")
    public String open405ErrorPage(HttpServletRequest request, Model model)
    {
        model.addAttribute(ERROR_CODE, "405");
        return "error/error";
    }


    @GetMapping(value = "/error/500")
    public String open500ErrorPage(HttpServletRequest request, Model model)
    {
        model.addAttribute(ERROR_CODE, "500");
        return "error/error";
    }
}