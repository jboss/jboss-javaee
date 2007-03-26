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
 * Interface used to associate the resource adapter with objects that implement
 * this interface.
 */
public interface ResourceAdapterAssociation
{
   /**
    * Retrieve the resource adapter
    *
    * @return the resource adapter
    */
   ResourceAdapter getResourceAdapter();

   /**
    * Set the resource adapter
    *
    * @param the resource adapter
    * @throws ResourceException for any error
    * @throws ResourceAdapterInternalException for an error in the resource adapter
    * @throws IllegalStateException if invoked more than once
    */
   void setResourceAdapter(ResourceAdapter ra) throws ResourceException;
}