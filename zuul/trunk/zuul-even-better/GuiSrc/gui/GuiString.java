package gui;

import java.util.Observable;

//kein runnable mehr
public class GuiString extends Observable implements Runnable{

	String test;
	public GuiString(){
		test="";
	}
	
	public void guiNewCommand(String textout){
		setChanged();
		notifyObservers(textout);
	}
	//methode unötig
	@Override
	public void run() {
		while(true){
			test="geh osten";
			noty();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test="geh westen";
			noty();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	//aufrufen wenn neues kommando eingetragen wird
	void noty(){
	setChanged();
	notifyObservers(test);
	}
}
