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
import javax.xml.registry.infomodel.RegistryObject;

/** This is the common base interface for all QueryManagers in the API.
 * 
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 */
public interface QueryManager
{
   public RegistryObject getRegistryObject(String id) throws JAXRException;
   public RegistryObject getRegistryObject(String id, String objectType)
      throws JAXRException;

   public BulkResponse getRegistryObjects() throws JAXRException;
   public BulkResponse getRegistryObjects(String objectType)
      throws JAXRException;
   public BulkResponse getRegistryObjects(Collection objectKeys)
      throws JAXRException;
   public BulkResponse getRegistryObjects(Collection objectKeys, String objectType)
      throws JAXRException;

   public RegistryService getRegistryService() throws JAXRException;
}
