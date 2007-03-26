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

/** A <CODE>MessageListener</CODE> object is used to receive asynchronously 
 * delivered messages.
 *
 * <P>Each session must insure that it passes messages serially to the
 * listener. This means that a listener assigned to one or more consumers
 * of the same session can assume that the <CODE>onMessage</CODE> method 
 * is not called with the next message until the session has completed the 
 * last call.
 */

public interface MessageListener
{

   /** Passes a message to the listener.
    *
    * @param message the message passed to the listener
    */

   void onMessage(Message message);
}
