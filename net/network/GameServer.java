package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GameServer extends Thread{

	private DatagramSocket socket;
	private GameLogic game;

	public GameServer(GameLogic game) {
		this.game = game;
		try {
			this.socket = new DatagramSocket(11333); // Dieser Socket LISTENED auf diesem Port!
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void run(){
		while (true){
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			System.out.println("[GAME SERVER] Trying to read a Packet...");
			try {
				socket.receive(packet); // hier versuchen wir das Packet zu erhalten!
				System.out.println("[GAME SERVER] I got a Packet!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String message = new String(packet.getData()); // hier versuchen wir aus dem Packet den String zu lesen
			System.out.println("[GAME SERVER] CLIENT > ["+ packet.getAddress().getHostAddress()+":"+packet.getPort()+"]: "+ message);
			if (message.trim().equalsIgnoreCase("ping")){
				System.out.println("[GAME SERVER] Returning pong...");
				sendData((Integer.toString(packet.getPort())).getBytes(), packet.getAddress(), packet.getPort()); // getAddress/Port holt die IP Addresse/Port vom Sender!
				//sendData("pong".getBytes(), packet.getAddress(), packet.getPort()); // getAddress/Port holt die IP Addresse/Port vom Sender!
				
			}
		}
	}
	
	public void sendData(byte[] data, InetAddress ipAddress, int port){
		DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port); // 11333 = Port
		System.out.println("[GAME SERVER] Trying to Send the Data to a Client...");
		try {
			this.socket.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
	

