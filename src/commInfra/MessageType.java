package commInfra;

public class MessageType {

	/**
	 * Initialization of the logging file name and the number of iterations (service
	 * request).
	 */

	public static final int SETNFIC = 1;

	/**
	 * Logging file was initialized (reply).
	 */

	public static final int NFICDONE = 2;

	/**
	 * Server shutdown (service request).
	 */

	public static final int SHUT = 3;
	/**
	 * Server was shutdown (reply).
	 */

	public static final int SHUTDONE = 4;
	/**
	 * Set chef state (service request).
	 */

	public static final int STCST = 5;

	/**
	 * Set waiter state (service request).
	 */

	public static final int STWST = 6;

	/**
	 * Set student state (service request).
	 */

	public static final int STSST = 7;

	/**
	 * Setting acknowledged (reply).
	 */

	public static final int SACK = 8;

	/**
	 * Payment was received (reply).
	 */

	public static final int RPAYDONE = 9;

	/**
	 * Call a chef (service request).
	 */

	public static final int CALLCHEF = 10;

	/**
	 * Request waiting for an order (service request).
	 */

	public static final int REQWAFOR = 11;

	/**
	 * Request waiting for an order (service request).
	 */

	public static final int WAFORDONE = 12;

	/**
	 * Request preparing a course (service request).
	 */
	public static final int REQPRPCS = 13;

	/**
	 * Preparing a course done (reply).
	 */
	public static final int PRPCSDONE = 14;

	/**
	 * Request continue preparation (service request).
	 */
	public static final int REQCONTPRE = 15;

	/**
	 * Continue preparation done (reply).
	 */
	public static final int CPDONE = 16;

	/**
	 * Request proceed presentation (service request).
	 */
	public static final int REQPROPRE = 17;

	/**
	 * Continue proceed presentation done (reply).
	 */
	public static final int PROPREDONE = 18;

	/**
	 * Request deliver Portion (service request).
	 */
	public static final int REQDEPORT = 19;

	/**
	 * Deliver portion done (reply).
	 */
	public static final int DEPORTDONE = 20;

	/**
	 * Request have next portion ready (service request).
	 */
	public static final int REQHNPORTREADY = 21;

	/**
	 * Have next portion ready done (reply).
	 */
	public static final int HNPORTREADYDONE = 22;

	/**
	 * Request alert waiter (service request).
	 */
	public static final int REQALERTWAITER = 23;

	/**
	 * Alert waiter done (reply).
	 */
	public static final int ALERTWAITERDONE = 24;

	/**
	 * Request clean up (service request).
	 */
	public static final int REQCLEANUP = 25;

	/**
	 * Clean up done (reply).
	 */
	public static final int CLEANUPDONE = 26;

	/**
	 * End of work - chef (service request).
	 */

	public static final int ENDOP = 27;

	/**
	 * Chef clean up (reply).
	 */

	public static final int ENDOPDONE = 28;

	/**
	 * Order been completed (service request).
	 */

	public static final int ORDERCOMPLET = 29;

	/**
	 * Order been completed (reply).
	 */

	public static final int ORDERCOMPLETDONE = 30;

	/**
	 * All portions delived (service request).
	 */

	public static final int APORTDELIVED = 31;

	/**
	 * All portions delived (reply).
	 */

	public static final int APORTDELIVEDDONE = 32;
}
