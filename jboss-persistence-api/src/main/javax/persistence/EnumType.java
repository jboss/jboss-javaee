//$Id: EnumType.java 11282 2007-03-14 22:05:59Z epbernard $
package javax.persistence;

/**
 * Defines mapping for the enumerated types. The constants of this enumerated type specify how persistent
 * property or field should be persisted as a enumerated type.
 *
 * @author Emmanuel Bernard
 */
public enum EnumType {
	/**
	 * Persist enumerated type property or field as an integer
	 */
	ORDINAL,
	/**
	 * Persist enumerated type property or field as a string
	 */
	STRING
}
