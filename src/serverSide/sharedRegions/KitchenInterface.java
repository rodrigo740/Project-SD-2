package serverSide.sharedRegions;

import clientSide.entities.ChefStates;
import clientSide.entities.WaiterStates;
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
		case MessageType.REQWAFOR:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			}
			else if ((inMessage.getChefState() < ChefStates.WAFOR)
					|| (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQPRPCS:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			}
			else if ((inMessage.getChefState() < ChefStates.WAFOR)
					|| (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQCONTPRE:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			}
			else if ((inMessage.getChefState() < ChefStates.WAFOR)
					|| (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQPROPRE:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			}
			else if ((inMessage.getChefState() < ChefStates.WAFOR)
					|| (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQDEPORT:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			}
			else if ((inMessage.getChefState() < ChefStates.WAFOR)
					|| (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQAPORTDELIVED:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			}
			else if ((inMessage.getChefState() < ChefStates.WAFOR)
					|| (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQHNPORTREADY:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			}
			else if ((inMessage.getChefState() < ChefStates.WAFOR)
					|| (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQALERTWAITER:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			}
			else if ((inMessage.getChefState() < ChefStates.WAFOR)
					|| (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQCLEANUP:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			}
			else if ((inMessage.getChefState() < ChefStates.WAFOR)
					|| (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.REQNOTECHEF:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.C)) {
				throw new MessageException("Invalid waiter id!", inMessage);
			}
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM)) {
				throw new MessageException("Invalid waiter state!", inMessage);
			}
			break;
		case MessageType.REQCOLLECTPORTION:
			if ((inMessage.getWaiterId() < 0) || (inMessage.getWaiterId() >= SimulPar.C)) {
				throw new MessageException("Invalid waiter id!", inMessage);
			}
			else if ((inMessage.getWaiterState() < WaiterStates.APPST)
					|| (inMessage.getWaiterState() > WaiterStates.RECPM)) {
				throw new MessageException("Invalid waiter state!", inMessage);
			}
			break;
		case MessageType.ENDOP:
			if ((inMessage.getChefId() < 0) || (inMessage.getChefId() >= SimulPar.C)) {
				throw new MessageException("Invalid chef id!", inMessage);
			}
			else if ((inMessage.getChefState() < ChefStates.WAFOR)
					|| (inMessage.getChefState() > ChefStates.CLSSV)) {
				throw new MessageException("Invalid chef state!", inMessage);
			}
			break;
		case MessageType.SHUT: // check nothing
			break;
		default:
			throw new MessageException("Invalid message type!", inMessage);
		}

		/* processing */

		switch (inMessage.getMsgType())

		{
		case MessageType.REQWAFOR:
			((KitchenClientProxy) Thread.currentThread()).setChefID(inMessage.getChefId());
			((KitchenClientProxy) Thread.currentThread()).setChefState(inMessage.getChefState());
			if (kitchen.watchTheNews())
				outMessage = new Message(MessageType.CUTHDONE,setChefId
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