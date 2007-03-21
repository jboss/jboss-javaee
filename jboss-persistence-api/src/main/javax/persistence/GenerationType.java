//$Id: GenerationType.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

/**
 * Defines the types of primary key generation.
 *
 * @author Emmanuel Bernard
 */
public enum GenerationType {
	/**
	 * Indicates that the persistence provider must assign primary keys for the entity using an underlying
	 * database table to ensure uniqueness.
	 */
	TABLE,
	/**
	 * Indicates that the persistence provider must assign primary keys for the entity using database
	 * sequence column.
	 */
	SEQUENCE,
	/**
	 * Indicates that the persistence provider must assign primary keys for the entity using
	 * database identity column.
	 */
	IDENTITY,
	/**
	 * Indicates that the persistence provider should pick an appropriate strategy for the
	 * particular database. The AUTO generation strategy may expect a database resource
	 * to exist, or it may attempt to create one. A vendor may provide documentation on how
	 * to create such resources in the event that it does not support schema generation or cannot
	 * create the schema resource at runtime.
	 */
	AUTO
};
