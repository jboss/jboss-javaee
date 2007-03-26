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
package javax.resource.spi.work;

import java.util.EventObject;
import java.io.ObjectStreamField;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.jboss.util.id.SerialVersion;

/**
 * Events that occur on work
 * @version $Revision$
 */
public class WorkEvent extends EventObject
{
   /** @since 4.0.2 */
   static final long serialVersionUID;

   // Constants -----------------------------------------------------
   /**
    * These field names match the j2ee 1.4.1 ri version names
    */
   private static final ObjectStreamField[] serialPersistentFields;
   private static final int TYPE_IDX = 0;
   private static final int WORK_IDX = 1;
   private static final int EXCPEPTION_IDX = 2;
   private static final int DURATION_IDX = 2;

   /** The WORK_ACCEPTED value */
   public static final int WORK_ACCEPTED = 1;
   /** The WORK_REJECTED value */
   public static final int WORK_REJECTED = 2;
   /** The WORK_STARTED  value */
   public static final int WORK_STARTED = 3;
   /** The WORK_COMPLETED value */
   public static final int WORK_COMPLETED = 4;
   
   static
   {
      if (SerialVersion.version == SerialVersion.LEGACY)
      {
         serialVersionUID = 6971276136970053051L;
         serialPersistentFields = new ObjectStreamField[] {
            /** @serialField type int */
            new ObjectStreamField("type", int.class),
            /** @serialField work Work */
            new ObjectStreamField("work", Work.class),
            /** @serialField exception WorkException */
            new ObjectStreamField("e", WorkException.class),
            /** @serialField startDuration long */
            new ObjectStreamField("startDuration", long.class)
         };
      }
      else
      {
         // j2ee 1.4.1 RI values
         serialVersionUID = -3063612635015047218L;
         serialPersistentFields = new ObjectStreamField[] {
            /** @serialField type int */
            new ObjectStreamField("type", int.class),
            /** @serialField work Work */
            new ObjectStreamField("work", Work.class),
            /** @serialField exception WorkException */
            new ObjectStreamField("exception", WorkException.class),
            /** @serialField startDuration long */
            new ObjectStreamField("startDuration", long.class)
         };         
      }
   }

   /** The event type */
   private int type;
   /** The work */
   private Work work;
   /** The exception */
   private WorkException e;
   /** The start delay in millis */
   private long startDuration;
   
   /**
    * Create a new WorkEvent
    *
    * @param source the source of the event
    * @param type the type
    * @param work the work
    * @param e the exception
    */
   public WorkEvent(Object source, int type, Work work, WorkException e)
   {
      this(source, type, work, e, 0l);
   }
   
   /**
    * Create a new WorkEvent
    *
    * @param source the source of the event
    * @param type the type
    * @param work the work
    * @param e the exception
    * @param startDuration the delay in the start in milliseconds
    */
   public WorkEvent(Object source, int type, Work work, WorkException e, long startDuration)
   {
      super(source);
      this.type = type;
      this.work = work;
      this.e = e;
      this.startDuration = startDuration;
   }
   
   /**
    * Get the type
    *
    * @return the type
    */
   public int getType()
   {
      return type;
   }
   
   /**
    * Get the work
    *
    * @return the work
    */
   public Work getWork()
   {
      return work;
   }
   
   /**
    * Get the exception
    *
    * @return the work exception
    */
   public WorkException getException()
   {
      return e;
   }
   
   /**
    * Get the start duration
    *
    * @return the start duration
    */
   public long getStartDuration()
   {
      return startDuration;
   }

   // Private -------------------------------------------------------
   private void readObject(ObjectInputStream ois)
      throws ClassNotFoundException, IOException
   {
      ObjectInputStream.GetField fields = ois.readFields();
      String name = serialPersistentFields[TYPE_IDX].getName();
      this.type = fields.get(name, 0);
      name = serialPersistentFields[WORK_IDX].getName();
      this.work = (Work) fields.get(name, null);
      name = serialPersistentFields[EXCPEPTION_IDX].getName();
      this.e = (WorkException) fields.get(name, null);
      name = serialPersistentFields[DURATION_IDX].getName();
      this.startDuration = fields.get(name, 0L);
   }

   private void writeObject(ObjectOutputStream oos)
      throws IOException
   {
      // Write j2ee 1.4.1 RI field names
      ObjectOutputStream.PutField fields =  oos.putFields();
      String name = serialPersistentFields[TYPE_IDX].getName();
      fields.put(name, type);
      name = serialPersistentFields[WORK_IDX].getName();
      fields.put(name, work);
      name = serialPersistentFields[EXCPEPTION_IDX].getName();
      fields.put(name, e);
      name = serialPersistentFields[DURATION_IDX].getName();
      fields.put(name, startDuration);
      oos.writeFields();
   }
}
