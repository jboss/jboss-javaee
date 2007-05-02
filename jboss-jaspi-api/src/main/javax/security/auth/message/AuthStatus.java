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
    * Indicates that the processing of the message by the 
    * authentication module resulted in an error
    */
   public static final AuthStatus FAIL = new AuthStatus(-1);
   
   /**
    * Indicates that the message processing runtime is to 
    * continue with its normal processing of the message exchange.
    */
   public static final AuthStatus PROCEED = new AuthStatus(1);
   
   /**
    * Indicates that the message processing runtime is to repeat 
    * its processing of the message exchange.
    */
   public static final AuthStatus RETRY =  new AuthStatus(0);
   
   private int status = -1; 
   private AuthStatus(int status)
   {
      this.status = status;
   }
}
