//$Id: TransactionRequiredException.java 11282 2007-03-14 22:05:59Z epbernard $
package javax.persistence;

/**
 * Thrown by the persistence provider when a transaction is required but is not active.
 * @author Gavin King
 */
public class TransactionRequiredException extends PersistenceException {

	/**
	 * Constructs a new TransactionRequiredException exception with null as its detail message
	 */
	public TransactionRequiredException() {
		super();
	}

	/**
	 * Constructs a new TransactionRequiredException exception with the specified detail message
	 * 
	 * @param message
	 */
	public TransactionRequiredException(String message) {
		super( message );
	}

}
