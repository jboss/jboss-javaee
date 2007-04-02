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
 * A ServletRequestListener can be implemented by the developer interested in
 * being notified of requests coming in and out of scope in a web component. A
 * request is defined as coming into scope when it is about to enter the first
 * servlet or filter in each web application, as going out of scope when it
 * exits the last servlet or the first filter in the chain.
 * 
 * @since Servlet 2.4
 */

public interface ServletRequestListener extends EventListener
{

   /** The request is about to go out of scope of the web application. */
   public void requestDestroyed(ServletRequestEvent sre);

   /** The request is about to come into scope of the web application. */
   public void requestInitialized(ServletRequestEvent sre);
}
