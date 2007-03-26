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

/** A <CODE>Queue</CODE> object encapsulates a provider-specific queue name. 
 * It is the way a client specifies the identity of a queue to JMS API methods.
 * For those methods that use a <CODE>Destination</CODE> as a parameter, a 
 * <CODE>Queue</CODE> object used as an argument. For example, a queue can
 * be used  to create a <CODE>MessageConsumer</CODE> and a 
 * <CODE>MessageProducer</CODE>  by calling:
 *<UL>
 *<LI> <CODE>Session.CreateConsumer(Destination destination)</CODE>
 *<LI> <CODE>Session.CreateProducer(Destination destination)</CODE>
 *
 *</UL>
 *
 * <P>The actual length of time messages are held by a queue and the 
 * consequences of resource overflow are not defined by the JMS API.
 *
 * @see Session#createConsumer(Destination)
 * @see Session#createProducer(Destination)
 * @see Session#createQueue(String)
 * @see QueueSession#createQueue(String)
 */

public interface Queue extends Destination
{

   /** Gets the name of this queue.
    *  
    * <P>Clients that depend upon the name are not portable.
    *  
    * @return the queue name
    *  
    * @exception JMSException if the JMS provider implementation of 
    *                         <CODE>Queue</CODE> fails to return the queue
    *                         name due to some internal
    *                         error.
    */

   String getQueueName() throws JMSException;

   /** Returns a string representation of this object.
    *
    * @return the provider-specific identity values for this queue
    */

   String toString();
}
