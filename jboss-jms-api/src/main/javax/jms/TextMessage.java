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

/** A <CODE>TextMessage</CODE> object is used to send a message containing a 
 * <CODE>java.lang.String</CODE>.
 * It inherits from the <CODE>Message</CODE> interface and adds a text message 
 * body.
 *
 * <P>This message type can be used to transport text-based messages, including
 *  those with XML content.
 *
 * <P>When a client receives a <CODE>TextMessage</CODE>, it is in read-only 
 * mode. If a client attempts to write to the message at this point, a 
 * <CODE>MessageNotWriteableException</CODE> is thrown. If 
 * <CODE>clearBody</CODE> is 
 * called, the message can now be both read from and written to.
 *
 * @see         javax.jms.Session#createTextMessage()
 * @see         javax.jms.Session#createTextMessage(String)
 * @see         javax.jms.BytesMessage
 * @see         javax.jms.MapMessage
 * @see         javax.jms.Message
 * @see         javax.jms.ObjectMessage
 * @see         javax.jms.StreamMessage
 * @see         java.lang.String
 */

public interface TextMessage extends Message
{

   /** Sets the string containing this message's data.
    *  
    * @param string the <CODE>String</CODE> containing the message's data
    *  
    * @exception JMSException if the JMS provider fails to set the text due to
    *                         some internal error.
    * @exception MessageNotWriteableException if the message is in read-only 
    *                                         mode.
    */

   void setText(String string) throws JMSException;

   /** Gets the string containing this message's data.  The default
    * value is null.
    *  
    * @return the <CODE>String</CODE> containing the message's data
    *  
    * @exception JMSException if the JMS provider fails to get the text due to
    *                         some internal error.
    */

   String getText() throws JMSException;
}
