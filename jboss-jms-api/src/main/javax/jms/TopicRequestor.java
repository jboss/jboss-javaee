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
package javax.jms;

/**
 * Provides a basic request/reply layer ontop of JMS.
 * Pass the constructor details of the session/topic to send requests upon.
 * Then call the request method to send a request.  The method will block
 * until the reply is received.
 *
 * @author Chris Kimpton (chris@kimptoc.net)
 * @author adrian brock (adrian@jboss.com)
 * @version $Revision$
 */
public class TopicRequestor
{
   private TopicSession topicSession = null;

   private TopicPublisher requestPublisher = null;

   private TemporaryTopic responseTopic = null;

   private TopicSubscriber responseSubscriber = null;

   public TopicRequestor(TopicSession session, Topic topic) throws JMSException
   {
      topicSession = session;
      requestPublisher = topicSession.createPublisher(topic);
      responseTopic = topicSession.createTemporaryTopic();
      responseSubscriber = topicSession.createSubscriber(responseTopic);
   }

   public Message request(Message message) throws JMSException
   {
      message.setJMSReplyTo(responseTopic);
      requestPublisher.publish(message);
      return responseSubscriber.receive();
   }

   public void close() throws JMSException
   {
      try
      {
         responseSubscriber.close();
      }
      catch (JMSException ignored)
      {
      }
      try
      {
         responseTopic.delete();
      }
      catch (JMSException ignored)
      {
      }
      topicSession.close();
   }
}
