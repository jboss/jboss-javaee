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
package javax.security.auth.message;

import java.util.Map;

import javax.security.auth.Subject;

//$Id$

/**
 *  An implementation of this interface is used to secure service request 
 *  messages, and validate received service response messages.
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)
 *  @since  May 11, 2006 
 *  @version $Revision$
 */
public interface ClientAuth
{
   /**
    * Remove module specific principals and credentials from the subject.
    * @param subject the Subject instance from which the Principals and 
    *                credentials are to be removed.
    * @param sharedState a Map for modules to save state across a sequence 
    *                of calls from secureRequest to validateResponse 
    *                returning AuthStatus.PROCEED
    * @return
    * @throws AuthException if an error occurs during the Subject processing.
    */
   public AuthStatus cleanSubject( Subject subject, Map sharedState)
   throws AuthException;
   
   /**
    * <p>Secure a service request message before sending it to the service.</p>
    * 
    * <p>Sign and encrpt the service request, for example.</p>
    * 
    * @param authParam an authentication parameter that encapsulates the 
    *                  client request and server response objects.
    * @param client a Subject that represents the source of the service request, 
    *               or null. It may be used by modules to retrieve Principals 
    *               and credentials necessary to secure the request. The module 
    *               may use a CallbackHandler to obtain any additional information 
    *               necessary to secure the request. Newly obtained or validated 
    *               credentials may be stored back into the Subject object.
    * @param sharedState a Map for modules to save state across a sequence of calls 
    *               from secureRequest to validateResponse returning AuthStatus.PROCEED
    * @return an AuthStatus object representing the completion status of the processing 
    *         performed by the module.
    *         <ul>
    *            <li>AuthStatus.PROCEED returned when the application request message
    *                was successfully secured. The runtime may proceed to send the 
    *                request message. returned in AuthParam.</li>
    *            <li>AuthStatus.RETRY returned when the module replaces the application 
    *                request message with an mechanism specific message to be sent in 
    *                advance of the application message. The runtime should throw an 
    *                exception if it is unable to process the rety. Otherwise, the 
    *                runtime should send the request message returned in AuthParam 
    *                (and without calling secureRequest).</li>
    *           <li>AuthStatus.ERROR returned when the processing by the module failed 
    *               and indicates that the module has defined an appropriate error request
    *               message in the AuthParam. The runtime may send the request message 
    *               returned in AuthParam (without calling SecureRequest), and must 
    *               discontinue its processing of the application request.</li>
    *           </ul>
    * @throws AuthException when the module wishes to signal a failure in securing 
    *               the request and without establishing a corresponding error request 
    *               message. The runtime must discontinue its processing of the message 
    *               exchange.
    */
   public AuthStatus secureRequest(AuthParam authParam,Subject client, Map sharedState)
   throws AuthException;
   
   /**
    * <p>Validate a received service response.</p>
    * 
    * <p>Decrypt and verify a signature on the response, for example.</p>
    * 
    * @param authParam an authentication parameter that encapsulates the client 
    *                  request and server response objects.
    * @param client a Subject that represents the recipient of the service response, 
    *               or null. It may be used by modules to retrieve Principals and 
    *               credentials necessary to validate the response. The module may use
    *               a CallbackHandler to obtain any additional information necessary 
    *               to validate the response. Newly obtained information may be stored 
    *               back into the Subject object.
    * @param service a Subject that represents the source of the service response, 
    *               or null. It may be used by modules to store Principals and credentials 
    *               validated in the response.
    * @param sharedState a Map for modules to save state across a sequence of calls from 
    *               secureRequest to validateResponse returning AuthStatus.PROCEED
    * @return an AuthStatus object representing the completion status of the processing 
    *         performed by the module.
    *         <ul>
    *            <li>AuthStatus.PROCEED returned when the validation of the application 
    *                response message succeded. The runtime may proceed to return the 
    *                response message in the AuthParam to the application.</li>
    *            <li>AuthStatus.RETRY returned when the message validation succeded, but 
    *                when the validated message is a mechanism specific message sent in 
    *                advance of the application message. The runtime must not proceed to 
    *                process the response message in the AuthParam. The runtime should 
    *                throw an exception if it is unable to process the retry. Otherwise, 
    *                it should send the request message returned in AuthParam (and without 
    *                calling secureRequest).</li>
    *           <li>AuthStatus.ERROR returned when the validation failed and indicates 
    *               that the module has defined an appropriate error request message in 
    *               the AuthParam. The runtime must not proceed to process the response 
    *               message in the AuthParam, and may send the request message returned in
    *               AuthParam (and without calling secureRequest).</li>
    *           </ul>
    * @throws AuthException
    */
   public AuthStatus validateResponse(AuthParam authParam, Subject client, 
         Subject service, Map sharedState)
   throws AuthException;
}
