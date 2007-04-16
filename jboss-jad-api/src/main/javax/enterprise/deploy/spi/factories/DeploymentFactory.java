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
package javax.enterprise.deploy.spi.factories;

// $Id$

import javax.enterprise.deploy.spi.DeploymentManager;
import javax.enterprise.deploy.spi.exceptions.DeploymentManagerCreationException;

/**
 * The DeploymentFactory interface is a deployment driver for a J2EE plaform product. 
 * 
 * It returns a DeploymentManager object which represents a connection to a specific J2EE platform product.
 * Each application server vendor must provide an implementation of this class in order for the J2EE 
 * Deployment API to work with their product.
 * 
 * The class implementing this interface should have a public no-argument constructor, 
 * and it should be stateless (two instances of the class should always behave the same). 
 * It is suggested but not required that the class have a static initializer that registers 
 * an instance of the class with the DeploymentFactoryManager class.
 * 
 * A connected or disconnected DeploymentManager can be requested. 
 * A DeploymentManager that runs connected to the platform can provide access to J2EE resources. 
 * A DeploymentManager that runs disconnected only provides module deployment configuration support. 
 *
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @version $Revision$
 */
public interface DeploymentFactory
{
   // Constants -----------------------------------------------------
   
   // Public --------------------------------------------------------
   
   /**
    * Tests whether the factory can create a manager for the URI
    *
    * @param uri the uri
    * @return true when it can, false otherwise
    */
   boolean handlesURI(String uri);

   /**
    * Get a connected deployment manager
    *
    * @param uri the uri of the deployment manager
    * @param userName the user name
    * @param password the password 
    * @return the deployment manager
    * @throws DeploymentManagerCreationException
    */
   DeploymentManager getDeploymentManager(String uri, String userName, String password) throws DeploymentManagerCreationException;

   /**
    * Get a disconnected version of the deployment manager
    *
    * @param uri the uri to connect to
    * @return the disconnected deployment manager
    * @throws DeploymentManagerCreationException
    */
   DeploymentManager getDisconnectedDeploymentManager(String uri) throws DeploymentManagerCreationException;
   
   /**
    * The vendor of the deployment manager
    *
    * @return the vendor name
    */
   String getDisplayName();
   
   /**
    * The version of the deployment manager
    *
    * @return the version
    */
   String getProductVersion();
}
