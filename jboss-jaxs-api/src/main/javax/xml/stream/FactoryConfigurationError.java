/*
* JBoss, Home of Professional Open Source
* Copyright 2005, JBoss Inc., and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
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
package javax.xml.stream;

/**
 * An error class for reporting factory configuration errors.
 *
 * @author Jason T. Greene
 * @version $Id$
 */
public class FactoryConfigurationError extends Error
{

   Exception nested;

   /**
    * Default constructor
    */
   public FactoryConfigurationError()
   {
   }

   /**
    * Construct an exception with a nested inner exception
    *
    * @param e the exception to nest
    */
   public FactoryConfigurationError(java.lang.Exception e)
   {
      nested = e;
   }

   /**
    * Construct an exception with a nested inner exception and a message
    *
    * @param e the exception to nest
    * @param msg the message to report
    */
   public FactoryConfigurationError(java.lang.Exception e, java.lang.String msg)
   {
      super(msg);
      nested = e;
   }

   /**
    * Construct an exception with a nested inner exception and a message
    *
    * @param msg the message to report
    * @param e the exception to nest
    */
   public FactoryConfigurationError(java.lang.String msg, java.lang.Exception e)
   {
      super(msg);
      nested = e;
   }

   /**
    * Construct an exception with associated message
    *
    * @param msg the message to report
    */
   public FactoryConfigurationError(java.lang.String msg)
   {
      super(msg);
   }

   /**
    * Return the nested exception (if any)
    *
    * @return the nested exception or null
    */
   public Exception getException()
   {
      return nested;
   }

   /**
    * Report the message associated with this error
    *
    * @return the string value of the message
    */
   public String getMessage()
   {
      return super.getMessage();
   }
}
