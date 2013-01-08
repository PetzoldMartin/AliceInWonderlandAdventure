package gameObserver;

import java.util.Observable;

public class TextOutActioner extends Observable {
	public TextOutActioner(){
		
	}
	public void setTextOutLine(String arg) {
		setChanged();
		notifyObservers(arg);
		
	}
	
	

}
