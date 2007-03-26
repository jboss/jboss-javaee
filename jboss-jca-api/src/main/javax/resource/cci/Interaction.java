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
 * The Interaction enables a component to execute functions on the underlying
 * resource. An object implementing the Interaction interface supports two
 * execute() methods for interacting with the underlying resource.
 * 
 * An Interaction is created from a Connection and maintains an association
 * with the Connection for its entire lifetime.
 * @version $Revision$
 */
public interface Interaction
{
   /**
	 * Clears all warnings reported by this Interaction.
	 * 
	 * @exception ResourceException Thrown if operation fails.
	 */
   public void clearWarnings() throws ResourceException;

   /**
	 * Closes an interaction
	 * 
	 * @exception ResourceException Thrown if operation fails.
	 */
   public void close() throws ResourceException;

   /**
	 * Executes the interaction specified by the InteractionSpec with the
	 * specified input.
	 * 
	 * @param spec Represents the target function on the underlying resource.
	 * @param input Input Record @returns Record Output if successful, null if
	 *           not.
	 * @exception ResourceException Thrown if Interaction fails.
	 */
   public Record execute(InteractionSpec spec, Record input) throws ResourceException;

   /**
	 * Executes the interaction specified by the InteractionSpec with the
	 * specified input.
	 * 
	 * @param spec Represents the target function on the underlying resource.
	 * @param input Input Record
	 * @param output Output record @returns boolean True if successful, false if
	 *           not
	 * @exception ResourceException Thrown if Interaction fails.
	 */
   public boolean execute(InteractionSpec spec, Record input, Record output) throws ResourceException;

   /**
	 * Gets the connection associated with this interaction.
    * @returns Connection Associated connection
	 * 
	 */
   public Connection getConnection();

   /**
	 * Gets the first warning for this interaction. @returns ResourceWarning
	 * First warning.
	 * 
	 * @exception ResourceException Thrown if operation fails.
	 */
   public ResourceWarning getWarnings() throws ResourceException;
}