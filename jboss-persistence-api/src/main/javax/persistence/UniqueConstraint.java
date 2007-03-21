//$Id: UniqueConstraint.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * This annotation is used to specify that a unique constraint is to be included in the generated DDL
 * for a primary or secondary table
 *
 * @author Emmanuel Bernard
 */
@Target({}) @Retention(RUNTIME)
public @interface UniqueConstraint {
	/**
	 * An array of the column names that make up the constraint
	 */
	String[] columnNames();
}
