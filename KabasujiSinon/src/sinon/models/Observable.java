package sinon.models;

import sinon.views.Observer;

/**
 * Observable objects, to be observed by Observer objects.
 * 
 * @author Brian
 *
 */
public interface Observable {

	/**
	 * Registers this observer.
	 * 
	 * @param observer.
	 */
	public void registerObserver(Observer observer);

	/** Notify all observers that it updated. */
	public void update();
}
