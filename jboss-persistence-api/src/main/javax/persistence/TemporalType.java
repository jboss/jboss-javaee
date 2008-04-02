//$Id: TemporalType.java 14298 2008-01-30 17:51:29Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

/**
 * Type used to indicate a specific mapping of {@link java.util.Date} or {@link java.util.Calendar).
 */
public enum TemporalType {
	/**
	 * Map as java.sql.Date
	 */
	DATE,
	/**
	 * Map as java.sql.Time
	 */
	TIME,
	/**
	 * Map as java.sql.Timestamp
	 */
	TIMESTAMP
}