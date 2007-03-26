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
package javax.resource.spi.work;

import java.util.EventListener;

/**
 * Listens to events on work
 * @version $Revision$
 */
public interface WorkListener extends EventListener
{
   /**
    * Invoked when work is accepted
    *
    * @param e the event
    */
   void workAccepted(WorkEvent e);

   /**
    * Invoked when work is rejected
    *
    * @param e the event
    */
   void workRejected(WorkEvent e);

   /**
    * Invoked when work is started
    *
    * @param e the event
    */
   void workStarted(WorkEvent e);

   /**
    * Invoked when work is completed
    *
    * @param e the event
    */
   void workCompleted(WorkEvent e);
}