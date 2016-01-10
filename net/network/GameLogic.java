package network;

import java.net.InetAddress;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameLogic extends Thread{
	
	boolean running = false;
	private GameClient socketClient;
	private GameServer socketServer;
	public InetAddress ip_client;
	
	public GameLogic(){
		//System.out.println("[I AM GAME LOGIC] Initializing socketServer = GameServer...");
		if (JOptionPane.showConfirmDialog(new JPanel(),  "Do You Want To Run The Server") == 0){
			socketServer = new GameServer(this);
			socketServer.start();
		}
		//System.out.println("[I AM GAME LOGIC] Initializing socketClient = GameClient...");
		if (JOptionPane.showConfirmDialog(new JPanel(),  "Do You Want To Connect Via Local IP?") == 0){
			System.out.println("SYSTEM: You Chose Local Connection with the Server!");
			socketClient = new GameClient(this, "localhost");}
		else {
			socketClient = new GameClient(this, "176.198.203.104");
			System.out.println("SYSTEM: You Chose Internet Connection with the Server!");
		}
		socketClient.start();
		ip_client = socketClient.ipAddress; // nur für Testzwecke da
	}
	public void run(){
	
		//System.out.println("[I AM GAME LOGIC] I started my run Method as I am a Thread");
		while (running){
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			GameInstance.amount_packages_sent++;
			System.out.println("[I AM GAME LOGIC] Going to Start the Method 'sendData' from the GameClient...");
			socketClient.sendData("ping".getBytes());
		}
	}
	public void setRunning(boolean set){
		running = set;
	}

}
