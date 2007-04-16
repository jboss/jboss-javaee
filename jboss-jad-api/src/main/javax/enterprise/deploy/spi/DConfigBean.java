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

import java.beans.PropertyChangeListener;

import javax.enterprise.deploy.model.DDBean;
import javax.enterprise.deploy.model.XpathEvent;
import javax.enterprise.deploy.spi.exceptions.BeanNotFoundException;
import javax.enterprise.deploy.spi.exceptions.ConfigurationException;

/**
 * A configuration associated with one or more deployment descriptors.
 *
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @version $Revision$
 */
public interface DConfigBean
{
   // Constants -----------------------------------------------------
   
   // Public --------------------------------------------------------
   
   /**
    * Get the XML text for this configuration
    *
    * @return the xml text
    */
   DDBean getDDBean();
   
   /**
    * Get the xpaths this deployment descriptor requires
    *
    * @return the xpaths
    */
   String[] getXpaths();
   
   /**
    * Return the JavaBean containing server specific deployment information
    *
    * @param bean the xml data to be evaluated
    * @return the server specific configuration 
    * @throws ConfigurationException for errors generating the configuring bean
    */
   DConfigBean getDConfigBean(DDBean bean) throws ConfigurationException;
   
   /**
    * Remove a child
    *
    * @param bean the child
    * @throws BeanNotFoundException when the bean is not found
    */
   void removeDConfigBean(DConfigBean bean) throws BeanNotFoundException;
   
   /**
    * A notification that the DDBean provided has changed and that this bean or
    * child needs re-evaluating
    *
    * @param event the event
    */
   void notifyDDChange(XpathEvent event);
   
   /**
    * Add a property change listener
    *
    * @param listener the listener
    */
   void addPropertyChangeListener(PropertyChangeListener listener);
   
   /**
    * Remove a property change listener
    *
    * @param listener the listener
    */
   void removePropertyChangeListener(PropertyChangeListener listener);
}
