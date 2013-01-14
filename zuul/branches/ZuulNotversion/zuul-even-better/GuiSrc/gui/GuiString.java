package gui;

import java.util.Observable;

//kein runnable mehr
public class GuiString extends Observable {

	String test;
	public GuiString(){
		test="";
	}
	
	
	
	//aufrufen wenn neues kommando eingetragen wird
	void noty(){
	setChanged();
	notifyObservers(test);
	}
}
