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
package javax.enterprise.deploy.shared;

/**
 * An enumeration of deployment status action types.
 *
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 */
public class DConfigBeanVersionType
{
   // Constants -----------------------------------------------------

   /** The 1.3 integer value */
   private static final int V1_3_INT = 0;
   /** The 1.3.1 integer value */
   private static final int V1_3_1_INT = 1;
   /** The 1.4 integer value */
   private static final int V1_4_INT = 2;
   /** The Java EE 5 integer value */
   private static final int V5_INT = 3;
   
   /** The version type for J2EE 1.3 */
   public static final DConfigBeanVersionType V1_3 = new DConfigBeanVersionType(V1_3_INT);
   /** The version type for J2EE 1.3.1 - DO NOT USE */
   public static final DConfigBeanVersionType V1_3_1 = new DConfigBeanVersionType(V1_3_1_INT);
   /** The version type for J2EE 1.4 */
   public static final DConfigBeanVersionType V1_4 = new DConfigBeanVersionType(V1_4_INT);
   /** The version type for Java EE 5 */
   public static final DConfigBeanVersionType V5 = new DConfigBeanVersionType(V5_INT);

   /** The version types */
   private static final DConfigBeanVersionType[] versionTypes = new DConfigBeanVersionType[]
   {
      V1_3, V1_3_1, V1_4, V5
   };

   /** The version descriptions */
   private static final String[] versionDescs = new String[]
   {
      "J2EE 1.3",
      "J2EE 1.3.1 - DO NOT USE",
      "J2EE 1.4",
      "JavaEE 5"
   };

   // Attributes ----------------------------------------------------
   
   /** The value */
   private int value;
   
   /**
    * Create a new DConfigBeanVersionType
    *
    * @param value the value
    */
   protected DConfigBeanVersionType(int value)
   {
      this.value = value;
   }
   
   // Public --------------------------------------------------------
   
   /**
    * Get the value
    *
    * @return the value
    */
   public int getValue()
   {
      return value;
   }
   
   /**
    * Get the string table for class DConfigBeanVersion type
    *
    * [todo] check this?
    * @return the string table
    */
   protected String[] getStringTable()
   {
      return versionDescs;
   }
   
   /**
    * Get the enumerated values for module type
    *
    * @return the string table
    */
   protected DConfigBeanVersionType[] getEnumValueTable()
   {
      return versionTypes;
   }

   /**
    * Get the version type for an integer
    *
    * @param type the type
    * @return the action type
    */
   public static DConfigBeanVersionType getDConfigBeanVersionType(int type)
   {
      if (type >= versionTypes.length)
         return null;
      return versionTypes[type];
   }

   public String toString()
   {
      return versionDescs[value];
   }

   /**
    * Return the offset of the first element
    *
    * @return the offset
    */
   protected int getOffset()
   {
      return V1_3_INT;
   }
   
   // Inner classes -------------------------------------------------
}
