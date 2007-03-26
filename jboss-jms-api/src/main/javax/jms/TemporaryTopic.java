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

/** A <CODE>TemporaryTopic</CODE> object is a unique <CODE>Topic</CODE> object 
 * created for the duration of a <CODE>Connection</CODE>. It is a 
 * system-defined topic that can be consumed only by the 
 * <CODE>Connection</CODE> that created it.
 *
 *<P>A <CODE>TemporaryTopic</CODE> object can be created either at the 
 * <CODE>Session</CODE> or <CODE>TopicSession</CODE> level. Creating it at the
 * <CODE>Session</CODE> level allows the <CODE>TemporaryTopic</CODE> to participate
 * in the same transaction with objects from the PTP domain. 
 * If a <CODE>TemporaryTopic</CODE> is  created at the 
 * <CODE>TopicSession</CODE>, it will only
 * be able participate in transactions with objects from the Pub/Sub domain.
 *
 * @see Session#createTemporaryTopic()
 * @see TopicSession#createTemporaryTopic()
 */

public interface TemporaryTopic extends Topic
{

   /** Deletes this temporary topic. If there are existing subscribers
    * still using it, a <CODE>JMSException</CODE> will be thrown.
    *  
    * @exception JMSException if the JMS provider fails to delete the
    *                         temporary topic due to some internal error.
    */

   void delete() throws JMSException;
}
