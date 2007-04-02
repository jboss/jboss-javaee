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
package javax.servlet.http;

import java.util.EventListener;

/**
 * Objects that are bound to a session may listen to container * events
 * notifying them that sessions will be passivated and that * session will be
 * activated. A container that migrates session between VMs * or persists
 * sessions is required to notify all attributes bound to sessions *
 * implementing HttpSessionActivationListener. *
 * 
 * @since 2.3
 */

public interface HttpSessionActivationListener extends EventListener
{

   /** Notification that the session is about to be passivated. */
   public void sessionWillPassivate(HttpSessionEvent se);

   /** Notification that the session has just been activated. */
   public void sessionDidActivate(HttpSessionEvent se);
}
