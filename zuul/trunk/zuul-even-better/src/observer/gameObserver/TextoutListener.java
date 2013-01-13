package observer.gameObserver;


import java.util.Observable;
import java.util.Observer;


/**
 * Die Klasse die die Textausgabe auf veränderungen überprüft und diese an den 
 * {@link TextOutActioner} weitergibt
 * @author Aismael
 *
 */
public class TextoutListener implements Observer {
	

	private TextOutActioner guiActioner;//enthält die Textausgaebe

	/**
	 * der Konstruktor des {@link TextoutListener}
	 * @param tOActioner enthält die Textausgaebe
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
