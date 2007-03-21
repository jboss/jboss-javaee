//$Id: FieldResult.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

/**
 * Is used to map the columns specified in the SELECT list of the query to the properties
 * or fields of the entity class.
 *
 * @author Emmanuel Bernard
 */
@Target({}) @Retention(RetentionPolicy.RUNTIME)
public @interface FieldResult {
	/**
	 * Name of the persistent field or property of the class.
	 */
	String name();
	/**
	 * Name of the column in the SELECT clause - i.e., column aliases, if applicable.
	 */
	String column();
}
