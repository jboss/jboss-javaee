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

/** An <CODE>XAQueueSession</CODE> provides a regular <CODE>QueueSession</CODE>,
 * which can be used to
 * create <CODE>QueueReceiver</CODE>, <CODE>QueueSender</CODE>, and 
 *<CODE>QueueBrowser</CODE> objects (optional).
 *
 * <P>The <CODE>XAQueueSession</CODE> interface is optional. JMS providers 
 * are not required to support this interface. This interface is for 
 * use by JMS providers to support transactional environments. 
 * Client programs are strongly encouraged to use the transactional support
 * available in their environment, rather than use these XA
 * interfaces directly. 
 *
 * @see         javax.jms.XASession
 */

public interface XAQueueSession extends XASession
{

   /** Gets the queue session associated with this <CODE>XAQueueSession</CODE>.
    *  
    * @return the queue session object
    *  
    * @exception JMSException if an internal error occurs.
    */

   QueueSession getQueueSession() throws JMSException;
}
