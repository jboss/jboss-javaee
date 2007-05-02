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

import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.message.AuthException;

//$Id$

/**
 *  <p>This interface is implemented by objects that can be used to obtain authentication 
 *  context configuration objects i.e., ClientAuthConfig or ServerAuthConfig objects.
 *  Authentication context configuration objects serve as sources of the authentication 
 *  context objects, i.e, ClientAuthContext or ServerAuthContext objects, for a 
 *  specific message layer and messaging context.</p>
 *  <p>Authentication context objects encapsulate the initialization, configuration, 
 *  and invocation of authentication modules, i.e., ClientAuthModule or ServerAuthModule
 *  objects, for a specific message exchange within a specific message layer and 
 *  messaging context.</p>
 *  <p>Callers do not directly operate on authentication modules. Instead, they rely on 
 *  a ClientAuthContext or ServerAuthContext to manage the invocation of modules. A 
 *  caller obtains an instance of ClientAuthContext or ServerAuthContext by calling the 
 *  respective getAuthContext method on a ClientAuthConfig or ServerAuthConfig object 
 *  obtained from an AuthConfigProvider.</p>
 *  <p> The following represents a typical sequence of calls for obtaining a client 
 *  authentication context object, and then using it to secure a request.</p>
 *  <ol>
 *  <li>AuthConfigProvider provider;</li>
 *  <li>ClientAuthConfig config = provider.getClientAuthConfig(layer,appID,cbh);</li>
 *  <li>String operation = config.getOperation(authParam);</li>
 *  <li>ClientAuthContext context = config.getAuthContext(operation,properties);</li>
 *  <li>context.secureRequest(authParam,subject,...);</li>
 *  </ol>
 *  <p>Every implementation of this interface must offer a public, single argument 
 *  constructor with the following signature:</p>
 *  <pre> public AuthConfigProviderImpl(Map properties);</pre>
 *  <p>where the properties argument may be null, and where all values and keys occuring
 *  in a non-null properties argument must be of type String.</p>
 *  <p>An AuthConfigFactory may be used to obtain the ConfigProvider for a specific 
 *  message layer and application context identifier.</p>
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)</a> 
 *  @since  May 12, 2006 
 *  @version $Revision$
 */
public interface AuthConfigProvider
{
   /**
    * Get an instance of ClientAuthConfig from this provider.
    * The implementation of this method returns a ClientAuthConfig instance that 
    * describes the configuration of ClientAuthModules at a given message layer, and 
    * for use in an identified application context.
    * 
    * @param layer a String identifying the message layer for the returned 
    *              ClientAuthConfig object.
    * @param appContext a String that identifies the messaging context for the 
    *              returned ClientAuthConfig object.
    * @param handler a CallbackHandler to be passed to the ClientAuthModules 
    *               encapsulated by ClientAuthContext objects derived from the 
    *               returned ClientAuthConfig. This parameter may be null, in which 
    *               case the implementation may assign a default handler to the 
    *               configuration. The “authconfigprovider.client.callbackhandler” 
    *               security property is used to define the fully qualified name of 
    *               the default CallbackHandler implementation class.
    * @return a ClientAuthConfig Object that describes the configuration of 
    *               ClientAuthModules at the message layer and messaging context 
    *               identified by the layer and appContext arguments. This method does 
    *               not return null.
    * @throws AuthException if this factory does not support the assignment of a 
    *               default CallbackHandler to the returned ClientAuthConfig.
    * @throws SecurityException if the caller does not have permission to retrieve 
    *               the configuration.
    */
   ClientAuthConfig getClientAuthConfig( String layer, String appContext, 
         CallbackHandler handler) throws AuthException, SecurityException;
   
   /**
    * Get an instance of ServerAuthConfig from this provider.
    * The implementation of this method returns a ServerAuthConfig instance that 
    * describes the configuration of ServerAuthModules at a given message layer, and 
    * for use in an identified application context.
    * 
    * @param layer a String identifying the message layer for the returned 
    *              ServerAuthConfig object.
    * @param appContext a String that identifies the messaging context for the 
    *              returned ServerAuthConfig object.
    * @param handler a CallbackHandler to be passed to the ServerAuthModules 
    *               encapsulated by ServerAuthContext objects derived from the 
    *               returned ServerAuthConfig. This parameter may be null, in which 
    *               case the implementation may assign a default handler to the 
    *               configuration. The “authconfigprovider.client.callbackhandler” 
    *               security property is used to define the fully qualified name of 
    *               the default CallbackHandler implementation class.
    * @return a ServerAuthConfig Object that describes the configuration of 
    *               ServerAuthModules at the message layer and messaging context 
    *               identified by the layer and appContext arguments. This method does 
    *               not return null.
    * @throws AuthException if this factory does not support the assignment of a 
    *               default CallbackHandler to the returned ServerAuthConfig.
    * @throws SecurityException if the caller does not have permission to retrieve 
    *               the configuration.
    */
   ServerAuthConfig getServerAuthConfig( String layer, String appContext,
         CallbackHandler handler) throws AuthException, SecurityException;
   
   /**
    * Causes a dynamic configuration provider to update its internal state such that 
    * any resulting change to its state is recognized by authentication context 
    * configuration objects previously created by the provider within the current 
    * process context.
    * <p> The effect on the authentication context configuration objects should be 
    * extended to the authentication context objects obtained from the configuration 
    * objects, such that the context objects recognize changes in the state of the 
    * configuration object from which they were obtained.</p>
    * @throws AuthException if an error occured during the refresh.
    * @throws SecurityException if the caller does not have permission to 
    *                    refresh the provider.
    */
   void refresh() throws AuthException, SecurityException;
}
