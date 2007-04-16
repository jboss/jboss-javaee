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

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;

/**
 * The StartElement interface provides access to information about start
 * elements. A StartElement is reported for each Start Tag in the document.
 * 
 * @author Jason T. Greene
 * @version $Id$
 */
public interface StartElement extends XMLEvent
{

   /**
    * Get the name of this event
    * 
    * @return the qualified name of this event
    */
   public QName getName();

   /**
    * Returns an Iterator of non-namespace declared attributes declared on this
    * START_ELEMENT, returns an empty iterator if there are no attributes. The
    * iterator must contain only implementations of the
    * javax.xml.stream.Attribute interface. Attributes are fundamentally
    * unordered and may not be reported in any order.
    * 
    * @return a readonly Iterator over Attribute interfaces, or an empty
    * iterator
    */
   public Iterator getAttributes();

   /**
    * Returns an Iterator of namespaces declared on this element. This Iterator
    * does not contain previously declared namespaces unless they appear on the
    * current START_ELEMENT. Therefore this list may contain redeclared
    * namespaces and duplicate namespace declarations. Use the
    * getNamespaceContext() method to get the current context of namespace
    * declarations.
    * 
    * <p>
    * The iterator must contain only implementations of the
    * javax.xml.stream.Namespace interface.
    * 
    * <p>
    * A Namespace isA Attribute. One can iterate over a list of namespaces as a
    * list of attributes. However this method returns only the list of
    * namespaces declared on this START_ELEMENT and does not include the
    * attributes declared on this START_ELEMENT. Returns an empty iterator if
    * there are no namespaces.
    * 
    * @return a readonly Iterator over Namespace interfaces, or an empty
    * iterator
    *  
    */
   public Iterator getNamespaces();

   /**
    * Returns the attribute referred to by this name
    * 
    * @param name the qname of the desired name
    * @return the attribute corresponding to the name value or null
    */
   public Attribute getAttributeByName(QName name);

   /**
    * Gets a read-only namespace context. If no context is available this method
    * will return an empty namespace context. The NamespaceContext contains
    * information about all namespaces in scope for this StartElement.
    * 
    * @return the current namespace context
    */
   public NamespaceContext getNamespaceContext();

   /**
    * Gets the value that the prefix is bound to in the context of this element.
    * Returns null if the prefix is not bound in this context
    * 
    * @param prefix the prefix to lookup
    * @return the uri bound to the prefix or null
    */
   public String getNamespaceURI(String prefix);
}
