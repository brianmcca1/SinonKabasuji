package sinon.serial;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import sinon.models.Hexomino;

public class Deserializer {
	
	public Deserializer(){}

//	public static void main(String args[]){
//		ArrayList<Hexomino> hexominoesReadFromFile;
// 		
//	    try{
//	    	FileInputStream fin = new FileInputStream("hexominoes.hex");
//	    	ObjectInputStream ois = new ObjectInputStream(fin);
//	    	hexominoesReadFromFile = (ArrayList<Hexomino>) ois.readObject();
//	    	ois.close();
//		   
//	    	//print out what we got from the list
//	    	String temp = "";
//	    	for(int i = 0; i < hexominoesReadFromFile.size(); i++){
//	    		temp = hexominoesReadFromFile.get(i).toString();
//	    		System.out.println(temp);
//	    	}
//	    	
//	    	
//	    }catch(Exception ex){
//	    	ex.printStackTrace();
//	    } 
//	}
	
	public ArrayList<Hexomino> deserializeHexominoesForBankView(){
		ArrayList<Hexomino> hexominoesReadFromFile = new ArrayList<Hexomino>();
 		
	    try{
	    	FileInputStream fin = new FileInputStream("hexominoes.hex");
	    	ObjectInputStream ois = new ObjectInputStream(fin);
	    	hexominoesReadFromFile = (ArrayList<Hexomino>) ois.readObject();
	    	ois.close();
		   
	    	//print out what we got from the list
	    	String temp = "";
	    	for(int i = 0; i < hexominoesReadFromFile.size(); i++){
	    		temp = hexominoesReadFromFile.get(i).toString();
	    		System.out.println(temp);
	    	}
	    }catch(Exception ex){
	    	ex.printStackTrace();
	    } 
	    
	    return hexominoesReadFromFile;
	}
	
}
