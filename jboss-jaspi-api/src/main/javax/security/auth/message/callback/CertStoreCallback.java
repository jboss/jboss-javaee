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

import java.security.cert.CertStore;

import javax.security.auth.callback.Callback;

//$Id$

/**
 *  Callback for CertStore.
 *  A CertStore is a generic repository for certificates. 
 *  CertStores may be searched to locate public key certificates, as well 
 *  as to put together certificate chains. Such a search may be necessary 
 *  when the caller needs to verify a signature.
 *  
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)
 *  @since  May 11, 2006 
 *  @version $Revision$
 */
public class CertStoreCallback implements Callback
{
   private CertStore certStore;
   
   /**
    *  Create a CertStoreCallback. 
    */
   public CertStoreCallback()
   { 
   }

   /**
    *  Get the requested CertStore.
    * 
    * @return the CertStore, or null. If null, the requester is assumed to 
    * already have access to the relevant certificate and/or chain.
    */
   public CertStore getCertStore()
   {
      return certStore;
   }

   /** 
    * Set the CertStore.
    * @param certStore the certificate store, which may be null If null, the 
    * requester is assumed to already have access to the relevant certificate 
    * and/or chain.
    */
   public void setCertStore(CertStore certStore)
   {
      this.certStore = certStore;
   } 
}
