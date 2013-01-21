package observer.guiObserver;


import java.util.Observable;
import java.util.Observer;

/**
 * Klasse die die GUI beobachtet
 * 
 * @author Martin Petzold
 * 
 */
public class GuiListener implements Observer {

	/**
	 * der zugehörige Actioner der die Werte der Gui enthält
	 */
	private GuiActioner gst;

	/**
	 * der Konstruktor des {@link GuiListener}
	 * @param gst der Zugehörige Guiactioner
	 */
	public GuiListener(GuiActioner gst) {
		this.gst = gst;
	}

	/**
 * Die die die werte an der Gamegui weitergibt
 */
	@Override
	public void update(Observable o, Object arg) {
		gst.changeString((String) arg);
	}

}
