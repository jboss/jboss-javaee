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
package javax.resource.cci;

import javax.resource.ResourceException;

/**
 * The LocalTransaction interface is the transaction demarcation interface for
 * transactions local to the resource manager. This interface is used for
 * application level transaction demarcation, the spi.LocalTransaction
 * interface is used for transaction management within a resource adapter.
 * 
 * Implementation of this interface is optional for a resource manager.
 */
public interface LocalTransaction
{
   /**
	 * Begins a local transaction on the userlying resource.
	 */
   public void begin() throws ResourceException;

   /**
	 * Commits a local transaction on the userlying resource.
	 */
   public void commit() throws ResourceException;

   /**
	 * Rolls back a local transaction on the userlying resource.
	 */
   public void rollback() throws ResourceException;
}