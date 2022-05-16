package clientSide.stubs;

import clientSide.entities.Chef;
import clientSide.entities.ChefStates;
import commInfra.ClientCom;
import commInfra.Message;
import commInfra.MessageType;
import genclass.GenericIO;

public class KitchenStub {

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

	public KitchenStub(String serverHostName, int serverPortNumb) {
		this.serverHostName = serverHostName;
		this.serverPortNumb = serverPortNumb;
	}

	public void watchTheNews() {

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
		outMessage = new Message(MessageType.REQWAFOR, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.WAFORDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < ChefStates.WAFOR)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Chef) Thread.currentThread()).setChefState(inMessage.getChefState());
	}

	public void startPreparations() {
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
		outMessage = new Message(MessageType.REQPRPCS, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.PRPCSDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < ChefStates.DLVPT) || (inMessage.getChefState() < ChefStates.PRPCS)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Chef) Thread.currentThread()).setChefState(inMessage.getChefState());
	}

	public void continuePreparation() {
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
		outMessage = new Message(MessageType.REQCONTPRE, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.CPDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < ChefStates.PRPCS) || (inMessage.getChefState() < ChefStates.DLVPT)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Chef) Thread.currentThread()).setChefState(inMessage.getChefState());
	}

	public void proceedToPresentation() {
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
		outMessage = new Message(MessageType.REQPROPRE, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.PROPREDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < ChefStates.PRPCS) || (inMessage.getChefState() < ChefStates.DLVPT)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Chef) Thread.currentThread()).setChefState(inMessage.getChefState());
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
		outMessage = new Message(MessageType.REQDEPORT, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.DEPORTDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < ChefStates.DSHPT)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Chef) Thread.currentThread()).setChefState(inMessage.getChefState());
	}

	public boolean allPortionsDelived() {
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
		outMessage = new Message(MessageType.APORTDELIVED);
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

	public void haveNextPortionReady() {
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
		outMessage = new Message(MessageType.REQHNPORTREADY, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.HNPORTREADYDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < ChefStates.PRPCS) || (inMessage.getChefState() < ChefStates.DLVPT)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Chef) Thread.currentThread()).setChefState(inMessage.getChefState());
	}

	public boolean orderBeenCompleted() {
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
		outMessage = new Message(MessageType.ORDERCOMPLET);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.ORDERCOMPLETDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		return inMessage.getEndOp();
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
		outMessage = new Message(MessageType.REQALERTWAITER, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.ALERTWAITERDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < ChefStates.DSHPT)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Chef) Thread.currentThread()).setChefState(inMessage.getChefState());
	}

	public void cleanUp() {
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
		outMessage = new Message(MessageType.REQCLEANUP, ((Chef) Thread.currentThread()).getChefState());
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if ((inMessage.getMsgType() != MessageType.CLEANUPDONE)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		if ((inMessage.getChefState() < ChefStates.DLVPT)) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid chef state!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
		((Chef) Thread.currentThread()).setChefState(inMessage.getChefState());
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
