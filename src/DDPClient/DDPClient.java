package DDPClient;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.Observer;

import Event.SensorData;
import me.kutrumbos.DdpClient;
import me.kutrumbos.examples.SimpleDdpClientObserver;

/**
 * Simple example of DDP client use-case that just involves 
 * 		making a connection to a locally hosted Meteor server
 * @author peterkutrumbos
 *
 */
public class DDPClient {
	
	private String meteorIp;
	private int meteorPort;

	public DDPClient(String meteorIp, int meteorPort){
		
		System.out.println("Test");
		
		this.meteorIp = meteorIp;
		this.meteorPort = meteorPort;
		
	}

	public boolean connect() {
		
		System.out.println("Test");

		DdpClient ddp = null;
		
		try {
			
			// create DDP client instance
			ddp = new DdpClient(meteorIp, meteorPort);
			
			// create DDP client observer
			Observer obs = new DdpClientObserver();
			
			// add observer
			ddp.addObserver(obs);
						
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
			// make connection to Meteor server
		
		do {
		ddp.connect();
		} while(ddp.getReadyState()==3);
			
		    /*while(true) {
				try {
					Thread.sleep(5000);

					System.out.println("calling remote method...");
					
					Object[] methodArgs = new Object[1];
					methodArgs[0] = new Date().toString();
					ddp.call("update_time", methodArgs);

				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}*/
		 
		
		return true;
	}

	
	
}
