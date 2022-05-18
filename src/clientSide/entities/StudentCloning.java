package clientSide.entities;
//DONE

/**
 * Student cloning.
 *
 * It specifies his own attributes. Implementation of a client-server model of
 * type 2 (server replication). Communication is based on a communication
 * channel under the TCP protocol.
 */
public interface StudentCloning {

	/**
	 * Get Student ID
	 * 
	 * @return studentID
	 */
	public int getStudentID();

	/**
	 * Set Student ID
	 * 
	 * @return studentID
	 */
	public void setStudentID(int studentID);

	/**
	 * Get number of the seat at the table
	 * 
	 * @return seat
	 */
	public int getSeat();

	/**
	 * Set number of the seat at the table
	 * 
	 * @param seat
	 */
	public void setSeat(int seat);

	/**
	 * Get Student state
	 * 
	 * @return studentState
	 */
	public int getStudentState();

	/**
	 * Set Student state
	 * 
	 * @param studentState
	 */
	public void setStudentState(int studentState);

}
