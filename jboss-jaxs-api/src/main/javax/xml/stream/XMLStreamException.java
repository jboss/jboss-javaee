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
 * The base exception for unexpected processing errors.  This Exception
 * class is used to report well-formedness errors as well as unexpected
 * processing conditions.
 *
 * @author Jason T. Greene
 * @version $Id$
 */
public class XMLStreamException extends Exception
{
   protected Throwable nested;
   protected Location location;

   /**
    * Default constructor
    */
   public XMLStreamException()
   {
      super();
   }

   /**
    * Construct an exception with the assocated message.
    *
    * @param msg the message to report
    */
   public XMLStreamException(String msg)
   {
      super(msg);
   }

   /**
    * Construct an exception with the assocated exception
    *
    * @param th a nested exception
    */
   public XMLStreamException(Throwable th)
   {
      nested = th;
   }

   /**
    * Construct an exception with the assocated message and exception
    *
    * @param th a nested exception
    * @param msg the message to report
    */
   public XMLStreamException(String msg, Throwable th)
   {
      super(msg);
      nested = th;
   }

   /**
    * Construct an exception with the assocated message, exception and location.
    *
    * @param th a nested exception
    * @param msg the message to report
    * @param location the location of the error
    */
   public XMLStreamException(String msg, Location location, Throwable th)
   {
      super("ParseError at [row,col]:[" + location.getLineNumber() + "," + location.getColumnNumber() + "]\n" + "Message: " + msg);
      nested = th;
      this.location = location;
   }

   /**
    * Construct an exception with the assocated message, exception and location.
    *
    * @param msg the message to report
    * @param location the location of the error
    */
   public XMLStreamException(String msg, Location location)
   {
      super("ParseError at [row,col]:[" + location.getLineNumber() + "," + location.getColumnNumber() + "]\n" + "Message: " + msg);
      this.location = location;
   }

   /**
    * Gets the nested exception.
    *
    * @return Nested exception
    */
   public Throwable getNestedException()
   {
      return nested;
   }

   /**
    * Gets the location of the exception
    *
    * @return the location of the exception, may be null if none is available
    */
   public Location getLocation()
   {
      return location;
   }
}
