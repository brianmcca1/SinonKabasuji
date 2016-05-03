package sinon.models;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import sinon.models.data.BoardData;
import sinon.views.Observer;

/**
 * Entity Class which represents the 12x12 area of game play.
 *
 * @author Josh Desmond
 * @author Brian
 **/
public class Board implements Observable {

	/** The list of observers which are watching for updates on the board */
	List<Observer> observers;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Board [tilesViaPoints=" + tilesViaPoints + ", hexominoLocations=" + hexominoLocations + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hexominoLocations == null) ? 0 : hexominoLocations.hashCode());
		result = prime * result + ((tilesViaPoints == null) ? 0 : tilesViaPoints.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (hexominoLocations == null) {
			if (other.hexominoLocations != null)
				return false;
		} else if (!hexominoLocations.equals(other.hexominoLocations))
			return false;
		if (tilesViaPoints == null) {
			if (other.tilesViaPoints != null)
				return false;
		} else if (!tilesViaPoints.equals(other.tilesViaPoints))
			return false;
		return true;
	}

	private final static int WIDTH = 12;
	private final static int HEIGHT = 12;
	private final static int WIDTH_BY_ZERO = WIDTH - 1;
	private final static int HEIGHT_BY_ZERO = HEIGHT - 1;

	Map<Point, Tile> tilesViaPoints;
	/** Maps every Hexomino to the tile of its anchor location. */
	Map<Hexomino, Point> hexominoLocations;

	List<Hint> hints;

	/**
	 * Creates a 12 by 12 Board with tiles initialized to all playable tiles.
	 */
	public Board() {
		hexominoLocations = new HashMap<Hexomino, Point>();
		tilesViaPoints = new HashMap<Point, Tile>();
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				Point p = new Point(x, y);
				initializeTiles(p, true);
			}
		}
		this.hints = new LinkedList<Hint>();
		initializeObserverList();
	}

	/**
	 * Creates a 12 by 12 Board with playability set to match the given
	 * BoardData.
	 * 
	 * @param boardData
	 *            BoardData specifying which tiles are playable.
	 */
	public Board(BoardData boardData) {
		hexominoLocations = new HashMap<Hexomino, Point>();
		tilesViaPoints = new HashMap<Point, Tile>();
		for (int x = 0; x < WIDTH; x++) {
			for (int y = 0; y < HEIGHT; y++) {
				boolean playable = boardData.getPlayableArray()[x][y];
				Point p = new Point(x, y);
				initializeTiles(p, playable);
			}
		}
		initializeObserverList();
		this.hints = boardData.getHints();
		update();
	}

	/**
	 * Initialize the tile at a given point
	 * 
	 * @param p
	 *            The point the tile is at
	 * @param playable
	 *            Whether the tile is playable or not
	 */
	protected void initializeTiles(Point p, boolean playable) {
		tilesViaPoints.put(p, new Tile(p, playable));
	}

	/** Every constructor should call this */
	private void initializeObserverList() {
		assert observers == null; // Why would you call this again?
		observers = new LinkedList<Observer>();
	}

	/**
	 * Determines if there is a hexomino at the given position.
	 * 
	 * @param row
	 * @param column
	 * @return True if there is a hexomino on this tile
	 */
	public boolean hasHex(int row, int column) {
		return getTile(row, column).hasHex();
	}

	/**
	 * Determines whether it's possible to add a Hexomino at the given location.
	 * 
	 * @param anchorLocation
	 *            Location of where the anchor of the hexomino will go.
	 * @param hex
	 *            The Hexomino to be added
	 * @return True if the move if possible, false otherwise.
	 */
	public boolean canAddHexomino(Point anchorLocation, Hexomino hex) {
		boolean canAdd = true;
		HexominoNumberSet hexominoNumberSet = hex.getHexominoNumberSet();
		for (Point p : hexominoNumberSet.getPoints()) {
			Point pointToCheck = new Point(anchorLocation.x + p.x, anchorLocation.y + p.y);
			if (!(this.isInBounds(pointToCheck.x, pointToCheck.y))) {
				return false;
			}
			if (!tilesViaPoints.get(pointToCheck).canAddHex(hex)) {
				canAdd = false;
			}
		}

		return canAdd;
	}

	/**
	 * Retrieves the position where a hexomino is placed.
	 * 
	 * @param hex
	 *            Hexomino to be found.
	 * @return The Point p where the anchor of tile is located.
	 */
	public Point getHexominoLocation(Hexomino hex) {
		return hexominoLocations.get(hex);
	}

	/**
	 * Adds the given Hexomino to the board. Must be a valid move.
	 * 
	 * @param anchorLocation
	 *            Location of where the anchor of the hexomino will go.
	 * @param hex
	 *            The Hexomino to be added
	 * 
	 */
	public void addHexomino(Point anchorLocation, Hexomino hex) {
		if (!canAddHexomino(anchorLocation, hex))
			throw new IllegalArgumentException();
		HexominoNumberSet hexominoNumberSet = hex.getHexominoNumberSet();

		hexominoLocations.put(hex, anchorLocation.getLocation());

		for (Point p : hexominoNumberSet.getPoints()) {
			Point pointToAdd = new Point(anchorLocation.x + p.x, anchorLocation.y + p.y);
			if (tilesViaPoints.get(pointToAdd).canAddHex(hex) & isInBounds(pointToAdd.x, pointToAdd.y)) {
				tilesViaPoints.get(pointToAdd).addHexomino(hex);
			}
		}

		update();
	}

	/**
	 * Completely removes the specified Hexomino from the board.
	 * 
	 * Note that this removes the Hexomino only if it is the exact same
	 * instance. If the Hexomino given is .equals() but not ==, it doesn't
	 * matter, it won't be removed.
	 */
	public void removeHexomino(Hexomino hex) {
		for (Tile t : getTiles()) {
			if (t.getHexomino().isPresent()) {
				if (t.getHexomino().get().getID().equals(hex.getID())) {
					t.removeHex();
				}
			}
		}

		hexominoLocations.remove(hex);
		update();
	}

	/**
	 * Gets the Tile at the specified position
	 * 
	 * @param row
	 * @param column
	 * @return The Tile found.
	 */
	public Tile getTile(int row, int column) {
		return getTile(new Point(row, column));
	}

	/**
	 * Gets the Tile at the specified position
	 * 
	 * @param p
	 *            Point to get tile at.
	 * @return The Tile found.
	 */
	public Tile getTile(Point p) {
		return tilesViaPoints.get(p);
	}

	/**
	 * Returns whether given row and column are in bounds in the existing game
	 * region. I.E. if the given row and column are outside of the 12 by 12
	 * grid, this will return false.
	 * 
	 * Note this has nothing to do with whether a tile is playable or not.
	 * 
	 * @param row
	 * @param column
	 * @return True if the location is in bounds
	 */
	public boolean isInBounds(int row, int column) {
		if (row > HEIGHT_BY_ZERO || column > WIDTH_BY_ZERO) {
			return false;
		} else if (row < 0 || column < 0) {
			return false;
		} else
			return true;
	}

	/**
	 * Gets a iterable of all the tiles.
	 * 
	 * You can use this any time you want to do some kind of operation on all of
	 * the tiles. Please be careful and don't actually edit the tiles with a
	 * controller or something unless it's really needed.
	 * 
	 * Note that these tiles are not in order if you use this method.
	 * 
	 * @return An iterable of all of the tiles.
	 */
	public Iterable<Tile> getTiles() {
		LinkedList<Tile> tempList = new LinkedList<Tile>();
		tilesViaPoints.forEach((k, v) -> tempList.add(v));
		return tempList;
	}

	/**
	 * Determines if this board has the hexomino hex played on it
	 * 
	 * @param hex
	 *            the hex to be looked for
	 * @return True if hex is found, otherwise false
	 */
	public boolean hasHex(Hexomino hex) {
		return this.containsHexID(hex.getID());
	}

	/**
	 * See if the Board contains a Hexomino with the given ID
	 * 
	 * @param id
	 *            The ID to check
	 * @return True if the board contains the Hexomino, False otherwise
	 */
	public boolean containsHexID(UUID id) {

		for (Tile t : this.getTiles()) {
			if (t.hasHex()) {
				if (t.getHexomino().get().getID().equals(id)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Sets a rectangle of tiles, with the given corners, to unplayable
	 * 
	 * @param topLeft
	 *            The top left corner
	 * @param bottomRight
	 *            The bottom right corner
	 */
	public void setUnplayableRectangle(Point topLeft, Point bottomRight) {

		for (int i = topLeft.x; i < bottomRight.x; i++) {

			for (int j = topLeft.y; j < bottomRight.y; j++) {
				this.getTile(i, j).setPlayable(false);
			}

		}
	}

	/**
	 * Adds a hint to the list of hints.
	 * 
	 * @param hint
	 *            The hint to add
	 */
	public void addHint(Hint hint) {
		this.hints.add(hint);
		update();
	}

	/**
	 * Remove a hint from the list of hints
	 * 
	 * @param hint
	 *            The hint to remove
	 */
	public void removeHint(Hint hint) {
		this.hints.remove(hint);
		update();
	}

	/**
	 * Get the list of hints
	 * 
	 * @return the list of hints
	 */
	public List<Hint> getHints() {
		return this.hints;
	}

	/**
	 * Get the list of points for a HexominoNumberSet placed at a specific point
	 * 
	 * @param anchor
	 *            The anchor point that the Number set is placed at
	 * @param numSet
	 *            The HexominoNumberSet being placed
	 * @return The list of points
	 */
	public List<Point> getPoints(Point anchor, HexominoNumberSet numSet) {
		List<Point> returnPoints = new LinkedList<Point>();

		for (Point p : numSet.getPoints()) {
			returnPoints.add(new Point(anchor.x + p.x, anchor.y + p.y));
		}

		return returnPoints;
	}

	@Override
	public void registerObserver(Observer observer) {
		this.observers.add(observer);
		update();
	}

	@Override
	public void update() {
		for (Observer o : observers) {
			o.updated();
		}
	}

}
