package sinon.serial;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import sinon.models.Hexomino;

public class Serializer {

	/**
	 * This method is temporary to serialize some hexominoes to a binary file 
	 * That file will then be read by the Deserializer and will return Hexomino models
	 * Which will then be applied to views, and the views will be added to the BankView
	 * (controller registry isnt important for this)
	 * @param args
	 */
	public static void main(String args[]){
		ArrayList<Hexomino> hexominoesToSerialize = new ArrayList<Hexomino>(35);
		
		hexominoesToSerialize.add(new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
		hexominoesToSerialize.add(new Hexomino(0, 0, 1, 0, 0, 1, 0, 2, 0, 3, 0, 4));
		hexominoesToSerialize.add(new Hexomino(0, 0, 0, 1, 1, 1, 0, 2, 0, 3, 0, 4));
		hexominoesToSerialize.add(new Hexomino());
		hexominoesToSerialize.add(new Hexomino());
		hexominoesToSerialize.add(new Hexomino());
		hexominoesToSerialize.add(new Hexomino());
		
		try{
			FileOutputStream fout = new FileOutputStream("hexominoes.hex");
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(hexominoesToSerialize);
			oos.close();
			System.out.println("ARRAYLIST OF HEXOMINOES HAS BEEN SERIALIZED TO 'hexominoes.hex'");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
