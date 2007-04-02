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

import java.io.InputStream;
import java.io.IOException;

/**
 * Provides an input stream for reading binary data from a client request,
 * including an efficient <code>readLine</code> method for reading data one
 * line at a time. With some protocols, such as HTTP POST and PUT, a
 * <code>ServletInputStream</code> object can be used to read data sent from
 * the client.
 * <p>
 * A <code>ServletInputStream</code> object is normally retrieved via the
 * {@link ServletRequest#getInputStream} method.
 * <p>
 * This is an abstract class that a servlet container implements. Subclasses of
 * this class must implement the <code>java.io.InputStream.read()</code>
 * method.
 * 
 * @author Various
 * @see ServletRequest
 */

public abstract class ServletInputStream extends InputStream
{

   /**
    * Does nothing, because this is an abstract class.
    */

   protected ServletInputStream()
   {
   }

   /**
    * Reads the input stream, one line at a time. Starting at an offset, reads
    * bytes into an array, until it reads a certain number of bytes or reaches a
    * newline character, which it reads into the array as well.
    * <p>
    * This method returns -1 if it reaches the end of the input stream before
    * reading the maximum number of bytes.
    * 
    * @param b
    *           an array of bytes into which data is read
    * @param off
    *           an integer specifying the character at which this method begins
    *           reading
    * @param len
    *           an integer specifying the maximum number of bytes to read
    * @return an integer specifying the actual number of bytes read, or -1 if
    *         the end of the stream is reached
    * @exception IOException
    *               if an input or output exception has occurred
    */

   public int readLine(byte[] b, int off, int len) throws IOException
   {

      if (len <= 0)
      {
         return 0;
      }
      int count = 0, c;

      while ((c = read()) != -1)
      {
         b[off++] = (byte) c;
         count++;
         if (c == '\n' || count == len)
         {
            break;
         }
      }
      return count > 0 ? count : -1;
   }
}
