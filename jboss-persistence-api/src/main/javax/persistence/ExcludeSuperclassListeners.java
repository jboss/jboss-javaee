//$Id: ExcludeSuperclassListeners.java 11282 2007-03-14 22:05:59Z epbernard $
package javax.persistence;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.TYPE;

/**
 * Specifies that the invocation of superclass listeners is to be excluded for the
 * entity class (or mapped superclass) and its subclasses.
 *
 * @author Emmanuel Bernard
 */
@Target(TYPE) @Retention(RUNTIME)
public @interface ExcludeSuperclassListeners {
}
