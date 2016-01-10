package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class GameClient extends Thread{

	public InetAddress ipAddress;
	public int own_port;
	private DatagramSocket socket;
	private GameLogic game;
	public static DatagramPacket lastPacket;

	public GameClient(GameLogic game, String ipAddress) {
		this.game = game;
		try {
			this.socket = new DatagramSocket();
			this.ipAddress = InetAddress.getByName(ipAddress);
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run(){
		while (true){
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			System.out.println("[I AM GAME CLIENT] Trying to read a Packet...");
			try {
				socket.receive(packet);
				lastPacket = packet; // das letzte Packet wird Lokal gespeichert, nicht notwendig, nur für Testzwecke
				System.out.println("[I AM GAME CLIENT] I just successfully received a Packet!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("ERROR: Fehler in GameClient beim Empfangen eines Pacakges!");
			}
			String message = new String(packet.getData()); // hier versuchen wir aus dem Packet den String zu lesen
			System.out.println("[I AM GAME CLIENT] SERVER said: "+ message);
		}
	}
	
	public void sendData(byte[] data){
		//DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, 11333); // 11333 = Port
		DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, 11333); // 11333 = Port
		System.out.println(ipAddress.getHostAddress());
		try {
			socket.send(packet);
			System.out.println("[I AM GAME CLIENT] Successfully sent the Packet to the Server, hoping it arrived!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
