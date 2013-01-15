package gui;

import java.util.Observable;

//kein runnable mehr
public class GuiString extends Observable {

	String Output;
	public GuiString(){
		Output="";
	}
	
	
	
	//aufrufen wenn neues kommando eingetragen wird
	void noty(){
	setChanged();
	notifyObservers(Output);
	System.out.println(Output);
	}
	
	
	public void setString(String string){
		Output=Output+" "+string;
	}
	
    public void setStringAndSend(String string){
    	Output=string+" "+Output;
    	noty();
    	Output="";
	}
    
    public boolean hasInsert(){
    	if(Output==""){
    	return false;
    	}
    	else{
    		return true;
    	}
    }
	
	
}
