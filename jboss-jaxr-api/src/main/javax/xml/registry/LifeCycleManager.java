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
import java.util.Locale;
import javax.activation.DataHandler;
import javax.xml.registry.infomodel.Association;
import javax.xml.registry.infomodel.Classification;
import javax.xml.registry.infomodel.ClassificationScheme;
import javax.xml.registry.infomodel.Concept;
import javax.xml.registry.infomodel.EmailAddress;
import javax.xml.registry.infomodel.ExternalIdentifier;
import javax.xml.registry.infomodel.ExternalLink;
import javax.xml.registry.infomodel.ExtrinsicObject;
import javax.xml.registry.infomodel.InternationalString;
import javax.xml.registry.infomodel.Key;
import javax.xml.registry.infomodel.LocalizedString;
import javax.xml.registry.infomodel.Organization;
import javax.xml.registry.infomodel.PersonName;
import javax.xml.registry.infomodel.PostalAddress;
import javax.xml.registry.infomodel.RegistryObject;
import javax.xml.registry.infomodel.RegistryPackage;
import javax.xml.registry.infomodel.Service;
import javax.xml.registry.infomodel.ServiceBinding;
import javax.xml.registry.infomodel.Slot;
import javax.xml.registry.infomodel.SpecificationLink;
import javax.xml.registry.infomodel.TelephoneNumber;
import javax.xml.registry.infomodel.User;

/**
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 */
public interface LifeCycleManager
{
   public static final String ASSOCIATION="Association";
   public static final String AUDITABLE_EVENT="AuditableEvent";
   public static final String CLASSIFICATION="Classification";
   public static final String CLASSIFICATION_SCHEME="ClassificationScheme";
   public static final String CONCEPT="Concept";
   public static final String EMAIL_ADDRESS="EmailAddress";
   public static final String EXTERNAL_IDENTIFIER="ExternalIdentifier";
   public static final String EXTERNAL_LINK="ExternalLink";
   public static final String EXTRINSIC_OBJECT="ExtrinsicObject";
   public static final String INTERNATIONAL_STRING="InternationalString";
   public static final String KEY="Key";
   public static final String LOCALIZED_STRING="LocalizedString";
   public static final String ORGANIZATION="Organization";
   public static final String PERSON_NAME="PersonName";
   public static final String POSTAL_ADDRESS="PostalAddress";
   public static final String REGISTRY_ENTRY="RegistryEntry";
   public static final String REGISTRY_PACKAGE="RegistryPackage";
   public static final String SERVICE="Service";
   public static final String SERVICE_BINDING="ServiceBinding";
   public static final String SLOT="Slot";
   public static final String SPECIFICATION_LINK="SpecificationLink";
   public static final String TELEPHONE_NUMBER="TelephoneNumber";
   public static final String USER="User";
   public static final String VERSIONABLE="Versionable";

   public Association createAssociation(RegistryObject targetObject, Concept associationType)
      throws JAXRException;
   public Classification createClassification(ClassificationScheme scheme,
      InternationalString name, String value) 
      throws JAXRException;
   public Classification createClassification(ClassificationScheme scheme,
      String name, String value)
      throws JAXRException;
   public Classification createClassification(Concept concept)
      throws JAXRException, InvalidRequestException;

   public ClassificationScheme createClassificationScheme(InternationalString name,
      InternationalString description)
      throws JAXRException, InvalidRequestException;
   public ClassificationScheme createClassificationScheme(Concept concept)
      throws JAXRException, InvalidRequestException;
   public ClassificationScheme createClassificationScheme(String name, String description)
      throws JAXRException, InvalidRequestException;

   public Concept createConcept(RegistryObject parent, String name, String value)
      throws JAXRException;
   public Concept createConcept(RegistryObject parent, InternationalString name,
      String value)
      throws JAXRException;

   public EmailAddress createEmailAddress(String address) throws JAXRException;
   public EmailAddress createEmailAddress(String address, String type) 
      throws JAXRException;

   public ExternalIdentifier createExternalIdentifier(
      ClassificationScheme identificationScheme, String name, String value)
      throws JAXRException;
   public ExternalIdentifier createExternalIdentifier(ClassificationScheme identificationScheme,
      InternationalString name, String value) 
      throws JAXRException;

   public ExternalLink createExternalLink(String externalURI, String description)
      throws JAXRException;
   public ExternalLink createExternalLink(String externalURI, InternationalString description) 
      throws JAXRException;

   public ExtrinsicObject createExtrinsicObject(DataHandler repositoryItem)
      throws JAXRException;

   public InternationalString createInternationalString()
      throws JAXRException;
   public InternationalString createInternationalString(String s)
      throws JAXRException;
   public InternationalString createInternationalString(Locale locale, String s)
      throws JAXRException;

   public Key createKey(String id) throws JAXRException;

   public LocalizedString createLocalizedString(Locale locale, String s)
      throws JAXRException;
   public LocalizedString createLocalizedString(Locale locale, String s, String cs)
      throws JAXRException;

   public Object createObject(String interfaceName)
      throws JAXRException, InvalidRequestException,
      UnsupportedCapabilityException;

   public Organization createOrganization(String name)
      throws JAXRException;
   public Organization createOrganization(InternationalString name)
      throws JAXRException;

   public PersonName createPersonName(String fullName) throws JAXRException;
   public PersonName createPersonName(String firstName, String middleName,
      String lastName)
      throws JAXRException;

   public PostalAddress createPostalAddress(String streetNumber, String street,
      String city, String stateOrProvince, String country, String postalCode,
      String type) throws JAXRException;

   public RegistryPackage createRegistryPackage(String name)
      throws JAXRException;
   public RegistryPackage createRegistryPackage(InternationalString name)
      throws JAXRException;

   public Service createService(String name)
      throws JAXRException;
   public Service createService(InternationalString name)
      throws JAXRException;

   public ServiceBinding createServiceBinding() throws JAXRException;

   public Slot createSlot(String name, String value, String slotType)
      throws JAXRException;
   public Slot createSlot(String name, Collection values, String slotType) 
      throws JAXRException;

   public SpecificationLink createSpecificationLink() throws JAXRException;
   public TelephoneNumber createTelephoneNumber() throws JAXRException;
   public User createUser() throws JAXRException;

   public BulkResponse deleteObjects(Collection keys) throws JAXRException;
   public BulkResponse deleteObjects(Collection keys, String objectType)
      throws JAXRException;

   public BulkResponse deprecateObjects(Collection keys) throws JAXRException;

   public RegistryService getRegistryService() throws JAXRException;
   public BulkResponse saveObjects(Collection objects) throws JAXRException;
   public BulkResponse unDeprecateObjects(Collection keys) throws JAXRException;

}
