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

import java.io.File;
import java.io.InputStream;
import java.util.Locale;

import javax.enterprise.deploy.model.DeployableObject;
import javax.enterprise.deploy.shared.DConfigBeanVersionType;
import javax.enterprise.deploy.shared.ModuleType;
import javax.enterprise.deploy.spi.exceptions.InvalidModuleException;
import javax.enterprise.deploy.spi.exceptions.TargetException;
import javax.enterprise.deploy.spi.exceptions.DConfigBeanVersionUnsupportedException;
import javax.enterprise.deploy.spi.status.ProgressObject;

/**
 * The core object for deploying modules to a j2ee environment
 *
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @version $Revision$
 */
public interface DeploymentManager
{
   // Constants -----------------------------------------------------
   
   // Public --------------------------------------------------------
   
   /**
    * Get the available targets
    *
    * @return the available targets
    * @throws IllegalStateException when the manager is disconnected
    */
   Target[] getTargets() throws IllegalStateException;

   /**
    * Get the running modules
    *
    * @param moduleType the module type
    * @param targets    the targets
    * @return the target modules
    * @throws TargetException       an invalid target
    * @throws IllegalStateException when the manager is disconnected
    */
   TargetModuleID[] getRunningModules(ModuleType moduleType, Target[] targets) throws TargetException, IllegalStateException;

   /**
    * Get the non running modules
    *
    * @param moduleType the module type
    * @param targets    the targets
    * @return the target modules
    * @throws TargetException       an invalid target
    * @throws IllegalStateException when the manager is disconnected
    */
   TargetModuleID[] getNonRunningModules(ModuleType moduleType, Target[] targets) throws TargetException, IllegalStateException;

   /**
    * Get the available modules both running and non running
    *
    * @param moduleType the module type
    * @param targets    the targets
    * @return the target modules
    * @throws TargetException       an invalid target
    * @throws IllegalStateException when the manager is disconnected
    */
   TargetModuleID[] getAvailableModules(ModuleType moduleType, Target[] targets) throws TargetException, IllegalStateException;

   /**
    * Retrieve server specific configuration for a component
    *
    * @param obj the deployable component
    * @return the configuration
    * @throws InvalidModuleException when the module does not exist or is not supported
    */
   DeploymentConfiguration createConfiguration(DeployableObject obj) throws InvalidModuleException;

   /**
    * Validates the configuration, generates all container specific classes and moves the archive
    * to the targets
    *
    * @param targets        the targets
    * @param moduleArchive  the module archive
    * @param deploymentPlan the runtime configuration
    * @return the progress object
    * @throws IllegalStateException when the manager is disconnected
    */
   ProgressObject distribute(Target[] targets, File moduleArchive, File deploymentPlan) throws IllegalStateException;

   /**
    * Validates the configuration, generates all container specific classes and moves the archive
    * to the targets
    *
    * @param targets        the targets
    * @param moduleArchive  the module archive
    * @param deploymentPlan the runtime configuration
    * @return the progress object
    * @throws IllegalStateException when the manager is disconnected
    */
   ProgressObject distribute(Target[] targets, InputStream moduleArchive, InputStream deploymentPlan) throws IllegalStateException;

   /**
    * The distribute method performs three tasks; it validates the deployment configuration
    * data, generates all container specific classes and interfaces, and moves the fully
    * baked archive to the designated deployment targets.
    * @param targets        the targets
    * @param moduleArchive  the module archive
    * @param deploymentPlan the runtime configuration
    * @return the progress object
    * @throws IllegalStateException when the manager is disconnected
    */
   public ProgressObject distribute(Target[] targets, ModuleType type,
         InputStream moduleArchive, InputStream deploymentPlan)
         throws IllegalStateException;

   /**
    * Start the modules
    *
    * @param moduleIDList the list of modules
    * @return the progress object
    * @throws IllegalStateException when the manager is disconnected
    */
   ProgressObject start(TargetModuleID[] moduleIDList) throws IllegalStateException;

   /**
    * Stop the modules
    *
    * @param moduleIDList the list of modules
    * @return the progress object
    * @throws IllegalStateException when the manager is disconnected
    */
   ProgressObject stop(TargetModuleID[] moduleIDList) throws IllegalStateException;

   /**
    * Removes the modules
    *
    * @param moduleIDList the list of modules
    * @return the progress object
    * @throws IllegalStateException when the manager is disconnected
    */
   ProgressObject undeploy(TargetModuleID[] moduleIDList) throws IllegalStateException;

   /**
    * Is redeploy supported
    *
    * @return true when redeploy is supported, false otherwise
    */
   boolean isRedeploySupported();

   /**
    * Redeploys the modules
    *
    * @param moduleIDList the list of modules
    * @return the progress object
    * @throws IllegalStateException         when the manager is disconnected
    * @throws UnsupportedOperationException when redeploy is not supported
    */
   ProgressObject redeploy(TargetModuleID[] moduleIDList, File moduleArchive, File deploymentPlan)
           throws UnsupportedOperationException, IllegalStateException;

   /**
    * Redeploys the modules
    *
    * @param moduleIDList the list of modules
    * @return the progress object
    * @throws IllegalStateException         when the manager is disconnected
    * @throws UnsupportedOperationException when redeploy is not supported
    */
   ProgressObject redeploy(TargetModuleID[] moduleIDList, InputStream moduleArchive, InputStream deploymentPlan)
           throws UnsupportedOperationException, IllegalStateException;

   /**
    * Release the deployment manager
    */
   void release();

   /**
    * Get the default locale
    *
    * @return the default locale
    */
   Locale getDefaultLocale();

   /**
    * Get the current local
    *
    * @return the current locale
    */
   Locale getCurrentLocale();

   /**
    * Set the locale
    *
    * @param locale the new local
    * @throws UnsupportedOperationException when the locale is not supported
    */
   void setLocale(Locale locale) throws UnsupportedOperationException;

   /**
    * Get the supported locales
    *
    * @return the supported locales
    */
   Locale[] getSupportedLocales();

   /**
    * Is the locale supported
    *
    * @param locale the locale
    * @return true when supported, false otherwise
    */
   boolean isLocaleSupported(Locale locale);

   /**
    * Get the J2EE platform version
    *
    * @return the version
    */
   DConfigBeanVersionType getDConfigBeanVersion();

   /**
    * Test whether the version is supported
    *
    * @param version the version
    * @return true when supported, false otherwise
    */
   boolean isDConfigBeanVersionSupported(DConfigBeanVersionType version);

   /**
    * Set the J2EE version
    *
    * @param version the version
    * @throws UnsupportedOperationException when the version is not supported
    */
   void setDConfigBeanVersion(DConfigBeanVersionType version)
           throws DConfigBeanVersionUnsupportedException;
}
