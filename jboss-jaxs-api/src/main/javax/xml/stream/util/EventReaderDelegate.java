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
package javax.xml.stream.util;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

/**
 * This is the base class for deriving an XMLEventReader filter.
 *
 * This class is designed to sit between an XMLEventReader and an application's
 * XMLEventReader. By default each method does nothing but call the
 * corresponding method on the parent interface.
 *
 * @author Jason T. Greene
 * @version $Id$
 *
 * @see StreamReaderDelegate
 */
public class EventReaderDelegate implements XMLEventReader
{

   private XMLEventReader reader;

   /**
    * Construct an empty filter with no parent.
    */
   public EventReaderDelegate()
   {
   }

   /**
    * Construct an filter with the specified parent.
    *
    * @param reader the parent
    */
   public EventReaderDelegate(XMLEventReader reader)
   {
      this.reader = reader;
   }

   /**
    * Set the parent of this instance.
    *
    * @param reader the new parent
    */
   public void setParent(XMLEventReader reader)
   {
      this.reader = reader;
   }

   /**
    * Get the parent of this instance.
    *
    * @return the parent or null if none is set
    */
   public XMLEventReader getParent()
   {
      return reader;
   }

   public XMLEvent nextEvent() throws XMLStreamException
   {
      return reader.nextEvent();
   }

   public Object next()
   {
      return reader.next();
   }

   public boolean hasNext()
   {
      return reader.hasNext();
   }

   public XMLEvent peek() throws XMLStreamException
   {
      return reader.peek();
   }

   public void close() throws XMLStreamException
   {
      reader.close();
   }

   public String getElementText() throws XMLStreamException
   {
      return reader.getElementText();
   }

   public XMLEvent nextTag() throws XMLStreamException
   {
      return reader.nextTag();
   }

   public Object getProperty(java.lang.String name) throws java.lang.IllegalArgumentException
   {
      return reader.getProperty(name);
   }

   public void remove()
   {
      reader.remove();
   }
}