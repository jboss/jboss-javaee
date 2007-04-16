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
package javax.enterprise.deploy.model;

/**
 * A fragment of a standard deployment descriptor.
 *
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @version $Revision$
 */
public interface DDBean
{
   // Constants -----------------------------------------------------
   
   // Public --------------------------------------------------------

   /**
    * Returns the original xpath string provided by the DConfigBean
    *
    * @return the xpath
    */
   String getXpath();
   
   /**
    * Returns the XML text for this bean
    *
    * @return the text
    */
   String getText();
   
   /**
    * Returns the tool specific attribute ID
    *
    * @return the id or null if there is no id
    */
   String getId();
   
   /**
    * Get the root element
    *
    * @return the root element
    */
   DDBeanRoot getRoot();
   
   /**
    * Get the child elements with the specified xpath
    *
    * @param xpath the xpath of the children
    * @return an array of children or null if there are none
    */
   DDBean[] getChildBean(String xpath);
   
   /**
    * Get the text for the given xpath
    *
    * @param xpath the xpath
    * @return an array of Strings for the xpath or null if there are none
    */
   String[] getText(String xpath);
   
   /**
    * Register a listener for a given xpath
    *
    * @param xpath the xpath
    * @param xpl the listener
    */
   void addXpathListener(String xpath, XpathListener xpl);
   
   /**
    * Unregister a listener for a given xpath
    *
    * @param xpath the xpath
    * @param xpl the listener
    */
   void removeXpathListener(String xpath, XpathListener xpl);
   
   /**
    * Returns the list of attributes associated with this element
    *
    * @return the list of attributes
    */
   String[] getAttributeNames();
   
   /**
    * Get the value for a given attribute
    *
    * @param attrName the attribute name
    * @return the value
    */
   String getAttributeValue(String attrName);
}
