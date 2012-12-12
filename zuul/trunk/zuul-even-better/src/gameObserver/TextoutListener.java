package gameObserver;


import java.util.Observable;
import java.util.Observer;



public class TextoutListener implements Observer {
	

	private TextOutActioner guiActioner;

	public TextoutListener(TextOutActioner tOActioner) {
		this.guiActioner=tOActioner;
	}


	@Override
	public void update(Observable o, Object arg) {
		guiActioner.setTextOutLine((String)arg);
	}
	
	
}
