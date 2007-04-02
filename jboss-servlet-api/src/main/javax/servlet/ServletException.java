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

/**
 * Defines a general exception a servlet can throw when it encounters
 * difficulty.
 * 
 * @author Various
 */

public class ServletException extends Exception
{

   private Throwable rootCause;

   /**
    * Constructs a new servlet exception.
    */

   public ServletException()
   {
      super();
   }

   /**
    * Constructs a new servlet exception with the specified message. The message
    * can be written to the server log and/or displayed for the user.
    * 
    * @param message
    *           a <code>String</code> specifying the text of the exception
    *           message
    */

   public ServletException(String message)
   {
      super(message);
   }

   /**
    * Constructs a new servlet exception when the servlet needs to throw an
    * exception and include a message about the "root cause" exception that
    * interfered with its normal operation, including a description message.
    * 
    * @param message
    *           a <code>String</code> containing the text of the exception
    *           message
    * @param rootCause
    *           the <code>Throwable</code> exception that interfered with the
    *           servlet's normal operation, making this servlet exception
    *           necessary
    */

   public ServletException(String message, Throwable rootCause)
   {
      super(message, rootCause);
      this.rootCause = rootCause;
   }

   /**
    * Constructs a new servlet exception when the servlet needs to throw an
    * exception and include a message about the "root cause" exception that
    * interfered with its normal operation. The exception's message is based on
    * the localized message of the underlying exception.
    * <p>
    * This method calls the <code>getLocalizedMessage</code> method on the
    * <code>Throwable</code> exception to get a localized exception message.
    * When subclassing <code>ServletException</code>, this method can be
    * overridden to create an exception message designed for a specific locale.
    * 
    * @param rootCause
    *           the <code>Throwable</code> exception that interfered with the
    *           servlet's normal operation, making the servlet exception
    *           necessary
    */

   public ServletException(Throwable rootCause)
   {
      super(rootCause);
      this.rootCause = rootCause;
   }

   /**
    * Returns the exception that caused this servlet exception.
    * 
    * @return the <code>Throwable</code> that caused this servlet exception
    */

   public Throwable getRootCause()
   {
      return rootCause;
   }
}
