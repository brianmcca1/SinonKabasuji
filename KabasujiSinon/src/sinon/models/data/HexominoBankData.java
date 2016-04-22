package sinon.models.data;

import java.util.ArrayList;
import java.util.List;

import sinon.models.Hexomino;

/**
 * This is the master class which is in charge of getting all 35 of the default
 * Hexominos.
 * 
 * The only method of interest is {@link #getHexmonios()}, which returns a list
 * of all the Hexominos.
 * 
 * @author Josh Desmond
 */
public class HexominoBankData {

    /**
     * Reads from disk all of the stored Hexominos and builds Hexomino Objects
     * for use when populating the BankView or other things.
     * 
     * @return List of all Hexominos.
     */
    public static List<Hexomino> getHexominos() {
        return createHexominos();
    }

    // FIXME
    private static List<Hexomino> createHexominos() {
        ArrayList<Hexomino> hexList = new ArrayList<Hexomino>();
        hexList.add(new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5));
        hexList.add(new Hexomino(0, 0, 1, 0, 0, 1, 0, 2, 0, 3, 0, 4));
        hexList.add(new Hexomino(0, 0, 0, 1, 1, 1, 0, 2, 0, 3, 0, 4));
        hexList.add(new Hexomino(0, 0, 0, 1, 0, 2, 1, 2, 0, 3, 0, 4));
        hexList.add(new Hexomino(0, 0, 0, 1, -1, 1, -1, 2, -1, 3, -1, 4));
        hexList.add(new Hexomino(0, 0, 0, 1, 1, 0, 1, 1, 0, 2, 0, 3));
        hexList.add(new Hexomino(0, 0, 1, 0, 0, 1, 0, 2, 1, 2, 0, 3));
        hexList.add(new Hexomino(0, 0, 1, 0, 0, 1, 0, 2, 0, 3, 1, 3));
        hexList.add(new Hexomino(0, 0, 0, 1, 1, 1, 0, 2, 1, 2, 0, 3));
        //9 done
        hexList.add(new Hexomino(0, 0, 0, 1, 0, 2, 0, 3, 1, 0, 2, 0));
        hexList.add(new Hexomino(0, 0, 0, 1, 1, 1, 2, 1, 0, 2, 0, 3));
        //11
        hexList.add(new Hexomino(0, 0, 1, 0, 2, 0, 1, 1, 1, 2, 1, 3));
        hexList.add(new Hexomino(0, 0, 1, 0, 0, 1, -1, 1, 0, 2, 0, 3));
        //13
        hexList.add(new Hexomino(0, 0, 1, 0, 0, 1, 0, 2, -1, 2, 0, 3));
        hexList.add(new Hexomino(0, 0, 1, 0, 0, 1, 0, 2, 0, 3, -1, 3));
        //15
        hexList.add(new Hexomino(0, 0, 0, 1, 1, 1, 0, 2, -1, 2, 0, 3));
        hexList.add(new Hexomino(0, 0, 0, 1, 1, 1, -1, 1, 0, 2, 0, 3));
        //17
        hexList.add(new Hexomino(0, 0, 1, 0, 1, -1, 2, 0, 0, 1, 0, 2));
        hexList.add(new Hexomino(0, 0, 1, 0, 1, -1, 0, 1, 0, 2, 1, 2));
        //19
        hexList.add(new Hexomino(0, 0, 0, 1, 0, 2, -1, 2, -1, 3, -1, 4));
        hexList.add(new Hexomino(0, 0, 1, 0, 1, -1, 0, 1, 1, 1, 0, 2));
        //21
        hexList.add(new Hexomino(0, 0, 0, 1, 0, 2, 1, 0, 1, 1, 1, 2));
        hexList.add(new Hexomino(0, 0, 1, 0, 2, 0, 2, -1, 1, 1, 1, 2));
        //23
        hexList.add(new Hexomino(0, 0, 1, 0, 2, 0, 1, 1, 2, 1, 1, 2));
        hexList.add(new Hexomino(0, 0, 1, 0, 1, -1, 0, 1, -1, 1, 0, 2));
        //25
        hexList.add(new Hexomino(0, 0, 1, 0,  2,  0,  2, -1,  0, 1,  0, 2));
        hexList.add(new Hexomino(0, 0, 1, 0,  1, -1,  2, -1,  0, 1,  0, 2));
        //27
        hexList.add(new Hexomino(0, 0, 1, 0,  2,  0,  2,  1,  0, 1,  0, 2));
        hexList.add(new Hexomino(0, 0, 2, 0,  0,  1,  1,  1,  2, 1,  0, 2));
        //29
        hexList.add(new Hexomino(0, 0, 1, 0,  0,  1,  0,  2, -1, 2,  -1, 3));
        hexList.add(new Hexomino(0, 0, 0, 1,  1,  1,  1,  2,  2, 1,  0, 2));
        //31
        hexList.add(new Hexomino(0, 0, 0, 1,  1,  1,  0,  2,  1, 2,  2, 2));
        hexList.add(new Hexomino(0, 0, 1, 0,  1, -1,  2,  0,  0, 1,  1, 1));
        //33
        hexList.add(new Hexomino(0, 0, 1, 0,  2,  0,  2, -1,  0, 1,  1, 1));
        hexList.add(new Hexomino(0, 0, 0, 1, -1,  1, -1,  2, -2, 2, -2, 3));
        //35


        
        return hexList;
    }

}
