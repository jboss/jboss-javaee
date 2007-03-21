//$Id: ClassTransformer.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence.spi;

import java.security.ProtectionDomain;
import java.lang.instrument.IllegalClassFormatException;

/**
 * A persistence provider provides an instance of this interface
 * to the PersistenceUnitInfo.addTransformer method.
 * The supplied transformer instance will get called to transform
 * entity class files when they are loaded and redefined.  The transformation
 * occurs before the class is defined by the JVM
 *
 *
 * @author <a href="mailto:bill@jboss.org">Bill Burke</a>
 * @version $Revision: 11282 $
 */
public interface ClassTransformer
{
   /**
    * Invoked when a class is being loaded or redefined to add hooks for persistence bytecode manipulation
    *
    * @param loader the defining class loaderof the class being transformed.  It may be null if using bootstrap loader
    * @param classname The name of the class being transformed
    * @param classBeingRedefined If an already loaded class is being redefined, then pass this as a parameter
    * @param protectionDomain ProtectionDomain of the class being (re)-defined
    * @param classfileBuffer The input byte buffer in class file format
    * @return A well-formed class file that can be loaded
    *
    * @throws IllegalClassFormatException
    */
   byte[] transform(ClassLoader loader,
                    String classname,
                    Class<?> classBeingRedefined,
                    ProtectionDomain protectionDomain,
                    byte[] classfileBuffer)
   throws IllegalClassFormatException;
}
