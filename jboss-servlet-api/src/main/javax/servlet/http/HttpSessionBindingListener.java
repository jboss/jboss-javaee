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
 * Causes an object to be notified when it is bound to or unbound from a
 * session. The object is notified by an {@link HttpSessionBindingEvent} object.
 * This may be as a result of a servlet programmer explicitly unbinding an
 * attribute from a session, due to a session being invalidated, or due to a
 * session timing out.
 * 
 * @author Various
 * @see HttpSession
 * @see HttpSessionBindingEvent
 */

public interface HttpSessionBindingListener extends EventListener
{

   /**
    * Notifies the object that it is being bound to a session and identifies the
    * session.
    * 
    * @param event
    *           the event that identifies the session
    * @see #valueUnbound
    */

   public void valueBound(HttpSessionBindingEvent event);

   /**
    * Notifies the object that it is being unbound from a session and identifies
    * the session.
    * 
    * @param event
    *           the event that identifies the session
    * @see #valueBound
    */

   public void valueUnbound(HttpSessionBindingEvent event);

}
