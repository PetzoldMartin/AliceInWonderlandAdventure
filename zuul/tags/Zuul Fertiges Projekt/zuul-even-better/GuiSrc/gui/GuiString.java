package gui;

import java.util.Observable;


/**
 * Klasse die den Outputstring der Gui beinhaltet
 * @author Martin Petzold
 *
 */
public class GuiString extends Observable {
/**
 * Outputstring der gui
 */
	String Output;
	
	
	public void setOutput(String output) {
		Output = output;
	}



	public String getOutput() {
		return Output;
	}



	public GuiString(){
		Output="";
	}
	
	
	
	//aufrufen wenn neues kommando eingetragen wird
	void noty(){
	setChanged();
	notifyObservers(Output);
	//System.out.println(Output);
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
