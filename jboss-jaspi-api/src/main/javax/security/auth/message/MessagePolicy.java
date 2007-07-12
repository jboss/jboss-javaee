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

/** 
 *  This class defines a message authentication policy.
    A ClientAuthContext uses this class to communicate (
    at module initialization time) request and response
    message protection policies to its ClientAuthModule objects. 
    A ServerAuthContext uses this class to communicate request 
    and response message protection policies to its ServerAuthModule objects.
 *  @author <a href="mailto:Anil.Saldhana@jboss.org">Anil Saldhana@jboss.org</a>
 *  @author Charlie Lai, Ron Monzillo (Javadoc for JSR-196)</a> 
 *  @since  May 11, 2006 
 *  @version $Revision$
 */
public class MessagePolicy
{ 
   protected TargetPolicy[] targetPolicies = null;
   private boolean mandatory;
   
   /** 
    * Create a MessagePolicy instance with an array of target policies.
    * 
    * @param targetPolicies an array of target policies.
    * @param mandatory - A boolean value indicating whether the MessagePolicy 
    *                    is mandatory or optional.
    * @throws IllegalArgumentException if the specified targetPolicies is null.
    */
   public MessagePolicy(TargetPolicy[] targetPolicies, boolean mandatory)
   {
      if( targetPolicies == null)
         throw new IllegalArgumentException("specified targetPolicies is null");
      
      this.targetPolicies = targetPolicies; 
      this.mandatory = mandatory;
   }
   
   /**
    * Get the target policies that comprise the authentication policy.
    * 
    * @return an array of target authentication policies, where each element describes an 
    *         authentication policy and the parts of the message to which the authentication 
    *         policy applies. This method returns null to indicate that no security operations 
    *         should be performed on the messages to which the policy applies. <b>This method 
    *         never returns a zero-length array</b>. When this method returns an array of target 
    *         policies, the order of elements in the array represents the order that the 
    *         corresponding message transformations or validations described by the target 
    *         policies are to be performed by the authentication module.
    */
   public TargetPolicy[]getTargetPolicies()
   {
      if(targetPolicies != null && targetPolicies.length == 0 )
         throw new IllegalStateException("Target Policies should not be of zero length");
      return this.targetPolicies;
   }
   
   public boolean isMandatory()
   {
      return this.mandatory;
   }
   
   /**
    * This interface is implemented by objects that represent and perform message targeting 
    * on behalf of authentication modules.</p>
    * <p>The internal state of a Target indicates whether it applies to the request or 
    * response message of an AuthParam and to which components it applies within the 
    * identified message.</p> 
    */
   public static interface Target
   {
      /**
       * Get the Object identified by the Target from the AuthParam.
       * 
       * @param authParam the AuthParam containing the request or response message from which 
       *                  the target is to be obtained.
       * @return an Object representing the target, or null when the target could not be found 
       *                  in the AuthParam.
       */
      public Object get(MessageInfo messageInfo);
      
      /** 
       * Put the Object into the AuthParam at the location identified by the target.
       * @param authParam the AuthParam containing the request or response message 
       *               into which the object is to be put.
       * @param data
       */
      public void put(MessageInfo messageInfo, Object data);
      
      /**
       * Remove the Object identified by the Target from the AuthParam.
       * 
       * @param authParam the AuthParam containing the request or response message from 
       *                  which the target is to be removed.
       */
      public void remove(MessageInfo messageInfo);
   }
    
   public static class TargetPolicy
   {
      
      protected ProtectionPolicy protectionPolicy;
      protected Target[] targets;
      
      /**
       * 
       * Create a new TargetPolicy.
       * 
       * @param targets
       * @param protectionPolicy
       */
      public TargetPolicy(Target[] targets,  ProtectionPolicy protectionPolicy)
      {
         this.targets = targets;
         this.protectionPolicy = protectionPolicy;
      }
      
      /**
       * Get the URI that identifies the policy that applies to the targets.
       * 
       * @return a URI that identifies a source or recipient authentication policy.
       */
      public ProtectionPolicy getProtectionPolicy()
      {
         return this.protectionPolicy;
      }
      
      /**
       * Get the array of layer-specific target descriptors that identify the one or 
       * more message parts to which the specified message protection policy applies.
       * @return an array of MessageTarget that identify targets within a message. 
       * This method returns null when the specified policy applies to the whole message 
       * (excluding any meta data added to the message to satisfy the policy). 
       * <b>This method never returns a zero-length array.</b>
       */
      public Target[] getTargets()
      {
         if(targets != null && targets.length == 0 )
            throw new IllegalStateException(" Targets cannot be of length zero");
         return this.targets;
      } 
   }
   
   /**
    * <p>This interface is used to represent message authentication policy.</p>
    * <p>The internal state of a ProtectionPolicy object defines the message 
    * authentication requirements to be applied to the associated Target.</p>
    */
   public static interface ProtectionPolicy
   {
      /**
       * A URI fragment that represents a recipient entity authentication policy AUTHENTICATE_RECIPIENT_CONTENT
       */
      public static final String AUTHENTICATE_SENDER = "http://jboss.org/security/auth/container/auth_sender";
      
      /**
       * A URI fragment that represents a source entity authentication policy AUTHENTICATE_SOURCE_CONTENT
       */
      public static final String AUTHENTICATE_RECIPIENT = "http://jboss.org/security/auth/container/auth_recipient";
      
      /**
       * A URI fragment that represents a data origin authentication policy
       */
      public static final String AUTHENTICATE_CONTENT = "http://jboss.org/security/auth/container/auth_content";
       
      /**
       * Get the ProtectionPolicy identifier. An identifier may represent a 
       * conceptual protection policy (as is the case with the static identifiers 
       * defined within this interface) or it may identify a procedural policy expression 
       * or plan that may be more difficult to categorize in terms of a conceptual identifier.
       * @return A String containing a policy identifier. This interface defines some 
       *         policy identifier constants. Configuration systems may define and employ 
       *         other policy identifiers values.
       */
      public String getID();
   }
   
}
