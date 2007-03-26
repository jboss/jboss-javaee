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

/** An <CODE>XATopicConnectionFactory</CODE> provides the same create options as 
 * a <CODE>TopicConnectionFactory</CODE> (optional).
 *
 * <P>The <CODE>XATopicConnectionFactory</CODE> interface is optional.  JMS providers 
 * are not required to support this interface. This interface is for 
 * use by JMS providers to support transactional environments. 
 * Client programs are strongly encouraged to use the transactional support
 * available in their environment, rather than use these XA
 * interfaces directly. 
 *
 * @see         javax.jms.TopicConnectionFactory
 * @see         javax.jms.XAConnectionFactory
 */

public interface XATopicConnectionFactory extends XAConnectionFactory, TopicConnectionFactory
{

   /** Creates an XA topic connection with the default user identity.
    * The connection is created in stopped mode. No messages 
    * will be delivered until the <code>Connection.start</code> method
    * is explicitly called.
    *
    * @return a newly created XA topic connection
    *
    * @exception JMSException if the JMS provider fails to create an XA topic 
    *                         connection due to some internal error.
    * @exception JMSSecurityException  if client authentication fails due to 
    *                         an invalid user name or password.
    */
   public XATopicConnection createXATopicConnection() throws JMSException;

   /** Creates an XA topic connection with the specified user identity.
    * The connection is created in stopped mode. No messages 
    * will be delivered until the <code>Connection.start</code> method
    * is explicitly called.
    *  
    * @param userName the caller's user name
    * @param password the caller's password
    *  
    * @return a newly created XA topic connection
    *
    * @exception JMSException if the JMS provider fails to create an XA topic 
    *                         connection due to some internal error.
    * @exception JMSSecurityException  if client authentication fails due to 
    *                         an invalid user name or password.
    */
   public XATopicConnection createXATopicConnection(String userName, String password) throws JMSException;
}
