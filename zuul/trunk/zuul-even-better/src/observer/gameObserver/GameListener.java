package observer.gameObserver;

import java.util.Observable;
import java.util.Observer;

import zuulCore.thingsWithstore.Player;

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
	private DoorActioner doorActioner;//der Actioner der das Roominventar enthält
	private SizeActioner sizeActioner;//enthält die Spielergröße

	/**
	 * der Konstruktor des GameListener
	 * @param backRndAct der Aktioner der die Information des Aktuellen raumes enthält
	 * @param kmActioner der Actioner der die Aktuellen Kommandos enthält
	 * @param inventAct der Aktioner der das Spielerinventar enthält
	 * @param roomInventAct der Actioner der das Roominventar enthält
	 * @param sizeActioner enthält die Spielergröße
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
	 * die Methode die Änderungen des Games an die Actioner Weitergibt
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
