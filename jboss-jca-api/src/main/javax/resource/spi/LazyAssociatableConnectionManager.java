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
package javax.resource.spi;

import javax.resource.ResourceException;

/**
 * An optioanl mixin interface for connection managers that support the lazy connection
 * association optimization.
 */
public interface LazyAssociatableConnectionManager
{
   /**
    * Invoked by a resource adapter to lazily associate a connection handle with the managed connection
    *
    * @param connection the connection handle
    * @param mcf the managed connection factory
    * @param cxRequestInfo the connection request info
    * @throws ResourceException for an generic error
    * @throws ApplicationServerInternalException for problems in the application server
    * @throws SecurityException for security problems
    * @throws ResourceAllocationException for problems allocating resources
    * @throws ResourceAdapterInternalException for errors from the resource adapter 
    */
   void associateConnection(Object connection, ManagedConnectionFactory mcf, ConnectionRequestInfo cxReqInfo) throws ResourceException;
}