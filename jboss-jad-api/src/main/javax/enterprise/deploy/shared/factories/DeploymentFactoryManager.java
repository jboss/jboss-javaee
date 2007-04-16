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
package javax.enterprise.deploy.shared.factories;

// $Id$

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.enterprise.deploy.spi.DeploymentManager;
import javax.enterprise.deploy.spi.exceptions.DeploymentManagerCreationException;
import javax.enterprise.deploy.spi.factories.DeploymentFactory;

import org.jboss.logging.Logger;

/**
 * The DeploymentFactoryManager class is a central registry for J2EE DeploymentFactory objects. 
 * 
 * The DeploymentFactoryManager retains references to DeploymentFactory objects loaded by a tool. 
 * A DeploymentFactory object provides a reference to a DeploymentManager. 
 * The DeploymentFactoryManager has been implemented as a singleton. 
 * A tool gets a reference to the DeploymentFactoryManager via the getInstance method. 
 * The DeploymentFactoryManager can return two types of DeploymentManagers, 
 * a connected DeploymentManager and a disconnected DeploymentManager. 
 * The connected DeploymentManager provides access to any product resources that 
 * may be required for configurations and deployment. 
 * The method to retrieve a connected DeploymentManager is getDeploymentManager. 
 * This method provides parameters for user name and password that the product 
 * may require for user authentication. A disconnected DeploymentManager does not 
 * provide access to a running J2EE product. The method to retrieve a disconnected 
 * DeploymentManager is getDisconnectedDeploymentManager. 
 * A disconnected DeploymentManager does not need user authentication information.
 *
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @author Thomas.Diesler@jboss.org
 * @version $Revision$
 */
public final class DeploymentFactoryManager
{
   // deployment logging
   private static final Logger log = Logger.getLogger(DeploymentFactoryManager.class);

   /** The instance */
   private static final DeploymentFactoryManager instance = new DeploymentFactoryManager();

   // Attributes ----------------------------------------------------

   /** The deployment factories */
   private Set deploymentFactories = Collections.synchronizedSet(new HashSet());

   // hide default constructor
   private DeploymentFactoryManager()
   {
   }

   /**
    * Retrieve the instance of the deployment factory manager
    *
    * @return the deployment factory manager
    */
   public static DeploymentFactoryManager getInstance()
   {
      return instance;
   }

   /**
    * Retrieve the deployment factories
    *
    * @return an array of deployment factories
    */
   public DeploymentFactory[] getDeploymentFactories()
   {
      DeploymentFactory[] template = new DeploymentFactory[0];
      return (DeploymentFactory[])deploymentFactories.toArray(template);
   }

   /**
    * Get a connected deployment manager
    *
    * @param uri the uri of the deployment manager
    * @param userName the user name
    * @param password the password 
    * @return the deployment manager
    * @throws DeploymentManagerCreationException
    */
   public DeploymentManager getDeploymentManager(String uri, String userName, String password) throws DeploymentManagerCreationException
   {
      Set clone;
      synchronized (deploymentFactories)
      {
         clone = new HashSet(deploymentFactories);
      }
      for (Iterator i = clone.iterator(); i.hasNext();)
      {
         DeploymentFactory factory = (DeploymentFactory)i.next();
         if (factory.handlesURI(uri))
            return factory.getDeploymentManager(uri, userName, password);
      }
      throw new DeploymentManagerCreationException("No deployment manager for uri=" + uri);
   }

   /**
    * Register a deployment factory
    *
    * @param factory the deployment factory
    */
   public void registerDeploymentFactory(DeploymentFactory factory)
   {
      deploymentFactories.add(factory);
   }

   /**
    * Get a disconnected version of the deployment manager
    *
    * @param uri the uri to connect to
    * @return the disconnected deployment manager
    * @throws DeploymentManagerCreationException
    */
   public DeploymentManager getDisconnectedDeploymentManager(String uri) throws DeploymentManagerCreationException
   {
      Set clone;
      synchronized (deploymentFactories)
      {
         clone = new HashSet(deploymentFactories);
      }
      for (Iterator i = clone.iterator(); i.hasNext();)
      {
         DeploymentFactory factory = (DeploymentFactory)i.next();
         if (factory.handlesURI(uri))
            return factory.getDisconnectedDeploymentManager(uri);
      }
      throw new DeploymentManagerCreationException("No deployment manager for uri=" + uri);
   }
}
