/* $Id: PersistenceUnit.java 11282 2007-03-14 22:05:59Z epbernard $
 * JBoss Inc
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package javax.persistence;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Expresses a dependency on an EntityManagerFactory.
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PersistenceUnit {
	/**
	 * The name by which the entity manager factory is to be accessed in the environment
	 * referencing context, and is not needed when dependency injection is used.
	 */
	String name() default "";
	/**
	 * The name of the persistence unit as defined in the persistence.xml file. If specified, the
	 * persistence unit for the entity manager factory that is accessible in JNDI must have the
	 * same name.
	 */
	String unitName() default "";
}
