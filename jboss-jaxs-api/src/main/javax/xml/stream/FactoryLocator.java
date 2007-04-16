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
package javax.xml.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Utility class that locates one of the many JSR-173 factories. This class is
 * not public since it is not part of the JSR-173 specification.
 *
 * @author Jason T. Greene
 * @version $Id$
 */
class FactoryLocator
{

   private static final String JAVA_HOME = System.getProperty("java.home");

   private static final String PROPERTY_FILE = JAVA_HOME + File.pathSeparator + "lib" + File.pathSeparator + "xml.stream.properties";

   private static final String SERVICES_PATH = "META-INF/services/";

   private static Object newInstance(String className, ClassLoader classLoader)
   {
      try
      {
         return classLoader.loadClass(className).newInstance();
      }
      catch (ClassNotFoundException e)
      {
         throw new FactoryConfigurationError("Could not locate provider [" + className + "]", e);
      }
      catch (Exception e)
      {
         throw new FactoryConfigurationError("Error creating provider [" + className + "]", e);
      }
   }

   /**
    * Gets property from JAVA_HOME/lib/xml.stream.properties file.
    */
   private static String getPropertyFromFile(String property)
   {
      File file = new File(PROPERTY_FILE);

      if (!file.exists())
         return null;

      Properties properties = new Properties();
      try
      {
         properties.load(new FileInputStream(file));
         return properties.getProperty(property);
      }
      catch (Exception e)
      {
         // Eat
         return null;
      }
   }

   private static String getPropertyFromServices(String property, ClassLoader classLoader)
   {
      String resource = SERVICES_PATH + property;
      InputStream stream = classLoader.getResourceAsStream(property);

      if (stream == null)
         return null;
      try
      {
         BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
         return reader.readLine();
      }
      catch (Exception e)
      {
         // Eat
         return null;
      }
   }

   /**
    * Locate a factory following the rules in JSR 173 section 4.5.1 using the
    * current classloader.
    *
    * @see FactoryLocator#find(String, String, ClassLoader)
    */
   static Object find(String factoryId, String defaultFactory) throws FactoryConfigurationError
   {
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      return find(factoryId, defaultFactory, loader);
   }

   /**
    * Locate a factory following the rules in JSR 173 section 4.5.1 using the
    * specified classloader.
    *
    * @param factoryId the factory identifier
    * @param defaultFactory the default factory class to load if the identifier
    * returns nothing
    * @param classLoader the classloader to load and search in
    * @return the factory object
    * @throws FactoryConfigurationError
    */
   static Object find(String factoryId, String defaultFactory, ClassLoader classLoader) throws FactoryConfigurationError
   {
      if (classLoader == null)
         throw new FactoryConfigurationError("Could not determine classloader.");

      String value = System.getProperty(factoryId);
      if (value != null)
         return newInstance(value, classLoader);

      value = getPropertyFromFile(factoryId);
      if (value != null)
         return newInstance(value, classLoader);

      value = getPropertyFromServices(factoryId, classLoader);
      if (value != null)
         return newInstance(value, classLoader);

      return newInstance(defaultFactory, classLoader);
   }
}
