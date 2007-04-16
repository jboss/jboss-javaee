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

/**
 * A module deployed to a target.
 *
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @version $Revision$
 */
public interface TargetModuleID
{
   // Constants -----------------------------------------------------
   
   // Public --------------------------------------------------------
   
   /**
    * Get the target
    *
    * @return the target
    */
   Target getTarget();
   
   /**
    * Get the module id
    *
    * @return the id
    */
   String getModuleID();
   
   /**
    * The URL for a web module
    *
    * @return the url
    */
   String getWebURL();

   /**
    * Return the identifier of this module 
    *
    * @return the identifier
    */
   String toString();
   
   /**
    * The parent of this module
    *
    * @return the parent or null if there is no parent
    */
   TargetModuleID getParentTargetModuleID();
   
   /**
    * Get the child modules
    *
    * @return an array of child modules or null if there are no children
    */
   TargetModuleID[] getChildTargetModuleID();
}
