package clientSide.stubs;

import clientSide.entities.Chef;
import clientSide.entities.ChefStates;
import clientSide.entities.Student;
import clientSide.entities.StudentStates;
import clientSide.entities.Waiter;
import clientSide.entities.WaiterStates;
import commInfra.ClientCom;
import commInfra.Message;
import commInfra.MessageType;
import genclass.GenericIO;
import serverSide.main.SimulPar;

public class BarStub {
	/**
	 * Name of the platform where is located the bar server.
	 */

	private String serverHostName;

	/**
	 * Port number for listening to service requests.
	 */

	private int serverPortNumb;

	/**
	 * Instantiation of a stub to the bar.
	 *
	 * @param serverHostName name of the platform where is located the bar server
	 * @param serverPortNumb port number for listening to service requests
	 */
	public BarStub(String serverHostName, int serverPortNumb) {
		this.serverHostName = serverHostName;
		this.serverPortNumb = serverPortNumb;
	}

	public char lookAround() { //// ver esta funcao----------------------------
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
		// form 1 (type)
		outMessage = new Message(MessageType.REQLOOKAROUND);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.LOOKAROUNDDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getOp();
	}

	public void returnToTheBarAfterSalute() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQRETURNBARSALUTE, 
				((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARSALUTEDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
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

	public void returnToTheBarAfterTakingTheOrder() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQRETURNBARTAKINGORDER,
				((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARTAKINGORDERDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
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

	public void returnToTheBarAfterPortionsDelivered() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQRETURNBARPORTIONSDELIVERED,
				((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARPORTIONSDELIVEREDDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
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

	public void prepareBill() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQPREPAREBILL, 
				((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.PREPAREBILLDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
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

	public void receivedPayment() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQRECEIVEDPAYMENT, 
				((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RECEIVEDPAYMENTDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
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

	public void returnToTheBar() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQRETURNBAR, 
				((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
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

	public void sayGoodbye() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQSAYGOODBYE, 
				((Waiter) Thread.currentThread()).getWaiterID(),
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.SAYGOODBYEDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() > WaiterStates.RECPM)) {
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

	public void alertWaiter() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQALWAITER, 
				((Chef) Thread.currentThread()).getChefID(),
				((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ALWAITERDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() > ChefStates.CLSSV)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef id!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Chef) Thread.currentThread()).setChefState(inMessage.getChefState());
	}

	// estudantes
	public void enter() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQENTER, 
				((Student) Thread.currentThread()).getStudentID(), 
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ENTERDONE)) {
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

	public void callTheWaiter() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQCALLWAITER, 
				((Student) Thread.currentThread()).getStudentID(), 
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.CALLWAITERDONE)) {
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

	public void signalWaiter() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQSIGNALWAITER,
				((Student) Thread.currentThread()).getStudentID(), 
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.SIGNALWAITERDONE)) {
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

	public void shouldHaveArrivedEarlier() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQARREARLIER, 
				((Student) Thread.currentThread()).getStudentID(), 
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ARREARLIERDONE)) {
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

	public void goHome() {
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
		// form 3 (type, id, state)
		outMessage = new Message(MessageType.REQGOHOME, 
				((Student) Thread.currentThread()).getStudentID(), 
				((Student) Thread.currentThread()).getStudentState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.GOHOMEDONE)) {
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

	public void endOperation(int waiterId) {
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
		// form 4 (type, id)
		outMessage = new Message(MessageType.ENDOP, waiterId);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.ENDOPDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if (inMessage.getWaiterId() != waiterId) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter id!");
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
