package serverSide.entities;

import clientSide.entities.ChefCloning;
import clientSide.entities.WaiterCloning;
import commInfra.ServerCom;
import genclass.GenericIO;
import serverSide.sharedRegions.KitchenInterface;

public class KitchenClientProxy extends Thread implements ChefCloning, WaiterCloning {
	/**
	 * Number of instantiayed threads.
	 */

	private static int nProxy = 0;
	/**
	 * Communication channel.
	 */

	private ServerCom sconi;

	/**
	 * Interface to the Kitchen
	 */

	private KitchenInterface KitchenInter;

	/**
	 * Instantiation of a client proxy.
	 *
	 * @param sconi        communication channel
	 * @param KitchenInter interface to the kitchen
	 */

	public KitchenClientProxy(ServerCom sconi, KitchenInterface KitchenInter) {
		super("KitchenProxy" + KitchenClientProxy.getProxyId());
		this.sconi = sconi;
		this.KitchenInter = KitchenInter;
	}

	/**
	 * Generation of the instantiation identifier.
	 *
	 * @return instantiation identifier
	 */

	private static int getProxyId() {
		Class<?> cl = null; // representation of the KitchenClientProxy object in JVM
		int proxyId; // instantiation identifier

		try {
			cl = Class.forName("serverSide.entities.KitchenClientProxy");
		} catch (ClassNotFoundException e) {
			GenericIO.writelnString("Data type KitchenClientProxy was not found!");
			e.printStackTrace();
			System.exit(1);
		}
		synchronized (cl) {
			proxyId = nProxy;
			nProxy += 1;
		}
		return proxyId;
	}

}
