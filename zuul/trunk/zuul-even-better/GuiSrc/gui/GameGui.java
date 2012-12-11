package gui;



	import java.util.Observer;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
	
public class GameGui extends JFrame {
	
		private static final long serialVersionUID = -7974319251489449012L;
		private JPanel contentPane;
		private String currentRoom;
	
		/**
		 * Create the frame.
		 */
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
			
			JLabel lblNewLabel = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			lblNewLabel.setBounds(710, 50, 64, 64);
			contentPane.add(lblNewLabel);
			
			JLabel label = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label.setBounds(636, 50, 64, 64);
			contentPane.add(label);
			
			JLabel label_1 = new JLabel((Icon) null);
			label_1.setBounds(636, 50, 64, 64);
			contentPane.add(label_1);
			
			JLabel label_2 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_2.setBounds(562, 50, 64, 64);
			contentPane.add(label_2);
			
			JLabel label_3 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_3.setBounds(710, 125, 64, 64);
			contentPane.add(label_3);
			
			JLabel label_4 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_4.setBounds(636, 125, 64, 64);
			contentPane.add(label_4);
			
			JLabel label_5 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_5.setBounds(562, 125, 64, 64);
			contentPane.add(label_5);
			
			JLabel label_6 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_6.setBounds(636, 350, 64, 64);
			contentPane.add(label_6);
			
			JLabel label_7 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_7.setBounds(710, 350, 64, 64);
			contentPane.add(label_7);
			
			JLabel label_8 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_8.setBounds(562, 350, 64, 64);
			contentPane.add(label_8);
			
			JLabel label_9 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_9.setBounds(710, 200, 64, 64);
			contentPane.add(label_9);
			
			JLabel label_10 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_10.setBounds(636, 200, 64, 64);
			contentPane.add(label_10);
			
			JLabel label_11 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_11.setBounds(562, 200, 64, 64);
			contentPane.add(label_11);
			
			JLabel label_12 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_12.setBounds(562, 275, 64, 64);
			contentPane.add(label_12);
			
			JLabel label_13 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_13.setBounds(636, 275, 64, 64);
			contentPane.add(label_13);
			
			JLabel label_14 = new JLabel(new ImageIcon(GameGui.class.getResource("/gui/default.png")));
			label_14.setBounds(710, 275, 64, 64);
			contentPane.add(label_14);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon(GameGui.class.getResource("/gui/white.png")));
			lblNewLabel_1.setBounds(30, 96, 500, 400);
			contentPane.add(lblNewLabel_1);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(GameGui.class.getResource("/gui/x.png")));
			btnNewButton.setBounds(742, 519, 32, 32);
			contentPane.add(btnNewButton);
			
			JButton button = new JButton("");
			button.setIcon(new ImageIcon(GameGui.class.getResource("/gui/re.png")));
			button.setBounds(700, 519, 32, 33);
			contentPane.add(button);
			
			JButton button_1 = new JButton("");
			button_1.setIcon(new ImageIcon(GameGui.class.getResource("/gui/fr.png")));
			button_1.setBounds(658, 519, 32, 32);
			contentPane.add(button_1);
			
			JButton btnAnschaun = new JButton("Anschaun");
			btnAnschaun.setBounds(20, 519, 89, 23);
			contentPane.add(btnAnschaun);
			
			JButton btnNewButton_1 = new JButton("Benutzen");
			btnNewButton_1.setBounds(140, 519, 89, 23);
			contentPane.add(btnNewButton_1);
			
			JButton btnWasTolles = new JButton("Was tolles");
			btnWasTolles.setBounds(239, 519, 89, 23);
			contentPane.add(btnWasTolles);
			
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon(GameGui.class.getResource("/gui/grey.png")));
			lblNewLabel_2.setBounds(52, 43, 478, 82);
			contentPane.add(lblNewLabel_2);
		}
		
	public String getCurrentRoom(){
		return currentRoom;
	}
	
	public void setCurrentRoom(String s) {
		currentRoom = s;
	}
}

