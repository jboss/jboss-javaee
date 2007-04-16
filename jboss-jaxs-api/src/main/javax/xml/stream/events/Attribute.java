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

import javax.xml.namespace.QName;

/**
 * An interface that contains information about an attribute. Attributes are
 * reported as a set of events accessible from a StartElement. Other
 * applications may report Attributes as first-order events, for example as the
 * results of an XPath expression.
 *
 * @author Jason T. Greene
 * @version $Id$
 */
public interface Attribute extends XMLEvent
{
   /**
    * Returns the QName for this attribute
    */
   public QName getName();

   /**
    * Gets the normalized value of this attribute
    */
   public String getValue();

   /**
    * Gets the type of this attribute, default is the String "CDATA"
    *
    * @return the type as a String, default is "CDATA"
    */
   public String getDTDType();

   /**
    * A flag indicating whether this attribute was actually specified in the
    * start-tag of its element, or was defaulted from the schema.
    *
    * @return returns true if this was specified in the start element
    */
   public boolean isSpecified();
}
