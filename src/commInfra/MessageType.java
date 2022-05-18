package commInfra;

//Fazer - acho que existe mensagens repetidas pelos metodos
//no shutdown nao se faz distincao se é chamada pelo bar, kitchen ou table
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

	public static final int REQAPORTDELIVED = 31;

	/**
	 * All portions delived (reply).
	 */

	public static final int APORTDELIVEDDONE = 32;

	/**
	 * Request alert waiter (service request).
	 */
	public static final int REQALWAITER = 33;

	/**
	 * Alert waiter done (reply).
	 */
	public static final int ALWAITERDONE = 34;

	/**
	 * Request hand the note to the chef (service request).
	 */
	public static final int REQNOTECHEF = 35;

	/**
	 * Hand the note to the chef done (reply).
	 */
	public static final int NOTECHEFDONE = 36;

	/**
	 * Request collect portion (service request).
	 */
	public static final int REQCOLLECTPORTION = 37;

	/**
	 * Collect portion done (reply).
	 */
	public static final int COLLECTPORTIONDONE = 38;

	/**
	 * Request return to the bar after salute (service request).
	 */
	public static final int REQRETURNBARSALUTE = 39;

	/**
	 * Return to the bar after salute done (reply).
	 */
	public static final int RETURNBARSALUTEDONE = 40;

	/**
	 * Request return to the bar after taking the order (service request).
	 */
	public static final int REQRETURNBARTAKINGORDER = 41;

	/**
	 * Return to the bar after taking the order done (reply).
	 */
	public static final int RETURNBARTAKINGORDERDONE = 42;

	/**
	 * Request return to the bar after portions delivered (service request).
	 */
	public static final int REQRETURNBARPORTIONSDELIVERED = 43;

	/**
	 * Return to the bar after portions delivered done (reply).
	 */
	public static final int RETURNBARPORTIONSDELIVEREDDONE = 44;

	/**
	 * Request prepare bill (service request).
	 */
	public static final int REQPREPAREBILL = 45;

	/**
	 * Prepare bill done (reply).
	 */
	public static final int PREPAREBILLDONE = 46;

	/**
	 * Request received payment (service request).
	 */
	public static final int REQRECEIVEDPAYMENT = 47;

	/**
	 * Received payment done (reply).
	 */
	public static final int RECEIVEDPAYMENTDONE = 48;

	/**
	 * Request return to the bar (service request).
	 */
	public static final int REQRETURNBAR = 49;

	/**
	 * Return to the bar done (reply).
	 */
	public static final int RETURNBARDONE = 50;

	/**
	 * Request say goodbye (service request).
	 */
	public static final int REQSAYGOODBYE = 49;

	/**
	 * Say goodbye done (reply).
	 */
	public static final int SAYGOODBYEDONE = 50;

	/**
	 * Request salute the client (service request).
	 */
	public static final int REQSALUTECLIENT = 51;

	/**
	 * Salute the client done (reply).
	 */
	public static final int SALUTECLIENTDONE = 52;

	/**
	 * Request get the pad (service request).
	 */
	public static final int REQGETPAD = 53;

	/**
	 * Get the pad done (reply).
	 */
	public static final int GETPADDONE = 54;

	/**
	 * Request have all portions been served (service request).
	 */
	public static final int REQAPORTSERVED = 55;

	/**
	 * Have all portions been served done (reply).
	 */
	public static final int APORTSERVEDDONE = 56;
}
