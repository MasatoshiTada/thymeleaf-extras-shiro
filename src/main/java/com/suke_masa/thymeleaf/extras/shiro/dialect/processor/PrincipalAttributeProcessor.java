package com.suke_masa.thymeleaf.extras.shiro.dialect.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;
import org.unbescape.html.HtmlEscape;

import static org.apache.shiro.SecurityUtils.getSubject;

/**
 * Created by tada on 2016/10/29.
 */
public class PrincipalAttributeProcessor extends AbstractAttributeTagProcessor {

    private static final String ATTR_NAME = "principal";

    public PrincipalAttributeProcessor(String dialectPrefix) {
        super(
                TemplateMode.HTML,
                dialectPrefix,
                null,
                false,
                ATTR_NAME,
                true,
                1000,
                true);
    }

    /**
     * 認証済みであればtrue
     */
    protected boolean isAuthenticated() {
        return getSubject() != null && getSubject().isAuthenticated();
    }

    @Override
    protected void doProcess(ITemplateContext context,
                             IProcessableElementTag tag,
                             AttributeName attributeName,
                             String attributeValue,
                             IElementTagStructureHandler structureHandler) {
        String name = isAuthenticated()
                ? getSubject().getPrincipal().toString()
                : "GUEST!!!";
        structureHandler.setBody(HtmlEscape.escapeHtml5(name), false);
    }
}
