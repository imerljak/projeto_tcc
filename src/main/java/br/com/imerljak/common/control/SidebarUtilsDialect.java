package br.com.imerljak.common.control;

import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Collections;
import java.util.Set;

public class SidebarUtilsDialect extends AbstractDialect implements IExpressionObjectDialect {


    public SidebarUtilsDialect() {
        super("SidebarUtilsDialect");
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return new IExpressionObjectFactory() {
            @Override
            public Set<String> getAllExpressionObjectNames() {
                return Collections.singleton("sidebarUtils");
            }

            @Override
            public Object buildObject(IExpressionContext context, String expressionObjectName) {
                return new SidebarUtils();
            }

            @Override
            public boolean isCacheable(String expressionObjectName) {
                return true;
            }
        };
    }
}
