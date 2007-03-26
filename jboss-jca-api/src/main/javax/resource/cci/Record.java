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
 * The Record interface is the base interface for representing input and output
 * for an Interaction.
 * 
 * A Record can be extended in several ways:
 * <ul>
 * <li>MappedRecord based on a Map
 * <li>IndexedRecord based on a List
 * <li>ResultSet based on a java.sql.ResultSet
 * <li>Arbitrary JavaBean
 * </ul>
 * 
 * Both MappedRecord and IndexedRecord support heirarchical structures of
 * Records with Records within Records.
 */
public interface Record extends Cloneable, Serializable
{
   /**
	 * Creae a copy of this Record
	 */
   public Object clone() throws CloneNotSupportedException;

   /**
	 * Compare two Records for equality
	 */
   public boolean equals(Object other);

   /*
	 * Return a hashcode for this Record
	 */
   public int hashCode();

   /**
	 * Get the name of this Record.
	 */
   public String getRecordName();

   /**
	 * Set the name of this Record.
	 */
   public void setRecordName(String name);

   /**
	 * Get the short description of this Record
	 */
   public String getRecordShortDescription();

   /**
	 * Set the short description of this Record
	 */
   public void setRecordShortDescription(String description);
}