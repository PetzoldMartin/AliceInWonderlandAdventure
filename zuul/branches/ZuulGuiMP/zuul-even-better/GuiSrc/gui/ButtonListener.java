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
			case "nutz":
				gst.setStringAndSend(label);
				break;
			case "nimm":
				gst.setStringAndSend(label);
				break;
			case "sprich":
				gst.setStringAndSend(label);
				break;
			case "?":
				gst.setStringAndSend(label);
				break;
			case "1":
				gst.setStringAndSend(label);
				break;
			case "2":
				gst.setStringAndSend(label);
				break;
			case "3":
				gst.setStringAndSend(label);
				break;
			case "4":
				gst.setStringAndSend(label);
				break;
			case "5":
				gst.setStringAndSend(label);
				break;
			case "6":
				gst.setStringAndSend(label);
				break;
			default:
				System.out.println(label);
				gst.setString(label);
				break;
			}
		}else{
			switch (label) {
			case "guck":
				gst.setStringAndSend("? "+label);
				break;
			case "geh":
				gst.setStringAndSend("? "+label);
				break;
			case "sprich":
				gst.setStringAndSend("? "+label);
				break;
			case "nutz":
				gst.setStringAndSend("? "+label);
				break;
			case "nimm":
				gst.setStringAndSend("? "+label);
				break;
			case "neustart":
				gst.setStringAndSend(label);
				break;
			case "ende":
				gst.setStringAndSend(label);
				break;
			case "1":
				gst.setStringAndSend(label);
				break;
			case "2":
				gst.setStringAndSend(label);
				break;
			case "3":
				gst.setStringAndSend(label);
				break;
			case "4":
				gst.setStringAndSend(label);
				break;
			case "5":
				gst.setStringAndSend(label);
				break;
			case "6":
				gst.setStringAndSend(label);
				break;
			case "?":
				gst.setStringAndSend(label);
				break;
			default:
				//System.out.println(label);
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
