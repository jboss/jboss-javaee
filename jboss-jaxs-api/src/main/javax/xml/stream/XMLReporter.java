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
 * This interface is used to report non-fatal errors. Only warnings should be
 * echoed through this interface.
 *
 * @author Jason T. Greene
 * @version $Id$
 */
public interface XMLReporter
{

   /**
    * Report the desired message in an application specific format. Only
    * warnings and non-fatal errors should be reported through this interface.
    * Fatal errors should be thrown as XMLStreamException.
    *
    * @param message the error message
    * @param errorType an implementation defined error type
    * @param relatedInformation information related to the error, if available
    * @param location the location of the error, if available
    * @throws XMLStreamException
    */
   public void report(String message, String errorType, Object relatedInformation, Location location) throws XMLStreamException;
}
