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

/** A <CODE>ServerSessionPool</CODE> object is an object implemented by an 
 * application server to provide a pool of <CODE>ServerSession</CODE> objects 
 * for processing the messages of a <CODE>ConnectionConsumer</CODE> (optional).
 *
 * <P>Its only method is <CODE>getServerSession</CODE>. The JMS API does not 
 * architect how the pool is implemented. It could be a static pool of 
 * <CODE>ServerSession</CODE> objects, or it could use a sophisticated 
 * algorithm to dynamically create <CODE>ServerSession</CODE> objects as 
 * needed.
 *
 * <P>If the <CODE>ServerSessionPool</CODE> is out of 
 * <CODE>ServerSession</CODE> objects, the <CODE>getServerSession</CODE> call 
 * may block. If a <CODE>ConnectionConsumer</CODE> is blocked, it cannot 
 * deliver new messages until a <CODE>ServerSession</CODE> is 
 * eventually returned.
 *
 * @see javax.jms.ServerSession
 */

public interface ServerSessionPool
{

   /** Return a server session from the pool.
    *
    * @return a server session from the pool
    *  
    * @exception JMSException if an application server fails to
    *                         return a <CODE>ServerSession</CODE> out of its
    *                         server session pool.
    */

   ServerSession getServerSession() throws JMSException;
}
