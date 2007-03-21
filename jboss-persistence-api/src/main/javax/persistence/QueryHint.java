//$Id: QueryHint.java 11282 2007-03-14 22:05:59Z epbernard $
package javax.persistence;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * An implementation-specific Query hint
 *
 * @author Emmanuel Bernard
 */
@Target({})
@Retention(RUNTIME)
public @interface QueryHint {
	/**
	 * Name of the hint
	 */
	String name();

	/**
	 * Value of the hint
	 */
	String value();
}
