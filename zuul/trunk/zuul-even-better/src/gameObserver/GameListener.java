package gameObserver;

import java.util.Observable;
import java.util.Observer;

import zuulCore.Player;

public class GameListener implements Observer {
	
	private BackroundActioner backRndAct;

	public GameListener(BackroundActioner backRndAct) {
		this.backRndAct=backRndAct;
	}

	@Override
	public void update(Observable o, Object arg) {
		backRndAct.setCurrentRoom(((Player) arg).getCurrentRoom().getName());
		//System.out.println(gameGui.getCurrentRoom());
	}
	
	
}
