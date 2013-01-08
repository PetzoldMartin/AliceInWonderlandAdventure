package gui;



import gameObserver.BackroundActioner;
import gameObserver.InventarActioner;
import gameObserver.TextOutActioner;

import java.util.Observable;
import java.util.Observer;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
	
public class GameGui extends JFrame implements Runnable , Observer, ActionListener{
	
		private static final long serialVersionUID = -7974319251489449012L;
		private JPanel contentPane;
		private String currentRoom="white";
		private String currentInventory="default";
		private JLabel lblRaum;
		private boolean isChanged=true;
		private JTextArea outText;
		private String ausgabe="Start";
		private JButton btnExit,btnRestart,btnHilfe;
		private JLabel lblInventItem0 ,lblInventItem1,lblInventItem2,lblInventItem3,lblInventItem4,lblInventItem5,lblInventItem6, lblInventItem7 ,lblInventItem8;
		

		public GameGui() {
			
				//Hauptfenster
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 800, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			
				//Raum  ||| !!! Raumbilder müssen die größe 475x400 haben !!! |||
			lblRaum = new JLabel("");
			//lblNewLabel_1.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+currentRoom+".png")));
			lblRaum.setIcon(new ImageIcon(GameGui.class.getResource("/data/grey.png")));
			lblRaum.setBounds(5, 10, 475, 400);
			contentPane.add(lblRaum);

			
				//text-Ausgabe
			outText = new JTextArea("New label",0,0);
			outText.setText("test");
			JScrollPane scroll = new JScrollPane(outText);
			scroll.setBounds(485, 10, 300, 160);
			contentPane.add(scroll);
			guiUpdate();
			
			
			JLabel lblRoomItem0 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblRoomItem0.setBounds(5, 400, 64, 64);
			contentPane.add(lblRoomItem0);
			
			JLabel lblRoomItem1 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblRoomItem1.setBounds(85, 400, 64, 64);
			contentPane.add(lblRoomItem1);
			
			JLabel lblRoomItem2 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblRoomItem2.setBounds(165, 400, 64, 64);
			contentPane.add(lblRoomItem2);
			
			JLabel lblRoomItem3 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblRoomItem3.setBounds(245, 400, 64, 64);
			contentPane.add(lblRoomItem3);
			
			JLabel lblRoomItem4 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblRoomItem4.setBounds(325, 400, 64, 64);
			contentPane.add(lblRoomItem4);
			
			JLabel lblRoomItem5 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblRoomItem5.setBounds(405, 400, 64, 64);
			contentPane.add(lblRoomItem5);
			
				//---
			
			
			lblInventItem0 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblInventItem0.setBounds(680, 180, 64, 64);
			contentPane.add(lblInventItem0);
			
			lblInventItem1 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblInventItem1.setBounds(600, 180, 64, 64);
			contentPane.add(lblInventItem1);
			
			lblInventItem2 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblInventItem2.setBounds(520, 180, 64, 64);
			contentPane.add(lblInventItem2);
			
			lblInventItem3 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblInventItem3.setBounds(680, 250, 64, 64);
			contentPane.add(lblInventItem3);
			
			lblInventItem4 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblInventItem4.setBounds(600, 250, 64, 64);
			contentPane.add(lblInventItem4);
			
			lblInventItem5 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblInventItem5.setBounds(520, 250, 64, 64);
			contentPane.add(lblInventItem5);
			
			lblInventItem6 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblInventItem6.setBounds(680, 320, 64, 64);
			contentPane.add(lblInventItem6);
			
			lblInventItem7 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblInventItem7.setBounds(600, 320, 64, 64);
			contentPane.add(lblInventItem7);
			
			lblInventItem8 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblInventItem8.setBounds(520, 320, 64, 64);
			contentPane.add(lblInventItem8);
			
				//--- Bewegung
			
			JButton btnNord = new JButton("");
			btnNord.setIcon(new ImageIcon(GameGui.class.getResource("/data/WRnord.png")));
			btnNord.setBounds(550, 400, 50, 50);
			contentPane.add(btnNord);

			JButton btnSued = new JButton("");
			btnSued.setIcon(new ImageIcon(GameGui.class.getResource("/data/WRsued.png")));
			btnSued.setBounds(550, 500, 50, 50);
			contentPane.add(btnSued);
			
			JButton btnWest = new JButton("");
			btnWest.setIcon(new ImageIcon(GameGui.class.getResource("/data/WRwest.png")));
			btnWest.setBounds(500, 450, 50, 50);
			contentPane.add(btnWest);
			
			JButton btnEast = new JButton("");
			btnEast.setIcon(new ImageIcon(GameGui.class.getResource("/data/WReast.png")));
			btnEast.setBounds(600, 450, 50, 50);
			contentPane.add(btnEast);
			
			JLabel lblWindrose = new JLabel(new ImageIcon(GameGui.class.getResource("/data/WRmid.png")));
			lblWindrose.setBounds(500, 400, 150, 150);
			contentPane.add(lblWindrose);
			


				// MenüButtons
			btnExit = new JButton("");
			btnExit.setIcon(new ImageIcon(GameGui.class.getResource("/data/x.png")));
			btnExit.setBounds(742, 519, 32, 32);
			contentPane.add(btnExit);
			
			btnRestart = new JButton("");
			btnRestart.setIcon(new ImageIcon(GameGui.class.getResource("/data/re.png")));
			btnRestart.setBounds(700, 519, 32, 33);
			contentPane.add(btnRestart);
			
			btnHilfe = new JButton("");
			btnHilfe.setIcon(new ImageIcon(GameGui.class.getResource("/data/fr.png")));
			btnHilfe.setBounds(658, 519, 32, 32);
			contentPane.add(btnHilfe);
			
			btnExit.addActionListener((ActionListener) this);
			btnRestart.addActionListener((ActionListener) this);
			btnHilfe.addActionListener((ActionListener) this);
			
				// 	Befehl Buttons
			JButton btnAnschaun = new JButton("Anschaun");
			btnAnschaun.setBounds(20, 519, 89, 23);
			contentPane.add(btnAnschaun);
			
			JButton btnNewButton_1 = new JButton("Benutzen");
			btnNewButton_1.setBounds(140, 519, 89, 23);
			contentPane.add(btnNewButton_1);
			
			JButton btnWasTolles = new JButton(currentRoom);
			btnWasTolles.setBounds(239, 519, 89, 23);
			contentPane.add(btnWasTolles);
			
			/*
			
			JLayeredPane layeredPane = new JLayeredPane();
			layeredPane.setBounds(52, 125, 478, -93);
			contentPane.add(layeredPane);
			
			JLabel label_1 = new JLabel((Icon) null);
			label_1.setBounds(636, 50, 64, 64);
			contentPane.add(label_1);*/


		}
	
	public void guiUpdate(){
		lblRaum.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+currentRoom+".png")));
		outText.setText(ausgabe);
		outText.setCaretPosition(outText.getText().length());
		
		guiItemUpdate();
		
	}
	
    private void guiItemUpdate() {
    	String[] splitResult = currentInventory.split(" ");
    	for (int i = 0; i < splitResult.length; i++) {
			System.out.println(splitResult[i] + " ");
		}
    	//	JLabel lblInventItem+i= new JLabel(new ImageIcon(GameGui.class.getResource("/data/default.png")));

			try {
				lblInventItem0.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+splitResult[0]+".png")));	
			} catch (Exception e) {
				//lblInventItem0.setIcon(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			}
    		


	}
		
	@Override
	public void run() {
		this.setVisible(true);
		
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
			while(isChanged) {
				guiUpdate();
				isChanged=false;
			}
		}
	}
		


	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0.getClass().equals(BackroundActioner.class))
			{setCurrentRoom((String) arg1);}
		if(arg0.getClass().equals(TextOutActioner.class))
			{setCurrentTextout((String) arg1);
		}
		if(arg0.getClass().equals(InventarActioner.class)) {
			setCurrentInventory((String)arg1);
		}
		isChanged=true;
		
	}
	
    public void actionPerformed (ActionEvent ae){
    	
        if(ae.getSource() == this.btnExit){
        	 System.out.println("exit");
        }
        else if(ae.getSource() == this.btnHilfe){
        	 System.out.println("hilfe");
        }
        else if (ae.getSource() == this.btnRestart){
        	 System.out.println("restart");
        }
    }


    
	private void setCurrentTextout(String arg1) {
		ausgabe=ausgabe+"\n"+arg1;
		
	}

	public String getCurrentRoom(){
		return currentRoom;
	}
	
	public void setCurrentRoom(String s) {
		
		currentRoom = s;
	}

	public String getCurrentInventory() {
		return currentInventory;
	}

	public void setCurrentInventory(String currentInventory) {
		this.currentInventory = currentInventory;
	}
}

