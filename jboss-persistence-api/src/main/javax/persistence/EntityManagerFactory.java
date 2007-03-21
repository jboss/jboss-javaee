//$Id: EntityManagerFactory.java 11282 2007-03-14 22:05:59Z epbernard $
package javax.persistence;

import java.util.Map;

/**
 * The EntityManagerFactory interface is used by the application to obtain an
 * application-managed entity manager. When the application has finished using
 * the entity manager factory, and/or at application shutdown, the application
 * should close the entity manager factory. Once an EntityManagerFactory has been
 * closed, all its entity managers are considered to be in the closed state.
 *
 * @author Emmanuel Bernard
 */
public interface EntityManagerFactory {

	/**
	 * Create a new EntityManager.
	 * This method returns a new EntityManager instance each time
	 * it is invoked.
	 * The isOpen method will return true on the returned instance.
	 */
	EntityManager createEntityManager();

	/**
	 * Create a new EntityManager with the specified Map of
	 * properties.
	 * This method returns a new EntityManager instance each time
	 * it is invoked.
	 * The isOpen method will return true on the returned instance.
	 */
	EntityManager createEntityManager(Map map);

	/**
	 * Close the factory, releasing any resources that it holds.
	 * After a factory instance is closed, all methods invoked on
	 * it will throw an IllegalStateException, except for isOpen,
	 * which will return false. Once an EntityManagerFactory has
	 * been closed, all its entity managers are considered to be
	 * in the closed state.
	 */
	void close();

	/**
	 * Indicates whether or not this factory is open. Returns
	 * true until a call to close has been made.
	 */
	public boolean isOpen();
}