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
 * Implementations of this interface receive notifications of * changes to the
 * attribute list on the servlet context of a web application. To receive
 * notification events, the implementation class must be configured in the
 * deployment descriptor for the web application.
 * 
 * @see ServletContextAttributeEvent
 * @since v 2.3
 */

public interface ServletContextAttributeListener extends EventListener
{
   /**
    * Notification that a new attribute was added to the servlet context. Called
    * after the attribute is added.
    */
   public void attributeAdded(ServletContextAttributeEvent scab);

   /**
    * Notification that an existing attribute has been removed from the servlet
    * context. Called after the attribute is removed.
    */
   public void attributeRemoved(ServletContextAttributeEvent scab);

   /**
    * Notification that an attribute on the servlet context has been replaced.
    * Called after the attribute is replaced.
    */
   public void attributeReplaced(ServletContextAttributeEvent scab);
}
