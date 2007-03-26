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

import java.util.Timer;

import javax.resource.spi.work.WorkManager;

/**
 * Used to pass context to the resource adapter start(BootstrapContext) method.
 */
public interface BootstrapContext
{
   /**
	 * Creates a new Timer that can be used to perform period work.
	 * 
	 * @return the timer instance
	 * @throws UnavailableException when not timer is available. It can be
	 *            retried later.
	 */
   Timer createTimer() throws UnavailableException;

   /**
	 * Get the work manager, the resource adapter should use this for all work
	 * on new threads.
	 * 
	 * @return the work manager
	 */
   WorkManager getWorkManager();

   /**
	 * Get the XATerminator. The resource adapter should use this to gain access
	 * to the transaction and crash recovery.
	 * 
	 * @return the XATerminator
	 */
   XATerminator getXATerminator();
}