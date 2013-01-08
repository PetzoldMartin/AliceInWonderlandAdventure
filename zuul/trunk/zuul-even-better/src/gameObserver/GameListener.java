package gameObserver;

import java.util.Observable;
import java.util.Observer;

import zuulCore.Player;

public class GameListener implements Observer {
	
	private BackroundActioner backRndAct;
	private KommandActioner kmdAct;
	private InventarActioner inventAct;

	public GameListener(BackroundActioner backRndAct,KommandActioner kmActioner, InventarActioner inventAct) {
		this.backRndAct=backRndAct;
		this.kmdAct=kmActioner;
		this.inventAct=inventAct;
	}

	@Override
	public void update(Observable o, Object arg) {
		backRndAct.setCurrentRoom(((Player) arg).getCurrentRoom().getName());
		kmdAct.setCurrentAusgaben(((Player) arg).getnCW().getAll());
		inventAct.setInventarListe(((Player)arg).getAllItemsToString());
		
	}
	
	
}
