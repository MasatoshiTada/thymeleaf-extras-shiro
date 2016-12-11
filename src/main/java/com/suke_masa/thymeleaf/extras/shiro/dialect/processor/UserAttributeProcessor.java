package com.suke_masa.thymeleaf.extras.shiro.dialect.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;

/**
 * Created by tada on 2016/10/29.
 */
public class UserAttributeProcessor extends AbstractSecureAttributeProcessor {

    private static final String ATTR_NAME = "user";

    public UserAttributeProcessor(String dialectPrefix) {
        super(dialectPrefix, ATTR_NAME);
    }

    @Override
    protected boolean isVisible(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue) {
        return getSubject() != null && getSubject().getPrincipal() != null;
    }
}
