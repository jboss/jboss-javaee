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
package javax.enterprise.deploy.spi;

import java.io.InputStream;
import java.io.OutputStream;

import javax.enterprise.deploy.model.DDBeanRoot;
import javax.enterprise.deploy.model.DeployableObject;
import javax.enterprise.deploy.spi.exceptions.BeanNotFoundException;
import javax.enterprise.deploy.spi.exceptions.ConfigurationException;

/**
 * A container for server specific configuration for a top level deployment.
 *
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @version $Revision$
 */
public interface DeploymentConfiguration
{
   // Constants -----------------------------------------------------
   
   // Public --------------------------------------------------------

   /**
    * Return an object that provides access to the deployment descriptor
    *
    * @return the deployable object
    */
   DeployableObject getDeployableObject();
   
   /**
    * Return the top level configuration for a deployment descriptor
    *
    * @param bean the root of the deployment descriptor
    * @return the configuration
    * @throws ConfigurationException for an error in the deployment descriptor
    */
   DConfigBeanRoot getDConfigBeanRoot(DDBeanRoot bean) throws ConfigurationException;
   
   /**
    * Remove a root configuration and all its children
    *
    * @param bean the configuration
    * @throws BeanNotFoundException when the bean is not found
    */
   void removeDConfigBean(DConfigBeanRoot bean) throws BeanNotFoundException;
   
   /**
    * Restore a configuration from an input stream
    *
    * @param input the input stream
    * @param bean the deployment descriptor
    * @return the configuration
    * @throws ConfigurationException when there is an error in the configuration
    */
   DConfigBeanRoot restoreDConfigBean(InputStream input, DDBeanRoot bean) throws ConfigurationException;
   
   /**
    * Save a configuration to an output stream
    *
    * @param output the output stream
    * @param bean the configuration
    * @throws ConfigurationException when there is an error in the configuration
    */
   void saveDConfigBean(OutputStream output, DConfigBeanRoot bean) throws ConfigurationException;

   /**
    * Restores a full set of configuration beans
    *
    * @param input the input stream
    * @throws ConfigurationException for an error in the configuration
    */
   void restore(InputStream input) throws ConfigurationException;
   
   /**
    * Saves the fulls set of configuration beans
    *
    * @param output the output stream
    * @throws ConfigurationException for an error in the configuration
    */
   void save(OutputStream output) throws ConfigurationException;
}
