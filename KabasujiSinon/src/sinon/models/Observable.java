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
	 * @param observer The observer to register to this Observable.
	 */
	public void registerObserver(Observer observer);

	/** Notify all observers that it updated. */
	public void update();
}
