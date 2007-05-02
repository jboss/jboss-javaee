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

import java.security.Principal;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;

//$Id$

/**
 *  Callback for setting the container’s caller (or Remote user) principal.
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)
 *  @since  May 11, 2006 
 *  @version $Revision$
 */
public class DistinguishedPrincipalCallback implements Callback
{
   private Subject subject = null;
   private Principal principal = null;
   
   /** 
    * Create a new DistinguishedPrincipalCallback.
    * 
    * @param subject the Subject in which the container will distinguish the principal
    * @param principal the Principal that will be distinguished.
    */
   public DistinguishedPrincipalCallback(Subject subject,Principal principal)
   {
      this.subject = subject;
      this.principal = principal;
   }

   /**
    * Get the principal.  
    * @return the principal.
    */
   public Principal getPrincipal()
   {
      return principal;
   }

   /**
    * Get the Subject. 
    * @return the subject.
    */
   public Subject getSubject()
   {
      return subject;
   } 
}
