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
package javax.resource;

import javax.naming.Reference;

/**
 * The Referenceable interface extends the javax.naming.Referenceable
 * interface. It enables support for the JNDI Reference mechanism for the
 * registration of the connection factory in the JNDI name space. Note that the
 * implementation and structure of a Reference is specific to an application
 * server.
 * 
 * The implementation class for a connection factory interface is required to
 * implement both the java.io.Serializable and the javax.resource.Referenceable
 * interfaces to support JNDI registration.
 */
public interface Referenceable extends javax.naming.Referenceable
{
   /**
	 * Sets the reference instance
	 * 
	 * @param reference the reference
	 */
   void setReference(Reference reference);
}