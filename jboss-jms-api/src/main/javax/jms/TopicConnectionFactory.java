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

/** A client uses a <CODE>TopicConnectionFactory</CODE> object to create 
 * <CODE>TopicConnection</CODE> objects with a publish/subscribe JMS provider.
 *
 * <P>A<CODE> TopicConnectionFactory</CODE> can be used to create a 
 * <CODE>TopicConnection</CODE>, from which specialized topic-related objects
 * can be  created. A more general, and recommended approach 
 * is to use the <CODE>ConnectionFactory</CODE> object.
 *  
 * <P> The <CODE>TopicConnectionFactory</CODE> object
 * should be used to support existing code.
 *
 * @see         javax.jms.ConnectionFactory
 */

public interface TopicConnectionFactory extends ConnectionFactory
{

   /** Creates a topic connection with the default user identity.
    * The connection is created in stopped mode. No messages 
    * will be delivered until the <code>Connection.start</code> method
    * is explicitly called.
    *
    * @return a newly created topic connection
    *
    * @exception JMSException if the JMS provider fails to create a topic 
    *                         connection due to some internal error.
    * @exception JMSSecurityException if client authentication fails due to 
    *                                 an invalid user name or password.
    */

   TopicConnection createTopicConnection() throws JMSException;

   /** Creates a topic connection with the specified user identity.
    * The connection is created in stopped mode. No messages 
    * will be delivered until the <code>Connection.start</code> method
    * is explicitly called.
    *  
    * @param userName the caller's user name
    * @param password the caller's password
    *  
    * @return a newly created topic connection
    *
    * @exception JMSException if the JMS provider fails to create a topic 
    *                         connection due to some internal error.
    * @exception JMSSecurityException if client authentication fails due to 
    *                                 an invalid user name or password.
    */

   TopicConnection createTopicConnection(String userName, String password) throws JMSException;
}
