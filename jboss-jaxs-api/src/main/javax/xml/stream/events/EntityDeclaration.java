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
package javax.xml.stream.events;

/**
 * An interface for handling Entity Declarations. This interface is used to
 * record and report unparsed entity declarations.
 *
 * @author Jason T. Greene
 * @version $Id$
 */
public interface EntityDeclaration extends XMLEvent
{

   /**
    * The entity's public identifier, or null if none was given
    *
    * @return the public ID for this declaration or null
    */
   public String getPublicId();

   /**
    * The entity's system identifier.
    *
    * @return the system ID for this declaration or null
    */
   public String getSystemId();

   /**
    * The entity's name
    *
    * @return the name, may not be null
    */
   public String getName();

   /**
    * The name of the associated notation.
    *
    * @return the notation name
    */
   public String getNotationName();

   /**
    * The replacement text of the entity. This method will only return non-null
    * if this is an internal entity.
    *
    * @return null or the replacment text
    */
   public String getReplacementText();

   /**
    * Get the base URI for this reference or null if this information is not
    * available
    *
    * @return the base URI or null
    */
   public String getBaseURI();
}
