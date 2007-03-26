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

/** A client uses a <CODE>QueueReceiver</CODE> object to receive messages that 
 * have been delivered to a queue.
 *
 * <P>Although it is possible to have multiple <CODE>QueueReceiver</CODE>s 
 * for the same queue, the JMS API does not define how messages are 
 * distributed between the <CODE>QueueReceiver</CODE>s.
 *
 * <P>If a <CODE>QueueReceiver</CODE> specifies a message selector, the 
 * messages that are not selected remain on the queue. By definition, a message
 * selector allows a <CODE>QueueReceiver</CODE> to skip messages. This 
 * means that when the skipped messages are eventually read, the total ordering
 * of the reads does not retain the partial order defined by each message 
 * producer. Only <CODE>QueueReceiver</CODE>s without a message selector
 * will read messages in message producer order.
 *
 * <P>Creating a <CODE>MessageConsumer</CODE> provides the same features as
 * creating a <CODE>QueueReceiver</CODE>. A <CODE>MessageConsumer</CODE> object is 
 * recommended for creating new code. The  <CODE>QueueReceiver</CODE> is
 * provided to support existing code.
 *
 * @see         javax.jms.Session#createConsumer(Destination, String)
 * @see         javax.jms.Session#createConsumer(Destination)
 * @see         javax.jms.QueueSession#createReceiver(Queue, String)
 * @see         javax.jms.QueueSession#createReceiver(Queue)
 * @see         javax.jms.MessageConsumer
 */

public interface QueueReceiver extends MessageConsumer
{

   /** Gets the <CODE>Queue</CODE> associated with this queue receiver.
    *  
    * @return this receiver's <CODE>Queue</CODE> 
    *  
    * @exception JMSException if the JMS provider fails to get the queue for
    *                         this queue receiver
    *                         due to some internal error.
    */

   Queue getQueue() throws JMSException;
}
