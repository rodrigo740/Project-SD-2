package clientSide.entities;
//DONE

/**
 * Waiter cloning.
 *
 * It specifies his own attributes. Implementation of a client-server model of
 * type 2 (server replication). Communication is based on a communication
 * channel under the TCP protocol.
 */
public interface WaiterCloning {
	/**
	 * Get waiter id
	 * 
	 * @return waiterID
	 */
	public int getWaiterID();

	/**
	 * Set waiter id
	 * 
	 */

	public void setWaiterID(int waiterID);

	/**
	 * Get waiter state
	 * 
	 * @return waiterState
	 */

	public int getWaiterState();

	/**
	 * Set waiter state
	 * 
	 */

	public void setWaiterState(int waiterState);
}
