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

import javax.enterprise.deploy.spi.TargetModuleID;
import javax.enterprise.deploy.spi.exceptions.OperationUnsupportedException;

/**
 * Tracks the progress of a deployment
 *
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @version $Revision$
 */
public interface ProgressObject
{
   // Constants -----------------------------------------------------
   
   // Public --------------------------------------------------------
   
   /**
    * Retrieve the status of the deployment
    *
    * @return the status
    */
   DeploymentStatus getDeploymentStatus();
   
   /**
    * Retrieve the resulting target module ids
    *
    * @return the module ids
    */
   TargetModuleID[] getResultTargetModuleIDs();
   
   /**
    * Return the client configuration associated with the module
    *
    * @param id the module id
    * @return the client configuration or null if none exists
    */
   ClientConfiguration getClientConfiguration(TargetModuleID id);
   
   /**
    * Is cancel supported
    *
    * @return true when cancel is supported, false otherwise
    */
   boolean isCancelSupported();
   
   /**
    * Cancels the deployment
    *
    * @throws OperationUnsupportedException when cancel is not supported
    */
   void cancel() throws OperationUnsupportedException;
   
   /**
    * Is stop supported
    *
    * @return true when stop is supported, false otherwise
    */
   boolean isStopSupported();
   
   /**
    * Stops the deployment
    *
    * @throws OperationUnsupportedException when stop is not supported
    */
   void stop() throws OperationUnsupportedException;
   
   /**
    * Add a progress listener
    *
    * @param listener the listener
    */
   void addProgressListener(ProgressListener listener);
   
   /**
    * Remove a progress listener
    *
    * @param listener the listener
    */
   void removeProgressListener(ProgressListener listener);
}
