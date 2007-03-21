//$Id: NonUniqueResultException.java 11282 2007-03-14 22:05:59Z epbernard $
package javax.persistence;

/**
 * Thrown by the persistence provider when getSingleResult() is executed on a query and there is more than
 * one result from the query. This exception will not cause the current transaction, if one is active, to be
 * marked for roll back.
 *
 * @author Gavin King
 */
public class NonUniqueResultException extends PersistenceException {

	/**
	 * Constructs a new NonUniqueResultException exception with null as its detail message
	 */
	public NonUniqueResultException() {
		super();
	}

	/**
	 * Constructs a new NonUniqueResultException exception with the specified detail message
	 * 
	 * @param message
	 */
	public NonUniqueResultException(String message) {
		super( message );
	}

}
