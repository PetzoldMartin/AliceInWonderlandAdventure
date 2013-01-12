package guiObserver;


import java.util.Observable;
import java.util.Observer;



public class GuiListener implements Observer {
	

	

	private GuiActioner gst;


	public GuiListener(GuiActioner gst) {
		this.gst=gst;
	}


	@Override
	public void update(Observable o, Object arg) {
		gst.setCommandstring((String)arg);
	}
	
	
}
