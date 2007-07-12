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

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;

//$Id$

/**
 *  Callback for PasswordValidation.
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)
 *  @since  May 11, 2006 
 *  @version $Revision$
 */
public class PasswordValidationCallback implements Callback
{
   private String username;
   private char[] password;
   
   private boolean resultOfAuthentication = false;
   private Subject subject;
   
   /** 
    * Create a new PasswordValidationCallback.
    * 
    * @param username the username to authenticate
    * @param password the user’s password, which may be null.
    */
   public PasswordValidationCallback(Subject subject, String username, char[] password)
   {
      this.subject = subject;
      this.username = username;
      this.password = password;
   }
   
   /**
    *  Clear the password.
    */
   public void clearPassword()
   {
      this.password = null;
   }
   
   /**
    * Get the password.
    * <b>Note</b> that this method returns a reference to the password. If a clone 
    * of the array is created it is the caller’s responsibility to zero out 
    * the password information after it is no longer needed.
    * 
    * @return the password, which may be null.
    */
   public char[] getPassword()
   {
      return this.password;
   }
   
   public Subject getSubject()
   {
      return this.subject;
   }
   
   /**
    * Get the authentication result. 
    * @return true if authentication succeeded, false otherwise
    */
   public boolean getResult()
   {
      return this.resultOfAuthentication;
   }
   
   /**
    * Get the username.   
    * @return the username.
    */
   public String getUsername()
   {
      return this.username;
   }
   
   /**
    * Set the authentication result.
    * 
    * @param result true if authentication succeeded, false otherwise
    */
   public void setResult(boolean result)
   {
      this.resultOfAuthentication = result;
   } 
}
