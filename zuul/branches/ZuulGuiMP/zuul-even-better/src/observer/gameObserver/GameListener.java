package observer.gameObserver;

import java.util.Observable;
import java.util.Observer;

import zuulCore.thingsWithstore.Player;

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
	private DoorActioner doorActioner;//der Actioner der das Roominventar enth�lt
	private SizeActioner sizeActioner;//enth�lt die Spielergr��e

	/**
	 * der Konstruktor des GameListener
	 * @param backRndAct der Aktioner der die Information des Aktuellen raumes enth�lt
	 * @param kmActioner der Actioner der die Aktuellen Kommandos enth�lt
	 * @param inventAct der Aktioner der das Spielerinventar enth�lt
	 * @param roomInventAct der Actioner der das Roominventar enth�lt
	 * @param sizeActioner enth�lt die Spielergr��e
	 */
	public GameListener(BackroundActioner backRndAct,KommandActioner kmActioner, InventarActioner inventAct,RoomInventarActioner roomInventAct,DoorActioner doorActioner,SizeActioner sizeActioner) {
		this.backRndAct=backRndAct;
		this.kmdAct=kmActioner;
		this.inventAct=inventAct;
		this.roomInventAct=roomInventAct;
		this.doorActioner=doorActioner;
		this.sizeActioner=sizeActioner;
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
		doorActioner.changeString(((Player)arg).getCurrentRoom().getExitString());
		sizeActioner.changeString(((Player)arg).getSize().toString());
	}
	
	
}
