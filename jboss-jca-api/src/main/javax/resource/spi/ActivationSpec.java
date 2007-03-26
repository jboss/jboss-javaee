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
package javax.resource.spi;

/**
 * A marker interface holding the configuration of a message endpoint.
 * 
 * An instance must be a javabean and be serializable.
 */
public interface ActivationSpec extends ResourceAdapterAssociation
{
   /**
	 * Optional method that can be used to check configuration by a deployment
	 * tool.
	 * 
	 * @throws InvalidPropertyException for invalid configuration
	 */
   void validate() throws InvalidPropertyException;
}