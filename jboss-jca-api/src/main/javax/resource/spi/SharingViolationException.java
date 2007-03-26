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

import javax.resource.ResourceException;

/**
 * Thrown when a shared connection is used in an unshareable manner.
 */
public class SharingViolationException extends ResourceException
{
   /**
	 * Create an exception.
	 */
   public SharingViolationException()
   {
      super();
   }

   /**
	 * Create an exception with a reason.
	 * 
	 * @param reason the reason
	 */
   public SharingViolationException(String reason)
   {
      super(reason);
   }

   /**
	 * Create an exception with a reason and an errorCode.
	 * 
	 * @param reason the reason
	 * @param errorCode the error code
	 */
   public SharingViolationException(String reason, String errorCode)
   {
      super(reason, errorCode);
   }

   /**
	 * Create an exception with a reason and an error.
	 * 
	 * @param reason the reason
	 * @param throwable the error
	 */
   public SharingViolationException(String reason, Throwable throwable)
   {
      super(reason, throwable);
   }

   /**
	 * Create an exception with an error.
	 * 
	 * @param throwable the error
	 */
   public SharingViolationException(Throwable throwable)
   {
      super(throwable);
   }
}