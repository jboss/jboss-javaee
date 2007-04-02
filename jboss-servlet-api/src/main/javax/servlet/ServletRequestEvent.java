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
 * Events of this kind indicate lifecycle events for a ServletRequest. The
 * source of the event is the ServletContext of this web application.
 * 
 * @see ServletRequestListener
 * @since Servlet 2.4
 */

public class ServletRequestEvent extends java.util.EventObject
{
   private ServletRequest request;

   /**
    * Construct a ServletRequestEvent for the given ServletContext and
    * ServletRequest.
    * 
    * @param sc
    *           the ServletContext of the web application.
    * @param request
    *           the ServletRequest that is sending the event.
    */
   public ServletRequestEvent(ServletContext sc, ServletRequest request)
   {
      super(sc);
      this.request = request;
   }

   /**
    * Returns the ServletRequest that is changing.
    */
   public ServletRequest getServletRequest()
   {
      return this.request;
   }

   /**
    * Returns the ServletContext of this web application.
    */
   public ServletContext getServletContext()
   {
      return (ServletContext) super.getSource();
   }
}
