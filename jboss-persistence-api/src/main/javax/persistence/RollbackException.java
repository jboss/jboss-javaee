//$Id: $
package javax.persistence;

/**
 * Thrown by the persistence provider when the EntityTransaction.commit() fails
 *
 * @author Emmanuel Bernard
 */
public class RollbackException extends PersistenceException {
	/**
	 * Constructs a new RollbackException exception with null as its detail message
	 */
	public RollbackException() {
		super();
	}

	/**
	 * Constructs a new RollbackException exception with the specified cause
	 *
	 * @param cause The detail cause
	 */
	public RollbackException(Throwable cause) {
		super( cause );
	}

	/**
	 * Constructs a new RollbackException exception with the specified detail message
	 *
	 * @param message The detail message
	 */
	public RollbackException(String message) {
		super( message );
	}

	/**
	 * Constructs a new RollbackException exception with the specified detail message and cause
	 *
	 * @param message The detail message
	 * @param cause The detail cause
	 */
	public RollbackException(String message, Throwable cause) {
		super( message, cause );
	}
}
