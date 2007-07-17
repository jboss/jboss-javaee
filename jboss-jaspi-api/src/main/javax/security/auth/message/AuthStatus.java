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

/**
 *  <p>The AuthStatus class is used to represent return values from 
 *  Authentication modules.</p> 
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)
 *  @since  May 11, 2006 
 *  @version $Revision$
 */
public class AuthStatus
{ 
   /**
    * Indicates that the message processing by the authentication module 
    * was NOT successful, and that the module replaced the application 
    * message with an error message.
    */
   public static final AuthStatus FAILURE = new AuthStatus(-1); 
   
   /**
    * Indicates the message processing by the authentication module is 
    * NOT complete, that the module replaced the application message 
    * with a security message, and that the runtime is to proceed by 
    * sending the security message.
    */
   public static final AuthStatus SEND_CONTINUE = new AuthStatus(3);
   
   /**
    * Indicates that the message processing by the authentication module
    * was NOT successful, that the module replaced the application message 
    * with an error message, and that the runtime is to proceed by sending 
    * the error message.
    */
   public static final AuthStatus SEND_FAILURE =  new AuthStatus(-2);
   
   /** Indicates that the message processing by the authentication module 
    * was successful and that the runtime is to proceed by sending a message 
    * returned by the authentication module.
   */
   public static final AuthStatus SEND_SUCCESS = new AuthStatus(2);
   
   /**
    * Indicates that the message processing by the authentication module 
    * was successful and that the runtime is to proceed with its normal processing 
    * of the resulting message.
    */
   public static final AuthStatus SUCCESS = new AuthStatus(1);
   
   private int status = -1; 
   private AuthStatus(int status)
   {
      this.status = status;
   }
}
