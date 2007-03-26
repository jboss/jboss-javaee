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

/** If a JMS provider detects a serious problem with a <CODE>Connection</CODE>
 * object, it informs the <CODE>Connection</CODE> object's 
 * <CODE>ExceptionListener</CODE>, if one has been registered. 
 * It does this by calling the listener's <CODE>onException</CODE> method, 
 * passing it a <CODE>JMSException</CODE> argument describing the problem.
 *
 * <P>An exception listener allows a client to be notified of a problem 
 * asynchronously. Some connections only consume messages, so they would have no
 * other way to learn that their connection has failed.
 *
 * <P>A JMS provider should attempt to resolve connection problems 
 * itself before it notifies the client of them.
 *
 * @see javax.jms.Connection#setExceptionListener(ExceptionListener)
 */

public interface ExceptionListener
{

   /** Notifies user of a JMS exception.
    *
    * @param exception the JMS exception
    */

   void onException(JMSException exception);
}
