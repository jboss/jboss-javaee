//$Id: JoinColumns.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Defines mapping for the composite foreign keys.
 * This annotation groups JoinColumn annotations for the same relationship.
 *
 * When the JoinColumns annotation is used, both the name and the referencedColumnName
 * elements must be specified in each such JoinColumn annotation.

 * @author Emmanuel Bernard
 */
@Target({METHOD, FIELD}) @Retention(RUNTIME)
public @interface JoinColumns {
    JoinColumn[] value();
}
