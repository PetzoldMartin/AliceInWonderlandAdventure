package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ButtonListener implements ActionListener
{

	private String label;
	private GuiString gst;
	public ButtonListener(String label,GuiString gst){
		this.setLabel(label);
		this.gst=gst;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(gst.hasInsert()){
			switch (label) {
			case "guck":
				gst.setStringAndSend(label);
				break;

			case "geh":
				gst.setStringAndSend(label);
				break;
			default:
				System.out.println("test");
				gst.setString(label);
				break;
			}
		}else{
			switch (label) {
			case "guck":
				gst.setStringAndSend(label+" raum");
				break;

			case "geh":
				gst.setStringAndSend(label);
				break;
			default:
				System.out.println("test");
				gst.setString(label);
				break;
			}
		}
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
