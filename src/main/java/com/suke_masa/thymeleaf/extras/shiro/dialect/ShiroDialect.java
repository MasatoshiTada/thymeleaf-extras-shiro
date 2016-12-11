package com.suke_masa.thymeleaf.extras.shiro.dialect;

import com.suke_masa.thymeleaf.extras.shiro.dialect.processor.HasRoleAttributeProcessor;
import com.suke_masa.thymeleaf.extras.shiro.dialect.processor.LacksPermissionAttributeProcessor;
import com.suke_masa.thymeleaf.extras.shiro.dialect.processor.LacksRoleAttributeProcessor;
import com.suke_masa.thymeleaf.extras.shiro.dialect.processor.UserAttributeProcessor;
import com.suke_masa.thymeleaf.extras.shiro.dialect.processor.AuthenticatedAttributeProcessor;
import com.suke_masa.thymeleaf.extras.shiro.dialect.processor.GuestAttributeProcessor;
import com.suke_masa.thymeleaf.extras.shiro.dialect.processor.HasAnyRoleAttributeProcessor;
import com.suke_masa.thymeleaf.extras.shiro.dialect.processor.HasPermissionAttributeProcessor;
import com.suke_masa.thymeleaf.extras.shiro.dialect.processor.NotAuthenticatedAttributeProcessor;
import com.suke_masa.thymeleaf.extras.shiro.dialect.processor.PrincipalAttributeProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tada on 2016/10/29.
 */
public class ShiroDialect extends AbstractProcessorDialect {

    private static final String DIALECT_NAME = "Shiro Dialect";

    public ShiroDialect() {
        super(DIALECT_NAME, "shiro", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new GuestAttributeProcessor(dialectPrefix));
        processors.add(new NotAuthenticatedAttributeProcessor(dialectPrefix));
        processors.add(new UserAttributeProcessor(dialectPrefix));
        processors.add(new AuthenticatedAttributeProcessor(dialectPrefix));
        processors.add(new HasRoleAttributeProcessor(dialectPrefix));
        processors.add(new LacksRoleAttributeProcessor(dialectPrefix));
        processors.add(new PrincipalAttributeProcessor(dialectPrefix));
        processors.add(new HasAnyRoleAttributeProcessor(dialectPrefix));
        processors.add(new HasPermissionAttributeProcessor(dialectPrefix));
        processors.add(new LacksPermissionAttributeProcessor(dialectPrefix));
        return processors;
    }

}
