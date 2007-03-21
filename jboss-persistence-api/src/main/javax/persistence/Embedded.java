//$Id: Embedded.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB Specification Copyright 2004 Sun Microsystems, Inc.
package javax.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Defines a persistent field or property of an entity whose value is an instance of
 * an embeddable class. The embeddable class must be annotated as Embeddable.
 *
 * @author Emmanuel Bernard
 */
@Target({METHOD, FIELD}) @Retention(RUNTIME)
public @interface Embedded {}
