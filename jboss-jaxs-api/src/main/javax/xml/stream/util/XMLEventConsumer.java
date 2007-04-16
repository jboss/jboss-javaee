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

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

/**
 * This interface defines an event consumer interface.  The contract of the
 * of a consumer is to accept the event.  This interface can be used to
 * mark an object as able to receive events.  Add may be called several
 * times in immediate succession so a consumer must be able to cache
 * events it hasn't processed yet.
 *
 * @author Jason T. Greene
 * @version $Id$
 */
public interface XMLEventConsumer
{

   /**
    * This method adds an event to the consumer. Calling this method invalidates
    * the event parameter. The client application should discard all references
    * to this event upon calling add. The behavior of an application that
    * continues to use such references is undefined.
    *
    * @param event the event to add, may not be null
    */
   public void add(XMLEvent event) throws XMLStreamException;
}
