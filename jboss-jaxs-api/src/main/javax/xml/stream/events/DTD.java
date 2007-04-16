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

import java.util.List;

/**
 * Returns the entire Document Type Declaration as a string, including the
 * internal DTD subset. This may be null if there is not an internal subset. If
 * it is not null it must return the entire Document Type Declaration which
 * matches the doctypedecl production in the XML 1.0 specification
 *
 * @author Jason T. Greene
 * @version $Id$
 */
public interface DTD extends XMLEvent
{
   /**
    * Returns the entire Document Type Declaration as a string, including the
    * internal DTD subset. This may be null if there is not an internal subset.
    * If it is not null it must return the entire Document Type Declaration
    * which matches the doctypedecl production in the XML 1.0 specification
    */
   public String getDocumentTypeDeclaration();

   /**
    * Returns an implementation defined representation of the DTD. This method
    * may return null if no representation is available.
    */
   public Object getProcessedDTD();

   /**
    * Return a List containing the notations declared in the DTD. This list must
    * contain NotationDeclaration events.
    *
    * @see NotationDeclaration
    * @return an unordered list of NotationDeclaration events
    */
   public List getNotations();

   /**
    * Return a List containing the general entities, both external and internal,
    * declared in the DTD. This list must contain EntityDeclaration events.
    *
    * @see EntityDeclaration
    * @return an unordered list of EntityDeclaration events
    */
   public List getEntities();
}
