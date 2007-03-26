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

/** A <CODE>QueueConnection</CODE> object is an active connection to a 
 * point-to-point JMS provider. A client uses a <CODE>QueueConnection</CODE> 
 * object to create one or more <CODE>QueueSession</CODE> objects
 * for producing and consuming messages.
 *
 *<P>A <CODE>QueueConnection</CODE> can be used to create a
 * <CODE>QueueSession</CODE>, from which specialized  queue-related objects
 * can be created.
 * A more general, and recommended, approach is to use the 
 * <CODE>Connection</CODE> object.
 * 
 *
 * <P>The <CODE>QueueConnection</CODE> object
 * should be used to support existing code that has already used it.
 *
 * <P>A <CODE>QueueConnection</CODE> cannot be used to create objects 
 * specific to the   publish/subscribe domain. The
 * <CODE>createDurableConnectionConsumer</CODE> method inherits
 * from  <CODE>Connection</CODE>, but must throw an 
 * <CODE>IllegalStateException</CODE>
 * if used from <CODE>QueueConnection</CODE>.
 *
 * @see         javax.jms.Connection
 * @see         javax.jms.ConnectionFactory
 * @see	 javax.jms.QueueConnectionFactory
 */

public interface QueueConnection extends Connection
{

   /** Creates a <CODE>QueueSession</CODE> object.
    *  
    * @param transacted indicates whether the session is transacted
    * @param acknowledgeMode indicates whether the consumer or the
    * client will acknowledge any messages it receives; ignored if the session
    * is transacted. Legal values are <code>Session.AUTO_ACKNOWLEDGE</code>, 
    * <code>Session.CLIENT_ACKNOWLEDGE</code>, and 
    * <code>Session.DUPS_OK_ACKNOWLEDGE</code>.
    *  
    * @return a newly created queue session
    *  
    * @exception JMSException if the <CODE>QueueConnection</CODE> object fails
    *                         to create a session due to some internal error or
    *                         lack of support for the specific transaction
    *                         and acknowledgement mode.
    *
    * @see Session#AUTO_ACKNOWLEDGE 
    * @see Session#CLIENT_ACKNOWLEDGE 
    * @see Session#DUPS_OK_ACKNOWLEDGE 
    */

   QueueSession createQueueSession(boolean transacted, int acknowledgeMode) throws JMSException;

   /** Creates a connection consumer for this connection (optional operation).
    * This is an expert facility not used by regular JMS clients.
    *
    * @param queue the queue to access
    * @param messageSelector only messages with properties matching the
    * message selector expression are delivered. A value of null or
    * an empty string indicates that there is no message selector 
    * for the message consumer.
    * @param sessionPool the server session pool to associate with this 
    * connection consumer
    * @param maxMessages the maximum number of messages that can be
    * assigned to a server session at one time
    *
    * @return the connection consumer
    *  
    * @exception JMSException if the <CODE>QueueConnection</CODE> object fails
    *                         to create a connection consumer due to some
    *                         internal error or invalid arguments for 
    *                         <CODE>sessionPool</CODE> and 
    *                         <CODE>messageSelector</CODE>.
    * @exception InvalidDestinationException if an invalid queue is specified.
    * @exception InvalidSelectorException if the message selector is invalid.
    * @see javax.jms.ConnectionConsumer
    */

   ConnectionConsumer createConnectionConsumer(Queue queue, String messageSelector, ServerSessionPool sessionPool,
         int maxMessages) throws JMSException;
}
