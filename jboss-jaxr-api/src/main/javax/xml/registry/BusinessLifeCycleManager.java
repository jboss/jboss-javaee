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
import javax.xml.registry.infomodel.Association;

/**
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 */
public interface BusinessLifeCycleManager
   extends LifeCycleManager
{
   public void confirmAssociation(Association assoc)
      throws JAXRException, InvalidRequestException;
   public BulkResponse deleteAssociations(Collection associationKeys) throws JAXRException;
   public BulkResponse deleteClassificationSchemes(Collection schemeKeys) throws JAXRException;
   public BulkResponse deleteConcepts(Collection conceptKeys) throws JAXRException;
   public BulkResponse deleteOrganizations(Collection organizationKeys) throws JAXRException;
   public BulkResponse deleteServiceBindings(Collection bindingKeys) throws JAXRException;
   public BulkResponse deleteServices(Collection serviceKeys) throws JAXRException;
   public BulkResponse saveAssociations(Collection associations, boolean replace)
      throws JAXRException;
   public BulkResponse saveClassificationSchemes(Collection schemes) throws JAXRException;
   public BulkResponse saveConcepts(Collection concepts) throws JAXRException;
   public BulkResponse saveOrganizations(Collection organizations) throws JAXRException;
   public BulkResponse saveServiceBindings(Collection bindings) throws JAXRException;
   public BulkResponse saveServices(Collection services) throws JAXRException;
   public void unConfirmAssociation(Association assoc)
      throws JAXRException, InvalidRequestException;

}
