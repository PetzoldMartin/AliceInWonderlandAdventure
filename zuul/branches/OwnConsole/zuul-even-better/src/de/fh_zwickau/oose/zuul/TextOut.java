package de.fh_zwickau.oose.zuul;

import java.util.ArrayList;


public class TextOut extends Thread implements Runnable{

	ArrayList<String>ausgaben;
	String textZeile;
	public TextOut(){
	ausgaben=new ArrayList<String>();
	textZeile="";
	}
	
	
	public void ausgabe()
	{
		ausgaben.add(textZeile);
		for (int j = 0; j < ausgaben.size(); j++){
			System.out.println(ausgaben.get(j));
		}
		ausgaben.clear();
		textZeile="";
		
	}
	public void lineEntry(String line){
		ausgaben.add(line);
	}
	public void lineEntry(){
		ausgaben.add("");
	}
	public void entry(String lineComp){
		textZeile=textZeile+lineComp;
	}
	
	public void run(){
		while(true){
		this.ausgabe();
		
		}
	}


}
