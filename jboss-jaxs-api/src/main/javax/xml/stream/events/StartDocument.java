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
 * An interface for the start document event
 *
 * @author Jason T. Greene
 * @version $Id$
 */
public interface StartDocument extends XMLEvent
{

   /**
    * Returns the system ID of the XML data
    *
    * @return the system ID, defaults to ""
    */
   public String getSystemId();

   /**
    * Returns the encoding style of the XML data
    *
    * @return the character encoding, defaults to "UTF-8"
    */
   public String getCharacterEncodingScheme();

   /**
    * Returns true if CharacterEncodingScheme was set in the encoding
    * declaration of the document
    */
   public boolean encodingSet();

   /**
    * Returns if this XML is standalone
    *
    * @return the standalone state of XML, defaults to "no"
    */
   public boolean isStandalone();

   /**
    * Returns true if the standalone attribute was set in the encoding
    * declaration of the document.
    */
   public boolean standaloneSet();

   /**
    * Returns the version of XML of this XML stream
    *
    * @return the version of XML, defaults to "1.0"
    */
   public String getVersion();
}
