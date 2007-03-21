//$Id: Embeddable.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB Specification Copyright 2004 Sun Microsystems, Inc.
package javax.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;


/**
 * Defines a class whose instances are stored as an intrinsic part of an owning entity and share
 * the identity of the entity. Each of the persistent properties or fields of the embedded object
 * is mapped to the database table for the entity. Only Basic, Column, Lob, Temporal, and
 * Enumerated mapping annotations may portably be used to map the persistent fields or properties
 * of classes annotated as Embeddable.
 *
 * @author Emmanuel Bernard
 */
@Target({TYPE}) @Retention(RUNTIME)
public @interface Embeddable {}
