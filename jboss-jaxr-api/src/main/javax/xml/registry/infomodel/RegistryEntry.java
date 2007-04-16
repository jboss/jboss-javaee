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

import java.util.Date;
import javax.xml.registry.JAXRException;

/**
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 */
public interface RegistryEntry
   extends RegistryObject, Versionable
{
   public static final int STABILITY_DYNAMIC=0;
   public static final int STABILITY_DYNAMIC_COMPATIBLE=1;
   public static final int STABILITY_STATIC=2;
   public static final int STATUS_APPROVED=1;
   public static final int STATUS_DEPRECATED=2;
   public static final int STATUS_SUBMITTED=0;
   public static final int STATUS_WITHDRAWN=3;

   public Date getExpiration() throws JAXRException;
   public int getStability() throws JAXRException;
   public int getStatus() throws JAXRException;
   public void setExpiration(Date expiration) throws JAXRException;
   public void setStability(int stability) throws JAXRException;

}
