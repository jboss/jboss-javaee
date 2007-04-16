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
 * An interface for handling Notation Declarations. Receive notification of a
 * notation declaration event. It is up to the application to record the
 * notation for later reference, At least one of publicId and systemId must be
 * non-null. There is no guarantee that the notation declaration will be
 * reported before any unparsed entities that use it.
 *
 * @author Jason T. Greene
 * @version $Id$
 */
public interface NotationDeclaration extends XMLEvent
{

   /**
    * The notation name.
    */
   public String getName();

   /**
    * The notation's public identifier, or null if none was given.
    */
   public String getPublicId();

   /**
    * The notation's system identifier, or null if none was given.
    */
   public String getSystemId();
}
