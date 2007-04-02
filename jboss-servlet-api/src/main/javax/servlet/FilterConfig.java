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

import java.util.Enumeration;

/**
 * 
 * A filter configuration object used by a servlet container to pass information
 * to a filter during initialization.
 * 
 * @see Filter
 * @since Servlet 2.3
 * 
 */
public interface FilterConfig
{

   /**
    * Returns the filter-name of this filter as defined in the deployment
    * descriptor.
    */
   public String getFilterName();

   /**
    * Returns a reference to the {@link ServletContext} in which the caller is
    * executing.
    * 
    * @return a {@link ServletContext} object, used by the caller to interact
    *         with its servlet container
    * 
    * @see ServletContext
    */
   public ServletContext getServletContext();

   /**
    * Returns a <code>String</code> containing the value of the named
    * initialization parameter, or <code>null</code> if the parameter does not
    * exist.
    * 
    * @param name
    *           a <code>String</code> specifying the name of the
    *           initialization parameter
    * 
    * @return a <code>String</code> containing the value of the initialization
    *         parameter
    */
   public String getInitParameter(String name);

   /**
    * Returns the names of the filter's initialization parameters as an
    * <code>Enumeration</code> of <code>String</code> objects, or an empty
    * <code>Enumeration</code> if the filter has no initialization parameters.
    * 
    * @return an <code>Enumeration</code> of <code>String</code> objects
    *         containing the names of the filter's initialization parameters
    */
   public Enumeration getInitParameterNames();

}
