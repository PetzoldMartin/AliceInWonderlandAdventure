package gameObserver;

import java.util.Observable;
import java.util.Observer;

import zuulCore.Player;

public class GameListener implements Observer {
	
	private BackroundActioner backRndAct;
	private KommandActioner kmdAct;

	public GameListener(BackroundActioner backRndAct,KommandActioner kmActioner) {
		this.backRndAct=backRndAct;
		this.kmdAct=kmActioner;
	}

	@Override
	public void update(Observable o, Object arg) {
		backRndAct.setCurrentRoom(((Player) arg).getCurrentRoom().getName());
		kmdAct.setCurrentAusgaben(((Player) arg).getnCW().getAll());
		
	}
	
	
}
