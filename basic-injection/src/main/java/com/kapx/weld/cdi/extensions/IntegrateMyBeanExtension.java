package com.kapx.weld.cdi.extensions;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.InjectionTarget;
import javax.enterprise.util.AnnotationLiteral;

import com.kapx.weld.cdi.beans.ScriptingService;

public class IntegrateMyBeanExtension implements Extension {
	public void onBeanDiscovery(@Observes AfterBeanDiscovery beanDiscovery, BeanManager beanManager) {
		final InjectionTarget<ScriptingService> injectionTarget = beanManager.createInjectionTarget(beanManager
				.createAnnotatedType(ScriptingService.class));
		beanDiscovery.addBean(new Bean<ScriptingService>() {

			@Override
			public ScriptingService create(CreationalContext<ScriptingService> context) {
				ScriptingService instance = (ScriptingService) injectionTarget.produce(context);
				injectionTarget.inject(instance, context);
				injectionTarget.postConstruct(instance);
				return instance;
			}

			@Override
			public void destroy(ScriptingService instance, CreationalContext<ScriptingService> context) {
				injectionTarget.preDestroy(instance);
				injectionTarget.dispose(instance);
				context.release();
			}

			@Override
			public Class<ScriptingService> getBeanClass() {
				return ScriptingService.class;
			}

			@Override
			public Set<InjectionPoint> getInjectionPoints() {
				return injectionTarget.getInjectionPoints();
			}

			@Override
			public String getName() {
				return "ScriptingService";
			}

			@SuppressWarnings("serial")
			@Override
			public Set<Annotation> getQualifiers() {
				Set<Annotation> qualifiers = new HashSet<Annotation>();
				qualifiers.add(new AnnotationLiteral<Default>() {
				});
				qualifiers.add(new AnnotationLiteral<Any>() {
				});
				return qualifiers;
			}

			@Override
			public Class<? extends Annotation> getScope() {
				return ApplicationScoped.class;
			}

			@Override
			public Set<Class<? extends Annotation>> getStereotypes() {
				return Collections.emptySet();
			}

			@Override
			public Set<Type> getTypes() {
				Set<Type> types = new HashSet<Type>();

				types.add(ScriptingService.class);

				return types;
			}

			@Override
			public boolean isAlternative() {
				return false;
			}

			@Override
			public boolean isNullable() {
				return false;
			}
		});
	}
}
