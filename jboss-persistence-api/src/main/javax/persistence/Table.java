//$Id: Table.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * This annotation specifies the primary table for the annotated entity. Additional
 * tables may be specified using SecondaryTable  or SecondaryTables annotation.
 *
 * If no Table annotation is specified for an entity class, the default values apply.
 *
 * @author Emmanuel Bernard
 */
@Target({TYPE}) @Retention(RUNTIME)
public @interface Table {
	/**
	 * The name of the table.
	 *
	 * Defaults to the entity name.
	 */
	String name() default "";
	/**
	 * The catalog of the table.
	 *
	 * Defaults to the default catalog.
	 */
	String catalog() default "";
	/**
	 * The schema of the table.
	 *
	 * Defaults to the default schema for user.
	 */
	String schema() default "";
	/**
	 * Unique constraints that are to be placed on the table. These are only used if table
	 * generation is in effect. These constraints apply in addition to any constraints
	 * specified by the Column and JoinColumn annotations and constraints entailed by
	 * primary key mappings.
	 *
	 * Defaults to no additional constraints.
	 */
	UniqueConstraint[] uniqueConstraints() default {};
}
