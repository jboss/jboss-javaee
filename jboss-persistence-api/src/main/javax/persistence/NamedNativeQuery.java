//$Id: NamedNativeQuery.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * Is used to specify a native SQL named query. Query names are scoped to the persistence unit.
 *
 * @author Emmanuel Bernard
 */
@Target({TYPE})
@Retention(RUNTIME)
public @interface NamedNativeQuery {
	/**
	 * Is used to refer to the query when using the EntityManager methods that create query objects
	 */
	String name();
	/**
	 * The SQL query string
	 */
	String query();

	/**
	 * Vendor-specific query hints
	 */
	QueryHint[] hints() default {};
	/**
	 * The class of the result
	 */
	Class resultClass() default void.class;
	/**
	 * The name of a SqlResultSetMapping, as defined in metadata
	 */
	String resultSetMapping() default ""; // name of SQLResultSetMapping
}
