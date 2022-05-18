package serverSide.entities;

import clientSide.entities.StudentCloning;
import clientSide.entities.WaiterCloning;
import commInfra.ServerCom;
import genclass.GenericIO;
import serverSide.sharedRegions.TableInterface;

public class TableClientProxy extends Thread implements StudentCloning, WaiterCloning {

	/**
	 * Number of instantiayed threads.
	 */

	private static int nProxy = 0;
	/**
	 * Communication channel.
	 */

	private ServerCom sconi;

	/**
	 * Interface to the Table
	 */

	private TableInterface TableInter;

	/**
	 * Instantiation of a client proxy.
	 *
	 * @param sconi        communication channel
	 * @param KitchenInter interface to the table
	 */

	public TableClientProxy(ServerCom sconi, TableInterface TableInter) {
		super("TableProxy" + TableClientProxy.getProxyId());
		this.sconi = sconi;
		this.TableInter = TableInter;
	}

	/**
	 * Generation of the instantiation identifier.
	 *
	 * @return instantiation identifier
	 */

	private static int getProxyId() {
		Class<?> cl = null; // representation of the TableClientProxy object in JVM
		int proxyId; // instantiation identifier

		try {
			cl = Class.forName("serverSide.entities.TableClientProxy");
		} catch (ClassNotFoundException e) {
			GenericIO.writelnString("Data type TableClientProxy was not found!");
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
