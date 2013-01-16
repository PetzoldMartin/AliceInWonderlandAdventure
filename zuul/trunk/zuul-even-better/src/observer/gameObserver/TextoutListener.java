package observer.gameObserver;


import java.util.Observable;
import java.util.Observer;


/**
 * Die Klasse die die Textausgabe auf ver�nderungen �berpr�ft und diese an den 
 * {@link TextOutActioner} weitergibt
 * @author Martin Petzold
 *
 */
public class TextoutListener implements Observer {
	

	/**
	 * enth�lt die Textausgaebe
	 */
	private TextOutActioner guiActioner;

	/**
	 * der Konstruktor des {@link TextoutListener}
	 * @param tOActioner enth�lt die Textausgaebe
	 */
	public TextoutListener(TextOutActioner tOActioner) {
		this.guiActioner=tOActioner;
	}

/**
 * die Methode die die werte an den {@link TextOutActioner} weitergibt
 */
	@Override
	public void update(Observable o, Object arg) {
		guiActioner.changeString((String)arg);
	}
	
	
}
