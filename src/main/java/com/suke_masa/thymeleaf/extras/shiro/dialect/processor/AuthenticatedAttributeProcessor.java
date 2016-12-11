package com.suke_masa.thymeleaf.extras.shiro.dialect.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;

/**
 * Created by tada on 2016/10/29.
 */
public class AuthenticatedAttributeProcessor extends AbstractSecureAttributeProcessor {

    private static final String ATTR_NAME = "authenticated";

    public AuthenticatedAttributeProcessor(String dialectPrefix) {
        super(dialectPrefix, ATTR_NAME);
    }

    /**
     * 認証済みであればtrue
     */
    @Override
    protected boolean isVisible(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue) {
        return getSubject() != null && getSubject().isAuthenticated();
    }

}
