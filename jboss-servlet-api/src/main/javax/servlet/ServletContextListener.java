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

import java.util.EventListener;

/**
 * Implementations of this interface receive notifications about changes to the
 * servlet context of the web application they are part of. To receive
 * notification events, the implementation class must be configured in the
 * deployment descriptor for the web application.
 * 
 * @see ServletContextEvent
 * @since v 2.3
 */

public interface ServletContextListener extends EventListener
{
   /**
    * * Notification that the web application initialization * process is
    * starting. * All ServletContextListeners are notified of context *
    * initialization before any filter or servlet in the web * application is
    * initialized.
    */

   public void contextInitialized(ServletContextEvent sce);

   /**
    * * Notification that the servlet context is about to be shut down. * All
    * servlets and filters have been destroy()ed before any *
    * ServletContextListeners are notified of context * destruction.
    */
   public void contextDestroyed(ServletContextEvent sce);
}
