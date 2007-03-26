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
package javax.resource.spi.security;

import javax.resource.spi.SecurityException;

/**
 * The interface GenericCredential defines a method of representing a security
 * credential for a resource which is independent of the security mechanism. It
 * can be used to wrap any type of underlying credentials, for example it could
 * be used to wrap Kerberos credentials. This allows the resource adapter to
 * utilize the credentials for sign-on to the EIS.
 * 
 * @deprecated Use org.ietf.jgss.GSSCredential
 */
public interface GenericCredential
{
   /**
	 * Gets security data from the credential.
	 * 
	 * @deprecated Use org.ietf.jgss.GSSCredential
	 * @return Credential data
	 */
   public byte[] getCredentialData() throws SecurityException;

   /**
	 * Returns the mechanism type for the credential
	 * 
	 * @deprecated Use org.ietf.jgss.GSSCredential
	 * @return Mechanism Type
	 */
   public String getMechType();

   /**
	 * Returns the name of the principal associated with the credential
	 * 
	 * @deprecated Use org.ietf.jgss.GSSCredential
	 * @return Principal name
	 */
   public String getName();

   /**
	 * Tests object for equality
	 * 
	 * @deprecated Use org.ietf.jgss.GSSCredential
	 */
   public boolean equals(Object other);

   /**
	 * Generates a hashCode for this object
	 * 
	 * @deprecated Use org.ietf.jgss.GSSCredential
	 */
   public int hashCode();
}