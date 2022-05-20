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
	 * waiter identification.
	 */
	private int waiterId = -1;
	/**
	 * waiter operation.
	 */
	private char op = ' ';
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
	 * @param id    entity identification
	 * @param state entity state
	 */
	public Message(int type, int id, int state) {
		msgType = type;
		// Waiter
		if ((msgType == MessageType.RETURNBARSALUTEDONE) 				|| 
				(msgType == MessageType.RETURNBARPORTIONSDELIVEREDDONE) || 
				(msgType == MessageType.PREPAREBILLDONE) 				|| 
				(msgType == MessageType.RETURNBARDONE) 					|| 
				(msgType == MessageType.SAYGOODBYEDONE) 				||
				(msgType == MessageType.NOTECHEFDONE) 					|| 
				(msgType == MessageType.COLLECTPORTIONDONE) 			|| 
				(msgType == MessageType.SALUTECLIENTDONE)				||
				(msgType == MessageType.GETPADDONE) 					|| 
				(msgType == MessageType.APORTSERVEDDONE) 				|| 
				(msgType == MessageType.DELIVERPORTIONDONE) 			|| 
				(msgType == MessageType.PRESENTBILLDONE)) {
			waiterState = state;
			waiterId = id;
		}
		// student
		else if ((msgType == MessageType.STSST) 					|| 
				(msgType == MessageType.ENTERDONE) 					|| 
				(msgType == MessageType.CALLWAITERDONE) 			||
				(msgType == MessageType.ARREARLIERDONE) 			|| 
				(msgType == MessageType.SIGNALWAITERDONE) 			||
				(msgType == MessageType.GOHOMEDONE)					||
				(msgType == MessageType.TAKESEATDONE) 				||
				(msgType == MessageType.SELCOURSEDONE) 				||
				(msgType == MessageType.FIRSTENTERDONE) 			||
				(msgType == MessageType.INFORMCOMPANIONSDONE) 		||
				(msgType == MessageType.ORGORDERDONE) 				||
				(msgType == MessageType.DESCORDERDONE) 				||
				(msgType == MessageType.CHATDONE) 					||
				(msgType == MessageType.ENJOYMEALDONE) 				||
				(msgType == MessageType.LASTEATDONE) 				||
				(msgType == MessageType.CHATAGAINDONE) 				||
				(msgType == MessageType.EVERYONEFINISHDONE) 		||
				(msgType == MessageType.LASTENTERRESTAURANTDONE) 	||
				(msgType == MessageType.HONORBILLDONE)) {
			studentState = state;
			studentId = id;
		} // chef
		else if ((msgType == MessageType.ALWAITERDONE) 		||
				(msgType == MessageType.WAFORDONE) 			||
				(msgType == MessageType.PRPCSDONE) 			||
				(msgType == MessageType.CONTPREDONE) 		||
				(msgType == MessageType.PROPREDONE) 		||
				(msgType == MessageType.DEPORTDONE) 		||
				(msgType == MessageType.APORTDELIVEDDONE) 	||
				(msgType == MessageType.HNPORTREADYDONE) 	||
				(msgType == MessageType.ALERTWAITERDONE) 	||
				(msgType == MessageType.CLEANUPDONE)) {
			chefState = state;
			chefId = id;
		}else {
			GenericIO.writelnString("Message type = " + msgType + ": non-implemented instantiation!");
			System.exit(1);
		}
	}

	/**
	 * Message instantiation (form 4).
	 *
	 * @param type message type
	 * @param id   entity identification
	 */
	public Message(int type, int id) {
		msgType = type;
		// waiter
		if ((msgType == MessageType.ENDOPDONEWAITER)) {
			waiterId = id;
		} 
		// student
		else if ((msgType == MessageType.ENDOPDONEWAITER)) {
			studentId = id;
		} 
		// chef
		else if ((msgType == MessageType.ENDOPDONEWAITER)) {
			chefId = id;
		}
		else {
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
	 * Message instantiation (form 6).
	 *
	 * @param type  message type
	 * @param id waiter identification
	 * @param state waiter state
	 * @param op operation char
	 */

	public Message(int type, int id, int state, char op) {
		msgType = type;
		if ((msgType == MessageType.LOOKAROUNDDONE)) {
			waiterState = state;
			waiterId = id;
			this.op = op;
		} else {
			GenericIO.writelnString("Message type = " + msgType + ": non-implemented instantiation!");
			System.exit(1);
		}
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
	
	/**
	 * Getting next operation of waiter (waiter).
	 *
	 * @return op char
	 */

	public char getOp() {
		return (op);
	}

}
