package guiObserver;

import java.util.Observable;

public class GuiActioner extends Observable {
	public GuiActioner(){
		
	}
	public void setCommandstring(String arg) {
		setChanged();
		notifyObservers(arg);
		
	}
	
	

}
