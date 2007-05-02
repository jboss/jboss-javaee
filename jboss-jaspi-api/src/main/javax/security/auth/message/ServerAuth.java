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
 *  An implementation of this interface is used to validate received service 
 *  request messages, and to secure service response messages.
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)</a> 
 *  @since  May 12, 2006 
 *  @version $Revision$
 */
public interface ServerAuth
{
   /**
    * Remove module specific principals and credentials from the subject.
    * @param subject the Subject instance from which the Principals and credentials 
    *                are to be removed.  
    * @param sharedState a Map for modules to save state across a sequence of calls from
    *                   validateRequest to secureResponse returning AuthStatus.PROCEED.
    * @throws AuthException if an error occurs during the Subject processing.
    */
   public void cleanSubject(Subject subject, Map sharedState)
   throws AuthException;
   
   /**
    * <p>Secure a service response before sending it to the client.</p>
    * <p>Sign and encrypt the response, for example.</p>
    * 
    * @param authParam an authentication parameter that encapsulates the client 
    *                  request and server response objects.
    * @param service a Subject that represents the source of the service response, 
    *                or null. It may be used by modules to retrieve Principals and 
    *                credentials necessary to secure the response. The module may 
    *                use a CallbackHandler to obtain any additional information 
    *                necessary to secure the response. Newly obtained information 
    *                may be stored back into the Subject object.
    * @param sharedState a Map for modules to save state across a sequence of calls 
    *                from validateRequest to secureResponse returning AuthStatus.PROCEED.
    * @return an AuthStatus object representing the completion status of the processing 
    *                performed by the module.
    *                <ul>
    *                  <li>AuthStatus.PROCEED returned when the application response 
    *                  message was successfully secured. The runtime may proceed to 
    *                  send the response message. returned in AuthParam.</li>
    *                  <li>AuthStatus.RETRY returned when the module replaces the 
    *                  application response message with an mechanism specific message 
    *                  to be sent in advance of the application message. The runtime 
    *                  should send the response message returned in AuthParam.</li>
    *                  <li>AuthStatus.ERROR returned when the processing by the module 
    *                  failed and indicates that the module has defined an appropriate 
    *                  error response message in the AuthParam. The runtime may send 
    *                  the response message returned in AuthParam.</li>
    *                </ul>
    * @throws AuthException
    */
   public AuthStatus secureResponse(AuthParam authParam, Subject service, Map sharedState)
   throws AuthException;
   
   /**
    * <p>Authenticate a received service request.</p>
    * <p>Decrypt content and verify a signature on a request, for example.</p>
    * 
    * @param authParam an authentication parameter that encapsulates the client 
    *                  request and server response objects.
    * @param client a Subject that represents the source of the service request. 
    *               It is used by modules to store Principals and credentials 
    *               validated in the request.
    * @param service a Subject that represents the recipient of the service request, 
    *               or null. It may be used by modules to retrieve Principals and 
    *               credentials necessary to validate the request. The module may 
    *               use a CallbackHandler to obtain any additional information 
    *               necessary to validate the response. Newly obtained information 
    *               may be stored back into the Subject object.
    * @param sharedState a Map for modules to save state across a sequence of calls from
    *               <i>validateRequest</i> to <i>secureResponse</i>
    *               returning AuthStatus.PROCEED.
    * @return an AuthStatus object representing the completion status of the processing 
    *                performed by the module.
    *                <ul>
    *                  <li>AuthStatus.PROCEED returned when the validation of the 
    *                  application message succeded. The runtime may proceed to process 
    *                  the request message in the AuthParam.</li>
    *                  <li>AuthStatus.RETRY returned when the message validation 
    *                  succeded, but when the validated message was sent in advance of 
    *                  either the application message or the security credentials. 
    *                  This return value indicates that the message authentication was 
    *                  not completed. If the runtime’s request processing policy 
    *                  requires that the authentication be completed, the runtime must 
    *                  not proceed to process the request message in the AuthParam, and 
    *                  should send the response message returned in the AuthParam (and 
    *                  without calling secureResponse).</li>
    *                  <li>AuthStatus.ERROR returned when the validation failed and 
    *                  indicates that the module has defined an appropriate error 
    *                  response message in the AuthParam. The runtime must not proceed 
    *                  to process the request message in the AuthParam, and may send 
    *                  the response message returned in AuthParam (and without calling 
    *                  secureResponse).</li>
    *                </ul>
    * @throws AuthException
    */
   public AuthStatus validateRequest(AuthParam authParam, Subject client,  
       Subject service,  Map sharedState) throws AuthException;
}
