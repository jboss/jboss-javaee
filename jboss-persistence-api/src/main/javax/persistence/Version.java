//$Id: Version.java 11282 2007-03-14 22:05:59Z epbernard $
//EJB3 Specification Copyright 2004-2006 Sun Microsystems, Inc.
package javax.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * This annotation specifies the version field or property of an entity class that serves as its
 * optimistic lock value. The version is used to ensure integrity when performing the merge
 * operation and for optimistic concurrency control.
 *
 * Only a single Version property or field should be used per class; applications that use more
 * than one Version property or field will not be portable.
 *
 * The Version property should be mapped to the primary table for the entity class; applications
 * that map the Version property to a table other than the primary table will not be portable.
 *
 * The following types are supported for version properties: int, Integer, short, Short, long,
 * Long, Timestamp.
 *  
 * @author Emmanuel Bernard
 */
@Target({METHOD, FIELD}) @Retention(RUNTIME)
public @interface Version {}
