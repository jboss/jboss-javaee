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
package javax.jms;

/**
 * <P>This exception is thrown when a provider is unable to allocate the 
 *    resources required by a method. For example, this exception should be 
 *    thrown when a call to 
 *    <CODE>TopicConnectionFactory.createTopicConnection</CODE> fails due to a
 *    lack of JMS provider resources.
 **/

public class ResourceAllocationException extends JMSException
{
   private static final long serialVersionUID = -1172695755360706776L;

   /** Constructs a <CODE>ResourceAllocationException</CODE> with the specified 
    *  reason and error code.
    *
    *  @param  reason        a description of the exception
    *  @param  errorCode     a string specifying the vendor-specific
    *                        error code
    *                        
    **/
   public ResourceAllocationException(String reason, String errorCode)
   {
      super(reason, errorCode);
   }

   /** Constructs a <CODE>ResourceAllocationException</CODE> with the specified 
    *  reason. The error code defaults to null.
    *
    *  @param  reason        a description of the exception
    **/
   public ResourceAllocationException(String reason)
   {
      super(reason);
   }

}
