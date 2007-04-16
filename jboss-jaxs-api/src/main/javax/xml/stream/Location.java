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
package javax.xml.stream;

/**
 * @author Jason T. Greene
 * @version $Id$
 */
public interface Location
{
   /**
    * Return the line number where the current event ends, returns -1 if none is
    * available.
    *
    * @return the current line number
    */
   int getLineNumber();

   /**
    * Return the column number where the current event ends, returns -1 if none
    * is available.
    *
    * @return the current column number
    */
   int getColumnNumber();

   /**
    * Return the byte or character offset into the input source this location is
    * pointing to. If the input source is a file or a byte stream then this is
    * the byte offset into that stream, but if the input source is a character
    * media then the offset is the character offset. Returns -1 if there is no
    * offset available.
    *
    * @return the current offset
    */
   int getCharacterOffset();

   /**
    * Returns the public ID of the XML
    *
    * @return the public ID, or null if not available
    */
   public String getPublicId();

   /**
    * Returns the system ID of the XML
    *
    * @return the system ID, or null if not available
    */
   public String getSystemId();
}
