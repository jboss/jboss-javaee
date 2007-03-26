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

/** For application servers, <CODE>Connection</CODE> objects provide a special 
 * facility 
 * for creating a <CODE>ConnectionConsumer</CODE> (optional). The messages it 
 * is to consume are 
 * specified by a <CODE>Destination</CODE> and a message selector. In addition,
 * a <CODE>ConnectionConsumer</CODE> must be given a 
 * <CODE>ServerSessionPool</CODE> to use for 
 * processing its messages.
 *
 * <P>Normally, when traffic is light, a <CODE>ConnectionConsumer</CODE> gets a
 * <CODE>ServerSession</CODE> from its pool, loads it with a single message, and
 * starts it. As traffic picks up, messages can back up. If this happens, 
 * a <CODE>ConnectionConsumer</CODE> can load each <CODE>ServerSession</CODE>
 * with more than one 
 * message. This reduces the thread context switches and minimizes resource 
 * use at the expense of some serialization of message processing.
 *
 * @see javax.jms.Connection#createConnectionConsumer
 * @see javax.jms.Connection#createDurableConnectionConsumer
 * @see javax.jms.QueueConnection#createConnectionConsumer
 * @see javax.jms.TopicConnection#createConnectionConsumer
 * @see javax.jms.TopicConnection#createDurableConnectionConsumer
 */

public interface ConnectionConsumer
{

   /** Gets the server session pool associated with this connection consumer.
    *  
    * @return the server session pool used by this connection consumer
    *  
    * @exception JMSException if the JMS provider fails to get the server 
    *                         session pool associated with this consumer due
    *                         to some internal error.
    */
   public ServerSessionPool getServerSessionPool() throws JMSException;

   /** Closes the connection consumer.
    *
    * <P>Since a provider may allocate some resources on behalf of a 
    * connection consumer outside the Java virtual machine, clients should 
    * close these resources when
    * they are not needed. Relying on garbage collection to eventually 
    * reclaim these resources may not be timely enough.
    *  
    * @exception JMSException if the JMS provider fails to release resources 
    *                         on behalf of the connection consumer or fails
    *                         to close the connection consumer.
    */
   public void close() throws JMSException;
}
