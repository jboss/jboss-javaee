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
package javax.xml.registry;

import java.util.Collection;

/** Contains the response of a method in the API that performs a bulk operation
 * and returns a bulk response. Partial commits are allowed on a bulk operation. 
 * 
 * In the event of a partial success where only a subset of objects were
 * processed successfully, the getStatus method of the BulkResponse must return
 * JAXRResponse.STATUS_WARNING. In this case, a Collection of JAXRException
 * instances is included in the BulkResponse instance. The JAXRExceptions
 * provide information on each error that prevented some objects in the request
 * to not be processed successfully.
 * 
 * @author Scott.Stark@jboss.org
 * @author Farrukh S. Najmi (javadoc)
 * @version $Revision$
 */
public interface BulkResponse extends JAXRResponse
{
   public Collection getCollection() throws JAXRException;
   public Collection getExceptions() throws JAXRException;
   public boolean isPartialResponse() throws JAXRException;
}
