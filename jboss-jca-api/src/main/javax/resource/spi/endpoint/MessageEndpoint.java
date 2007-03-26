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
package javax.resource.spi.endpoint;

import java.lang.reflect.Method;

import javax.resource.ResourceException;

/**
 * A factory for message end points
 */
public interface MessageEndpoint
{
   /**
	 * Invoked before delivery
	 * 
	 * @param method the method on the endpoint
	 * @throws NoSuchMethodException when there is no such method
	 * @throws ResourceException for a generic error
	 * @throws ApplicationServerInternalException for an error in the
	 *            application server
	 * @throws IllegalStateException when not in the correct state, eg. before
	 *            and after delivery are not paired
    * @throws UnavailableException when the endpoint is unavailable
	 */
   void beforeDelivery(Method method) throws NoSuchMethodException, ResourceException;

   /**
	 * Invoked after delivery
	 * 
	 * @throws ResourceException for a generic error
    * @throws ApplicationServerInternalException for an error in the
    *            application server
    * @throws IllegalStateException when not in the correct state, eg. before
    *            and after delivery are not paired
    * @throws UnavailableException when the endpoint is unavailable
	 */
   void afterDelivery() throws ResourceException;

   /**
    * Release the endpoint
    */
   void release();
}