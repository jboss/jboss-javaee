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
package javax.xml.registry.infomodel;

import java.util.Collection;
import javax.xml.registry.JAXRException;

/**
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 */
public interface Organization
   extends RegistryObject
{
   public void addChildOrganization(Organization org) throws JAXRException;
   public void addChildOrganizations(Collection orgs) throws JAXRException;
   public void addService(Service service) throws JAXRException;
   public void addServices(Collection services) throws JAXRException;
   public void addUser(User user) throws JAXRException;
   public void addUsers(Collection users) throws JAXRException;
   public int getChildOrganizationCount() throws JAXRException;
   public Collection getChildOrganizations() throws JAXRException;
   public Collection getDescendantOrganizations() throws JAXRException;
   public Organization getParentOrganization() throws JAXRException;
   public PostalAddress getPostalAddress() throws JAXRException;
   public User getPrimaryContact() throws JAXRException;
   public Organization getRootOrganization() throws JAXRException;
   public Collection getServices() throws JAXRException;
   public Collection getTelephoneNumbers(String phoneType) throws JAXRException;
   public Collection getUsers() throws JAXRException;
   public void removeChildOrganization(Organization org) throws JAXRException;
   public void removeChildOrganizations(Collection orgs) throws JAXRException;
   public void removeService(Service service) throws JAXRException;
   public void removeServices(Collection services) throws JAXRException;
   public void removeUser(User user) throws JAXRException;
   public void removeUsers(Collection users) throws JAXRException;
   public void setPostalAddress(PostalAddress addr) throws JAXRException;
   public void setPrimaryContact(User user) throws JAXRException;
   public void setTelephoneNumbers(Collection phoneNumbers) throws JAXRException;

}
