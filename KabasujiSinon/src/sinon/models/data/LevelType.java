package sinon.models.data;

import java.io.Serializable;

/** Enum representing three types of levels. */
public class LevelType implements Serializable{

	private static final long serialVersionUID = 3520586132922947808L;

	public enum types {
        PUZZLE, LIGHTNING, RELEASE
    }
}
