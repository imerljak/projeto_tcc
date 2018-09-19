package br.com.imerljak.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    private static final String ACCESS_DENIED_PATH = "/access-denied";

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            log.warn("User: " + auth.getName()
                             + " attempted to access the protected URL: "
                             + request.getRequestURI());
        }

        response.sendRedirect(request.getContextPath() + ACCESS_DENIED_PATH);
    }
}
