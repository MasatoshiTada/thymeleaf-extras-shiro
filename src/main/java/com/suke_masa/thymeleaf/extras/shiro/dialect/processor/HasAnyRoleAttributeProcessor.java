package com.suke_masa.thymeleaf.extras.shiro.dialect.processor;

import org.apache.shiro.subject.Subject;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;

/**
 * Created by tada on 2016/10/29.
 */
public class HasAnyRoleAttributeProcessor extends AbstractSecureAttributeProcessor {

    private static final String ROLE_NAMES_DELIMETER = ",";

    private static final String ATTR_NAME = "hasAnyRole";

    public HasAnyRoleAttributeProcessor(String dialectPrefix) {
        super(dialectPrefix, ATTR_NAME);
    }

    @Override
    protected boolean isVisible(ITemplateContext context,
                                IProcessableElementTag tag,
                                AttributeName attributeName,
                                String attributeValue) {
        Subject subject = getSubject();
        if (subject != null) {
            for (String role : attributeValue.split(ROLE_NAMES_DELIMETER)) {
                if (subject.hasRole(role.trim())) {
                    return true;
                }
            }
        }
        return false;
    }
}
