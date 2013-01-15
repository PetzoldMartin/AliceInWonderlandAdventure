package gui;


import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import observer.gameObserver.BackroundActioner;
import observer.gameObserver.DoorActioner;
import observer.gameObserver.InventarActioner;
import observer.gameObserver.KommandActioner;
import observer.gameObserver.RoomInventarActioner;
import observer.gameObserver.TextOutActioner;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameGui extends JFrame implements Runnable, Observer {

	private static final long serialVersionUID = -7974319251489449012L;
	private JPanel contentPane;
	private String currentRoom = "white";
	private JLabel Bildanzeige;
	private boolean isChanged = true;
	private JTextArea outText;
	private String ausgabe = "Start";
	private JButton Ende;
	private JButton Restart;
	private JButton Hilfe;
	private JButton Kommando1, Kommando2, Kommando3, Kommando4, Kommando5, Kommando6;
	private String currentInventory="";
	private String currentCommands="";
	private JButton[] KommandoButtons ;//die Arreyliste der Kommando Buttons
	private JButton[] Rauminventar ;// das Arrey mit den Rauminventar Buttons
	private JButton[] PlayerInventar;//das Arrey mitt den Spielerinventar Buttons
	private GuiString gst;//der an das spiel zu übergebende String als ÜbergabeKlasse
	private String currentRoomInventory="";
	private JButton RoomInventar1p1,RoomInventar1p2,RoomInventar1p3,RoomInventar2p1,RoomInventar2p2,RoomInventar2p3;
	private JButton Inventar1p1,Inventar1p2,Inventar1p3,Inventar2p1,Inventar2p2,Inventar2p3;
	private String currentDoors="";
	private JButton btnNord,btnSued,btnWest,btnEast;
	private ButtonListener K1,K2,K3,K4,K5,K6,RI1,RI2,RI3,RI4,RI5,RI6,I1,I2,I3,I4,I5,I6,n,o,s,w,h,r,e;

	public GameGui() {
		gst = new GuiString();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				Kommando6 = new JButton("Kommando6");
				Kommando6.setForeground(Color.BLACK);
				Kommando6.setBackground(Color.WHITE);
				Kommando6.setBounds(500, 530, 89, 23);
				contentPane.add(Kommando6);
		
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(52, 125, 478, -93);
		contentPane.add(layeredPane);
			
	//--Raum.Gegenstände//--Raum.Gegenstände//--Raum.Gegenstände
		JLabel raumgegenständeHeader = new JLabel("Raumgegenst\u00E4nde");
		raumgegenständeHeader.setForeground(Color.BLACK);
		raumgegenständeHeader.setBackground(Color.GRAY);
		raumgegenständeHeader.setBounds(560, 0, 210, 25);
		contentPane.add(raumgegenständeHeader);
		
		RoomInventar1p1 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		RoomInventar1p1.setFont(new Font("Tahoma", Font.PLAIN, 0));
		RoomInventar1p1.setBounds(562, 25, 64, 64);
		contentPane.add(RoomInventar1p1);

		RoomInventar1p2 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		RoomInventar1p2.setFont(new Font("Tahoma", Font.PLAIN, 0));
		RoomInventar1p2.setBounds(636, 25, 64, 64);
		contentPane.add(RoomInventar1p2); 

		RoomInventar1p3 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		RoomInventar1p3.setFont(new Font("Tahoma", Font.PLAIN, 0));
		RoomInventar1p3.setBounds(710, 25, 64, 64);
		contentPane.add(RoomInventar1p3);

		RoomInventar2p1 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		RoomInventar2p1.setFont(new Font("Tahoma", Font.PLAIN, 0));
		RoomInventar2p1.setBounds(562, 100, 64, 64);
		contentPane.add(RoomInventar2p1);

		RoomInventar2p2 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		RoomInventar2p2.setFont(new Font("Tahoma", Font.PLAIN, 0));
		RoomInventar2p2.setBounds(636, 100, 64, 64);
		contentPane.add(RoomInventar2p2);

		RoomInventar2p3 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		RoomInventar2p3.setFont(new Font("Tahoma", Font.PLAIN, 0));
		RoomInventar2p3.setBounds(710, 100, 64, 64);
		contentPane.add(RoomInventar2p3);

	//--InventarGegenstände//--InventarGegenstände//--InventarGegenstände
		JLabel InventarHeader = new JLabel("Inventar");
		InventarHeader.setForeground(Color.BLACK);
		InventarHeader.setBackground(Color.GRAY);
		InventarHeader.setBounds(562, 175, 212, 23);
		contentPane.add(InventarHeader);

		Inventar1p1 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		Inventar1p1.setFont(new Font("Tahoma", Font.PLAIN, 0));
		Inventar1p1.setBounds(562, 200, 64, 64);
		contentPane.add(Inventar1p1);

		Inventar1p2 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		Inventar1p2.setFont(new Font("Tahoma", Font.PLAIN, 0));
		Inventar1p2.setBounds(636, 200, 64, 64);
		contentPane.add(Inventar1p2);

		Inventar1p3 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		Inventar1p3.setFont(new Font("Tahoma", Font.PLAIN, 0));
		Inventar1p3.setBounds(710, 200, 64, 64);
		contentPane.add(Inventar1p3);

		Inventar2p1 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		Inventar2p1.setFont(new Font("Tahoma", Font.PLAIN, 0));
		Inventar2p1.setBounds(562, 275, 64, 64);
		contentPane.add(Inventar2p1);

		Inventar2p2 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		Inventar2p2.setFont(new Font("Tahoma", Font.PLAIN, 0));
		Inventar2p2.setBounds(636, 275, 64, 64);
		contentPane.add(Inventar2p2);

		Inventar2p3 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		Inventar2p3.setFont(new Font("Tahoma", Font.PLAIN, 0));
		Inventar2p3.setBounds(710, 275, 64, 64);
		contentPane.add(Inventar2p3);

		
	//-Windrose Windrose Windrose
		
		JLabel Richtungen = new JLabel("Bewegung");
		Richtungen.setForeground(Color.BLACK);
		Richtungen.setBackground(Color.GRAY);
		Richtungen.setBounds(562, 350, 212, 23);
		contentPane.add(Richtungen);
		
		btnNord = new JButton("norden");
		btnNord.setFont(new Font("Tahoma", Font.PLAIN, 0));
		btnNord.setIcon(new ImageIcon(GameGui.class.getResource("/data/norden.png")));
		btnNord.setBounds(600, 400, 50, 50);
		contentPane.add(btnNord);

		btnSued = new JButton("sueden");
		btnSued.setFont(new Font("Tahoma", Font.PLAIN, 0));
		btnSued.setIcon(new ImageIcon(GameGui.class.getResource("/data/sueden.png")));
		btnSued.setBounds(600, 500, 50, 50);
		contentPane.add(btnSued);
		
		btnWest = new JButton("westen");
		btnWest.setFont(new Font("Tahoma", Font.PLAIN, 0));
		btnWest.setIcon(new ImageIcon(GameGui.class.getResource("/data/westen.png")));
		btnWest.setBounds(550, 450, 50, 50);
		contentPane.add(btnWest);
		
		btnEast = new JButton("osten");
		btnEast.setFont(new Font("Tahoma", Font.PLAIN, 0));
		btnEast.setIcon(new ImageIcon(GameGui.class.getResource("/data/osten.png")));
		btnEast.setBounds(650, 450, 50, 50);
		contentPane.add(btnEast);
		
		JLabel lblWindrose = new JLabel(new ImageIcon(GameGui.class.getResource("/data/WRmid.png")));
		lblWindrose.setBounds(550, 400, 150, 150);
		contentPane.add(lblWindrose);
		
	//----


		JLabel Kommandos = new JLabel("Kommandos");
		Kommandos.setForeground(Color.BLACK);
		Kommandos.setBounds(5, 505, 212, 23);
		contentPane.add(Kommandos);

		Ende = new JButton("ende");
		Ende.setFont(new Font("Tahoma", Font.PLAIN, 0));
		Ende.setIcon(new ImageIcon(GameGui.class.getResource("/data/x.png")));
		Ende.setBounds(740, 520, 32, 32);
		contentPane.add(Ende);

		Restart = new JButton("neustart");
		Restart.setFont(new Font("Tahoma", Font.PLAIN, 0));
		Restart.setIcon(new ImageIcon(GameGui.class.getResource("/data/re.png")));
		Restart.setBounds(740, 480, 32, 33);
		contentPane.add(Restart);

		Hilfe = new JButton("?");
		Hilfe.setFont(new Font("Tahoma", Font.PLAIN, 0));
		Hilfe.setBackground(Color.DARK_GRAY);
		Hilfe.setIcon(new ImageIcon(GameGui.class.getResource("/data/fr.png")));
		Hilfe.setBounds(740, 440, 32, 32);
		contentPane.add(Hilfe);

		Kommando1 = new JButton("Kommando1");
		Kommando1.setForeground(Color.BLACK);
		Kommando1.setBackground(Color.WHITE);
		Kommando1.setBounds(5, 530, 89, 23);
		contentPane.add(Kommando1);

		Kommando2 = new JButton("Kommando2");
		Kommando2.setForeground(Color.BLACK);
		Kommando2.setBackground(Color.WHITE);
		Kommando2.setBounds(104, 530, 89, 23);
		contentPane.add(Kommando2);

		Kommando3 = new JButton("Kommando3");
		Kommando3.setForeground(Color.BLACK);
		Kommando3.setBackground(Color.WHITE);
		Kommando3.setBounds(203, 530, 89, 23);
		contentPane.add(Kommando3);

		Kommando4 = new JButton("Kommando4");
		Kommando4.setForeground(Color.BLACK);
		Kommando4.setBackground(Color.WHITE);
		Kommando4.setBounds(302, 530, 89, 23);
		contentPane.add(Kommando4);

		Kommando5 = new JButton("Kommando5");
		Kommando5.setForeground(Color.BLACK);
		Kommando5.setBackground(Color.WHITE);
		Kommando5.setBounds(401, 530, 89, 23);
		contentPane.add(Kommando5);

		Bildanzeige = new JLabel("");
		Bildanzeige.setBackground(Color.DARK_GRAY);
		Bildanzeige.setForeground(Color.DARK_GRAY);
		Bildanzeige.setIcon(new ImageIcon(GameGui.class.getResource("/data/"
				+ currentRoom + ".png")));
		Bildanzeige.setBounds(30, 140, 500, 368);
		contentPane.add(Bildanzeige);

		JLabel Avatar = new JLabel(new ImageIcon(
				GameGui.class.getResource("/data/Alice.png")));
		Avatar.setBounds(0, 0, 92, 129); 
		contentPane.add(Avatar);

		outText = new JTextArea("New label", 52, 38);
		outText.setForeground(Color.DARK_GRAY);
		outText.setBackground(Color.WHITE);
		outText.setText("test");
		JScrollPane scroll = new JScrollPane(outText);
		scroll.setBounds(97, 0, 455, 139);
		// contentPane.add(outText);
		contentPane.add(scroll);
		
		//Buttons in arreylist initialisieren
		JButton[] KommandoButtons = {Kommando1,Kommando2,Kommando3,Kommando4,Kommando5,Kommando6};
		this.KommandoButtons=KommandoButtons;
		JButton[] Rauminventar={RoomInventar1p1,RoomInventar1p2,RoomInventar1p3,RoomInventar2p1,RoomInventar2p2,RoomInventar2p3};
		this.Rauminventar=Rauminventar;
		JButton[] PlayerInventar={Inventar1p1,Inventar1p2,Inventar1p3,Inventar2p1,Inventar2p2,Inventar2p3};
		this.PlayerInventar=PlayerInventar;
		
		K1=new ButtonListener(Kommando1.getText(),gst);
		K2=new ButtonListener(Kommando2.getText(),gst);
		K3=new ButtonListener(Kommando3.getText(),gst);
		K4=new ButtonListener(Kommando4.getText(),gst);
		K5=new ButtonListener(Kommando5.getText(),gst);
		K6=new ButtonListener(Kommando6.getText(),gst);
		RI1=new ButtonListener(RoomInventar1p1.getText(), gst);
		RI2=new ButtonListener(RoomInventar1p2.getText(), gst);
		RI3=new ButtonListener(RoomInventar1p3.getText(), gst);
		RI4=new ButtonListener(RoomInventar2p1.getText(), gst);
		RI5=new ButtonListener(RoomInventar2p2.getText(), gst);
		RI6=new ButtonListener(RoomInventar2p3.getText(), gst);
		I1=new ButtonListener(Inventar1p1.getText(), gst);
		I2=new ButtonListener(Inventar1p2.getText(), gst);
		I3=new ButtonListener(Inventar1p3.getText(), gst);
		I4=new ButtonListener(Inventar1p1.getText(), gst);
		I5=new ButtonListener(Inventar2p2.getText(), gst);
		I6=new ButtonListener(Inventar2p3.getText(), gst);
		n=new ButtonListener(btnNord.getText(), gst);
		o=new ButtonListener(btnEast.getText(), gst);
		s=new ButtonListener(btnSued.getText(), gst);
		w=new ButtonListener(btnWest.getText(), gst);
		h=new ButtonListener(Hilfe.getText(), gst);
		e=new ButtonListener(Ende.getText(), gst);
		r=new ButtonListener(Restart.getText(), gst);
		Kommando1.addActionListener(K1);
		Kommando2.addActionListener(K2);
		Kommando3.addActionListener(K3);
		Kommando4.addActionListener(K4);
		Kommando5.addActionListener(K5);
		Kommando6.addActionListener(K6);
		RoomInventar1p1.addActionListener(RI1);
		RoomInventar1p2.addActionListener(RI2);
		RoomInventar1p3.addActionListener(RI3);
		RoomInventar2p1.addActionListener(RI4);
		RoomInventar2p2.addActionListener(RI5);
		RoomInventar2p3.addActionListener(RI6);
		Inventar1p1.addActionListener(I1);
		Inventar1p2.addActionListener(I2);
		Inventar1p3.addActionListener(I3);
		Inventar2p1.addActionListener(I4);
		Inventar2p2.addActionListener(I5);
		Inventar2p3.addActionListener(I6);
		btnEast.addActionListener(o);
		btnNord.addActionListener(n);
		btnSued.addActionListener(s);
		btnWest.addActionListener(w);
		Hilfe.addActionListener(h);
		Ende.addActionListener(e);
		Restart.addActionListener(r);
		guiUpdate();

	}

	public void guiUpdate() {
		Bildanzeige.setIcon(new ImageIcon(GameGui.class.getResource("/data/"
				+ currentRoom + ".png")));
		outText.setText(ausgabe);
		outText.setCaretPosition(outText.getText().length());
		//ansprechen der Kommandobuttons
		this.setButtons(new StringTokenizer(currentCommands));
		this.setPlayerinventory(PlayerInventar,new StringTokenizer(currentInventory));
		this.setPlayerinventory(Rauminventar,new StringTokenizer(currentRoomInventory));
		this.setDirection(new StringTokenizer(currentDoors));
		K1.setLabel(Kommando1.getText());
		K2.setLabel(Kommando2.getText());
		K3.setLabel(Kommando3.getText());
		K4.setLabel(Kommando4.getText());
		K5.setLabel(Kommando5.getText());
		K6.setLabel(Kommando6.getText());
		RI1.setLabel(RoomInventar1p1.getText());
		RI2.setLabel(RoomInventar1p2.getText());
		RI3.setLabel(RoomInventar1p3.getText());
		RI4.setLabel(RoomInventar2p1.getText());
		RI5.setLabel(RoomInventar2p2.getText());
		RI6.setLabel(RoomInventar2p3.getText());
		I1.setLabel(Inventar1p1.getText());
		I2.setLabel(Inventar1p2.getText());
		I3.setLabel(Inventar1p3.getText());
		I4.setLabel(Inventar2p1.getText());
		I5.setLabel(Inventar2p2.getText());
		I6.setLabel(Inventar2p3.getText());
		o.setLabel(btnEast.getText());
		n.setLabel(btnNord.getText());
		s.setLabel(btnSued.getText());
		w.setLabel(btnWest.getText());
		h.setLabel(Hilfe.getText());
		r.setLabel(Restart.getText());
		e.setLabel(Ende.getText());
	}

	@Override
	public void run() {
		this.setVisible(true);

		
		
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
			while (isChanged) {
				guiUpdate();
				isChanged = false;
			}
		}
	}

	public String getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(String s) {

		currentRoom = s;
	}

	public void setDirection(StringTokenizer tokenizer){
		btnEast.setVisible(false);
		btnNord.setVisible(false);
		btnSued.setVisible(false);
		btnWest.setVisible(false);
		while(tokenizer.hasMoreTokens()){
			String aktualltoken = tokenizer.nextToken();
			switch (aktualltoken) {
			case "sueden":
				btnSued.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+ aktualltoken + ".png")));
				btnSued.setVisible(true);
				btnSued.setText("sueden");
				break;
			case "norden":
				btnNord.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+ aktualltoken + ".png")));
				btnNord.setVisible(true);
				btnNord.setText("norden");
				break;
			case "osten":
				btnEast.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+ aktualltoken + ".png")));
				btnEast.setVisible(true);
				btnEast.setText("osten");
				break;
			case "westen":
				btnWest.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+ aktualltoken + ".png")));
				btnWest.setVisible(true);
				btnWest.setText("westen");
				break;
			case "hoch":
				btnNord.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+ aktualltoken + ".png")));
				btnNord.setVisible(true);
				btnNord.setText("hoch");
				break;
			case "vase":
				btnSued.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+ aktualltoken + ".png")));
				btnSued.setVisible(true);
				btnSued.setText("vase");
				break;
			case "raus":
				btnNord.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+ "hoch" + ".png")));
				btnNord.setVisible(true);
				btnNord.setText("raus");
				break;
			case "runter":
				btnSued.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+ "hoch" + ".png")));
				btnSued.setVisible(true);
				btnSued.setText("runter");
				break;
			case "ofen":
				btnNord.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+ "Ofen" + ".png")));
				btnNord.setVisible(true);
				btnNord.setText("ofen");
			default:
				break;
			}
		
		}
		
	}
	/**
	 * die methode die den Stringtokenizer auf die Kommandobuttons überträgt
	 * @param tokenizer
	 */
	public void setButtons(StringTokenizer tokenizer){
		Ende.setVisible(false);
		Restart.setVisible(false);
		Hilfe.setVisible(false);
		int buttonanzahl=KommandoButtons.length;
		for(int i=0; i<KommandoButtons.length; i++)
		{
			KommandoButtons[i].setVisible(false);
		}
		while(tokenizer.hasMoreTokens()){
			String aktualltoken = tokenizer.nextToken();
			switch (aktualltoken) {
			case "ende":
				Ende.setVisible(true);
				break;
			case "neustart":
				Restart.setVisible(true);
				break;
			case "?":
				Hilfe.setVisible(true);
				break;
			case "hilfe":
				Hilfe.setVisible(true);
				break;
			default:
				if (buttonanzahl==0)
				{
					System.err.println("mehr Kommandos als buttons");
				}
					
				else{
					KommandoButtons[KommandoButtons.length-buttonanzahl].setVisible(true);
					KommandoButtons[KommandoButtons.length-buttonanzahl].setText(aktualltoken);
					buttonanzahl--;
				}
				break;
			}
		}
	}

	public void setPlayerinventory(JButton[] buttons,StringTokenizer tokenizer){
		int buttonanzahl=buttons.length;
		for(int i=0; i<buttons.length; i++)
		{
			buttons[i].setVisible(false);
		}
		while(tokenizer.hasMoreTokens()){
			String aktualltoken = tokenizer.nextToken();
		if (buttonanzahl==0)
		{
			System.err.println("mehr Kommandos als buttons");
		}
			
		else{
			buttons[buttons.length-buttonanzahl].setVisible(true);
			buttons[buttons.length-buttonanzahl].setText(aktualltoken);
			buttons[buttons.length-buttonanzahl].setIcon(new ImageIcon(GameGui.class.getResource("/data/"
					+ aktualltoken + ".png")));
			buttonanzahl--;
		}
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if (arg0.getClass().equals(BackroundActioner.class)) {
			setCurrentRoom((String) arg1);
		}
		if (arg0.getClass().equals(TextOutActioner.class)) {
			setCurrentTextout((String) arg1);
		}
		if (arg0.getClass().equals(KommandActioner.class)) {
			setCurrentCommands((String) arg1);
		}
		if(arg0.getClass().equals(InventarActioner.class)) {
			setCurrentInventory((String)arg1);
		}
		if(arg0.getClass().equals(RoomInventarActioner.class)) {
			setCurrentRoomInventory((String)arg1);
		}
		if(arg0.getClass().equals(DoorActioner.class)) {
			setDoors((String)arg1);
		}
		

		isChanged = true;

	}

	private void setDoors(String currentDoors) {
		System.out.println("Spieler"+currentDoors);
		this.currentDoors= currentDoors;
		
	}

	public void setCurrentInventory(String currentInventory) {
		System.out.println("Spieler"+currentInventory);
		this.currentInventory = currentInventory;
	}
	public void setCurrentCommands(String currentCommands) {
		this.currentCommands = currentCommands;
	}
	
	public void setCurrentRoomInventory(String currentRoomInventory) {
		System.out.println("raum"+currentRoomInventory);
		this.currentRoomInventory = currentRoomInventory;
	}
	
	private void setCurrentTextout(String arg1) {
		ausgabe = ausgabe + "\n" + arg1;

	}

	public GuiString getGst() {
		return gst;
	}
	
}

