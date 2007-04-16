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
 * This interface is used to resolve resources during an XML parse. If an
 * application wishes to perform custom entity resolution it must register an
 * instance of this interface with the XMLInputFactory using the setXMLResolver
 * method.
 *
 * @author Jason T. Greene
 * @version $Id$
 */
public interface XMLResolver
{
   /**
    * Retrieves a resource. This resource can be of the following three return
    * types: (1) java.io.InputStream (2) javax.xml.stream.XMLStreamReader (3)
    * java.xml.stream.X MLEventReader. If this method returns null the processor
    * will attempt to resolve the entity using its default mechanism.
    *
    * @param publicID The public identifier of the external entity being
    * referenced, or null if none was supplied.
    * @param systemID The system identifier of the external entity being
    * referenced.
    * @param baseURI Absolute base URI associated with systemId.
    * @param namespace The namespace of the entity to resolve.
    * @return The resource requested or null.
    * @throws XMLStreamException if there was a failure attempting to resolve
    * the resource.
    */
   public Object resolveEntity(String publicID, String systemID, String baseURI, String namespace) throws XMLStreamException;
}
