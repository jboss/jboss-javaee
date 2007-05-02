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
package javax.security.auth.message.callback;

import javax.security.auth.callback.Callback;

//$Id$

/**
 *  Callback for secret key
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)
 *  @since  May 11, 2006 
 *  @version $Revision$
 */
public class SecretKeyCallback implements Callback
{
   /**
    * Marker interface for secret key request types.
    */
   public static interface Request
   { 
   }
   
   /**
    * Request type for secret keys that are identified via an alias.
    */
   public static class AliasRequest implements Request
   {
      private String alias = "Alias";
      
      /**
       * 
       * <p>Construct an AliasRequest with an alias.</p>
       * 
       * <p>The alias is used to directly identify the secret key to be returned.</p>
       * <p>If the alias is null, the handler of the callback relies on its own default.</p> 
       * @param alias name identifier for the secret key, or null
       */
      public AliasRequest(String alias)
      { 
         if(alias != null)
           this.alias = alias;
      }
      
      /**
       * Get the alias.
       * @return the alias, or null.
       */
      public String getAlias()
      {
         return alias;
      } 
   }
}
