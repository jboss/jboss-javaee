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
 * An enumeration of j2ee module types.
 *
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @version $Revision$
 */
public class ModuleType
{
   // Constants -----------------------------------------------------

   /** The EAR integer value */
   private static final int EAR_INT = 0;
   /** The EJB integer value */
   private static final int EJB_INT = 1;
   /** The CAR integer value */
   private static final int CAR_INT = 2;
   /** The RAR integer value */
   private static final int RAR_INT = 3;
   /** The WAR integer value */
   private static final int WAR_INT = 4;
   
   /** The module type for an EAR */
   public static final ModuleType EAR = new ModuleType(EAR_INT);
   /** The module type for an EJB */
   public static final ModuleType EJB = new ModuleType(EJB_INT);
   /** The module type for an CAR */
   public static final ModuleType CAR = new ModuleType(CAR_INT);
   /** The module type for an RAR */
   public static final ModuleType RAR = new ModuleType(RAR_INT);
   /** The module type for an WAR */
   public static final ModuleType WAR = new ModuleType(WAR_INT);

   /** The module types */
   private static final ModuleType[] moduleTypes = new ModuleType[]
   {
      EAR, EJB, CAR, RAR, WAR                                          
   };

   /** The module type strings */
   private static final String[] stringTable =
   {
      "ear", "ejb", "car", "rar", "war"
   };

   /** The module extensions */
   private static final String[] moduleExtensions = new String[]
   {
      ".ear", ".jar", ".jar", ".rar", ".war"                                          
   };

   // Attributes ----------------------------------------------------
   
   /** The value */
   private int value;
   
   /**
    * Create a new ModuleType
    *
    * @param value the value
    */
   protected ModuleType(int value)
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
    * Get the string table for class module type. This is:
    * {"ear", "ejb", "car", "rar", "war"}
    *
    * @return the string table
    */
   protected String[] getStringTable()
   {
      return stringTable;
   }
   
   /**
    * Get the enumerated values for module type
    *
    * @return the string table
    */
   protected ModuleType[] getEnumValueTable()
   {
      return moduleTypes;
   }

   /**
    * Get the file extension for this module
    *
    * @return the file extension
    */
   public String getModuleExtension()
   {
      if (value >= moduleExtensions.length)
         return Integer.toString(value);
      return moduleExtensions[value];
   }

   /**
    * Get the module type for an integer
    *
    * @param type the type
    * @return the module type
    */
   public static ModuleType getModuleType(int type)
   {
      if (type >= moduleTypes.length)
         return null;
      return moduleTypes[type];
   }


   /**
    * @return The stringTable entry for this ModuleType value
    */ 
   public String toString()
   {
      if (value >= stringTable.length)
         return Integer.toString(value);
      return stringTable[value];
   }

   /**
    * Return the offset of the first element
    *
    * @return the offset
    */
   protected int getOffset()
   {
      return EAR_INT;
   }
   
   // Private -------------------------------------------------------
   
   // Inner classes -------------------------------------------------
}
