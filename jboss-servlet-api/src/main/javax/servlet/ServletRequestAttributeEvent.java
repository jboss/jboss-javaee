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
 * This is the event class for notifications of changes to the attributes of the
 * servlet request in an application.
 * 
 * @see ServletRequestAttributeListener
 * @since Servlet 2.4
 */

public class ServletRequestAttributeEvent extends ServletRequestEvent
{
   private String name;

   private Object value;

   /**
    * Construct a ServletRequestAttributeEvent giving the servlet context of
    * this web application, the ServletRequest whose attributes are changing and
    * the name and value of the attribute.
    * 
    * @param sc
    *           the ServletContext that is sending the event.
    * @param request
    *           the ServletRequest that is sending the event.
    * @param name
    *           the name of the request attribute.
    * @param value
    *           the value of the request attribute.
    */
   public ServletRequestAttributeEvent(ServletContext sc, ServletRequest request, String name, Object value)
   {
      super(sc, request);
      this.name = name;
      this.value = value;
   }

   /**
    * Return the name of the attribute that changed on the ServletRequest.
    * 
    * @return the name of the changed request attribute
    */
   public String getName()
   {
      return this.name;
   }

   /**
    * Returns the value of the attribute that has been added, removed or
    * replaced. If the attribute was added, this is the value of the attribute.
    * If the attribute was removed, this is the value of the removed attribute.
    * If the attribute was replaced, this is the old value of the attribute.
    * 
    * @return the value of the changed request attribute
    */
   public Object getValue()
   {
      return this.value;
   }
}
