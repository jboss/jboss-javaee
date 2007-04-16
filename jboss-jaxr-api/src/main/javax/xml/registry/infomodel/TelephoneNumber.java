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
public interface TelephoneNumber
{
   public String getAreaCode() throws JAXRException;
   public String getCountryCode() throws JAXRException;
   public String getExtension() throws JAXRException;
   public String getNumber() throws JAXRException;
   public String getType() throws JAXRException;
   public String getUrl() throws JAXRException;
   public void setAreaCode(String areaCode) throws JAXRException;
   public void setCountryCode(String cc) throws JAXRException;
   public void setExtension(String ext) throws JAXRException;
   public void setNumber(String number) throws JAXRException;
   public void setType(String type) throws JAXRException;
   public void setUrl(String url) throws JAXRException;

}
