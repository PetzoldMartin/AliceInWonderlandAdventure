package gui;



import gameObserver.BackroundActioner;
import gameObserver.TextOutActioner;

import java.util.Observable;
import java.util.Observer;

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
	
public class GameGui extends JFrame implements Runnable , Observer{
	
		private static final long serialVersionUID = -7974319251489449012L;
		private JPanel contentPane;
		private String currentRoom="white";
		private JLabel lblNewLabel_1;
		private boolean isChanged=true;
		private JTextArea outText;
		private String ausgabe="Start";
	

		public GameGui() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 800, 600);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			JLayeredPane layeredPane = new JLayeredPane();
			layeredPane.setBounds(52, 125, 478, -93);
			contentPane.add(layeredPane);
			
			JButton lblNewLabel = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			lblNewLabel.setBounds(710, 25, 64, 64);
			contentPane.add(lblNewLabel);
			
			JButton label = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label.setBounds(636, 25, 64, 64);
			contentPane.add(label);
			
			JLabel label_1 = new JLabel((Icon) null);
			label_1.setBounds(636, 50, 64, 64);
			contentPane.add(label_1);
			
			JButton label_2 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_2.setBounds(562, 25, 64, 64);
			contentPane.add(label_2);
			
			JButton label_3 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_3.setBounds(710, 100, 64, 64);
			contentPane.add(label_3);
			
			JButton label_4 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_4.setBounds(636, 100, 64, 64);
			contentPane.add(label_4);
			
			JButton label_5 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_5.setBounds(562, 100, 64, 64);
			contentPane.add(label_5);
			
			JButton label_6 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_6.setBounds(636, 380, 64, 64);
			contentPane.add(label_6);
			
			JButton label_9 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_9.setBounds(710, 200, 64, 64);
			contentPane.add(label_9);
			
			JButton label_10 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_10.setBounds(636, 200, 64, 64);
			contentPane.add(label_10);
			
			JButton label_11 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_11.setBounds(562, 200, 64, 64);
			contentPane.add(label_11);
			
			JButton label_12 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_12.setBounds(562, 275, 64, 64);
			contentPane.add(label_12);
			
			JButton label_13 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_13.setBounds(636, 275, 64, 64);
			contentPane.add(label_13);
			
			JButton label_14 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_14.setBounds(710, 275, 64, 64);
			contentPane.add(label_14);
			
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+currentRoom+".png")));
			lblNewLabel_1.setBounds(30, 140, 500, 368);
			contentPane.add(lblNewLabel_1);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(GameGui.class.getResource("/data/x.png")));
			btnNewButton.setBounds(742, 530, 32, 32);
			contentPane.add(btnNewButton);
			
			JButton button = new JButton("");
			button.setIcon(new ImageIcon(GameGui.class.getResource("/data/re.png")));
			button.setBounds(700, 529, 32, 33);
			contentPane.add(button);
			
			JButton button_1 = new JButton("");
			button_1.setIcon(new ImageIcon(GameGui.class.getResource("/data/fr.png")));
			button_1.setBounds(656, 530, 32, 32);
			contentPane.add(button_1);
			
			JButton btnAnschaun = new JButton("Anschaun");
			btnAnschaun.setBounds(0, 539, 89, 23);
			contentPane.add(btnAnschaun);
			
			JButton btnNewButton_1 = new JButton("Benutzen");
			btnNewButton_1.setBounds(99, 539, 89, 23);
			contentPane.add(btnNewButton_1);
			
			JButton btnWasTolles = new JButton(currentRoom);
			btnWasTolles.setBounds(198, 539, 89, 23);
			contentPane.add(btnWasTolles);
			
			outText = new JTextArea("New label",52,38);
			outText.setText("test");
			JScrollPane scroll = new JScrollPane(outText);
			scroll.setBounds(97, 0, 455, 139);
			//contentPane.add(outText);
			contentPane.add(scroll);
			
			JLabel raumgegenständeHeader = new JLabel("Raumgegenst\u00E4nde");
			raumgegenständeHeader.setBounds(562, 0, 212, 23);
			contentPane.add(raumgegenständeHeader);
			
			JLabel InventarHeader = new JLabel("Inventar");
			InventarHeader.setBounds(562, 175, 212, 23);
			contentPane.add(InventarHeader);
			
			JButton button_2 = new JButton("white");
			button_2.setBounds(297, 539, 89, 23);
			contentPane.add(button_2);
			
			JButton button_3 = new JButton("white");
			button_3.setBounds(396, 539, 89, 23);
			contentPane.add(button_3);
			
			JButton label_15 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_15.setBounds(562, 455, 64, 64);
			contentPane.add(label_15);
			
			JButton label_16 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_16.setBounds(636, 455, 64, 64);
			contentPane.add(label_16);
			
			JButton label_17 = new JButton(new ImageIcon(GameGui.class.getResource("/data/default.png")));
			label_17.setBounds(710, 455, 64, 64);
			contentPane.add(label_17);
			
			JLabel Richtungen = new JLabel("Richtungen");
			Richtungen.setBounds(562, 350, 212, 23);
			contentPane.add(Richtungen);
			
			JLabel label_7 = new JLabel("Kommandos");
			label_7.setBounds(0, 505, 212, 23);
			contentPane.add(label_7);
			
			JButton button_4 = new JButton("white");
			button_4.setBounds(495, 539, 89, 23);
			contentPane.add(button_4);
			
			JLabel button_5 = new JLabel(new ImageIcon(GameGui.class.getResource("/data/fr.png")));
			button_5.setBounds(10, 11, 82, 118);
			contentPane.add(button_5);
			guiUpdate();

		}
	
	public void guiUpdate(){
		lblNewLabel_1.setIcon(new ImageIcon(GameGui.class.getResource("/data/"+currentRoom+".png")));
		outText.setText(ausgabe);
		outText.setCaretPosition(outText.getText().length());
		
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
		while(isChanged){
		guiUpdate();
		isChanged=false;
		}
		}
	}
		
	public String getCurrentRoom(){
		return currentRoom;
	}
	
	public void setCurrentRoom(String s) {
		
		currentRoom = s;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0.getClass().equals(BackroundActioner.class))
		{setCurrentRoom((String) arg1);}
		if(arg0.getClass().equals(TextOutActioner.class))
		{setCurrentTextout((String) arg1);
		//System.out.println((String) arg1);
		}
		isChanged=true;
		
	}

	private void setCurrentTextout(String arg1) {
		ausgabe=ausgabe+"\n"+arg1;
		
	}
}

