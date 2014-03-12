/*------------------------------------------------------------------------------
 *******************************************************************************
 * COPYRIGHT Ericsson 2012
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *******************************************************************************
 *----------------------------------------------------------------------------*/
package com.ericsson.cdi.beanmanager.example;

import java.util.Iterator;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

@ApplicationScoped
public enum BeanFactory {
    INSTANCE;

    private BeanManager beanManager;

    BeanFactory() {
        WeldContainer weldContainer = new Weld().initialize();
        beanManager = weldContainer.getBeanManager();
    }

    @SuppressWarnings({ "unchecked" })
    public <T> T getBeanInstanceByName(final String name) {
        final Iterator<Bean<?>> iterator = beanManager.getBeans(name).iterator();
        final Bean<T> bean = (Bean<T>) iterator.next();
        final CreationalContext<T> context = beanManager.createCreationalContext(bean);
        return (T) beanManager.getReference(bean, bean.getBeanClass(), context);
    }
}
