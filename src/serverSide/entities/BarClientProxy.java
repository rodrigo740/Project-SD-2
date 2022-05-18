package serverSide.entities;

import clientSide.entities.StudentCloning;
import clientSide.entities.WaiterCloning;
import commInfra.ServerCom;
import genclass.GenericIO;
import serverSide.sharedRegions.BarInterface;

public class BarClientProxy extends Thread implements WaiterCloning, StudentCloning {
	/**
	 * Number of instantiayed threads.
	 */

	private static int nProxy = 0;
	/**
	 * Communication channel.
	 */

	private ServerCom sconi;

	/**
	 * Interface to the Barber Shop.
	 */

	private BarInterface barInter;

	/**
	 * Instantiation of a client proxy.
	 *
	 * @param sconi      communication channel
	 * @param bShopInter interface to the barber shop
	 */

	public BarClientProxy(ServerCom sconi, BarInterface barInter) {
		super("BarProxy" + BarClientProxy.getProxyId());
		this.sconi = sconi;
		this.barInter = barInter;
	}

	/**
	 * Generation of the instantiation identifier.
	 *
	 * @return instantiation identifier
	 */

	private static int getProxyId() {
		Class<?> cl = null; // representation of the BarberShopClientProxy object in JVM
		int proxyId; // instantiation identifier

		try {
			cl = Class.forName("serverSide.entities.BarberShopClientProxy");
		} catch (ClassNotFoundException e) {
			GenericIO.writelnString("Data type BarberShopClientProxy was not found!");
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
