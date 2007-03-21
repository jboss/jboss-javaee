//$Id: Entity.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * Specifies that the class is an entity. This annotation is applied to the entity class.
 *
 * @author Emmanuel Bernard
 */
@Target(TYPE) @Retention(RUNTIME)
public @interface Entity {
	/**
	 * The name of an entity. Defaults to the unqualified name of the entity class.
	 * This name is used to refer to the entity in queries. The name must not be a
	 * reserved literal in the Java Persistence query language.
	 */
	String name() default "";
}
