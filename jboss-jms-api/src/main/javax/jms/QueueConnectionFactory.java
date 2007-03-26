/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005, JBoss Inc., and individual contributors as indicated
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
package javax.jms;

/** A client uses a <CODE>QueueConnectionFactory</CODE> object to create 
 * <CODE>QueueConnection</CODE> objects with a point-to-point JMS provider.
 *
 * <P><CODE>QueueConnectionFactory</CODE> can be used to create a 
 * <CODE>QueueConnection</CODE>, from which specialized queue-related objects
 * can be  created. A more general, and recommended,  approach 
 * is to use the <CODE>ConnectionFactory</CODE> object.
 *
 *<P> The <CODE>QueueConnectionFactory</CODE> object
 * can be used to support existing code that already uses it.
 *
 * @see         javax.jms.ConnectionFactory
 */

public interface QueueConnectionFactory extends ConnectionFactory
{

   /** Creates a queue connection with the default user identity.
    * The connection is created in stopped mode. No messages 
    * will be delivered until the <code>Connection.start</code> method
    * is explicitly called.
    *
    .
    *
    * @return a newly created queue connection
    *
    * @exception JMSException if the JMS provider fails to create the queue 
    *                         connection due to some internal error.
    * @exception JMSSecurityException  if client authentication fails due to 
    *                         an invalid user name or password.
    */

   QueueConnection createQueueConnection() throws JMSException;

   /** Creates a queue connection with the specified user identity.
    * The connection is created in stopped mode. No messages 
    * will be delivered until the <code>Connection.start</code> method
    * is explicitly called.
    *  
    * @param userName the caller's user name
    * @param password the caller's password
    *  
    * @return a newly created queue connection
    *
    * @exception JMSException if the JMS provider fails to create the queue 
    *                         connection due to some internal error.
    * @exception JMSSecurityException  if client authentication fails due to 
    *                         an invalid user name or password.
    */

   QueueConnection createQueueConnection(String userName, String password) throws JMSException;
}
