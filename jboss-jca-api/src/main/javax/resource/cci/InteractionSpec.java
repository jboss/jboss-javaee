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

/**
 * An InteractionSpec holds properties for use by an Interaction in order to
 * execute a function on the underlying resource.
 * 
 * There is a set of standard properties which are used to give hints to an
 * Interaction object about the requirements of a ResultSet.
 * 
 * FetchSize, FetchDirection, MaxFieldSize, ResultSetType, ResultSetConcurrency
 * 
 * A specific implementation may implement additional properties.
 */
public interface InteractionSpec extends Serializable
{
   /**
	 * Execution requires only a send to the underlying resource.
	 */
   public static final int SYNC_SEND = 0;

   /**
	 * Execution requires only a send to the underlying resource.
	 */
   public static final int SYNC_SEND_RECEIVE = 1;

   /**
	 * Execution results in a synchronous receive of the output Record
	 */
   public static final int SYNC_RECEIVE = 2;
}