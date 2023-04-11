package com.orion.web.core.services.heartbeat;

import com.orion.web.core.services.OrionWebService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeartbeatAPIService extends OrionWebService
{
    @GetMapping(value = "/heartbeat")
    public ResponseEntity<?> isServerAlive(HttpServletRequest request, HttpServletResponse response, Model model, CsrfToken token)
    {
        return Heartbeat.isServerAlive();
    }
}