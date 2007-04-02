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
package javax.servlet.http;

import java.io.IOException;

import javax.servlet.ServletResponseWrapper;

/**
 * Provides a convenient implementation of the HttpServletResponse interface
 * that can be subclassed by developers wishing to adapt the response from a
 * Servlet. This class implements the Wrapper or Decorator pattern. Methods
 * default to calling through to the wrapped response object.
 * 
 * @author Various
 * @since v 2.3
 * @see javax.servlet.http.HttpServletResponse
 */

public class HttpServletResponseWrapper extends ServletResponseWrapper implements HttpServletResponse
{

   /**
    * Constructs a response adaptor wrapping the given response.
    * 
    * @throws java.lang.IllegalArgumentException
    *            if the response is null
    */
   public HttpServletResponseWrapper(HttpServletResponse response)
   {
      super(response);
   }

   private HttpServletResponse _getHttpServletResponse()
   {
      return (HttpServletResponse) super.getResponse();
   }

   /**
    * The default behavior of this method is to call addCookie(Cookie cookie) on
    * the wrapped response object.
    */
   public void addCookie(Cookie cookie)
   {
      this._getHttpServletResponse().addCookie(cookie);
   }

   /**
    * The default behavior of this method is to call containsHeader(String name)
    * on the wrapped response object.
    */

   public boolean containsHeader(String name)
   {
      return this._getHttpServletResponse().containsHeader(name);
   }

   /**
    * The default behavior of this method is to call encodeURL(String url) on
    * the wrapped response object.
    */
   public String encodeURL(String url)
   {
      return this._getHttpServletResponse().encodeURL(url);
   }

   /**
    * The default behavior of this method is to return encodeRedirectURL(String
    * url) on the wrapped response object.
    */
   public String encodeRedirectURL(String url)
   {
      return this._getHttpServletResponse().encodeRedirectURL(url);
   }

   /**
    * The default behavior of this method is to call encodeUrl(String url) on
    * the wrapped response object. *
    * 
    * @deprecated As of version 2.1, use encodeURL(String url) instead
    */
   @Deprecated
   public String encodeUrl(String url)
   {
      return this._getHttpServletResponse().encodeUrl(url);
   }

   /**
    * The default behavior of this method is to return encodeRedirectUrl(String
    * url) on the wrapped response object.
    * 
    * @deprecated As of version 2.1, use encodeURL(String url) instead
    */
   @Deprecated
   public String encodeRedirectUrl(String url)
   {
      return this._getHttpServletResponse().encodeRedirectUrl(url);
   }

   /**
    * The default behavior of this method is to call sendError(int sc, String
    * msg) on the wrapped response object.
    */
   public void sendError(int sc, String msg) throws IOException
   {
      this._getHttpServletResponse().sendError(sc, msg);
   }

   /**
    * The default behavior of this method is to call sendError(int sc) on the
    * wrapped response object.
    */

   public void sendError(int sc) throws IOException
   {
      this._getHttpServletResponse().sendError(sc);
   }

   /**
    * The default behavior of this method is to return sendRedirect(String
    * location) on the wrapped response object.
    */
   public void sendRedirect(String location) throws IOException
   {
      this._getHttpServletResponse().sendRedirect(location);
   }

   /**
    * The default behavior of this method is to call setDateHeader(String name,
    * long date) on the wrapped response object.
    */
   public void setDateHeader(String name, long date)
   {
      this._getHttpServletResponse().setDateHeader(name, date);
   }

   /**
    * The default behavior of this method is to call addDateHeader(String name,
    * long date) on the wrapped response object.
    */
   public void addDateHeader(String name, long date)
   {
      this._getHttpServletResponse().addDateHeader(name, date);
   }

   /**
    * The default behavior of this method is to return setHeader(String name,
    * String value) on the wrapped response object.
    */
   public void setHeader(String name, String value)
   {
      this._getHttpServletResponse().setHeader(name, value);
   }

   /**
    * The default behavior of this method is to return addHeader(String name,
    * String value) on the wrapped response object.
    */
   public void addHeader(String name, String value)
   {
      this._getHttpServletResponse().addHeader(name, value);
   }

   /**
    * The default behavior of this method is to call setIntHeader(String name,
    * int value) on the wrapped response object.
    */
   public void setIntHeader(String name, int value)
   {
      this._getHttpServletResponse().setIntHeader(name, value);
   }

   /**
    * The default behavior of this method is to call addIntHeader(String name,
    * int value) on the wrapped response object.
    */
   public void addIntHeader(String name, int value)
   {
      this._getHttpServletResponse().addIntHeader(name, value);
   }

   /**
    * The default behavior of this method is to call setStatus(int sc) on the
    * wrapped response object.
    */

   public void setStatus(int sc)
   {
      this._getHttpServletResponse().setStatus(sc);
   }

   /**
    * The default behavior of this method is to call setStatus(int sc, String
    * sm) on the wrapped response object.
    * 
    * @deprecated As of version 2.1, due to ambiguous meaning of the message
    *             parameter. To set a status code use
    *             <code>setStatus(int)</code>, to send an error with a
    *             description use <code>sendError(int, String)</code>. Sets
    *             the status code and message for this response.
    */
   @Deprecated
   public void setStatus(int sc, String sm)
   {
      this._getHttpServletResponse().setStatus(sc, sm);
   }

}
