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
package javax.security.auth.message.callback;

import java.security.Principal;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;

//$Id$

/**
 *  
 *  @author Anil.Saldhana@redhat.com
 *  @since  Jul 11, 2007 
 *  @version $Revision$
 */
public class CallerPrincipalCallback implements Callback
{
   private Subject subject;
   private Principal principal;
   private String name;

   public CallerPrincipalCallback(javax.security.auth.Subject s, java.security.Principal p)
   {
      this.subject = s;
      this.principal = p;
   }
   
   public CallerPrincipalCallback(javax.security.auth.Subject s, java.lang.String n)
   {
      this.subject = s;
      this.name = n;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public Principal getPrincipal()
   {
      return this.principal;
   }
   
   public Subject getSubject()
   {
      return this.subject;
   }
}
