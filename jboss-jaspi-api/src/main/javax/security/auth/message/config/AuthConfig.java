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
package javax.security.auth.message.config;

import javax.security.auth.message.AuthException;
import javax.security.auth.message.AuthParam;

//$Id$

/**
 *  <p>This interface defines the common functionality implemented by 
 *  Authentication context configuration objects.</p>
 *  
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)</a> 
 *  @since  May 12, 2006 
 *  @version $Revision$
 */
public interface AuthConfig
{
   /**
    * Get the application context identifier of this authentication context 
    * configuration object.
    * @return the String identifying the application context of this configuration 
    *         object or null if the configuration object pertains to an unspecified 
    *         application context.
    */
   String getContextID();
   
   /**
    * Get the message layer name of this authentication context configuration object.
    * @return the message layer name of this configuration object, or null if the 
    *         configuration object pertains to an unspecified message layer.
    */
   String getMessageLayer();
   
   /**
    * Get the operation identifier corresponding to the request and response objects 
    * encapsulated in authParam.
    * 
    * @param authParam an AuthParam containing the messages for which the corresponding 
    *                  operation is to be determined.
    * @return the operation identifier related to the encapsulated request and response 
    *                 objects, or null.
    * @throws java.lang.IllegalArgumentException - if the type of the message objects 
    *                incorporated in authParam are not compatible with the message types 
    *                supported by this authentication context configuration object.
    */
   String getOperation(AuthParam authParam);
   
   /**
    * Causes a dynamic anthentication context configuration object to update its internal 
    * state and such that any change to its state is recognized by any authentication 
    * context objects that were previously obtained from the config object.
    * @throws AuthException if an error occured during the update.
    * @throws SecurityException if the caller does not have permission to refresh 
    *                           the configuration object.
    */
   void refresh() throws AuthException, SecurityException;
}
