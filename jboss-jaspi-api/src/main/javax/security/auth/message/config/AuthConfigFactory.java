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
package javax.security.auth.message.config;

import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.SecurityPermission;
import java.util.Map;

import javax.security.auth.message.AuthException;
 

//$Id$

/**
 *  <p>This class is used to obtain AuthConfigProvider objects that can be used to 
 *  obtain authentication context configuration objects, i.e., ClientAuthConfig and 
 *  ServerAuthConfig objects. Authentication context configuration objects are used 
 *  to obtain authentication context objects. Authentication context objects, 
 *  i.e., ClientAuthContext and ServerAuthContex objects encapsulate authentication 
 *  modules. Authentication modules are pluggable components that perform 
 *  security-related processing of request and response messages.</p>
 *  <p>Callers do not operate on modules directly. Instead they rely on an authentication 
 *  context to manage the invocation of modules. A caller obtains an authentication 
 *  context by calling the getAuthContext method on a ClientAuthConfig or ServerAuthConfig 
 *  obtained from an AuthConfigProvider.</p>
 *  <p>The following represents a typical sequence of calls for obtaining a client 
 *  authentication context, and then using it to secure a request.</p>
 *  <ol>
 *  <li>AuthConfigFactory factory = AuthConfigFactory.getFactory();</li>
 *  <li>AuthConfigProvider provider = factory.getConfigProvider(layer,appID,null);</li>
 *  <li>ClientAuthConfig config = provider.getClientAuthConfig(layer,appID,cbh)</li>
 *  <li>String operation = config.getOperation(authParam);</li>
 *  <li>ClientAuthContext context = config.getAuthContext(operation,properties);</li>
 *  <li>context.secureRequest(authParam,subject,...);</li>
 *  </ol>
 *  <p>A system-wide AuthConfigFactory implementation can be set by invoking 
 *  setFactory, and retrieved via getFactory.</p>
 *  <p>Every implementation of this abstract class must offer a public, zero argument 
 *  constructor. This constructor must support the construction and registration of 
 *  AuthConfigProviders from a persistent declarative representation.</p>
 *  <p>For example, a factory implementation class could interpret the contents of a 
 *  file containing a sequence of configuration entries, with one entry per 
 *  AuthConfigProvider, with each entry representing the following 5 values:</p>
 *  <ul>
 *  <li>the fully qualified name of the provider implementation class</li>
 *  <li>the pathname of the provider initialization file</li>
 *  <li>the message layer name</li>
 *  <li>the application context identifier</li>
 *  <li>the registration description</li>
 *  </ul> 
 *  <p>A value would be required for the implementation class. The remaining values 
 *  could be optional, and when specified, the contents of the provider initialization 
 *  file could be required to conform to the syntax defined by 
 *  <a href="http://java.sun.com/dtd/properties.dtd">http://java.sun.com/dtd/properties.dtd</a> 
 *  (which can be loaded into a Properties object).</p>
 *  
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)</a> 
 *  @since  May 12, 2006 
 *  @version $Revision$
 */
public abstract class AuthConfigFactory
{
   private static AuthConfigFactory _factory = null;
   private static final String FACTORY_PROP = "authconfigprovider.factory";
   
   /** The default AuthConfigFactory implementation */
   static final String DEFAULT_FACTORY_SECURITY_PROPERTY = 
      "org.jboss.security.auth.message.config.JBossAuthConfigFactory";
   
   public AuthConfigFactory()
   { 
   }
   
   /**
    * Disassociate the listener from all the provider registrations whose layer and 
    * appContext values are matched by the corresponding arguments to this method.
    * 
    * @param listener the RegistrationListener to be detached.
    * @param layer a String identifying the message layer or null.
    * @param appContext a String value identifying the application contex or null.
    * @return
    */
   public abstract String[] detachListener(RegistrationListener  listener, String layer, 
         String appContext);
   
   /**
    * Get a registered AuthConfigProvider from the factory. Get the provider of 
    * ServerAuthConfig and/or ClientAuthConfig objects registered for the identified 
    * message layer and application context.
    * 
    * @param layer a String identifying the message layer for which the registered 
    *              AuthConfigProvider is to be returned. This argument may be null.
    * @param appContext a String that identifys the application messaging context for 
    *             which the registered AuthConfigProvider is to be returned. This 
    *             argument may be null.
    * @param listener the RegistrationListener whose notify method is to be invoked 
    *             if the corresponding registration is unregistered or replaced. The 
    *             value of this argument may be null.
    * @return the implementation of the AuthConfigProvider interface registered at the 
    *         factory for the layer and appContext or null if no AuthConfigProvider 
    *         is selected.
    *         <p>All factories shall employ the following precedence rules to select 
    *         the registered AuthConfigProvider that matches the layer and appContext 
    *         arguments:</p>
    *         <ul>
    *         <li>The provider that is specifically registered for both the corresponding 
    *         message layer and appContext shall be selected.</li>
    *         <li>if no provider is selected according to the preceding rule, the provider 
    *         specifically registered for the corresponding appContext and for all message 
    *         layers shall be selected.</li>
    *         <li>if no provider is selected according to the preceding rules, the provider
    *         specifically registered for the corresponding message layer and for all 
    *         appContexts shall be selected.</li>
    *         <li>if no provider is selected according to the preceding rules, the provider
    *         registered for all message layers and for all appContexts shall be selected.</li>
    *         <li>if no provider is selected according to the preceding rules, the factory 
    *         shall terminate its search for a registered provider.</li>
    */
   public abstract AuthConfigProvider  getConfigProvider( String layer, 
         String appContext, RegistrationListener listener);
   
   /**
    * <p>Get the system-wide AuthConfigFactory implementation.</p>
    * <p>If a non-null system-wide factory instance is defined at the time of the call, 
    * e.g., with setfactory, it will be returned. Otherwise, an attempt will be made to 
    * construct an instance of the default AuthConfigFactory implementation class. The 
    * fully qualified class name of the default factory implementation class is obtained
    * from the value of the “authconfigprovider.factory” security property.  When an 
    * instance of the defaultfactory implementation class is successfully constructed by 
    * this method, this method will set it as the system-wide factory instance.</p>
    * 
    * @return the non-null system-wide AuthConfigFactory instance set at the time of the 
    *         call, or if that value was null, the value of the system-wide factory 
    *         instance established by this method. This method returns null when the 
    *         system-wide factory was not defined when this method was called and no 
    *         default factory name was defined via the security property.
    */
   public static AuthConfigFactory getFactory()
   {
      //Validate the caller permission
      SecurityManager sm = System.getSecurityManager();
      if (sm != null)
         sm.checkPermission(new SecurityPermission("getFactory"));

      if (_factory == null)
      {
         String factoryName = null;
         Class clazz = null;
         try
         {
            LoadAction action = new LoadAction();
            try
            {
               clazz = (Class) AccessController.doPrivileged(action);
               factoryName = action.getName();
            }
            catch (PrivilegedActionException ex)
            {
               factoryName = action.getName();
               Exception e = ex.getException();
               if (e instanceof ClassNotFoundException)
                  throw (ClassNotFoundException) e;
               else
                  throw new IllegalStateException("Failure during load of class: " + action.getName() + e);
            }
            _factory = (AuthConfigFactory) clazz.newInstance();
         }
         catch (ClassNotFoundException e)
         {
            String msg = "Failed to find AuthConfigFactory : " + factoryName;
            IllegalStateException ise = new IllegalStateException(msg);
            ise.initCause(e);
            throw ise;
         }
         catch (IllegalAccessException e)
         {
            String msg = "Unable to access class : " + factoryName;
            IllegalStateException ise = new IllegalStateException(msg);
            ise.initCause(e);
            throw ise;
         }
         catch (InstantiationException e)
         {
            String msg = "Failed to create instance of: " + factoryName;
            IllegalStateException ise = new IllegalStateException(msg);
            ise.initCause(e);
            throw ise;
         }
         catch (ClassCastException e)
         {
            StringBuffer msg = new StringBuffer(factoryName + " Is not a AuthConfigFactory, ");
            msg.append("ACF.class.CL: "+ AuthConfigFactory.class.getClassLoader());
            msg.append("\nACF.class.CS: " + AuthConfigFactory.class.getProtectionDomain().getCodeSource());
            msg.append("\nACF.class.hash: "+System.identityHashCode(AuthConfigFactory.class));
            msg.append("\nclazz.CL: "+clazz.getClassLoader());
            msg.append("\nclazz.CS: "+clazz.getProtectionDomain().getCodeSource());
            msg.append("\nclazz.super.CL: "+clazz.getSuperclass().getClassLoader());
            msg.append("\nclazz.super.CS: "+clazz.getSuperclass().getProtectionDomain().getCodeSource());
            msg.append("\nclazz.super.hash: "+System.identityHashCode(clazz.getSuperclass()));
            ClassCastException cce = new ClassCastException(msg.toString());
            cce.initCause(e);
            throw cce;
         }
      }
      return _factory;
   }
   
   public abstract RegistrationContext getRegistrationContext(String registrationID);
   
   public abstract String[] getRegistrationIDs(AuthConfigProvider provider);
   
   public abstract void refresh() throws AuthException, SecurityException;
   
   public abstract String registerConfigProvider( String className, Map properties,String layer,
           String appContext,  String description) throws AuthException, SecurityException;
   
   public abstract java.lang.String registerConfigProvider(AuthConfigProvider provider,
          String layer,  String appContext,  String description);
   
   public abstract boolean removeRegistration( String registrationID);
   
   public static void setFactory(AuthConfigFactory factory)
   { 
      _factory = factory;
   }
   
   /**
    * Represents the layer identifier, application context identifier., and description 
    * components of an AuthConfigProvider registration at the factory
    */
   public static interface RegistrationContext
   {
      /**
       * Get the application context identifier from the registration context
       * 
       * @return a String identifying the application context for which the 
       *         AuthConfigProvider was registered. The returned value may be null.
       */
      String getAppContext();
      
      /**
       * Get the description from the registration context
       * 
       * @return the description String from the registration, or null, if no 
       *         description string was included in the registration.
       */
      String getDescription();
      
      /**
       * Get the layer name from the registration context
       * @return a String identifying the message layer for which the AuthConfigProvider 
       *                  was registered. the returned value may be null.
       */
      String getMessageLayer();
      
      public boolean isPersistent();
   }
   
   
   
   /** A PrivilegedExceptionAction that looks up the class name identified
    * by the authcontextfactory.provider system property and loads the class 
    * using the thread context class loader.
    */ 
   private static class LoadAction implements PrivilegedExceptionAction
   {
      private String name;
      public String getName()
      {
         return name;
      }
      public Object run()
         throws Exception
      {
         name = System.getProperty(FACTORY_PROP);
         if( name == null )
         {
            // Use the default factory impl
            name = DEFAULT_FACTORY_SECURITY_PROPERTY;
         }
         ClassLoader loader = Thread.currentThread().getContextClassLoader();
         Class factoryClass = loader.loadClass(name);
         return factoryClass;
      }
   }
}
