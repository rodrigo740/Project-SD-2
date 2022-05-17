package clientSide.stubs;

import clientSide.entities.Chef;
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

	public char lookAround() {
		return 'a';
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
		outMessage = new Message(MessageType.REQRETURNBARSALUTE, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARSALUTEDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < WaiterStates.TKODR) || (inMessage.getChefState() < WaiterStates.PCODR)
				|| (inMessage.getChefState() < WaiterStates.WTFPT) || (inMessage.getChefState() < WaiterStates.PRCBL)
				|| (inMessage.getChefState() < WaiterStates.RECPM)) {
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
		outMessage = new Message(MessageType.REQRETURNBARTAKINGORDER, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARTAKINGORDERDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < WaiterStates.PRCBL) || (inMessage.getChefState() < WaiterStates.TKODR)) {
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
				((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RETURNBARPORTIONSDELIVEREDDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < WaiterStates.APPST) || (inMessage.getChefState() < WaiterStates.PRSMN)
				|| (inMessage.getChefState() < WaiterStates.TKODR) || (inMessage.getChefState() < WaiterStates.PCODR)
				|| (inMessage.getChefState() < WaiterStates.PRCBL) || (inMessage.getChefState() < WaiterStates.RECPM)) {
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
		outMessage = new Message(MessageType.REQPREPAREBILL, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.PREPAREBILLDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < WaiterStates.RECPM) || (inMessage.getChefState() < WaiterStates.WTFPT)
				|| (inMessage.getChefState() < WaiterStates.PCODR) || (inMessage.getChefState() < WaiterStates.PRSMN)
				|| (inMessage.getChefState() < WaiterStates.PRCBL)) {
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
		outMessage = new Message(MessageType.REQRECEIVEDPAYMENT, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.RECEIVEDPAYMENTDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < WaiterStates.WTFPT) || (inMessage.getChefState() < WaiterStates.PCODR)
				|| (inMessage.getChefState() < WaiterStates.TKODR) || (inMessage.getChefState() < WaiterStates.PRSMN)
				|| (inMessage.getChefState() < WaiterStates.APPST)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid waiter state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Waiter) Thread.currentThread()).setWaiterState(inMessage.getWaiterState());
	}

	public void returnToTheBar() {

	}

	public void sayGoodbye() {

	}

	/**
	 * Operation end of work.
	 *
	 * New operation.
	 * 
	 */

	public void endOperation() {
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
		outMessage = new Message(MessageType.ENDOP);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.ENDOPDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
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
