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

import java.io.OutputStream;
import java.io.IOException;
import java.io.CharConversionException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Provides an output stream for sending binary data to the client. A
 * <code>ServletOutputStream</code> object is normally retrieved via the
 * {@link ServletResponse#getOutputStream} method.
 * <p>
 * This is an abstract class that the servlet container implements. Subclasses
 * of this class must implement the <code>java.io.OutputStream.write(int)</code>
 * method.
 * 
 * @author Various
 * @see ServletResponse
 */

public abstract class ServletOutputStream extends OutputStream
{

   private static final String LSTRING_FILE = "javax.servlet.LocalStrings";

   private static ResourceBundle lStrings = ResourceBundle.getBundle(LSTRING_FILE);

   /**
    * Does nothing, because this is an abstract class.
    */

   protected ServletOutputStream()
   {
   }

   /**
    * Writes a <code>String</code> to the client, without a carriage
    * return-line feed (CRLF) character at the end.
    * 
    * @param s
    *           the <code>String</code> to send to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void print(String s) throws IOException
   {
      if (s == null)
         s = "null";
      int len = s.length();
      for (int i = 0; i < len; i++)
      {
         char c = s.charAt(i);

         //
         // XXX NOTE: This is clearly incorrect for many strings,
         // but is the only consistent approach within the current
         // servlet framework. It must suffice until servlet output
         // streams properly encode their output.
         //
         if ((c & 0xff00) != 0)
         { // high order byte must be zero
            String errMsg = lStrings.getString("err.not_iso8859_1");
            Object[] errArgs = new Object[1];
            errArgs[0] = new Character(c);
            errMsg = MessageFormat.format(errMsg, errArgs);
            throw new CharConversionException(errMsg);
         }
         write(c);
      }
   }

   /**
    * Writes a <code>boolean</code> value to the client, with no carriage
    * return-line feed (CRLF) character at the end.
    * 
    * @param b
    *           the <code>boolean</code> value to send to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void print(boolean b) throws IOException
   {
      String msg;
      if (b)
      {
         msg = lStrings.getString("value.true");
      }
      else
      {
         msg = lStrings.getString("value.false");
      }
      print(msg);
   }

   /**
    * Writes a character to the client, with no carriage return-line feed (CRLF)
    * at the end.
    * 
    * @param c
    *           the character to send to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void print(char c) throws IOException
   {
      print(String.valueOf(c));
   }

   /**
    * Writes an int to the client, with no carriage return-line feed (CRLF) at
    * the end.
    * 
    * @param i
    *           the int to send to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void print(int i) throws IOException
   {
      print(String.valueOf(i));
   }

   /**
    * Writes a <code>long</code> value to the client, with no carriage
    * return-line feed (CRLF) at the end.
    * 
    * @param l
    *           the <code>long</code> value to send to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void print(long l) throws IOException
   {
      print(String.valueOf(l));
   }

   /**
    * Writes a <code>float</code> value to the client, with no carriage
    * return-line feed (CRLF) at the end.
    * 
    * @param f
    *           the <code>float</code> value to send to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void print(float f) throws IOException
   {
      print(String.valueOf(f));
   }

   /**
    * Writes a <code>double</code> value to the client, with no carriage
    * return-line feed (CRLF) at the end.
    * 
    * @param d
    *           the <code>double</code> value to send to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void print(double d) throws IOException
   {
      print(String.valueOf(d));
   }

   /**
    * Writes a carriage return-line feed (CRLF) to the client.
    * 
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void println() throws IOException
   {
      print("\r\n");
   }

   /**
    * Writes a <code>String</code> to the client, followed by a carriage
    * return-line feed (CRLF).
    * 
    * @param s
    *           the <code>String</code> to write to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void println(String s) throws IOException
   {
      print(s);
      println();
   }

   /**
    * Writes a <code>boolean</code> value to the client, followed by a
    * carriage return-line feed (CRLF).
    * 
    * @param b
    *           the <code>boolean</code> value to write to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void println(boolean b) throws IOException
   {
      print(b);
      println();
   }

   /**
    * Writes a character to the client, followed by a carriage return-line feed
    * (CRLF).
    * 
    * @param c
    *           the character to write to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void println(char c) throws IOException
   {
      print(c);
      println();
   }

   /**
    * Writes an int to the client, followed by a carriage return-line feed
    * (CRLF) character.
    * 
    * @param i
    *           the int to write to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void println(int i) throws IOException
   {
      print(i);
      println();
   }

   /**
    * Writes a <code>long</code> value to the client, followed by a carriage
    * return-line feed (CRLF).
    * 
    * @param l
    *           the <code>long</code> value to write to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void println(long l) throws IOException
   {
      print(l);
      println();
   }

   /**
    * Writes a <code>float</code> value to the client, followed by a carriage
    * return-line feed (CRLF).
    * 
    * @param f
    *           the <code>float</code> value to write to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void println(float f) throws IOException
   {
      print(f);
      println();
   }

   /**
    * Writes a <code>double</code> value to the client, followed by a carriage
    * return-line feed (CRLF).
    * 
    * @param d
    *           the <code>double</code> value to write to the client
    * @exception IOException
    *               if an input or output exception occurred
    */

   public void println(double d) throws IOException
   {
      print(d);
      println();
   }
}
