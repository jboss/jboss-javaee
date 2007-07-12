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
package javax.security.auth.message.config;
 
/**
 * <p>A Listener that may associated with a provider registration by a user 
 * of the registration. The Listener will be notified if the corresponding 
 * provider is unregistered or replaced.</p>
 *  @author Anil.Saldhana@redhat.com
 *  @since  Jul 10, 2007 
 *  @version $Revision$    
 */
public interface RegistrationListener
{
   /**
    * Notify the listener that a registration with which it was associated, was 
    * replaced or unregistered. When a RegistrationListener is associated with a 
    * provider registration within the factory, the factory must call its notify 
    * method when the corresponding registration is unregistered or replaced.
    * 
    * @param layer a String identifying the message layer(s) corresponding to 
    *              registration for which the listerner is being notified.
    * @param appContext a String value identifying the application context(s) 
    *              corresponding to registration for which the listerner is being 
    *              notified. The factory detaches the listener from the 
    *              corresponding registration once the listener has been notified 
    *              for the registration. The detachListerner method must be called 
    *              to detach listeners that are no longer in use.
    */
   public void notify( String layer, String appContext); 
}
