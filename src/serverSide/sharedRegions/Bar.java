package serverSide.sharedRegions;

import clientSide.entities.Student;
import clientSide.entities.StudentStates;
import clientSide.entities.Waiter;
import clientSide.entities.WaiterStates;
import clientSide.stubs.GeneralReposStub;
import genclass.GenericIO;
import serverSide.entities.BarClientProxy;
import serverSide.main.ServerBar;
import serverSide.main.SimulPar;

/**
 * Bar.
 *
 * It is responsible for the the synchronization of the waiter, student and chef
 * during the order processing and is implemented as an implicit monitor.
 * 
 * There is two internal synchronization points: two blocking points for the
 * waiter, where he waits for something to happen and waits for the student to
 * signal that he can bring the next course.
 */
public class Bar {

	/**
	 * Reference to the General Information Repository.
	 */
	private final GeneralReposStub reposStub;
	/**
	 * Number of entity groups requesting the shutdown.
	 */

	private int nEntities;

	/**
	 * Reference to student threads.
	 */

	private final BarClientProxy[] student;
	/**
	 * Reference to waiter threads.
	 */

	private final BarClientProxy[] waiter;
	/**
	 * Char that represents the next operation of the waiter
	 */
	private char oper;
	/**
	 * Boolean flag that indicates if the payment was received
	 */
	private boolean paymentReceived;
	/**
	 * Boolean flag that indicates if wants pay
	 */
	private boolean wantsToPay;
	/**
	 * Boolean flag that indicates if described the order
	 */
	private boolean describedOrder;
	/**
	 * Boolean flag that indicates if signal to waiter
	 */
	private boolean signalWaiter;
	/**
	 * Boolean flag that indicates if bill honored
	 */
	private boolean billHonored;
	/**
	 * Boolean flag that indicates if called the waiter
	 */
	private boolean hasCalledWaiter;

	/**
	 * Boolean flag that indicates if need action
	 */
	private boolean actionNeeded;

	/**
	 * Boolean flag that indicates if bring next course
	 */
	private boolean bringNextCourse;

	/**
	 * Boolean flag that indicates if ready to pay
	 */
	private boolean readyToPay;
	/**
	 * Boolean flag that indicates if student called the waiter
	 */
	private boolean studentCalled;

	/**
	 * Boolean flag that indicates if waiter was alerted
	 */
	private boolean waiterAlerted;
	/**
	 * number of the students leave the restaurant
	 */
	private int nLeft;
	/**
	 * number of the students entered in the restaurant
	 */
	private int nEntered;
	/**
	 * number of the students that waiter saluted
	 */
	private int nSaluted;
	/**
	 * number of the students that waiter said goodbye
	 */
	private int nSaidGoodbye;

	/**
	 * Bar instantiation
	 * 
	 * @param reposStub reference to the General Information Repository
	 */
	public Bar(GeneralReposStub reposStub) {
		this.reposStub = reposStub;
		student = new BarClientProxy[SimulPar.S];
		waiter = new BarClientProxy[SimulPar.W];
		for (int i = 0; i < SimulPar.S; i++)
			student[i] = null;
		for (int i = 0; i < SimulPar.W; i++)
			waiter[i] = null;

	}

	/**
	 * Operation look around
	 *
	 * It is called by a waiter to look around
	 * 
	 * @return oper operation to be performed
	 */

	public synchronized char lookAround() {
		// if everyone left end
		if (nLeft == SimulPar.S) {
			setOper('e');
			return oper;
		}
		// if payment received while on other task wake up
		if (paymentReceived) {
			notifyAll();
		}
		// if someone left while on other task, say goodbye
		if (nLeft != nSaidGoodbye) {
			setActionNeeded(true);
			setOper('g');
		} else {
			if (nLeft != 0) {
				setActionNeeded(false);
			}
		}
		// if someone entered while on other task, salute him
		if (nSaluted != nEntered) {
			setOper('c');
			return oper;
		} else {
			setActionNeeded(false);
		}
		// if ready to pay was set while on other task, prepare operation 'b'
		if (readyToPay) {
			setOper('b');
			return oper;
		}
		// if a student called while the waiter was on other task, prepare
		// operation 'o'
		if (studentCalled) {
			setOper('o');
			return oper;
		}
		// if the chef called while the waiter was on other task, prepare
		// operation 'p'
		if (waiterAlerted) {
			setOper('p');
			return oper;
		}
		// if a student said that the next course can be delivered while the waiter was
		// on other task, prepare
		// operation 'p'
		if (bringNextCourse) {
			setOper('p');
			setActionNeeded(true);
		}

		// Sleep while waiting for something to happen
		while (!actionNeeded) {
			waiter[((BarClientProxy) Thread.currentThread()).getWaiterID()] = (BarClientProxy) Thread.currentThread();
			try {
				wait();
			} catch (InterruptedException e) {
				waiter[((BarClientProxy) Thread.currentThread()).getWaiterID()] = null;
				return 'e';
			}
		}
		if (oper == 'p') {
			// Sleep while waiting for the student to signal it needs the next course
			while (!bringNextCourse) {
				waiter[((BarClientProxy) Thread.currentThread()).getWaiterID()] = (BarClientProxy) Thread.currentThread();
				try {
					wait();
				} catch (InterruptedException e) {
					waiter[((BarClientProxy) Thread.currentThread()).getWaiterID()] = null;
					return 'e';
				}
			}
			// reset bringNextCourse flag
			bringNextCourse = false;
		}
		// reseting actionNeeded flag
		setActionNeeded(false);
		return oper;

	}

	/**
	 * Set actionNeeded flag
	 *
	 * @param action actionNeeded
	 */

	public synchronized void setActionNeeded(boolean action) {
		actionNeeded = action;
	}

	/**
	 * Set oper flag
	 *
	 * @param op oper
	 */
	public synchronized void setOper(char op) {
		oper = op;
	}

	/**
	 * Getter has called waiter
	 *
	 * Method that returns hasCalledWaiter flag
	 * 
	 * @return hasCalledWaiter 
	 */
	public synchronized boolean getHasCalledWaiter() {
		return hasCalledWaiter;
	}

	/**
	 * Set hasCalledWaiter flag
	 *
	 * @param hasCalledWaiter has called waiter
	 */
	public synchronized void setHasCalledWaiter(boolean hasCalledWaiter) {
		this.hasCalledWaiter = hasCalledWaiter;
	}

	/**
	 * Getter wants to pay
	 *
	 * Method that returns wantsToPay flag
	 * 
	 * @return wantsToPay
	 */
	public synchronized boolean getWantsToPay() {
		return wantsToPay;
	}

	/**
	 * Set wantsToPay flag
	 *
	 * @param wantsToPay wants to pay
	 */
	public synchronized void setWantsToPay(boolean wantsToPay) {
		this.wantsToPay = wantsToPay;
	}

	/**
	 * Getter described order
	 *
	 * Method that returns describedOrder flag
	 * 
	 * @return describedOrder
	 */
	public synchronized boolean getDescribedOrder() {
		return describedOrder;
	}

	/**
	 * Set describedOrder flag
	 *
	 * @param describedOrder described order
	 */
	public synchronized void setDescribedOrder(boolean describedOrder) {
		this.describedOrder = describedOrder;
	}

	/**
	 * Getter signal waiter
	 *
	 * Method that returns signalWaiter flag
	 * 
	 * @return signalWaiter
	 */
	public synchronized boolean getSignalWaiter() {
		return signalWaiter;
	}

	/**
	 * Set signalWaiter flag
	 *
	 * @param signalWaiter signal waiter
	 */
	public synchronized void setSignalWaiter(boolean signalWaiter) {
		this.signalWaiter = signalWaiter;
	}

	/**
	 * Getter bill honored
	 *
	 * Method that returns billHonored flag
	 * 
	 * @return billHonored
	 */
	public synchronized boolean getBillHonored() {
		return billHonored;
	}

	/**
	 * Set billHonored flag
	 *
	 * @param billHonored bill honored
	 */
	public synchronized void setBillHonored(boolean billHonored) {
		this.billHonored = billHonored;
	}

	/**
	 * Operation say goodbye
	 *
	 * It is called by a waiter to say goodbye to the student
	 * 
	 */
	public synchronized void sayGoodbye() {
		nSaidGoodbye++;
	}

	/**
	 * Operation return to the bar
	 *
	 * It is called by a waiter to return to the bar
	 * 
	 */
	public synchronized void returnToTheBar() {
		// set state of waiter
		((BarClientProxy) Thread.currentThread()).setWaiterState(WaiterStates.APPST);
		reposStub.setWaiterState(((BarClientProxy) Thread.currentThread()).getWaiterID(), WaiterStates.APPST);
	}

	/**
	 * Operation return to the bar after salute
	 *
	 * It is called by a waiter to return to the bar after saluting the student
	 * 
	 */
	public synchronized void returnToTheBarAfterSalute() {
		nSaluted++;
		// set state of waiter
		((BarClientProxy) Thread.currentThread()).setWaiterState(WaiterStates.APPST);
		reposStub.setWaiterState(((BarClientProxy) Thread.currentThread()).getWaiterID(), WaiterStates.APPST);
	}

	/**
	 * Operation return to the bar after taking the order
	 *
	 * It is called by a waiter to return to the bar after taking the order
	 * 
	 */
	public synchronized void returnToTheBarAfterTakingTheOrder() {
		// reset student called flag
		studentCalled = false;
		// set state of waiter
		((BarClientProxy) Thread.currentThread()).setWaiterState(WaiterStates.APPST);
		reposStub.setWaiterState(((BarClientProxy) Thread.currentThread()).getWaiterID(), WaiterStates.APPST);
	}

	/**
	 * Operation return to the bar after portions delivered
	 *
	 * It is called by a waiter to the bar after all portions of a course have been
	 * delivered
	 * 
	 */

	public synchronized void returnToTheBarAfterPortionsDelivered() {
		waiterAlerted = false;
		// set state of waiter
		((BarClientProxy) Thread.currentThread()).setWaiterState(WaiterStates.APPST);
		reposStub.setWaiterState(((BarClientProxy) Thread.currentThread()).getWaiterID(), WaiterStates.APPST);
	}

	/**
	 * Operation prepare the bill
	 *
	 * It is called by a waiter to prepare the bill
	 * 
	 */
	public synchronized void prepareBill() {
		// set state of waiter
		((BarClientProxy) Thread.currentThread()).setWaiterState(WaiterStates.PRCBL);
		reposStub.setWaiterState(((BarClientProxy) Thread.currentThread()).getWaiterID(), WaiterStates.PRCBL);
	}

	/**
	 * Operation «get the pad
	 *
	 * It is called by a waiter to get the pad
	 * 
	 */
	public synchronized void getThePad() {
		// wake up the student
		notifyAll();
	}

	/**
	 * Operation call the waiter
	 *
	 * It is called by a student to call the waiter to describe the order
	 * 
	 */

	public synchronized void callTheWaiter() {
		// set bringNextCourse and studentCalled flag
		bringNextCourse = true;
		studentCalled = true;
		// set action flag and oper and finally wake up the waiter
		setActionNeeded(true);
		setOper('o');
		notifyAll();
	}

	/**
	 * Operation should have arrived earlier
	 *
	 * It is called by a student to warn the waiter that it is ready to pay the bill
	 * 
	 */
	public synchronized void shouldHaveArrivedEarlier() {
		// set ready to pay flag
		readyToPay = true;
		// set action flag and oper and finally wake up the waiter
		setActionNeeded(true);
		setOper('b');
		notifyAll();
	}

	/**
	 * Operation enter
	 *
	 * It is called by a student to enter the restaurant
	 * 
	 */

	public synchronized void enter() {
		// increment number of students that entered the restaurant
		nEntered++;
		// set action flag and oper and finally wake up the waiter
		setActionNeeded(true);
		setOper('c');
		notifyAll();
	}

	/**
	 * Operation alert waiter
	 *
	 * It is called by a chef to warn the waiter that a portions is ready to be
	 * delivered
	 * 
	 */

	public synchronized void alertWaiter() {
		// set waiter alerted flag
		waiterAlerted = true;
		// set action flag and oper and finally wake up the waiter
		setActionNeeded(true);
		setOper('p');
		notifyAll();
	}

	/**
	 * Operation signal waiter
	 *
	 * It is called by a student to warn the waiter that it can start delivering the
	 * portions of the next course
	 * 
	 */
	public synchronized void signalWaiter() {
		// set bringNextCourse flag
		bringNextCourse = true;
		// set action flag and oper and finally wake up the waiter
		setActionNeeded(true);
		setOper('p');
		notifyAll();

	}

	/**
	 * Operation go home
	 *
	 * It is called by a student to warn the waiter that its going home
	 * 
	 */
	public synchronized void goHome() {
		int studentID;
		// set state of student
		studentID = ((BarClientProxy) Thread.currentThread()).getStudentID();
		((BarClientProxy) Thread.currentThread()).setStudentState(StudentStates.GGHOM);
		reposStub.setStudentState(studentID, StudentStates.GGHOM);
		// increment number of students that have left the restaurant
		nLeft++;
		// set action flag and oper and finally wake up the waiter
		setActionNeeded(true);
		setOper('g');
		notifyAll();
	}

	/**
	 * Operation received payment
	 *
	 * It is called by a waiter after the payment has been received
	 * 
	 */

	public synchronized void receivedPayment() {
		// set paymentReceived flag and reseting readyToPay flag
		paymentReceived = true;
		readyToPay = false;
	}

	/**
	 * Operation end of work.
	 *
	 * New operation.
	 *
	 * @param waiterID waiter id
	 */

	public synchronized void endOperation(int waiterID) {
		while (nEntities < 2) { /* the waiter waits for the termination of the students */
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		if (waiter[waiterID] != null)
			waiter[waiterID].interrupt();
	}

	/**
	 * Operation server shutdown.
	 *
	 * New operation.
	 */

	public synchronized void shutdown() {
		nEntities += 1;
		if (nEntities >= SimulPar.EB)
			ServerBar.waitConnection = false;
		notifyAll(); // the waiter may now terminate
	}

}
