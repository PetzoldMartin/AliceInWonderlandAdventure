package gameObserver;

import gui.GameGui;

import java.util.Observable;
import java.util.Observer;

import zuulCore.Game;
import zuulCore.Player;

public class GameListener implements Observer {
	
	private GameGui gameGui;

	public GameListener(GameGui gameGui) {
		this.gameGui=gameGui;
	}

	@Override
	public void update(Observable o, Object arg) {
		gameGui.setCurrentRoom(((Player) arg).getCurrentRoom().getName());
		//System.out.println(gameGui.getCurrentRoom());
	}
	
	
}
