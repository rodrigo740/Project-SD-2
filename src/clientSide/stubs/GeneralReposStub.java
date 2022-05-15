package clientSide.stubs;

import commInfra.ClientCom;
import commInfra.Message;
import commInfra.MessageType;
import genclass.GenericIO;

public class GeneralReposStub {

	/**
	 * Name of the platform where is located the general repository server.
	 */

	private String serverHostName;

	/**
	 * Port number for listening to service requests.
	 */

	private int serverPortNumb;

	/**
	 * Instantiation of a stub to the general repository.
	 *
	 * @param serverHostName name of the platform where is located the barber shop
	 *                       server
	 * @param serverPortNumb port number for listening to service requests
	 */

	public GeneralReposStub(String serverHostName, int serverPortNumb) {
		this.serverHostName = serverHostName;
		this.serverPortNumb = serverPortNumb;
	}

	/**
	 * Operation initialization of the simulation.
	 *
	 * @param fileName logging file name
	 */

	public void initSimul(String fileName) {
		ClientCom com; // communication channel
		Message outMessage; // outgoing message
		Message inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.SETNFIC, fileName);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.NFICDONE) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	/**
	 * Operation server shutdown.
	 *
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

	/*
	 * Set chef state.
	 *
	 * @param state chef state
	 */
	public void setChefState(int state) {
		ClientCom com; // communication channel
		Message outMessage; // outgoing message
		Message inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.STCST, state);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.SACK) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	/*
	 * Set waiter state.
	 *
	 * @param state waiter state
	 */
	public void setWaiterState(int state) {
		ClientCom com; // communication channel
		Message outMessage; // outgoing message
		Message inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.STWST, state);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.SACK) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	/*
	 * Set student state.
	 *
	 * @param id student id
	 * 
	 * @param state student state
	 */
	public void setStudentState(int id, int state) {
		ClientCom com; // communication channel
		Message outMessage; // outgoing message
		Message inMessage; // incoming message

		com = new ClientCom(serverHostName, serverPortNumb);
		while (!com.open()) {
			try {
				Thread.sleep((long) (1000));
			} catch (InterruptedException e) {
			}
		}
		outMessage = new Message(MessageType.STSST, id, state);
		com.writeObject(outMessage);
		inMessage = (Message) com.readObject();
		if (inMessage.getMsgType() != MessageType.SACK) {
			GenericIO.writelnString("Thread " + Thread.currentThread().getName() + ": Invalid message type!");
			GenericIO.writelnString(inMessage.toString());
			System.exit(1);
		}
		com.close();
	}

	public synchronized void setStudentSeat(int studentID, int n) {
		// seat[n] = studentID;
	}

	public void setPortionsDelivered(int n) {
		// portionsDelivered = n;
	}

	public void setCoursesDelivered(int n) {
		// coursesDelivered = n;
	}

}
