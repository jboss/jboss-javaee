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

import java.beans.PropertyDescriptor;

import javax.resource.ResourceException;

import org.jboss.util.id.SerialVersion;

/**
 * Represents invalid configuration properties
 */
public class InvalidPropertyException extends ResourceException
{
   /** @since 4.0.2 */ 
   static final long serialVersionUID;
   static
   {
      if (SerialVersion.version == SerialVersion.LEGACY)
         serialVersionUID = -2395559483586818078L;
      else
         serialVersionUID = -485903720300735741L;
   }

   /** The invalidProperties */
   PropertyDescriptor[] invalidProperties;
   
   /**
	 * Create an invalid property exception.
	 */
   public InvalidPropertyException()
   {
      super();
   }

   /**
	 * Create an invalid property exception with a reason.
	 * 
	 * @param reason the reason
	 */
   public InvalidPropertyException(String reason)
   {
      super(reason);
   }

   /**
	 * Create an invalid property exception with a reason and an errorCode.
	 * 
	 * @param reason the reason
	 * @param errorCode the error code
	 */
   public InvalidPropertyException(String reason, String errorCode)
   {
      super(reason, errorCode);
   }

   /**
	 * Create an invalid property exception with a reason and an error.
	 * 
	 * @param reason the reason
	 * @param throwable the error
	 */
   public InvalidPropertyException(String reason, Throwable throwable)
   {
      super(reason, throwable);
   }

   /**
	 * Create an invalid property exception with an error.
	 * 
	 * @param throwable the error
	 */
   public InvalidPropertyException(Throwable throwable)
   {
      super(throwable);
   }

   /**
    * Get the invalid property descriptors
    *
    * @return an array of invalid property descriptors
    */
   public PropertyDescriptor[] getInvalidPropertyDescriptors()
   {
      return invalidProperties;
   }

   /**
    * Set the invalid property descriptors
    *
    * @param an array of invalid property descriptors
    */
   public void setInvalidPropertyDescriptors(PropertyDescriptor[] invalidProperties)
   {
      this.invalidProperties = invalidProperties;
   }
}