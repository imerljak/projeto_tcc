package br.com.imerljak.seguranca.config;

import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

public class NoRolePrefixSecurityExpressionHandler extends DefaultWebSecurityExpressionHandler {
    @Override
    protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, FilterInvocation fi) {
        WebSecurityExpressionRoot expressionRoot =
                (WebSecurityExpressionRoot) super.createSecurityExpressionRoot(authentication, fi);

        expressionRoot.setDefaultRolePrefix("");

        return expressionRoot;
    }
}
