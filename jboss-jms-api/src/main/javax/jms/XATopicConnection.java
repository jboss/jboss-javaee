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

/** An <CODE>XATopicConnection</CODE> provides the same create options as 
 * <CODE>TopicConnection</CODE> (optional). The Topic connections created are
 * transactional.
 *
 * <P>The <CODE>XATopicConnection</CODE> interface is optional.  JMS providers 
 * are not required to support this interface. This interface is for 
 * use by JMS providers to support transactional environments. 
 * Client programs are strongly encouraged to use the transactional support
 * available in their environment, rather than use these XA
 * interfaces directly. 
 *
 * @see         javax.jms.XAConnection
 */

public interface XATopicConnection extends XAConnection, TopicConnection
{

   /** Creates an <CODE>XATopicSession</CODE> object.
    *  
    * @return a newly created XA topic session
    *  
    * @exception JMSException if the <CODE>XATopicConnection</CODE> object
    *                         fails to create an XA topic session due to some 
    *                         internal error.
    */

   XATopicSession createXATopicSession() throws JMSException;

   /** Creates an <CODE>XATopicSession</CODE> object.
    *
    * @param transacted usage undefined
    * @param acknowledgeMode usage undefined
    *  
    * @return a newly created XA topic session
    *  
    * @exception JMSException if the <CODE>XATopicConnection</CODE> object
    *                         fails to create an XA topic session due to some 
    *                         internal error.
    */

   TopicSession createTopicSession(boolean transacted, int acknowledgeMode) throws JMSException;
}
