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

import java.beans.PropertyChangeEvent;

/**
 * An event describing ConfigBeans added/changed/removed from a configuration
 */
public final class XpathEvent
{
   // Constants -----------------------------------------------------

   /** A bean is added */
   public static final Object BEAN_ADDED = new Object();
   /** A bean is removed */
   public static final Object BEAN_REMOVED = new Object();
   /** A bean is changed */
   public static final Object BEAN_CHANGED = new Object();
   
   // Attributes ----------------------------------------------------
   
   /** The bean */
   private DDBean bean;
   /** The type */
   private Object type;
   /** The property change event */
   private PropertyChangeEvent propertyChangeEvent;
   
   // Static --------------------------------------------------------
   
   // Constructors --------------------------------------------------
   
   /**
    * Create a new XpathEvent
    *
    * @param bean the bean
    * @param type the event type
    */
   public XpathEvent(DDBean bean, Object type)
   {
      this.bean = bean;
      this.type = type;
   }
   
   // Public --------------------------------------------------------
   
   /**
    * Get the property change event
    *
    * @return the property change event
    */
   public PropertyChangeEvent getChangeEvent()
   {
      return propertyChangeEvent;
   }
   
   /**
    * Set the property change event
    *
    * @param propertyChangeEvent the property change event
    */
   public void setChangeEvent(PropertyChangeEvent propertyChangeEvent)
   {
      this.propertyChangeEvent = propertyChangeEvent;
   }
   
   /**
    * Get the DDBean
    *
    * @return the DDBean
    */
   public DDBean getBean()
   {
      return bean;
   }
   
   /**
    * Is it an add event
    *
    * @return true when it is an add event, false otherwise
    */
   public boolean isAddEvent()
   {
      return type == BEAN_ADDED;
   }
   
   /**
    * Is it a remove event
    *
    * @return true when it is a remove event, false otherwise
    */
   public boolean isRemoveEvent()
   {
      return type == BEAN_REMOVED;
   }
   
   /**
    * Is it a change event
    *
    * @return true when it is a change event, false otherwise
    */
   public boolean isChangeEvent()
   {
      return type == BEAN_CHANGED;
   }
   
   // Package protected ---------------------------------------------
   
   // Protected -----------------------------------------------------
   
   // Private -------------------------------------------------------
   
   // Inner classes -------------------------------------------------
}