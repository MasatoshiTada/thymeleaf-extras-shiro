package com.suke_masa.thymeleaf.extras.shiro.dialect.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;

/**
 * Created by tada on 2016/10/29.
 */
public class NotAuthenticatedAttributeProcessor extends AbstractSecureAttributeProcessor {

    private static final String TAG_NAME = "notAuthenticated";

    public NotAuthenticatedAttributeProcessor(String dialectPrefix) {
        super(dialectPrefix, TAG_NAME);
    }

    @Override
    protected boolean isVisible(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue) {
        return getSubject() == null || !getSubject().isAuthenticated();
    }
}
