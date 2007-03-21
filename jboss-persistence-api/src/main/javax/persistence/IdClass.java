//$Id: IdClass.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Specifies a composite primary key class that is mapped to multiple fields or properties
 * of the entity.
 *
 * The names of the fields or properties in the primary key class and the primary key fields
 * or properties of the entity must correspond and their types must be the same.
 *
 * @author Emmanuel Bernard
 */
@Target({TYPE}) @Retention(RUNTIME)
public @interface IdClass {
	/**
	 * Primary key class
	 */
	Class value();
}
