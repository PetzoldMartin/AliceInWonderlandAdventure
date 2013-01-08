package gameObserver;

import java.util.Observable;
import java.util.Observer;

import zuulCore.Player;

public class GameListener implements Observer {
	
	private BackroundActioner backRndAct;
	private InventarActioner inventAct;

	public GameListener(BackroundActioner backRndAct, InventarActioner inventAct) {
		this.backRndAct=backRndAct;
		this.inventAct=inventAct;
	}

	@Override
	public void update(Observable o, Object arg) {
		backRndAct.setCurrentRoom(((Player) arg).getCurrentRoom().getName());
		inventAct.setInventarListe(((Player)arg).getAllItemsToString());
		//System.out.println(gameGui.getCurrentRoom());
	}
	
	
}
