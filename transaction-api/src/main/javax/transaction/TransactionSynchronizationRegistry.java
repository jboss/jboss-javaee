/*
* JBoss, Home of Professional Open Source
* Copyright 2006, JBoss Inc., and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package javax.transaction;

/**
 * TransactionSynchronizationRegistry.
 * 
 * @author <a href="adrian@jboss.com">Adrian Brock</a>
 * @version $Revision$
 */
public interface TransactionSynchronizationRegistry
{
   /**
    * An object that has the same equals/hashCode behaviour
    * as the transaction currently associated with the thread
    * 
    * @return the key or null if there is no current transaction
    */
   Object getTransactionKey();
   
   /**
    * Get the transaction status of the current thread
    * 
    * @return the status
    */
   int getTransactionStatus();

   /**
    * Get the rollback status of the transaction associated with the
    * current thread.
    * 
    * @return true when the transaction is rollback only
    * @throws IllegalStateException if there is no current transaction
    */
   boolean getRollbackOnly() throws IllegalStateException;

   /**
    * Set the transaction associated with the current thread to force a rollback
    * 
    * @throws IllegalStateException if there is no current transaction
    */
   void setRollbackOnly() throws IllegalStateException;

   /**
    * Add a transaction synchronization that is invoked "last",
    * i.e. after SessionSynchronizations and directly registered transaction synchronizations.<p>
    * 
    * The beforeCompletion is invoked in the context of the transaction,
    * the afterCompletion in an undefined transaction context.
    * Other context is the same as when the one used to register the synchronization.<p>
    * 
    * Access to "user components" is not allowed, e.g. ejb bean methods.<p>
    * 
    * Access to other resources, e.g. jca, is allowed in the beforeCompletion,
    * but not transactional work is allowed in the afterCompletion. e.g.
    * typically only "close()" is allowed.
    * 
    * @param sync the synchronization
    * @throws IllegalStateException if there is no current transaction
    */
   void registerInterposedSynchronization(Synchronization sync) throws IllegalStateException;
   
   /**
    * Get a transaction local for the current transaction
    * 
    * @param key the key to the value
    * @return the value
    * @throws IllegalStateException if there is no current transaction
    * @throws NullPointerException if the key is null
    */
   Object getResource(Object key) throws IllegalStateException;
   
   /**
    * Set a transaction local for the current transaction
    * 
    * @param key the key to the value
    * @param value the value
    * @throws IllegalStateException if there is no current transaction
    * @throws NullPointerException if the key is null
    */
   void putResource(Object key, Object value) throws IllegalStateException;
}
