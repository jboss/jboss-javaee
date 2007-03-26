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
 * A LocalTransactionException represents various error conditions related to
 * local transaction management. Common error conditions which are indicated by
 * this exception include failure to commit, attempt to start a transaction
 * while inside a transaction, or any resource adapter transaction related
 * error condition.
 */
public class LocalTransactionException extends ResourceException
{
   /**
	 * Create an exception.
	 */
   public LocalTransactionException()
   {
      super();
   }

   /**
	 * Create an exception with a reason.
	 */
   public LocalTransactionException(String reason)
   {
      super(reason);
   }

   /**
	 * Create an exception with a reason and an errorCode.
	 */
   public LocalTransactionException(String reason, String errorCode)
   {
      super(reason, errorCode);
   }

   /**
	 * Create an exception with a reason and cause.
	 * 
	 * @param reason the reason
	 * @param cause the cause
	 */
   public LocalTransactionException(String reason, Throwable cause)
   {
      super(reason, cause);
   }

   /**
	 * Create an exception with a cause.
	 * 
	 * @param cause the cause
	 */
   public LocalTransactionException(Throwable cause)
   {
      super(cause);
   }
}