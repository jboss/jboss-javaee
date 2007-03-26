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
 * The ConnectionMetaData provides information about the underlying resources
 * for the connection.
 */
public interface ConnectionMetaData
{
   /**
	 * Gets the product name of the underlying resource for the connection.
	 * 
	 * @return Product name of underlying resource.
	 */
   public String getEISProductName() throws ResourceException;

   /**
	 * Gets the product version of the underlying resource for the connection.
	 * 
	 * @return Product version name of underlying resource.
	 */
   public String getEISProductVersion() throws ResourceException;

   /**
	 * Gets the user name for the connection to the underlying resource as known
	 * to the underlying resource. This name corresponds to the principal under
	 * whose context the connection was first made.
	 * 
	 * @return Product name of underlying resource.
	 */
   public String getUserName() throws ResourceException;
}