package clientSide.entities;

import clientSide.stubs.BarStub;
import clientSide.stubs.KitchenStub;
import clientSide.stubs.TableStub;
import genclass.GenericIO;

//DONE

/**
 * Waiter thread.
 *
 * Used to simulate the Waiter life cycle.
 */

public class Waiter extends Thread {

	/**
	 * Waiter identification.
	 */

	private int waiterID;

	/**
	 * Waiter state.
	 */

	private int waiterState;

	/**
	 * Reference to the Bar.
	 */

	private final BarStub barStub;

	/**
	 * Reference to the Kitchen.
	 */

	private final KitchenStub kitStub;

	/**
	 * Reference to the Table.
	 */

	private final TableStub tblStub;

	/**
	 * Instantiation of a Waiter thread.
	 * 
	 * @param name        thread name
	 * @param waiterID    id of the waiter
	 * @param waiterState state of the waiter
	 * @param bar         reference to the bar
	 * @param kit         reference to the kitchen
	 * @param tbl         reference to the table
	 */
	public Waiter(String name, int waiterID, int waiterState, BarStub barStub, KitchenStub kitStub, TableStub tblStub) {
		super(name);
		this.waiterID = waiterID;
		this.waiterState = WaiterStates.APPST;
		this.barStub = barStub;
		this.kitStub = kitStub;
		this.tblStub = tblStub;
	}

	/**
	 * Get waiter id
	 * 
	 * @return waiterID
	 */
	public int getWaiterID() {
		return waiterID;
	}

	/**
	 * Set waiter id
	 * 
	 */

	public void setWaiterID(int waiterID) {
		this.waiterID = waiterID;
	}

	/**
	 * Get waiter state
	 * 
	 * @return waiterState
	 */

	public int getWaiterState() {
		return waiterState;
	}

	/**
	 * Set waiter state
	 * 
	 */

	public void setWaiterState(int waiterState) {
		this.waiterState = waiterState;
	}

	/**
	 * Regulates the life cycle of the Waiter.
	 */

	@Override
	public void run() {
		char oper;
		boolean end = false;
		while (!end) {
			// Transition to 'APPST'
			oper = barStub.lookAround();
			switch (oper) {
			case 'c':
				// Transition to 'PRSMN'
				tblStub.saluteTheClient();
				// Transition to 'APPST'
				barStub.returnToTheBarAfterSalute();
				break;
			case 'o':
				// Transition to 'TKODR'
				tblStub.getThePad();
				// Transition to 'PCODR'
				kitStub.handTheNoteToTheChef();
				// Transition to 'APPST'
				barStub.returnToTheBarAfterTakingTheOrder();
				break;
			case 'p':
				while (!tblStub.haveAllPortionsBeenServed()) {
					// Transition to 'WTFPT'
					kitStub.collectPortion();

					GenericIO.writelnString("Portion collected");
					tblStub.deliverPortion();

					GenericIO.writelnString("Portion delivered waiter");
				}

				GenericIO.writelnString("all portions served");
				// Transition to 'APPST'
				barStub.returnToTheBarAfterPortionsDelivered();
				break;
			case 'b':
				// Transition to 'PRCBL'
				barStub.prepareBill();
				// Transition to 'RECPM'
				tblStub.presentBill();
				barStub.receivedPayment();
				// Transition to 'APPST'
				barStub.returnToTheBar();
				break;
			case 'g':
				barStub.sayGoodbye();
				// Transition to 'APPST'
				barStub.returnToTheBar();
				break;
			case 'e':
				end = true;
				break;
			}
		}
	}
}
