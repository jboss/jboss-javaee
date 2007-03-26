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
 * A queue requestor
 *
 * @author Chris Kimpton (chris@kimptoc.net)
 * @author Adrian Brock (adrian@jboss.com)
 * @version $Revision$
 */
public class QueueRequestor
{
   private QueueSession queueSession = null;

   private QueueSender requestSender = null;

   private QueueReceiver replyReceiver = null;

   private TemporaryQueue replyQueue = null;

   public QueueRequestor(QueueSession session, Queue queue) throws JMSException
   {
      queueSession = session;

      requestSender = queueSession.createSender(queue);
      replyQueue = queueSession.createTemporaryQueue();
      replyReceiver = queueSession.createReceiver(replyQueue);
   }

   public Message request(Message message) throws JMSException
   {
      message.setJMSReplyTo(replyQueue);
      message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
      requestSender.send(message);
      return replyReceiver.receive();
   }

   public void close() throws JMSException
   {
      try
      {
         replyReceiver.close();
      }
      catch (JMSException ignored)
      {
      }
      try
      {
         replyQueue.delete();
      }
      catch (JMSException ignored)
      {
      }
      queueSession.close();
   }
}
