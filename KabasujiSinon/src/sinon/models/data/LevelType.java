package sinon.models.data;

import java.io.Serializable;

/** Enum representing three types of levels. */
public class LevelType implements Serializable{

	private static final long serialVersionUID = 3520586132922947808L;

	/**
	 * The types of Kabasuji levels.
	 * @author PDeBrine.
	 */
	public enum Types {
        /**
         * A level with a limited amount of moves.
         */
        PUZZLE, 
        
        
        /**
         * A level with a limited amount of time.
         */
        LIGHTNING,
        
        
        /**
         * A level with targets to be covered.
         */
        RELEASE
    }
}
