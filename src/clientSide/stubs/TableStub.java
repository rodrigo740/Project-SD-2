package clientSide.stubs;

import clientSide.entities.Student;
import clientSide.entities.StudentStates;
import clientSide.entities.Waiter;
import clientSide.entities.WaiterStates;
import commInfra.ClientCom;
import commInfra.Message;
import commInfra.MessageType;
import genclass.GenericIO;
import serverSide.main.SimulPar;

public class TableStub {

	/**
	 * Name of the platform where is located the kitchen server.
	 */

	private String serverHostName;

	/**
	 * Port number for listening to service requests.
	 */

	private int serverPortNumb;

	/**
	 * Instantiation of a stub to the kitchen.
	 *
	 * @param serverHostName name of the platform where is located the kitchen
	 *                       server
	 * @param serverPortNumb port number for listening to service requests
	 */

	public TableStub(String serverHostName, int serverPortNumb) {
		this.serverHostName = serverHostName;
		this.serverPortNumb = serverPortNumb;
	}

	public void saluteTheClient() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQSALUTECLIENT, ((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.SALUTECLIENTDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.WTFPT) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Waiter) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
	}

	public void getThePad() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQGETPAD, ((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.GETPADDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.WTFPT) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Waiter) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
	}

	public boolean haveAllPortionsBeenServed() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQAPORTSERVED);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.APORTSERVEDDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getEndOp();
	}

	public void deliverPortion() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQGETPAD, ((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.GETPADDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.WTFPT) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Waiter) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
	}

	public void presentBill() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQGETPAD, ((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.GETPADDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.WTFPT) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.W)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Waiter) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
	}

	// estudante
	public void takeASeat() {

		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQTAKESEAT, ((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.TAKESEATDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());
	}

	public void selectingCourse() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQSELCOURSE, ((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.SELCOURSEDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());

	}

	public boolean firstToEnter() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQFIRSTENTER);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.FIRSTENTERDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getEndOp();
	}

	public void informCompanions() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQINFORMCOMPANIONS, ((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.INFORMCOMPANIONSDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());

	}

	public void organizeOrder() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQORGORDER, ((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ORGORDERDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());

	}

	public void describeOrder() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQDESCORDER, ((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ESCORDERDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());

	}

	public void chat() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQCHAT, ((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.CHATDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());

	}

	public void enjoyMeal() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQENJOYMEAL, ((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ENJOYMEALDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());

	}

	public boolean lastToEat() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQLASTEAT);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.LASTEATDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getEndOp();
	}

	public void chatAgain() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQCHATAGAIN, ((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.CHATAGAINDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());
	}

	public void waitForEveryoneToFinish() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQEVERYONEFINISH, ((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.EVERYONEFINISHDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());
	}

	public boolean lastToEnterRestaurant() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQLASTENTERRESTAURANT);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.LASTENTERRESTAURANTDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getEndOp();
	}

	public void honorTheBill() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) // waits for a connection to be established
		{
			try {
				Thread.currentThread().sleep((long) (10));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.REQHONORBILL, ((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.HONORBILLDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentState() < StudentStates.GGTRT)
				|| (inMessage.getStudentState() > StudentStates.GGHOM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getStudentId() < 0) || (inMessage.getStudentId() >= SimulPar.S)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Student) Thread.currentThread()).setStudentState(inMessage.getStudentState());
	}

	/**
	 * Operation end of work.
	 *
	 * New operation.
	 * 
	 */

	public void endOperation(int studentId) {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.ENDOP, studentId);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.ENDOPDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if (inMessage.getStudentId() != studentId) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid student id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	/**
	 * Operation server shutdown.
	 *
	 * New operation.
	 */

	public void shutdown() {
		ClientCom com; // communication channel
		Message outMessage, // outgoing message
				inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.SHUT);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.SHUTDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}
}
