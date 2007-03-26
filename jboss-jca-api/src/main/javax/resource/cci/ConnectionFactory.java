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

import java.io.Serializable;

import javax.resource.Referenceable;
import javax.resource.ResourceException;

/**
 * The ConnectionFactory provides an interface for getting a Connection from
 * the Resource adapter.
 * 
 * The application retrieves a reference to the ConnectionFactory through a
 * JNDI lookup.
 * 
 * ConnectionFactory extends java.io.Serializable and
 * javax.resource.Referenceable in order to support JNDI lookup.
 */
public interface ConnectionFactory extends Serializable, Referenceable
{
   /**
	 * Gets a connection from the resource adapter. When using this method the
	 * client does not pass any security information, and wants the container to
	 * manage sign-on. This is called container managed sign-on.
	 */
   public Connection getConnection() throws ResourceException;

   /**
	 * Gets a connection from the resource adapter. When using this method the
	 * client passes in the security information. This is called component
	 * managed sign-on.
	 */
   public Connection getConnection(ConnectionSpec properties) throws ResourceException;

   /**
	 * Gets a RecordFactory instance for use in creating Record objects.
	 */
   public RecordFactory getRecordFactory() throws ResourceException;

   /**
	 * Gets metadata for the resource adapter. This call does not require an
	 * active connection.
	 */
   public ResourceAdapterMetaData getMetaData() throws ResourceException;
}