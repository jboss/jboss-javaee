/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2007, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
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
package javax.servlet;

/**
 * Ensures that servlets handle only one request at a time. This interface has
 * no methods.
 * <p>
 * If a servlet implements this interface, you are <i>guaranteed</i> that no
 * two threads will execute concurrently in the servlet's <code>service</code>
 * method. The servlet container can make this guarantee by synchronizing access
 * to a single instance of the servlet, or by maintaining a pool of servlet
 * instances and dispatching each new request to a free servlet.
 * <p>
 * Note that SingleThreadModel does not solve all thread safety issues. For
 * example, session attributes and static variables can still be accessed by
 * multiple requests on multiple threads at the same time, even when
 * SingleThreadModel servlets are used. It is recommended that a developer take
 * other means to resolve those issues instead of implementing this interface,
 * such as avoiding the usage of an instance variable or synchronizing the block
 * of the code accessing those resources. This interface is deprecated in
 * Servlet API version 2.4.
 * 
 * @author Various
 * @deprecated As of Java Servlet API 2.4, with no direct replacement.
 */
@Deprecated
public interface SingleThreadModel
{
}
