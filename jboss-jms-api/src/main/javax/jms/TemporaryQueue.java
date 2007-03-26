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

/** A <CODE>TemporaryQueue</CODE> object is a unique <CODE>Queue</CODE> object 
 * created for the duration of a <CODE>Connection</CODE>. It is a 
 * system-defined queue that can be consumed only by the 
 * <CODE>Connection</CODE> that created it.
 *
 *<P>A <CODE>TemporaryQueue</CODE> object can be created at either the 
 * <CODE>Session</CODE> or <CODE>QueueSession</CODE> level. Creating it at the
 * <CODE>Session</CODE> level allows to the <CODE>TemporaryQueue</CODE> to 
 * participate in transactions with objects from the Pub/Sub  domain. 
 * If it is created at the <CODE>QueueSession</CODE>, it will only
 * be able participate in transactions with objects from the PTP domain.
 *
 * @see Session#createTemporaryQueue()
 * @see QueueSession#createTemporaryQueue()
 */

public interface TemporaryQueue extends Queue
{

   /** Deletes this temporary queue. If there are existing receivers
    * still using it, a <CODE>JMSException</CODE> will be thrown.
    *  
    * @exception JMSException if the JMS provider fails to delete the 
    *                         temporary queue due to some internal error.
    */

   void delete() throws JMSException;
}
