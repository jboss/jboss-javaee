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

import java.util.Enumeration;

/** A <CODE>ConnectionMetaData</CODE> object provides information describing the 
 * <CODE>Connection</CODE> object.
 */

public interface ConnectionMetaData
{

   /** Gets the JMS API version.
    *
    * @return the JMS API version
    *  
    * @exception JMSException if the JMS provider fails to retrieve the
    *                         metadata due to some internal error.
    */
   public String getJMSVersion() throws JMSException;

   /** Gets the JMS major version number.
    *  
    * @return the JMS API major version number
    *  
    * @exception JMSException if the JMS provider fails to retrieve the
    *                         metadata due to some internal error.
    */
   public int getJMSMajorVersion() throws JMSException;

   /** Gets the JMS minor version number.
    *  
    * @return the JMS API minor version number
    *  
    * @exception JMSException if the JMS provider fails to retrieve the
    *                         metadata due to some internal error.
    */
   public int getJMSMinorVersion() throws JMSException;

   /** Gets the JMS provider name.
    *
    * @return the JMS provider name
    *  
    * @exception JMSException if the JMS provider fails to retrieve the
    *                         metadata due to some internal error.
    */
   public String getJMSProviderName() throws JMSException;

   /** Gets the JMS provider version.
    *
    * @return the JMS provider version
    *  
    * @exception JMSException if the JMS provider fails to retrieve the
    *                         metadata due to some internal error.
    */
   public String getProviderVersion() throws JMSException;

   /** Gets the JMS provider major version number.
    *  
    * @return the JMS provider major version number
    *  
    * @exception JMSException if the JMS provider fails to retrieve the
    *                         metadata due to some internal error.
    */
   public int getProviderMajorVersion() throws JMSException;

   /** Gets the JMS provider minor version number.
    *  
    * @return the JMS provider minor version number
    *  
    * @exception JMSException if the JMS provider fails to retrieve the
    *                         metadata due to some internal error.
    */
   public int getProviderMinorVersion() throws JMSException;

   /** Gets an enumeration of the JMSX property names.
    *  
    * @return an Enumeration of JMSX property names
    *  
    * @exception JMSException if the JMS provider fails to retrieve the
    *                         metadata due to some internal error.
    */
   public Enumeration getJMSXPropertyNames() throws JMSException;
}
