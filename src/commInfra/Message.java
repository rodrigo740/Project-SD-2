package commInfra;

import java.io.Serializable;

import genclass.GenericIO;

public class Message implements Serializable {
	/**
	 * Chef state.
	 */
	private int chefState = -1;

	/**
	 * waiter state.
	 */
	private int waiterState = -1;
	/**
	 * Student state.
	 */
	private int studentState = -1;

	/**
	 * Customer identification.
	 */

	private int studentId = -1;
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

	public Message(int type) {
		// TODO Auto-generated constructor stub
		msgType = type;
	}

	public Message(int type, String name) {
		msgType = type;
		fName = name;
	}

	// falta mais cenas nos ifs
	public Message(int type, int id, int state) {
		msgType = type;
		if ((msgType == MessageType.STWST) || (msgType == MessageType.CALLCHEF) || (msgType == MessageType.RPAYDONE)) {
			waiterState = state;
		} else if ((msgType == MessageType.STSST) || (msgType == MessageType.REQCUTH)
				|| (msgType == MessageType.CUTHDONE) || (msgType == MessageType.BSHOPF)) {
			studentState = state;
			studentId = id;
		} else if ((msgType == MessageType.STCST)) {
			chefState = state;
		} else {
			GenericIO.writelnString("Message type = " + msgType + ": non-implemented instantiation!");
			System.exit(1);
		}
	}

	// falta mais cenas nos ifs
	public Message(int type, int state) {
		msgType = type;
		if ((msgType == MessageType.STWST) || (msgType == MessageType.CALLCHEF) || (msgType == MessageType.RPAYDONE)) {
			waiterState = state;
		} else if ((msgType == MessageType.STSST) || (msgType == MessageType.REQCUTH)
				|| (msgType == MessageType.CUTHDONE) || (msgType == MessageType.BSHOPF)) {
			studentState = state;
		} else if ((msgType == MessageType.STCST)) {
			chefState = state;
		} else {
			GenericIO.writelnString("Message type = " + msgType + ": non-implemented instantiation!");
			System.exit(1);
		}
	}

	public int getMsgType() {
		return (msgType);
	}

}
