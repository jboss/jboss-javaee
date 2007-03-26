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

/** The <CODE>XAConnectionFactory</CODE> interface is a base interface for the
 * <CODE>XAQueueConnectionFactory</CODE> and 
 * <CODE>XATopicConnectionFactory</CODE> interfaces.
 *
 * <P>Some application servers provide support for grouping JTS capable 
 * resource use into a distributed transaction (optional). To include JMS API transactions 
 * in a JTS transaction, an application server requires a JTS aware JMS
 * provider. A JMS provider exposes its JTS support using an
 * <CODE>XAConnectionFactory</CODE> object, which an application server uses 
 * to create <CODE>XAConnection</CODE> objects.
 *
 * <P><CODE>XAConnectionFactory</CODE> objects are JMS administered objects, 
 * just like <CODE>ConnectionFactory</CODE> objects. It is expected that 
 * application servers will find them using the Java Naming and Directory
 * Interface (JNDI) API.
 *
 *<P>The <CODE>XAConnectionFactory</CODE> interface is optional. JMS providers 
 * are not required to support this interface. This interface is for 
 * use by JMS providers to support transactional environments. 
 * Client programs are strongly encouraged to use the transactional support
 * available in their environment, rather than use these XA
 * interfaces directly. 
 *
 * @see         javax.jms.XAQueueConnectionFactory
 * @see         javax.jms.XATopicConnectionFactory
 */

public interface XAConnectionFactory
{

   /** Creates an <CODE>XAConnection</CODE> with the default user identity.
    * The connection is created in stopped mode. No messages 
    * will be delivered until the <code>Connection.start</code> method
    * is explicitly called.
    *
    * @return a newly created <CODE>XAConnection</CODE>
    *
    * @exception JMSException if the JMS provider fails to create an XA  
    *                         connection due to some internal error.
    * @exception JMSSecurityException  if client authentication fails due to 
    *                         an invalid user name or password.
    * 
    * @since 1.1 
    */

   XAConnection createXAConnection() throws JMSException;

   /** Creates an XA  connection with the specified user identity.
    * The connection is created in stopped mode. No messages 
    * will be delivered until the <code>Connection.start</code> method
    * is explicitly called.
    *  
    * @param userName the caller's user name
    * @param password the caller's password
    *  
    * @return a newly created XA connection
    *
    * @exception JMSException if the JMS provider fails to create an XA  
    *                         connection due to some internal error.
    * @exception JMSSecurityException  if client authentication fails due to 
    *                         an invalid user name or password.
    *
    * @since 1.1 
    */

   XAConnection createXAConnection(String userName, String password) throws JMSException;
}
