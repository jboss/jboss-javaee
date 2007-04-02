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
import java.io.PrintWriter;
import java.util.Locale;

/**
 * Provides a convenient implementation of the ServletResponse interface that
 * can be subclassed by developers wishing to adapt the response from a Servlet.
 * This class implements the Wrapper or Decorator pattern. Methods default to
 * calling through to the wrapped response object.
 * 
 * @author Various
 * @since v 2.3
 * @see javax.servlet.ServletResponse
 */

public class ServletResponseWrapper implements ServletResponse
{
   private ServletResponse response;

   /**
    * Creates a ServletResponse adaptor wrapping the given response object.
    * 
    * @throws java.lang.IllegalArgumentException
    *            if the response is null.
    */

   public ServletResponseWrapper(ServletResponse response)
   {
      if (response == null)
      {
         throw new IllegalArgumentException("Response cannot be null");
      }
      this.response = response;
   }

   /**
    * Return the wrapped ServletResponse object.
    */

   public ServletResponse getResponse()
   {
      return this.response;
   }

   /**
    * Sets the response being wrapped.
    * 
    * @throws java.lang.IllegalArgumentException
    *            if the response is null.
    */

   public void setResponse(ServletResponse response)
   {
      if (response == null)
      {
         throw new IllegalArgumentException("Response cannot be null");
      }
      this.response = response;
   }

   /**
    * The default behavior of this method is to call setCharacterEncoding(String
    * charset) on the wrapped response object.
    * 
    * @since 2.4
    */

   public void setCharacterEncoding(String charset)
   {
      this.response.setCharacterEncoding(charset);
   }

   /**
    * The default behavior of this method is to return getCharacterEncoding() on
    * the wrapped response object.
    */

   public String getCharacterEncoding()
   {
      return this.response.getCharacterEncoding();
   }

   /**
    * The default behavior of this method is to return getOutputStream() on the
    * wrapped response object.
    */

   public ServletOutputStream getOutputStream() throws IOException
   {
      return this.response.getOutputStream();
   }

   /**
    * The default behavior of this method is to return getWriter() on the
    * wrapped response object.
    */

   public PrintWriter getWriter() throws IOException
   {
      return this.response.getWriter();
   }

   /**
    * The default behavior of this method is to call setContentLength(int len)
    * on the wrapped response object.
    */

   public void setContentLength(int len)
   {
      this.response.setContentLength(len);
   }

   /**
    * The default behavior of this method is to call setContentType(String type)
    * on the wrapped response object.
    */

   public void setContentType(String type)
   {
      this.response.setContentType(type);
   }

   /**
    * The default behavior of this method is to return getContentType() on the
    * wrapped response object.
    * 
    * @since 2.4
    */

   public String getContentType()
   {
      return this.response.getContentType();
   }

   /**
    * The default behavior of this method is to call setBufferSize(int size) on
    * the wrapped response object.
    */
   public void setBufferSize(int size)
   {
      this.response.setBufferSize(size);
   }

   /**
    * The default behavior of this method is to return getBufferSize() on the
    * wrapped response object.
    */
   public int getBufferSize()
   {
      return this.response.getBufferSize();
   }

   /**
    * The default behavior of this method is to call flushBuffer() on the
    * wrapped response object.
    */

   public void flushBuffer() throws IOException
   {
      this.response.flushBuffer();
   }

   /**
    * The default behavior of this method is to return isCommitted() on the
    * wrapped response object.
    */
   public boolean isCommitted()
   {
      return this.response.isCommitted();
   }

   /**
    * The default behavior of this method is to call reset() on the wrapped
    * response object.
    */

   public void reset()
   {
      this.response.reset();
   }

   /**
    * The default behavior of this method is to call resetBuffer() on the
    * wrapped response object.
    */

   public void resetBuffer()
   {
      this.response.resetBuffer();
   }

   /**
    * The default behavior of this method is to call setLocale(Locale loc) on
    * the wrapped response object.
    */

   public void setLocale(Locale loc)
   {
      this.response.setLocale(loc);
   }

   /**
    * The default behavior of this method is to return getLocale() on the
    * wrapped response object.
    */
   public Locale getLocale()
   {
      return this.response.getLocale();
   }

}
