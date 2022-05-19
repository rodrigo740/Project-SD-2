package commInfra;

import java.io.Serializable;

import genclass.GenericIO;

//FAZER
// ver construtores daqui ------------------- por cauasa dos ids 
public class Message implements Serializable {
	/**
	 * Student state.
	 */
	private int studentState = -1;

	/**
	 * student identification.
	 */
	private int studentId = -1;
	/**
	 * Chef state.
	 */
	private int chefState = -1;

	/**
	 * chef identification.
	 */
	private int chefId = -1;
	/**
	 * Waiter state.
	 */
	private int waiterState = -1;
	/**
	 * chef identification.
	 */
	private int waiterId = -1;
	/**
	 * ids of the students in each seat
	 */
	private int seat[];

	/**
	 * Message type.
	 */
	private int msgType = -1;
	/**
	 * Name of the logging file.
	 */
	private String fName = null;
	/**
	 * End of operations (chef).
	 */

	private boolean endOp = false;

	/**
	 * Message instantiation (form 1).
	 *
	 * @param type message type
	 */
	public Message(int type) {
		// TODO Auto-generated constructor stub
		msgType = type;
	}

	/**
	 * Message instantiation (form 2).
	 *
	 * @param type message type
	 * @param name name of the logging file
	 */
	public Message(int type, String name) {
		msgType = type;
		fName = name;
	}

	/**
	 * Message instantiation (form 3).
	 *
	 * @param type  message type
	 * @param id    student identification
	 * @param state student state
	 */
	public Message(int type, int id, int state) { /// falta mais condicoes no if-.......
		msgType = type;
		if ((msgType == MessageType.STSST)) {
			studentState = state;
			studentId = id;
		} else {
			GenericIO.writelnString("Message type = " + msgType + ": non-implemented instantiation!");
			System.exit(1);
		}
	}

	/**
	 * Message instantiation (form 4).
	 *
	 * @param type message type
	 * @param id   waiter/chef identification
	 */
	public Message(int type, int state) { // falta mais cenas nos ifs.............
		msgType = type;
		if ((msgType == MessageType.STWST) || (msgType == MessageType.CALLCHEF) || (msgType == MessageType.RPAYDONE)) {
			waiterState = state;
		} else if ((msgType == MessageType.STCST)) {
			chefState = state;
		} else {
			GenericIO.writelnString("Message type = " + msgType + ": non-implemented instantiation!");
			System.exit(1);
		}
	}

	/**
	 * Message instantiation (form 5).
	 *
	 * @param type  message type
	 * @param endOP end of operations flag
	 */

	public Message(int type, boolean endOp) {
		msgType = type;
		this.endOp = endOp;
	}

	/**
	 * Getting message type.
	 *
	 * @return message type
	 */
	public int getMsgType() {
		return (msgType);
	}

	/**
	 * Getting name of logging file.
	 *
	 * @return name of the logging file
	 */

	public String getLogFName() {
		return (fName);
	}

	/**
	 * Getting student identification.
	 *
	 * @return student identification
	 */

	public int getStudentId() {
		return (studentId);
	}

	/**
	 * Getting student state.
	 *
	 * @return student state
	 */

	public int getStudentState() {
		return (studentState);
	}

	/**
	 * Getting chef identification.
	 *
	 * @return chef identification
	 */

	public int getChefId() {
		return (chefId);
	}

	/**
	 * Getting chef state.
	 *
	 * @return chef state
	 */

	public int getChefState() {
		return (chefState);
	}

	/**
	 * Getting waiter identification.
	 *
	 * @return waiter identification
	 */

	public int getWaiterId() {
		return (waiterId);
	}

	/**
	 * Getting waiter state.
	 *
	 * @return waiter state
	 */

	public int getWaiterState() {
		return (waiterState);
	}

	/**
	 * Getting end of operations flag (chef).
	 *
	 * @return end of operations flag
	 */

	public boolean getEndOp() {
		return (endOp);
	}
}
