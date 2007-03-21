//$Id: PersistenceContextType.java 11282 2007-03-14 22:05:59Z epbernard $
package javax.persistence;

/**
 * Specifies whether a transaction-scoped or extended persistence context is to be used in
 * PersistenceContext. If the type element is not specified, a transaction-scoped persistence
 * context is used.
 */
public enum PersistenceContextType {
	/**
	 * Transaction-scoped persistence context
	 */
	TRANSACTION,
	/**
	 * Extended persistence context
	 */
	EXTENDED
}
