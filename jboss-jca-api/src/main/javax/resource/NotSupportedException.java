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
package javax.resource;

/**
 * A NotSupportedException is thrown to indicate that the callee (resource
 * adapter or application server for system contracts) cannot execute an
 * operation because the operation is not a supported feature. For example, if
 * the transaction support level for a resource adapter is NO_TRANSACTION, an
 * invocation of ManagedConnection.getXAResource method should throw
 * NotSupportedException exception.
 */
public class NotSupportedException extends ResourceException
{
   /**
	 * Create a not supported exception.
	 */
   public NotSupportedException()
   {
      super();
   }

   /**
	 * Create a not supported exception with a reason.
	 * 
	 * @param reason the reason
	 */
   public NotSupportedException(String reason)
   {
      super(reason);
   }

   /**
	 * Create a not supported exception with a reason and an errorCode.
	 * 
	 * @param reason the reason
	 * @param errorCode the error code
	 */
   public NotSupportedException(String reason, String errorCode)
   {
      super(reason, errorCode);
   }

   /**
	 * Create a not supported exception with a reason and an error.
	 * 
	 * @param reason the reason
	 * @param throwable the error
	 */
   public NotSupportedException(String reason, Throwable throwable)
   {
      super(reason, throwable);
   }

   /**
	 * Create a not supported exception with an error.
	 * 
	 * @param throwable the error
	 */
   public NotSupportedException(Throwable throwable)
   {
      super(throwable);
   }
}