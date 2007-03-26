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

/** A <CODE>TopicConnection</CODE> object is an active connection to a 
 * publish/subscribe JMS provider. A client uses a <CODE>TopicConnection</CODE> 
 * object to create one or more <CODE>TopicSession</CODE> objects
 * for producing and consuming messages.
 *
 *<P>A <CODE>TopicConnection</CODE> can be used to create a 
 *<CODE>TopicSession</CODE>, from which
 * specialized topic-related objects can be created. 
 * A more general, and recommended approach is to use the 
 * <CODE>Connection</CODE> object. 
 *
 *
 * <P>The <CODE>TopicConnection</CODE> object
 * should be used to support existing code.
 *
 * @see         javax.jms.Connection
 * @see         javax.jms.ConnectionFactory
 * @see	 javax.jms.TopicConnectionFactory
 */

public interface TopicConnection extends Connection
{

   /** Creates a <CODE>TopicSession</CODE> object.
    *
    * @param transacted indicates whether the session is transacted
    * @param acknowledgeMode indicates whether the consumer or the
    * client will acknowledge any messages it receives; ignored if the session
    * is transacted. Legal values are <code>Session.AUTO_ACKNOWLEDGE</code>, 
    * <code>Session.CLIENT_ACKNOWLEDGE</code>, and 
    * <code>Session.DUPS_OK_ACKNOWLEDGE</code>. 
    *  
    * @return a newly created topic session
    *  
    * @exception JMSException if the <CODE>TopicConnection</CODE> object fails
    *                         to create a session due to some internal error or
    *                         lack of support for the specific transaction
    *                         and acknowledgement mode.
    *
    * @see Session#AUTO_ACKNOWLEDGE 
    * @see Session#CLIENT_ACKNOWLEDGE 
    * @see Session#DUPS_OK_ACKNOWLEDGE 
    */

   TopicSession createTopicSession(boolean transacted, int acknowledgeMode) throws JMSException;

   /** Creates a connection consumer for this connection (optional operation).
    * This is an expert facility not used by regular JMS clients.
    *  
    * @param topic the topic to access
    * @param messageSelector only messages with properties matching the
    * message selector expression are delivered.  A value of null or
    * an empty string indicates that there is no message selector  
    * for the message consumer.
    * @param sessionPool the server session pool to associate with this 
    * connection consumer
    * @param maxMessages the maximum number of messages that can be
    * assigned to a server session at one time
    *
    * @return the connection consumer
    *
    * @exception JMSException if the <CODE>TopicConnection</CODE> object fails
    *                         to create a connection consumer due to some
    *                         internal error or invalid arguments for 
    *                         <CODE>sessionPool</CODE> and 
    *                         <CODE>messageSelector</CODE>.
    * @exception InvalidDestinationException if an invalid topic is specified.
    * @exception InvalidSelectorException if the message selector is invalid.
    * @see javax.jms.ConnectionConsumer
    */

   ConnectionConsumer createConnectionConsumer(Topic topic, String messageSelector, ServerSessionPool sessionPool,
         int maxMessages) throws JMSException;

   /** Create a durable connection consumer for this connection (optional operation). 
    * This is an expert facility not used by regular JMS clients.
    *                
    * @param topic the topic to access
    * @param subscriptionName durable subscription name
    * @param messageSelector only messages with properties matching the
    * message selector expression are delivered.  A value of null or
    * an empty string indicates that there is no message selector 
    * for the message consumer.
    * @param sessionPool the server session pool to associate with this 
    * durable connection consumer
    * @param maxMessages the maximum number of messages that can be
    * assigned to a server session at one time
    *
    * @return the durable connection consumer
    *  
    * @exception JMSException if the <CODE>TopicConnection</CODE> object fails
    *                         to create a connection consumer due to some
    *                         internal error or invalid arguments for 
    *                         <CODE>sessionPool</CODE> and 
    *                         <CODE>messageSelector</CODE>.
    * @exception InvalidDestinationException if an invalid topic is specified.
    * @exception InvalidSelectorException if the message selector is invalid.
    * @see javax.jms.ConnectionConsumer
    */

   ConnectionConsumer createDurableConnectionConsumer(Topic topic, String subscriptionName, String messageSelector,
         ServerSessionPool sessionPool, int maxMessages) throws JMSException;
}
