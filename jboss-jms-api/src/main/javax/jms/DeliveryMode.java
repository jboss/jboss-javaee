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

/** The delivery modes supported by the JMS API are <CODE>PERSISTENT</CODE> and
 * <CODE>NON_PERSISTENT</CODE>.
 *
 * <P>A client marks a message as persistent if it feels that the 
 * application will have problems if the message is lost in transit.
 * A client marks a message as non-persistent if an occasional
 * lost message is tolerable. Clients use delivery mode to tell a
 * JMS provider how to balance message transport reliability with throughput.
 *
 * <P>Delivery mode covers only the transport of the message to its 
 * destination. Retention of a message at the destination until
 * its receipt is acknowledged is not guaranteed by a <CODE>PERSISTENT</CODE> 
 * delivery mode. Clients should assume that message retention 
 * policies are set administratively. Message retention policy
 * governs the reliability of message delivery from destination
 * to message consumer. For example, if a client's message storage 
 * space is exhausted, some messages may be dropped in accordance with 
 * a site-specific message retention policy.
 *
 * <P>A message is guaranteed to be delivered once and only once
 * by a JMS provider if the delivery mode of the message is 
 * <CODE>PERSISTENT</CODE> 
 * and if the destination has a sufficient message retention policy.
 *
 */
public interface DeliveryMode
{

   /** This is the lowest-overhead delivery mode because it does not require 
    * that the message be logged to stable storage. The level of JMS provider
    * failure that causes a <CODE>NON_PERSISTENT</CODE> message to be lost is 
    * not defined.
    *
    * <P>A JMS provider must deliver a <CODE>NON_PERSISTENT</CODE> message 
    * with an 
    * at-most-once guarantee. This means that it may lose the message, but it 
    * must not deliver it twice.
    */

   static final int NON_PERSISTENT = 1;

   /** This delivery mode instructs the JMS provider to log the message to stable 
    * storage as part of the client's send operation. Only a hard media 
    * failure should cause a <CODE>PERSISTENT</CODE> message to be lost.
    */

   static final int PERSISTENT = 2;
}
