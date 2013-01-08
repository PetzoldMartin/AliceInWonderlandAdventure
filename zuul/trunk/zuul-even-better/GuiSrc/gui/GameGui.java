package gui;

import gameObserver.BackroundActioner;
import gameObserver.InventarActioner;
import gameObserver.KommandActioner;
import gameObserver.TextOutActioner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.util.StringTokenizer;

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
	private JButton[] KommandoButtons ;//die Arreyliste der Kommando buttons

	public GameGui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/** Wozu brauch wir den teil?
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(52, 125, 478, -93);
		contentPane.add(layeredPane);
			*/
	//--Raum.Gegenstände//--Raum.Gegenstände//--Raum.Gegenstände
		JLabel raumgegenständeHeader = new JLabel("Raumgegenst\u00E4nde");
		raumgegenständeHeader.setForeground(Color.BLACK);
		raumgegenständeHeader.setBackground(Color.GRAY);
		raumgegenständeHeader.setBounds(560, 0, 210, 25);
		contentPane.add(raumgegenständeHeader);
		
		JButton RoomInventar1p1 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		RoomInventar1p1.setBounds(562, 25, 64, 64);
		contentPane.add(RoomInventar1p1);

		JButton RoomInventar1p2 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		RoomInventar1p2.setBounds(636, 25, 64, 64);
		contentPane.add(RoomInventar1p2);

		JButton RoomInventar1p3 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		RoomInventar1p3.setBounds(710, 25, 64, 64);
		contentPane.add(RoomInventar1p3);

		JButton RoomInventar2p1 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		RoomInventar2p1.setBounds(562, 100, 64, 64);
		contentPane.add(RoomInventar2p1);

		JButton RoomInventar2p2 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		RoomInventar2p2.setBounds(636, 100, 64, 64);
		contentPane.add(RoomInventar2p2);

		JButton RoomInventar2p3 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		RoomInventar2p3.setBounds(710, 100, 64, 64);
		contentPane.add(RoomInventar2p3);

	//--InventarGegenstände//--InventarGegenstände//--InventarGegenstände
		JLabel InventarHeader = new JLabel("Inventar");
		InventarHeader.setForeground(Color.BLACK);
		InventarHeader.setBackground(Color.GRAY);
		InventarHeader.setBounds(562, 175, 212, 23);
		contentPane.add(InventarHeader);

		JButton Inventar1p1 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		Inventar1p1.setBounds(562, 200, 64, 64);
		contentPane.add(Inventar1p1);

		JButton Inventar1p2 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		Inventar1p2.setBounds(636, 200, 64, 64);
		contentPane.add(Inventar1p2);

		JButton Inventar1p3 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		Inventar1p3.setBounds(710, 200, 64, 64);
		contentPane.add(Inventar1p3);

		JButton Inventar2p1 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		Inventar2p1.setBounds(562, 275, 64, 64);
		contentPane.add(Inventar2p1);

		JButton Inventar2p2 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		Inventar2p2.setBounds(636, 275, 64, 64);
		contentPane.add(Inventar2p2);

		JButton Inventar2p3 = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/default.png")));
		Inventar2p3.setBounds(710, 275, 64, 64);
		contentPane.add(Inventar2p3);

		
	//-Windrose Windrose Windrose
		
		JLabel Richtungen = new JLabel("Bewegung");
		Richtungen.setForeground(Color.BLACK);
		Richtungen.setBackground(Color.GRAY);
		Richtungen.setBounds(562, 350, 212, 23);
		contentPane.add(Richtungen);
		
		JButton btnNord = new JButton("");
		btnNord.setIcon(new ImageIcon(GameGui.class.getResource("/data/WRnord.png")));
		btnNord.setBounds(600, 400, 50, 50);
		contentPane.add(btnNord);

		JButton btnSued = new JButton("");
		btnSued.setIcon(new ImageIcon(GameGui.class.getResource("/data/WRsued.png")));
		btnSued.setBounds(600, 500, 50, 50);
		contentPane.add(btnSued);
		
		JButton btnWest = new JButton("");
		btnWest.setIcon(new ImageIcon(GameGui.class.getResource("/data/WRwest.png")));
		btnWest.setBounds(550, 450, 50, 50);
		contentPane.add(btnWest);
		
		JButton btnEast = new JButton("");
		btnEast.setIcon(new ImageIcon(GameGui.class.getResource("/data/WReast.png")));
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

		Ende = new JButton("");
		Ende.setIcon(new ImageIcon(GameGui.class.getResource("/data/x.png")));
		Ende.setBounds(740, 520, 32, 32);
		contentPane.add(Ende);

		Restart = new JButton("");
		Restart.setIcon(new ImageIcon(GameGui.class.getResource("/data/re.png")));
		Restart.setBounds(740, 480, 32, 33);
		contentPane.add(Restart);

		Hilfe = new JButton("");
		Hilfe.setBackground(Color.DARK_GRAY);
		Hilfe.setIcon(new ImageIcon(GameGui.class.getResource("/data/fr.png")));
		Hilfe.setBounds(740, 440, 32, 32);
		contentPane.add(Hilfe);

		Kommando1 = new JButton("Kommando1");
		Kommando1.setForeground(Color.BLACK);
		Kommando1.setBackground(Color.DARK_GRAY);
		Kommando1.setBounds(5, 530, 89, 23);
		contentPane.add(Kommando1);

		Kommando2 = new JButton("Kommando2");
		Kommando2.setForeground(Color.BLACK);
		Kommando2.setBackground(Color.DARK_GRAY);
		Kommando2.setBounds(104, 530, 89, 23);
		contentPane.add(Kommando2);

		Kommando3 = new JButton("Kommando3");
		Kommando3.setForeground(Color.BLACK);
		Kommando3.setBackground(Color.DARK_GRAY);
		Kommando3.setBounds(203, 530, 89, 23);
		contentPane.add(Kommando3);

		Kommando4 = new JButton("Kommando4");
		Kommando4.setForeground(Color.BLACK);
		Kommando4.setBackground(Color.DARK_GRAY);
		Kommando4.setBounds(302, 530, 89, 23);
		contentPane.add(Kommando4);

		Kommando5 = new JButton("Kommando5");
		Kommando5.setForeground(Color.BLACK);
		Kommando5.setBackground(Color.DARK_GRAY);
		Kommando5.setBounds(401, 530, 89, 23);
		contentPane.add(Kommando5);

		Kommando6 = new JButton("Kommando6");
		Kommando6.setForeground(Color.BLACK);
		Kommando6.setBackground(Color.DARK_GRAY);
		Kommando6.setBounds(500, 530, 89, 23);
		contentPane.add(Kommando6);

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
		
		guiUpdate();

	}

	public void guiUpdate() {
		Bildanzeige.setIcon(new ImageIcon(GameGui.class.getResource("/data/"
				+ currentRoom + ".png")));
		outText.setText(ausgabe);
		outText.setCaretPosition(outText.getText().length());
		//ansprechen der Kommandobuttons
		this.setButtons(new StringTokenizer(currentCommands));

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
					KommandoButtons[KommandoButtons.length-buttonanzahl].setLabel(aktualltoken);
					buttonanzahl--;
				}
				break;
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
		if(arg0.getClass().equals(InventarActioner.class)) {
			setCurrentInventory((String)arg1);
		}
		}

		isChanged = true;

	}

	public void setCurrentInventory(String currentInventory) {
		this.currentInventory = currentInventory;
	}
	public void setCurrentCommands(String currentCommands) {
		this.currentCommands = currentCommands;
	}
	
	private void setCurrentTextout(String arg1) {
		ausgabe = ausgabe + "\n" + arg1;

	}
}
