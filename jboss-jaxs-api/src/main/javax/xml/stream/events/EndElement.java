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

import java.util.Iterator;

import javax.xml.namespace.QName;

/**
 * An interface for the end element event.  An EndElement is reported
 * for each End Tag in the document.
 *
 * @author Jason T. Greene
 * @version $Id$
 */
public interface EndElement extends XMLEvent
{
   /**
    * Get the name of this event
    *
    * @return the qualified name of this event
    */
   public QName getName();

   /**
    * Returns an Iterator of namespaces that have gone out of scope. Returns an
    * empty iterator if no namespaces have gone out of scope.
    *
    * @return an Iterator over Namespace interfaces, or an empty iterator
    */
   public Iterator getNamespaces();
}
