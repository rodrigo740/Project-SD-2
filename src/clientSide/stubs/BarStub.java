package clientSide.stubs;

import clientSide.entities.Chef;
import clientSide.entities.ChefStates;
import clientSide.entities.Waiter;
import clientSide.entities.WaiterStates;
import commInfra.ClientCom;
import commInfra.Message;
import commInfra.MessageType;
import genclass.GenericIO;

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
		return 'a';
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
		outMessage = new Message(MessageType.REQAPORTDELIVED);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.APORTDELIVEDDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getEndOp();
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
		outMessage = new Message(MessageType.REQRETURNBARSALUTE, ((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARSALUTEDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.TKODR) || (inMessage.getWaiterState() < WaiterStates.PCODR)
				|| (inMessage.getWaiterState() < WaiterStates.WTFPT)
				|| (inMessage.getWaiterState() < WaiterStates.PRCBL)
				|| (inMessage.getWaiterState() < WaiterStates.RECPM)
				|| (inMessage.getWaiterState() < WaiterStates.APPST)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
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
		outMessage = new Message(MessageType.REQRETURNBARTAKINGORDER,
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARTAKINGORDERDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.RECPM) || (inMessage.getWaiterState() < WaiterStates.PRCBL)
				|| (inMessage.getWaiterState() < WaiterStates.WTFPT)
				|| (inMessage.getWaiterState() < WaiterStates.TKODR)
				|| (inMessage.getWaiterState() < WaiterStates.PRSMN)
				|| (inMessage.getWaiterState() < WaiterStates.APPST)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
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
		outMessage = new Message(MessageType.REQRETURNBARPORTIONSDELIVERED,
				((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARPORTIONSDELIVEREDDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.APPST) || (inMessage.getWaiterState() < WaiterStates.PRSMN)
				|| (inMessage.getWaiterState() < WaiterStates.TKODR)
				|| (inMessage.getWaiterState() < WaiterStates.PCODR)
				|| (inMessage.getWaiterState() < WaiterStates.PRCBL)
				|| (inMessage.getWaiterState() < WaiterStates.RECPM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
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
		outMessage = new Message(MessageType.REQPREPAREBILL, ((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.PREPAREBILLDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.RECPM) || (inMessage.getWaiterState() < WaiterStates.WTFPT)
				|| (inMessage.getWaiterState() < WaiterStates.PCODR)
				|| (inMessage.getWaiterState() < WaiterStates.PRSMN)
				|| (inMessage.getWaiterState() < WaiterStates.PRCBL)
				|| (inMessage.getWaiterState() < WaiterStates.TKODR)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
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
		outMessage = new Message(MessageType.REQRECEIVEDPAYMENT, ((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RECEIVEDPAYMENTDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.WTFPT) || (inMessage.getWaiterState() < WaiterStates.PCODR)
				|| (inMessage.getWaiterState() < WaiterStates.TKODR)
				|| (inMessage.getWaiterState() < WaiterStates.PRSMN)
				|| (inMessage.getWaiterState() < WaiterStates.APPST)
				|| (inMessage.getWaiterState() < WaiterStates.RECPM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
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
		outMessage = new Message(MessageType.REQRETURNBAR, ((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.PRSMN) || (inMessage.getWaiterState() < WaiterStates.TKODR)
				|| (inMessage.getWaiterState() < WaiterStates.PCODR)
				|| (inMessage.getWaiterState() < WaiterStates.PRCBL)
				|| (inMessage.getWaiterState() < WaiterStates.WTFPT)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
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
		outMessage = new Message(MessageType.REQSAYGOODBYE, ((Waiter) Thread.currentThread()).getWaiterState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.SAYGOODBYEDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getWaiterState() < WaiterStates.PRSMN) || (inMessage.getWaiterState() < WaiterStates.TKODR)
				|| (inMessage.getWaiterState() < WaiterStates.PCODR)
				|| (inMessage.getWaiterState() < WaiterStates.WTFPT)
				|| (inMessage.getWaiterState() < WaiterStates.PRCBL)
				|| (inMessage.getWaiterState() < WaiterStates.RECPM)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
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
		outMessage = new Message(MessageType.REQALWAITER, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ALWAITERDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < ChefStates.WAFOR) || (inMessage.getChefState() < ChefStates.PRPCS)
				|| (inMessage.getChefState() < ChefStates.DLVPT) || (inMessage.getChefState() < ChefStates.CLSSV)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Chef) Thread.currentThread()).setChefState(inMessage.getChefState());
	}

	// estudantes
	public void enter() {

	}

	public void callTheWaiter() {

	}

	public void signalWaiter() {

	}

	public void shouldHaveArrivedEarlier() {

	}

	public void goHome() {

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
		outMessage = new Message(MessageType.ENDOP, waiterId);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.ENDOPDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if (inMessage.getChefId() != waiterId) {
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
