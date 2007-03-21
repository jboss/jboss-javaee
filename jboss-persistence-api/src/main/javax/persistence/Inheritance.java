//$Id: Inheritance.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

/**
 * Defines the inheritance strategy to be used for an entity class hierarchy. It is specified
 * on the entity class that is the root of the entity class hierarchy.
 *
 * @author Emmanuel Bernard
 */
@Target({TYPE}) @Retention(RUNTIME)
public @interface Inheritance {
	/**
	 * The strategy to be used
	 */
	InheritanceType strategy() default SINGLE_TABLE;
}
