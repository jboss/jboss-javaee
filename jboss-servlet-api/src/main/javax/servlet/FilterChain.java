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
 * A FilterChain is an object provided by the servlet container to the developer
 * giving a view into the invocation chain of a filtered request for a resource. Filters
 * use the FilterChain to invoke the next filter in the chain, or if the calling filter
 * is the last filter in the chain, to invoke the resource at the end of the chain.
 *
 * @see     Filter
 * @since   Servlet 2.3
 **/
public interface FilterChain
{

   /**
    * Causes the next filter in the chain to be invoked, or if the calling filter is the last filter
    * in the chain, causes the resource at the end of the chain to be invoked.
    *
    * @param    request the request to pass along the chain.
    * @param    response the response to pass along the chain.
    *
    * @since    2.3
    */
   public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException;

}
