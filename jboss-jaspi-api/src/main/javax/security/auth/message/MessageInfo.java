/*
  * JBoss, Home of Professional Open Source
  * Copyright 2007, JBoss Inc., and individual contributors as indicated
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
package javax.security.auth.message;

import java.util.Map;

//$Id$

/**
 *  A message processing runtime uses this interface to pass messages and 
 *  message processing state to authentication contexts for processing by 
 *  authentication modules. 
 *  
 *  This interface encapsulates a request message object and a response 
 *  message object for a message exchange.
 *  
 *  This interface may also be used to associate additional context in the 
 *  form of key/value pairs, with the encapsulated messages. Every implementation 
 *  of this interface should provide a zero argument constructor, and a constructor 
 *  which takes a single Map argument. Additional constructors may also be provided. 
 *  @author Anil.Saldhana@redhat.com
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)
 *  @since  Jul 10, 2007 
 *  @version $Revision$
 */
public interface MessageInfo
{
   /**
    * Get (a reference to) the Map object of this MessageInfo. Operations performed 
    * on the acquired Map must effect the Map within the MessageInfo.
    * @return the Map object of this MessageInfo. This method never returns null. 
    * If a Map has not been associated with the MessageInfo, this method instantiates 
    * a Map, associates it with this MessageInfo, and then returns it.
    */
   Map getMap();
   
   /**
    * Get the request message object from this MessageInfo.
    * @return An object representing the request message, or null if no request message 
    * is set within the MessageInfo.
    */
   Object getRequestMessage();
   
   /**
    * Get the response message object from this MessageInfo.
    * @return an object representing the response message, or null if no response message 
    * is set within the MessageInfo.
    */
   Object getResponseMessage();
   
   /**
    * Set the request message object in this MessageInfo.
    * @param request An object representing the request message.
    */
   void setRequestMessage(Object request);
   
   /**
    * Set the response message object in this MessageInfo.
    * @param response An object representing the response message.
    */
   void setResponseMessage(Object response);
}
