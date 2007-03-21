//$Id: NoResultException.java 11282 2007-03-14 22:05:59Z epbernard $
package javax.persistence;

/**
 * Thrown by the persistence provider when getSingleResult() is executed on a query and there is no result to return.
 * This exception will not cause the current transaction, if one is active, to be marked for roll back.
 * 
 * @author Emmanuel Bernard
 */
public class NoResultException extends PersistenceException {

	/**
	 * Constructs a new NoResultException exception with null as its detail message
	 */
	public NoResultException() {
		super();
	}

	/**
	 * Constructs a new NoResultException exception with the specified detail message.
	 * 
	 * @param message
	 */
	public NoResultException(String message) {
		super( message );
	}
}
