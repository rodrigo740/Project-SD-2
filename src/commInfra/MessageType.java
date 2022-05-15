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

	public static final int SHUT = 14;
	/**
	 * Server was shutdown (reply).
	 */

	public static final int SHUTDONE = 15;
	/**
	 * Set chef state (service request).
	 */

	public static final int STCST = 17;

	/**
	 * Set waiter state (service request).
	 */

	public static final int STWST = 17;

	/**
	 * Set student state (service request).
	 */

	public static final int STSST = 17;

	/**
	 * Setting acknowledged (reply).
	 */

	public static final int SACK = 19;

	/**
	 * Payment was received (reply).
	 */

	public static final int RPAYDONE = 11;

	/**
	 * Call a chef (service request).
	 */

	public static final int CALLCHEF = 8;

}
