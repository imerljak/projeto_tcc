package br.com.imerljak.common.control;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SidebarUtils {

    public String activeClass(String urlPath) {
        return isActive(urlPath) ? "active" : "";
    }

    public boolean isActive(String urlPath) {
        return isActive(urlPath, false);
    }

    public boolean isActive(String urlPath, boolean endsWith) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();

        if (endsWith) {
            return request.getRequestURI().endsWith(urlPath);
        }

        return request.getRequestURI().contains(urlPath);
    }

    public String activeClass(String urlPath, boolean endsWith) {
        return isActive(urlPath, endsWith) ? "active" : "";
    }

}
