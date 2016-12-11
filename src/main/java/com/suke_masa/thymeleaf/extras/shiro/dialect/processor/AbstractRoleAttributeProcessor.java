package com.suke_masa.thymeleaf.extras.shiro.dialect.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;

/**
 * Created by tada on 2016/10/29.
 */
public abstract class AbstractRoleAttributeProcessor extends AbstractSecureAttributeProcessor {

    public AbstractRoleAttributeProcessor(String dialectPrefix, String attrName) {
        super(dialectPrefix, attrName);
    }

    protected abstract boolean isVisible(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue);

    protected final boolean hasRole(String roleName) {
        return getSubject() != null && getSubject().hasRole(roleName);
    }
}