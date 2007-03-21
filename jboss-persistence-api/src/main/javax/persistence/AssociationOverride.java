//$Id:$
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;

/**
 * This annotation is used to override a many-to-one or one-to-one mapping of property or field for
 * an entity relationship.
 * The AssociationOverride annotation may be applied to an entity that extends a mapped superclass
 * to override a many-to-one or one-to-one mapping defined by the mapped superclass. If the
 * AssociationOverride annotation is not specified, the join column is mapped the same as in
 * the original mapping.
 *
 * @author Emmanuel Bernard
 */
@Target({TYPE, METHOD, FIELD}) @Retention(RUNTIME)
public @interface AssociationOverride {
	/**
	 * The name of the relationship property whose mapping is being overridden if property-based
	 * access is being used, or the name of the relationship field if field-based access is used.
	 */
	String name();

	/**
	 * The join column that is being mapped to the persistent attribute.
	 */
	JoinColumn[] joinColumns();
}
