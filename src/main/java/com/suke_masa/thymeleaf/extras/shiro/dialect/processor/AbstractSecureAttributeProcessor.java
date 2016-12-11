package com.suke_masa.thymeleaf.extras.shiro.dialect.processor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementModelProcessor;
import org.thymeleaf.processor.element.IElementModelStructureHandler;
import org.thymeleaf.standard.processor.AbstractStandardConditionalVisibilityTagProcessor;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * Created by tada on 2016/10/29.
 */
public abstract class AbstractSecureAttributeProcessor extends AbstractStandardConditionalVisibilityTagProcessor {

    public static final int ATTR_PRECEDENCE = 300;

    public AbstractSecureAttributeProcessor(String dialectPrefix, String attrName) {
        super(
                TemplateMode.HTML,
                dialectPrefix,
                attrName,
                ATTR_PRECEDENCE
        );
    }

    protected final Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    protected abstract boolean isVisible(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName, String attributeValue);
}