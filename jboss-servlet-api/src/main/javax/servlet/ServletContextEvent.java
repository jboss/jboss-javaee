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
 * This is the event class for notifications about changes to the servlet
 * context of a web application.
 * 
 * @see ServletContextListener
 * @since v 2.3
 */

public class ServletContextEvent extends java.util.EventObject
{

   /**
    * Construct a ServletContextEvent from the given context.
    * 
    * @param source -
    *           the ServletContext that is sending the event.
    */
   public ServletContextEvent(ServletContext source)
   {
      super(source);
   }

   /**
    * Return the ServletContext that changed.
    * 
    * @return the ServletContext that sent the event.
    */
   public ServletContext getServletContext()
   {
      return (ServletContext) super.getSource();
   }

}
