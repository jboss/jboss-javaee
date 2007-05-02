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

import java.security.KeyStore;

import javax.security.auth.callback.Callback;

//$Id$

/**
 *  Callback for trusted certificate KeyStore.
 *  <p>A trusted certificate KeyStore may be used to determine whether a
 *  given certificate chain can be trusted.</p>
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)
 *  @since  May 11, 2006 
 *  @version $Revision$
 */
public class TrustStoreCallback implements Callback
{
   private KeyStore trustStore;

   /** 
    * Create a new TrustStoreCallback.
    */
   public TrustStoreCallback()
   { 
   }
   
   /**
    * Get the requested trusted certificate KeyStore.
    * @return the trusted certificate KeyStore. 
    *         The KeyStore is guaranteed to already be loaded.
    */
   public KeyStore getTrustStore()
   {
      return trustStore;
   }

   /**
    * Set the trusted certificate KeyStore.
    * @param trustStore the trusted certificate KeyStore, which 
    *           must already be loaded.
    */
   public void setTrustStore(KeyStore trustStore)
   {
      this.trustStore = trustStore;
   } 
}
