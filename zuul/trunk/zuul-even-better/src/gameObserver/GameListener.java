package gameObserver;

import java.util.Observable;
import java.util.Observer;

import zuulCore.Player;

/**
 * die Klasse die das Spiel beobachtet um Veränderungen in die Actioner zu schreiben
 * @author Aismael
 *
 */
public class GameListener implements Observer {
	
	private BackroundActioner backRndAct;//der Aktioner der die Information des Aktuellen raumes enthält
	private KommandActioner kmdAct;//der Actioner der die Aktuellen Kommandos enthält
	private InventarActioner inventAct;//der Aktioner der das Spielerinventar enthält
	private RoomInventarActioner roomInventAct;//der Actioner der das Roominventar enthält

	/**
	 * der Konstruktor des GameListener
	 * @param backRndAct der Aktioner der die Information des Aktuellen raumes enthält
	 * @param kmActioner der Actioner der die Aktuellen Kommandos enthält
	 * @param inventAct der Aktioner der das Spielerinventar enthält
	 * @param roomInventAct der Actioner der das Roominventar enthält
	 */
	public GameListener(BackroundActioner backRndAct,KommandActioner kmActioner, InventarActioner inventAct,RoomInventarActioner roomInventAct) {
		this.backRndAct=backRndAct;
		this.kmdAct=kmActioner;
		this.inventAct=inventAct;
		this.roomInventAct=roomInventAct;
	}

	@Override
	/**
	 * die Methode die Änderungen des Games an die Actioner Weitergibt
	 */
	public void update(Observable o, Object arg) {
		backRndAct.changeString(((Player) arg).getCurrentRoom().getName());
		kmdAct.changeString(((Player) arg).getnCW().getAll());
		inventAct.changeString(((Player)arg).getAllItemsToString());
		roomInventAct.changeString(((Player)arg).getCurrentRoom().getAllItemsToString());
	}
	
	
}
