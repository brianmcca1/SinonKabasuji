package sinon.views;

/**
 * Observer objects, to observe the Observable objects.
 * 
 * @author Brian
 *
 */
public interface Observer {

	/** Tells the observer to repaint everything its observing. */
	public void updated();

}
