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
 * A marker interface for connections that support the lazy connection
 * association optimization.
 */
public interface DissociatableManagedConnection
{
   /**
	 * Invoked by the application server to dissociate the managed connection
	 * from all handles.
	 * 
	 * @throws ResourceException for any error
	 * @throws ResourceAdapterInternalException for an internal error in the
	 *            resource adapter
	 * @throws IllegalStateException if the state cannot be cleaned up, e.g. a
	 *            transaction is in progress
	 */
   void dissociateConnections() throws ResourceException;
}