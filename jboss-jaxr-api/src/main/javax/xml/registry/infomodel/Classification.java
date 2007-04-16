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

import javax.xml.registry.JAXRException;

/**
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 */
public interface Classification
   extends RegistryObject
{
   public abstract ClassificationScheme getClassificationScheme() throws JAXRException;

   public abstract RegistryObject getClassifiedObject() throws JAXRException;

   public abstract Concept getConcept() throws JAXRException;

   public abstract String getValue() throws JAXRException;

   public abstract boolean isExternal() throws JAXRException;

   public abstract void setClassificationScheme(ClassificationScheme classificationScheme)
      throws JAXRException;

   public abstract void setClassifiedObject(RegistryObject classifiedObject)
      throws JAXRException;

   public abstract void setConcept(Concept concept)
      throws JAXRException;

   public abstract void setValue(String value)
      throws JAXRException;

}
