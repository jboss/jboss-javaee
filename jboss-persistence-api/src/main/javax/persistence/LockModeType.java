//$Id: LockModeType.java 11282 2007-03-14 22:05:59Z epbernard $
package javax.persistence;

/**
 * Lock modes that can be specified by means of the EntityManager.lock() method.
 *
 * The semantics of requesting locks of type LockModeType.READ and LockModeType.WRITE are t
 * he following.
 *
 * If transaction T1 calls lock(entity, LockModeType.READ) on a versioned object, the entity
 * manager must ensure that neither of the following phenomena can occur:
 *
 * * P1 (Dirty read): Transaction T1 modifies a row. Another transaction T2 then reads
 * that row and obtains the modified value, before T1 has committed or rolled back.
 * Transaction T2 eventually commits successfully; it does not matter whether T1 commits or rolls
 * back and whether it does so before or after T2 commits.
 *
 * * P2 (Non-repeatable read): Transaction T1 reads a row. Another transaction T2 then modifies
 * or deletes that row, before T1 has committed. Both transactions eventually commit successfully.
 *
 * Lock modes must always prevent the phenomena P1 and P2.
 * In addition, calling lock(entity, LockModeType.WRITE) on a versioned object,
 * will also force an update (increment) to the entity's version column.
 *
 * The persistence implementation is not required to support calling EntityManager.lock()
 * on a non-versioned object. When it cannot support a such lock call, it must
 * throw the PersistenceException.
 *
 * @author Emmanuel Bernard
 */
public enum LockModeType {
	/**
	 * Read lock
	 */
	READ,
	/**
	 * Write lock
	 */
	WRITE
}
