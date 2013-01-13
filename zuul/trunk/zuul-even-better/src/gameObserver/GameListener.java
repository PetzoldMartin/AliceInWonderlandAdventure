package gameObserver;

import java.util.Observable;
import java.util.Observer;

import zuulCore.Player;

/**
 * die Klasse die das Spiel beobachtet um Ver�nderungen in die Actioner zu schreiben
 * @author Aismael
 *
 */
public class GameListener implements Observer {
	
	private BackroundActioner backRndAct;//der Aktioner der die Information des Aktuellen raumes enth�lt
	private KommandActioner kmdAct;//der Actioner der die Aktuellen Kommandos enth�lt
	private InventarActioner inventAct;//der Aktioner der das Spielerinventar enth�lt
	private RoomInventarActioner roomInventAct;//der Actioner der das Roominventar enth�lt

	/**
	 * der Konstruktor des GameListener
	 * @param backRndAct der Aktioner der die Information des Aktuellen raumes enth�lt
	 * @param kmActioner der Actioner der die Aktuellen Kommandos enth�lt
	 * @param inventAct der Aktioner der das Spielerinventar enth�lt
	 * @param roomInventAct der Actioner der das Roominventar enth�lt
	 */
	public GameListener(BackroundActioner backRndAct,KommandActioner kmActioner, InventarActioner inventAct,RoomInventarActioner roomInventAct) {
		this.backRndAct=backRndAct;
		this.kmdAct=kmActioner;
		this.inventAct=inventAct;
		this.roomInventAct=roomInventAct;
	}

	@Override
	/**
	 * die Methode die �nderungen des Games an die Actioner Weitergibt
	 */
	public void update(Observable o, Object arg) {
		backRndAct.changeString(((Player) arg).getCurrentRoom().getName());
		kmdAct.changeString(((Player) arg).getnCW().getAll());
		inventAct.changeString(((Player)arg).getAllItemsToString());
		roomInventAct.changeString(((Player)arg).getCurrentRoom().getAllItemsToString());
	}
	
	
}
