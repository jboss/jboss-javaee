/* $Id: PersistenceUnits.java 11282 2007-03-14 22:05:59Z epbernard $
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
 * Declares one or more PersistenceUnit annotations
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PersistenceUnits {
	/**
	 * One or more PersistenceUnit annotations
	 */
	PersistenceUnit[] value();
}
