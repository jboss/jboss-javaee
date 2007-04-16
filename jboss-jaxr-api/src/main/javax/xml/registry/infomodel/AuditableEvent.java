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

import java.sql.Timestamp;
import javax.xml.registry.JAXRException;

/**
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 */
public interface AuditableEvent
   extends RegistryObject
{
	public static final int EVENT_TYPE_CREATED=0;
	public static final int EVENT_TYPE_DELETED=1;
	public static final int EVENT_TYPE_DEPRECATED=2;
	public static final int EVENT_TYPE_UNDEPRECATED=5;
	public static final int EVENT_TYPE_UPDATED=3;
	public static final int EVENT_TYPE_VERSIONED=4;

	public int getEventType() throws JAXRException;
	public RegistryObject getRegistryObject() throws JAXRException;
	public Timestamp getTimestamp() throws JAXRException;
	public User getUser() throws JAXRException;
}
