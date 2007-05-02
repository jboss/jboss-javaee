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
package javax.security.auth.message;

import java.util.Map;

/**
 *  <p>A message processing uses this interface to pass messages to authentication 
 *  contexts for processing by authentication modules.</p>
 *  
 *  <p>This interface encapsulates a request message object and a response message 
 *  object for a message exchange. This interface may also be used to associate 
 *  additional context in the form of key/value pairs, with the encapsulated messages.</p>
 *  
 *  <p>Every implementation of this interface should provide a zero argument 
 *  constructor, and a constructor which takes a single Map argument according to the 
 *  recommendations in the Map interface. Additional constructors may also be provided.</p>
 *  
 *  <p>An implementation of this interface need not make the request and response 
 *  message values available or setable via the methods of its Map interface.</p>
 *  
 *  <p>Implementations of this interface may vary in their support for key and value 
 *  types, fail-fast behavior, orderinvariance, and synchronization.</p> 
 *  
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana@jboss.org</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)
 *  @since  May 11, 2006 
 *  @version $Revision$
 */
public interface AuthParam extends Map
{
   /**
    * Get the request message object from this AuthParam.
    * @return an object representing the request message, or null if no request message 
    *         is set within the AuthParam.
    */
   public Object getRequestMessage();
   
   /**
    * Get the response message object from this AuthParam.
    * @return an object representing the response message, or null if no response 
    *         message is set within the AuthParam.
    */
   public Object getResponseMessage();
   
   /**
    * Set the request message object in this AuthParam.
    * @param request an object representing the request message.
    */
   public void setRequestMessage(Object request);
   
   /**
    * Set the response message object in this AuthParam.
    * @param response an object representing the response message.
    */
   public void setResponseMessage(Object response); 
}
