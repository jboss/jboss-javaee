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
package javax.enterprise.deploy.model;

import javax.enterprise.deploy.shared.ModuleType;

/**
 * A deployable object for an ear
 * 
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @version $Revision$
 */
public interface J2eeApplicationObject extends DeployableObject
{
   // Constants -----------------------------------------------------
   
   // Public --------------------------------------------------------

   /**
    * Retrieve a deployable object
    *
    * @param uri describes where to get the deployable object
    * @return the deployable object or null if there is no such object
    */
   DeployableObject getDeployableObject(String uri);

   /**
    * Get all deployable objects in this application of the given module type
    *
    * @param type the module type
    * @return the deployable objects or null if there are no such objects
    */
   DeployableObject[] getDeployableObjects(ModuleType type);
   
   /**
    * Get all deployable objects in this application
    *
    * @return the deployable objects or null are no such objects
    */
   DeployableObject[] getDeployableObjects();
   
   /**
    * Return the list of module uris for a give module type
    *
    * @param type the module type
    * @return the uris or null if there are none
    */
   String[] getModuleUris(ModuleType type);
   
   /**
    * Return the list of module uris
    *
    * @return the uris or null if there are none
    */
   String[] getModuleUris();
   
   /**
    * Get the child elements with the specified xpath
    *
    * @param xpath the xpath of the children
    * @return an array of children or null if there are none
    */
   DDBean[] getChildBean(ModuleType type, String xpath);
   
   /**
    * Get the text for the given xpath
    *
    * @param xpath the xpath
    * @return an array of Strings for the xpath or null if there are none
    */
   String[] getText(ModuleType type, String xpath);
   
   /**
    * Register a listener for a given xpath
    *
    * @param xpath the xpath
    * @param xpl the listener
    */
   void addXpathListener(ModuleType type, String xpath, XpathListener xpl);
   
   /**
    * Unregister a listener for a given xpath
    *
    * @param xpath the xpath
    * @param xpl the listener
    */
   void removeXpathListener(ModuleType type, String xpath, XpathListener xpl);
}