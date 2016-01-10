package network;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class GameInstance extends JFrame {


	
	Thread x1 = null;
	GameLogic logic = null;
	String ip_string = "noch nichts";
	JTextField textfield = null;
	JTextField textfield_amount = null;
	public static int amount_packages_received = 0;
	public static int amount_packages_sent = 0;
	
	public GameInstance(){
		this.setDefaultCloseOperation(3);
		this.setSize(400, 250);
		this.setLocation(300, 300);
		this.setLayout(new BorderLayout());
		textfield = new JTextField("noch keine IP ermittelt");
		textfield_amount = new JTextField("noch keine Datagram Packets gesendet...");
		this.add(textfield,"North");
		this.add(textfield_amount,"South");
		this.setVisible(true);
		// Game Logic START
		logic = new GameLogic();
		logic.setRunning(true);
		// Game Logic END
		// Thread START
		x1 = new Thread(logic);
		x1.start();
		
		Thread x2 = new Thread(){
			public void run(){
				while (true){
					try {
						this.sleep(250);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						if (GameClient.lastPacket!=null){
						ip_string= logic.ip_client.getHostAddress();
						ip_string+=":";
						ip_string+=new String(GameClient.lastPacket.getData());
						textfield.setText("IP(Client): "+ip_string+", Server Port:"+GameClient.lastPacket.getPort());
						textfield_amount.setText("Packets versendet: "+Integer.toString(amount_packages_sent));
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				//textfield.setText(Double.toString((Math.random())));
				}
			}
		
		};
		x2.start();
		// Thread END
		
	}
	
	public void start(){
		// synchronized im Video
	}

	
	
	
}
