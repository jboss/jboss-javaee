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

import java.io.IOException;

/**
 * Defines an object that receives requests from the client and sends them to
 * any resource (such as a servlet, HTML file, or JSP file) on the server. The
 * servlet container creates the <code>RequestDispatcher</code> object, which
 * is used as a wrapper around a server resource located at a particular path or
 * given by a particular name.
 * <p>
 * This interface is intended to wrap servlets, but a servlet container can
 * create <code>RequestDispatcher</code> objects to wrap any type of resource.
 * 
 * @author Various
 * @see ServletContext#getRequestDispatcher(java.lang.String)
 * @see ServletContext#getNamedDispatcher(java.lang.String)
 * @see ServletRequest#getRequestDispatcher(java.lang.String)
 */

public interface RequestDispatcher
{

   /**
    * Forwards a request from a servlet to another resource (servlet, JSP file,
    * or HTML file) on the server. This method allows one servlet to do
    * preliminary processing of a request and another resource to generate the
    * response.
    * <p>
    * For a <code>RequestDispatcher</code> obtained via
    * <code>getRequestDispatcher()</code>, the <code>ServletRequest</code>
    * object has its path elements and parameters adjusted to match the path of
    * the target resource.
    * <p>
    * <code>forward</code> should be called before the response has been
    * committed to the client (before response body output has been flushed). If
    * the response already has been committed, this method throws an
    * <code>IllegalStateException</code>. Uncommitted output in the response
    * buffer is automatically cleared before the forward.
    * <p>
    * The request and response parameters must be either the same objects as
    * were passed to the calling servlet's service method or be subclasses of
    * the {@link ServletRequestWrapper} or {@link ServletResponseWrapper}
    * classes that wrap them.
    * 
    * @param request
    *           a {@link ServletRequest} object that represents the request the
    *           client makes of the servlet
    * @param response
    *           a {@link ServletResponse} object that represents the response
    *           the servlet returns to the client
    * @exception ServletException
    *               if the target resource throws this exception
    * @exception IOException
    *               if the target resource throws this exception
    * @exception IllegalStateException
    *               if the response was already committed
    */

   public void forward(ServletRequest request, ServletResponse response) throws ServletException, IOException;

   /**
    * Includes the content of a resource (servlet, JSP page, HTML file) in the
    * response. In essence, this method enables programmatic server-side
    * includes.
    * <p>
    * The {@link ServletResponse} object has its path elements and parameters
    * remain unchanged from the caller's. The included servlet cannot change the
    * response status code or set headers; any attempt to make a change is
    * ignored.
    * <p>
    * The request and response parameters must be either the same objects as
    * were passed to the calling servlet's service method or be subclasses of
    * the {@link ServletRequestWrapper} or {@link ServletResponseWrapper}
    * classes that wrap them.
    * 
    * @param request
    *           a {@link ServletRequest} object that contains the client's
    *           request
    * @param response
    *           a {@link ServletResponse} object that contains the servlet's
    *           response
    * @exception ServletException
    *               if the included resource throws this exception
    * @exception IOException
    *               if the included resource throws this exception
    */

   public void include(ServletRequest request, ServletResponse response) throws ServletException, IOException;
}
