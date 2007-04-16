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
package javax.enterprise.deploy.spi.status;

import javax.enterprise.deploy.shared.ActionType;
import javax.enterprise.deploy.shared.CommandType;
import javax.enterprise.deploy.shared.StateType;

/**
 * The status of the deployment.
 *
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @version $Revision$
 */
public interface DeploymentStatus
{
   // Constants -----------------------------------------------------
   
   // Public --------------------------------------------------------
   
   /**
    * Get the state of the deployment
    *
    * @return the state
    */
   StateType getState();
   
   /**
    * The deployment command
    *
    * @return the command
    */
   CommandType getCommand();
   
   /**
    * The action of this deployment
    *
    * @return the action
    */
   ActionType getAction();
   
   /**
    * Get the message
    *
    * @return the message
    */
   String getMessage();
   
   /**
    * Is the deployment complete
    *
    * @return true when complete, false otherwise
    */
   boolean isCompleted();
   
   /**
    * Has the deployment failed
    *
    * @return true when failed, false otherwise
    */
   boolean isFailed();
   
   /**
    * Is the deployment in progress
    *
    * @return true when in progress, false otherwise
    */
   boolean isRunning();
}
