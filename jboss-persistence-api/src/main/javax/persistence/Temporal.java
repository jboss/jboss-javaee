//$Id: Temporal.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * This annotation must be specified for persistent fields or properties of type Date and Calendar.
 * It may only be specified for fields or properties of these types.
 *
 * The Temporal annotation may be used in conjunction with the Basic annotation.
 *
 * @author Emmanuel Bernard
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface Temporal {
	/**
	 * The type used in mapping java.util.Date or java.util.Calendar
	 */
	TemporalType value();
}
