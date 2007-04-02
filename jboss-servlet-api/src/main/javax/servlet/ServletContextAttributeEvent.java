/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2007, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
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
package javax.servlet;

/**
 * This is the event class for notifications about changes to the attributes of
 * the servlet context of a web application.
 * 
 * @see ServletContextAttributeListener
 * @since v 2.3
 */

public class ServletContextAttributeEvent extends ServletContextEvent
{
   private String name;

   private Object value;

   /**
    * Construct a ServletContextAttributeEvent from the given context for the *
    * given attribute name and attribute value.
    */
   public ServletContextAttributeEvent(ServletContext source, String name, Object value)
   {
      super(source);
      this.name = name;
      this.value = value;
   }

   /**
    * Return the name of the attribute that changed on the ServletContext.
    */
   public String getName()
   {
      return this.name;
   }

   /**
    * Returns the value of the attribute that has been added, removed, or
    * replaced. If the attribute was added, this is the value of the attribute.
    * If the attribute was removed, this is the value of the removed attribute.
    * If the attribute was replaced, this is the old value of the attribute.
    */

   public Object getValue()
   {
      return this.value;
   }
}
