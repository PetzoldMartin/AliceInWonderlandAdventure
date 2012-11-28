package de.fh_zwickau.oose.zuul;

import java.util.ArrayList;


public class TextOut {

	ArrayList<String>ausgaben;
	String textZeile;
	public TextOut(){
	ausgaben=new ArrayList<String>();
	textZeile="";
	}
	
	
	public void ausgabe()
	{
		String newEntry = null;
		ausgaben.add(textZeile);
		for (int j = 0; j < ausgaben.size(); j++){
			if(ausgaben.get(j)!=">"){
			System.out.println(ausgaben.get(j));} // NOPMD by Aismael on 27.11.12 15:07
			else{
				newEntry = ausgaben.get(j);// NOPMD by Aismael on 27.11.12 15:07
			}
			
		}
		if(newEntry!=null){
		System.out.print(newEntry);}
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
	

	


}
