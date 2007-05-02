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

//$Id$

import javax.security.auth.login.LoginException;

/**
 *  <p>A generic authentication exception.</p>
 *  @see LoginException
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana@jboss.org</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)
 *  @since  Dec 5, 2005
 */
public class AuthException extends LoginException
{
   /** The serialVersionUID */
   private static final long serialVersionUID = -1424234495120552796L;

   /**
    * Constructs an AuthException with no detail message. 
    * A detail message is a String that describes this particular exception. 
    */
   public AuthException()
   {
      super(); 
   }

   /**
    * Constructs an AuthException with the specified detail message. A detail 
    * message is a String that describes this particular exception.
    * 
    * @param msg the detail message.
    */
   public AuthException(String msg)
   {
      super(msg); 
   }
  
}
