// =============================================================================
//
//   EagerExtension.java
//
//   (c) 2021, Christian Bachmaier <bachmaier@fim.uni-passau.de>
//
// =============================================================================

package de.uni_passau.fim.einfuehrungsaufgabe22.annotation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.*;

import java.util.ArrayList;
import java.util.List;

public class EagerExtension implements Extension {

    private final List<Bean<?>> eagerBeansList = new ArrayList<>();
    
    public <T> void collect(@Observes ProcessBean<T> event) {
        if (event.getAnnotated().isAnnotationPresent(Eager.class)
                && event.getAnnotated().isAnnotationPresent(
                    ApplicationScoped.class)) {
            eagerBeansList.add(event.getBean());
        }
    }
    
    public void load(@Observes AfterDeploymentValidation event,
            BeanManager beanManager) {
        for (Bean<?> bean : eagerBeansList) {
            // note that toString() is important to instantiate the bean
            beanManager.getReference(bean, bean.getBeanClass(),
                beanManager.createCreationalContext(bean)).toString();
        }
    }

}

// -----------------------------------------------------------------------------
// end of file
// -----------------------------------------------------------------------------
