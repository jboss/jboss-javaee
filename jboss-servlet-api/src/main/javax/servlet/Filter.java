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
 * A filter is an object that performs filtering tasks on either the request to
 * a resource (a servlet or static content), or on the response from a resource,
 * or both. <br>
 * <br>
 * Filters perform filtering in the <code>doFilter</code> method. Every Filter
 * has access to a FilterConfig object from which it can obtain its
 * initialization parameters, a reference to the ServletContext which it can
 * use, for example, to load resources needed for filtering tasks.
 * <p>
 * Filters are configured in the deployment descriptor of a web application
 * <p>
 * Examples that have been identified for this design are<br>
 * <ol>
 * <li>Authentication Filters</li>
 * <li>Logging and Auditing Filters</li>
 * <li>Image conversion Filters</li>
 * <li>Data compression Filters</li>
 * <li>Encryption Filters</li>
 * <li>Tokenizing Filters</li>
 * <li>Filters that trigger resource access events</li>
 * <li>XSL/T filters</li>
 * <li>Mime-type chain Filter</li>
 * </ol>
 * 
 * @since Servlet 2.3
 */

public interface Filter
{

   /**
    * Called by the web container to indicate to a filter that it is being
    * placed into service. The servlet container calls the init method exactly
    * once after instantiating the filter. The init method must complete
    * successfully before the filter is asked to do any filtering work. <br>
    * <br>
    * 
    * The web container cannot place the filter into service if the init method
    * either<br>
    * <ol>
    * <li>Throws a ServletException</li>
    * <li>Does not return within a time period defined by the web container</li>
    * </ol>
    */
   public void init(FilterConfig filterConfig) throws ServletException;

   /**
    * The <code>doFilter</code> method of the Filter is called by the
    * container each time a request/response pair is passed through the chain
    * due to a client request for a resource at the end of the chain. The
    * FilterChain passed in to this method allows the Filter to pass on the
    * request and response to the next entity in the chain.
    * <p>
    * A typical implementation of this method would follow the following
    * pattern:- <br>
    * <ol>
    * <li>Examine the request</li>
    * <li>Optionally wrap the request object with a custom implementation to
    * filter content or headers for input filtering</li>
    * <li>Optionally wrap the response object with a custom implementation to
    * filter content or headers for output filtering</li>
    * <li>a) <strong>Either</strong> invoke the next entity in the chain using
    * the FilterChain object (<code>chain.doFilter()</code>), <br>
    * b) <strong>or</strong> not pass on the request/response pair to the
    * next entity in the filter chain to block the request processing</li>
    * <li> Directly set headers on the response after invocation of the next
    * entity in the filter chain.</li>
    * </ol>
    */
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException;

   /**
    * Called by the web container to indicate to a filter that it is being taken
    * out of service. This method is only called once all threads within the
    * filter's doFilter method have exited or after a timeout period has passed.
    * After the web container calls this method, it will not call the doFilter
    * method again on this instance of the filter. <br>
    * <br>
    * 
    * This method gives the filter an opportunity to clean up any resources that
    * are being held (for example, memory, file handles, threads) and make sure
    * that any persistent state is synchronized with the filter's current state
    * in memory.
    */
   public void destroy();

}
