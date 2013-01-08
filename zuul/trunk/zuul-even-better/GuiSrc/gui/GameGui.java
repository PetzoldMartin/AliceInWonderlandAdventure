package gui;

import gameObserver.BackroundActioner;
import gameObserver.KommandActioner;
import gameObserver.TextOutActioner;

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
	private JButton Kommando1;
	private JButton Kommando2;
	private JButton Kommando3;
	private JButton Kommando4;
	private JButton Kommando5;
	private JButton Kommando6;

	public GameGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(52, 125, 478, -93);
		contentPane.add(layeredPane);

		JLabel raumgegenständeHeader = new JLabel("Raumgegenst\u00E4nde");
		raumgegenständeHeader.setForeground(Color.BLACK);
		raumgegenständeHeader.setBackground(Color.GRAY);
		raumgegenständeHeader.setBounds(562, 0, 212, 23);
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

		JLabel Richtungen = new JLabel("Richtungen");
		Richtungen.setForeground(Color.BLACK);
		Richtungen.setBackground(Color.GRAY);
		Richtungen.setBounds(562, 350, 212, 23);
		contentPane.add(Richtungen);

		JButton Norden = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/norden.png")));
		Norden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Norden.setBounds(636, 380, 64, 64);
		contentPane.add(Norden);

		JButton Westen = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/westen.png")));
		Westen.setBounds(562, 455, 64, 64);
		contentPane.add(Westen);

		JButton Sueden = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/sueden.png")));
		Sueden.setBounds(636, 455, 64, 64);
		contentPane.add(Sueden);

		JButton Osten = new JButton(new ImageIcon(
				GameGui.class.getResource("/data/osten.png")));
		Osten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Osten.setBounds(710, 455, 64, 64);
		contentPane.add(Osten);

		JLabel Kommandos = new JLabel("Kommandos");
		Kommandos.setForeground(Color.BLACK);
		Kommandos.setBounds(0, 505, 212, 23);
		contentPane.add(Kommandos);

		Ende = new JButton("");
		Ende.setIcon(new ImageIcon(GameGui.class.getResource("/data/x.png")));
		Ende.setBounds(742, 530, 32, 32);
		contentPane.add(Ende);

		Restart = new JButton("");
		Restart.setIcon(new ImageIcon(GameGui.class.getResource("/data/re.png")));
		Restart.setBounds(700, 529, 32, 33);
		contentPane.add(Restart);

		Hilfe = new JButton("");
		Hilfe.setBackground(Color.DARK_GRAY);
		Hilfe.setIcon(new ImageIcon(GameGui.class.getResource("/data/fr.png")));
		Hilfe.setBounds(656, 530, 32, 32);
		contentPane.add(Hilfe);

		Kommando1 = new JButton("Kommando1");
		Kommando1.setForeground(Color.BLACK);
		Kommando1.setBackground(Color.DARK_GRAY);
		Kommando1.setBounds(0, 539, 89, 23);
		contentPane.add(Kommando1);

		Kommando2 = new JButton("Kommando2");
		Kommando2.setForeground(Color.BLACK);
		Kommando2.setBackground(Color.DARK_GRAY);
		Kommando2.setBounds(99, 539, 89, 23);
		contentPane.add(Kommando2);

		Kommando3 = new JButton("Kommando3");
		Kommando3.setForeground(Color.BLACK);
		Kommando3.setBackground(Color.DARK_GRAY);
		Kommando3.setBounds(198, 539, 89, 23);
		contentPane.add(Kommando3);

		Kommando4 = new JButton("Kommando4");
		Kommando4.setForeground(Color.BLACK);
		Kommando4.setBackground(Color.DARK_GRAY);
		Kommando4.setBounds(297, 539, 89, 23);
		contentPane.add(Kommando4);

		Kommando5 = new JButton("Kommando5");
		Kommando5.setForeground(Color.BLACK);
		Kommando5.setBackground(Color.DARK_GRAY);
		Kommando5.setBounds(396, 539, 89, 23);
		contentPane.add(Kommando5);

		Kommando6 = new JButton("Kommando6");
		Kommando6.setForeground(Color.BLACK);
		Kommando6.setBackground(Color.DARK_GRAY);
		Kommando6.setBounds(495, 539, 89, 23);
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
		outText.setForeground(Color.BLACK);
		outText.setBackground(Color.GRAY);
		outText.setText("test");
		JScrollPane scroll = new JScrollPane(outText);
		scroll.setBounds(97, 0, 455, 139);
		// contentPane.add(outText);
		contentPane.add(scroll);
		guiUpdate();

	}

	public void guiUpdate() {
		Bildanzeige.setIcon(new ImageIcon(GameGui.class.getResource("/data/"
				+ currentRoom + ".png")));
		outText.setText(ausgabe);
		outText.setCaretPosition(outText.getText().length());

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

	public void setCommands(String Kommands) {
		StringTokenizer tokenizer = new StringTokenizer(Kommands);

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
			setCommands((String) arg1);
		}

		isChanged = true;

	}

	private void setCurrentTextout(String arg1) {
		ausgabe = ausgabe + "\n" + arg1;

	}
}
