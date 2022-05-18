package serverSide.sharedRegions;

import commInfra.Message;
import commInfra.MessageException;
import commInfra.MessageType;
import serverSide.entities.KitchenClientProxy;
import serverSide.main.SimulPar;

//FAZER
public class KitchenInterface {
	/**
	 * Reference to the kitchen.
	 */

	private final Kitchen kitchen;

	/**
	 * Instantiation of an interface to the kitchen.
	 *
	 * @param kitchen reference to the kitchen
	 */

	public KitchenInterface(Kitchen kitchen) {
		this.kitchen = kitchen;
	}

	/**
	 * Processing of the incoming messages.
	 *
	 * Validation, execution of the corresponding method and generation of the
	 * outgoing message.
	 *
	 * @param inMessage service request
	 * @return service reply
	 * @throws MessageException if the incoming message is not valid
	 */

	public Message processAndReply(Message inMessage) throws MessageException {
		Message outMessage = null; // outgoing message

		/* validation of the incoming message */

		switch (inMessage.getMsgType()) {
		case MessageType.REQCUTH:
			if ((inMessage.getCustId() < 0) || (inMessage.getCustId() >= SimulPar.N))
				throw new MessageException("Invalid customer id!", inMessage);
			else if ((inMessage.getCustState() < CustomerStates.DAYBYDAYLIFE)
					|| (inMessage.getCustState() > CustomerStates.CUTTHEHAIR))
				throw new MessageException("Invalid customer state!", inMessage);
			break;
		case MessageType.SLEEP:
			if ((inMessage.getBarbId() < 0) || (inMessage.getBarbId() >= SimulPar.M))
				throw new MessageException("Invalid barber id!", inMessage);
			break;
		case MessageType.CALLCUST:
			if ((inMessage.getBarbId() < 0) || (inMessage.getBarbId() >= SimulPar.M))
				throw new MessageException("Invalid barber id!", inMessage);
			else if ((inMessage.getBarbState() < BarberStates.SLEEPING)
					|| (inMessage.getBarbState() > BarberStates.INACTIVITY))
				throw new MessageException("Invalid barber state!", inMessage);
			break;
		case MessageType.RECPAY:
			if ((inMessage.getBarbId() < 0) || (inMessage.getBarbId() >= SimulPar.M))
				throw new MessageException("Invalid barber id!", inMessage);
			else if ((inMessage.getBarbState() < BarberStates.SLEEPING)
					|| (inMessage.getBarbState() > BarberStates.INACTIVITY))
				throw new MessageException("Invalid barber state!", inMessage);
			else if ((inMessage.getCustId() < 0) || (inMessage.getCustId() >= SimulPar.N))
				throw new MessageException("Invalid customer id!", inMessage);
			break;
		case MessageType.ENDOP:
			if ((inMessage.getBarbId() < 0) || (inMessage.getBarbId() >= SimulPar.M))
				throw new MessageException("Invalid barber id!", inMessage);
			break;
		case MessageType.SHUT: // check nothing
			break;
		default:
			throw new MessageException("Invalid message type!", inMessage);
		}

		/* processing */

		switch (inMessage.getMsgType())

		{
		case MessageType.REQCUTH:
			((KitchenClientProxy) Thread.currentThread()).setCustomerId(inMessage.getCustId());
			((KitchenClientProxy) Thread.currentThread()).setCustomerState(inMessage.getCustState());
			if (kitchen.goCutHair())
				outMessage = new Message(MessageType.CUTHDONE,
						((KitchenClientProxy) Thread.currentThread()).getCustomerId(),
						((KitchenClientProxy) Thread.currentThread()).getCustomerState());
			else
				outMessage = new Message(MessageType.kitchenF,
						((KitchenClientProxy) Thread.currentThread()).getCustomerId(),
						((KitchenClientProxy) Thread.currentThread()).getCustomerState());
			break;
		case MessageType.SLEEP:
			((KitchenClientProxy) Thread.currentThread()).setBarberId(inMessage.getBarbId());
			if (kitchen.goToSleep())
				outMessage = new Message(MessageType.SLEEPDONE,
						((KitchenClientProxy) Thread.currentThread()).getBarberId(), true);
			else
				outMessage = new Message(MessageType.SLEEPDONE,
						((KitchenClientProxy) Thread.currentThread()).getBarberId(), false);
			break;
		case MessageType.CALLCUST:
			((KitchenClientProxy) Thread.currentThread()).setBarberId(inMessage.getBarbId());
			((KitchenClientProxy) Thread.currentThread()).setBarberState(inMessage.getBarbState());
			int custId = kitchen.callACustomer();
			outMessage = new Message(MessageType.CCUSTDONE, ((KitchenClientProxy) Thread.currentThread()).getBarberId(),
					((KitchenClientProxy) Thread.currentThread()).getBarberState(), custId);
			break;
		case MessageType.RECPAY:
			((KitchenClientProxy) Thread.currentThread()).setBarberId(inMessage.getBarbId());
			((KitchenClientProxy) Thread.currentThread()).setBarberState(inMessage.getBarbState());
			kitchen.receivePayment(inMessage.getCustId());
			outMessage = new Message(MessageType.RPAYDONE, ((KitchenClientProxy) Thread.currentThread()).getBarberId(),
					((KitchenClientProxy) Thread.currentThread()).getBarberState());
			break;
		case MessageType.ENDOP:
			kitchen.endOperation(inMessage.getBarbId());
			outMessage = new Message(MessageType.EOPDONE, inMessage.getBarbId());
			break;
		case MessageType.SHUT:
			kitchen.shutdown();
			outMessage = new Message(MessageType.SHUTDONE);
			break;
		}

		return (outMessage);
	}

}