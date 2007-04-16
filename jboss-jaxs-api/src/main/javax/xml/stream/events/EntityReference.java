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
 * An interface for handling Entity events.
 *
 * This event reports entities that have not been resolved and reports their
 * replacement text unprocessed (if available). This event will be reported if
 * javax.xml.stream.isReplacingEntityRefere nces is set to false. If
 * javax.xml.stream.isReplacingEntityReferences is set to true entity references
 * will be resolved transparently. <br>
 * Entities are handled in two possible ways: <br>
 * (1) If javax.xml.stream.isReplacingEntityReferences is set to true all entity
 * references are resolved and reported as markup transparently. <br>
 * (2) If javax.xml.stream.isReplacingEntityReferences is set to false Entity
 * references are reported as an EntityReference Event.
 *
 * @author Jason T. Greene
 * @version $Id$
 */
public interface EntityReference extends XMLEvent
{
   /**
    * Return the declaration of this entity.
    */
   public EntityDeclaration getDeclaration();

   /**
    * The name of the entity
    *
    * @return the entity's name, may not be null
    */
   public String getName();
}
