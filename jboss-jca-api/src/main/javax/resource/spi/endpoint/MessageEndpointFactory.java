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

import javax.resource.spi.UnavailableException;
import javax.transaction.xa.XAResource;

/**
 * A factory for message end points
 */
public interface MessageEndpointFactory
{
   /**
    * Creates a message endpoint
    *
    * @param resource the xa resource
    * @return the message endpoint
    * @throws UnavailableException a transient failure in the endpoint
    */
   MessageEndpoint createEndpoint(XAResource resource) throws UnavailableException;

   /**
    * Tests whether the delivery is transactional for the given method
    *
    * @param method the method to test
    * @return true for transacted delivery, false otherwise
    * @throws NoSuchMethodException if there is no such method for the endpoint
    */
   boolean isDeliveryTransacted(Method method) throws NoSuchMethodException;
}