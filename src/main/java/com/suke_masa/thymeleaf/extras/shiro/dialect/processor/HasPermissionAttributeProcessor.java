package com.suke_masa.thymeleaf.extras.shiro.dialect.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;

/**
 * Created by tada on 2016/10/29.
 */
public class HasPermissionAttributeProcessor extends AbstractPermissionAttributeProcessor {

    private static final String ATTR_NAME = "hasPermission";

    public HasPermissionAttributeProcessor(String dialectPrefix) {
        super(dialectPrefix, ATTR_NAME);
    }

    @Override
    protected boolean isVisible(ITemplateContext context,
                                IProcessableElementTag tag,
                                AttributeName attributeName,
                                String attributeValue) {
        return isPermitted(attributeValue);
    }
}
