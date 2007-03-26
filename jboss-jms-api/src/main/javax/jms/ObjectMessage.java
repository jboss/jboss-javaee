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

import java.io.Serializable;

/** An <CODE>ObjectMessage</CODE> object is used to send a message that contains
 * a serializable object in the Java programming language ("Java object").
 * It inherits from the <CODE>Message</CODE> interface and adds a body
 * containing a single reference to an object. Only <CODE>Serializable</CODE> 
 * Java objects can be used.
 *
 * <P>If a collection of Java objects must be sent, one of the 
 * <CODE>Collection</CODE> classes provided since JDK 1.2 can be used.
 *
 * <P>When a client receives an <CODE>ObjectMessage</CODE>, it is in read-only 
 * mode. If a client attempts to write to the message at this point, a 
 * <CODE>MessageNotWriteableException</CODE> is thrown. If 
 * <CODE>clearBody</CODE> is called, the message can now be both read from and 
 * written to.
 *
 * @see         javax.jms.Session#createObjectMessage()
 * @see         javax.jms.Session#createObjectMessage(Serializable)
 * @see         javax.jms.BytesMessage
 * @see         javax.jms.MapMessage
 * @see         javax.jms.Message
 * @see         javax.jms.StreamMessage
 * @see         javax.jms.TextMessage
 */

public interface ObjectMessage extends Message
{

   /** Sets the serializable object containing this message's data.
    * It is important to note that an <CODE>ObjectMessage</CODE>
    * contains a snapshot of the object at the time <CODE>setObject()</CODE>
    * is called; subsequent modifications of the object will have no 
    * effect on the <CODE>ObjectMessage</CODE> body.
    *
    * @param object the message's data
    *  
    * @exception JMSException if the JMS provider fails to set the object
    *                         due to some internal error.
    * @exception MessageFormatException if object serialization fails.
    * @exception MessageNotWriteableException if the message is in read-only
    *                                         mode.
    */

   void setObject(Serializable object) throws JMSException;

   /** Gets the serializable object containing this message's data. The 
    * default value is null.
    *
    * @return the serializable object containing this message's data
    *  
    * @exception JMSException if the JMS provider fails to get the object
    *                         due to some internal error.
    * @exception MessageFormatException if object deserialization fails.
    */

   Serializable getObject() throws JMSException;
}
