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
 * The Connection provides a handle for use by the application to access an
 * underlying physical connection.
 * 
 * The client calls the getConnection() method on a ConnectionFactory object to
 * get a Connection.
 */
public interface Connection
{
   /**
	 * Closes a connection
	 */
   public void close() throws ResourceException;

   /**
	 * Creates a new interaction associated with this connection.
	 */
   public Interaction createInteraction() throws ResourceException;

   /**
	 * Gets a LocalTransaction object which allows the client to manage local
	 * transactions for the connection.
	 */
   public LocalTransaction getLocalTransaction() throws ResourceException;

   /**
	 * Gets meta data for the underlying resource represented by this
	 * connection.
	 */
   public ConnectionMetaData getMetaData() throws ResourceException;

   /**
	 * Gets information on ResultSet functionality supported by the underlying
	 * resource for the connection.
	 */
   public ResultSetInfo getResultSetInfo() throws ResourceException;
}