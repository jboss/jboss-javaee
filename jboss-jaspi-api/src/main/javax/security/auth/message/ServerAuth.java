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
    * Remove implementation specific principals and credentials from the subject.
    * @param messageInfo - A contextual object that encapsulates the client request 
    *                      and server response objects, and that may be used to save 
    *                      state across a sequence of calls made to the methods of 
    *                      this interface for the purpose of completing a secure 
    *                      message exchange.
    * @param subject - The Subject instance from which the Principals and credentials 
    *                      are to be removed. 
    * @throws AuthException if an error occurs during the Subject processing.
    */
   public void cleanSubject( MessageInfo messageInfo, Subject subject)
   throws AuthException;
   
   /**
    * <p>Secure a service request message before sending it to the service.</p>
    * 
    * <p>Sign and encrpt the service request, for example.</p>
    * 
    * @param messageInfo - A contextual object that encapsulates the client request 
    *                      and server response objects, and that may be used to save 
    *                      state across a sequence of calls made to the methods of 
    *                      this interface for the purpose of completing a secure 
    *                      message exchange.
    * @param serviceSubject - A Subject that represents the source of the service request,
    *                      or null. It may be used by the method implementation as the 
    *                      source of Principals or credentials to be used to secure 
    *                      the request. If the Subject is not null, the method 
    *                      implementation may add additional Principals or credentials 
    *                      (pertaining to the source of the service request) to the Subject.
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
   public AuthStatus secureResponse(MessageInfo messageInfo, Subject serviceSubject)
   throws AuthException;
   
   /**
    * <p>Validate a received service response.</p>
    * 
    * <p>This method is called to transform the mechanism-specific response message 
    * acquired by calling getResponseMessage (on messageInfo) into the validated 
    * application message to be returned to the message processing runtime. If 
    * the response message is a (mechanism-specific) meta-message, the method 
    * implementation must attempt to transform the meta-message into the next 
    * mechanism-specific request message to be sent by the runtime.</p>
    * 
    * @param messageInfo - A contextual object that encapsulates the client 
    *                      request and server response objects, and that may be 
    *                      used to save state across a sequence of calls made to 
    *                      the methods of this interface for the purpose of 
    *                      completing a secure message exchange.
    * 
    * @param clientSubject - A Subject that represents the recipient of the 
    *                      service response, or null. It may be used by the method 
    *                      implementation as the source of Principals or credentials 
    *                      to be used to validate the response. If the Subject is 
    *                      not null, the method implementation may add additional 
    *                      Principals or credentials (pertaining to the recipient 
    *                      of the service request) to the Subject.
    *                  
    * @param serviceSubject - A Subject that represents the source of the service 
    *                      response, or null. If the Subject is not null, the method 
    *                      implementation may add additional Principals or credentials 
    *                      (pertaining to the source of the service response) to the Subject.
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
   public AuthStatus validateRequest(MessageInfo messageInfo, Subject clientSubject, 
         Subject serviceSubject)
   throws AuthException;
}
