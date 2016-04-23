package sinon.views.builder;

import sinon.main.HexominoBankControllerFactory;

/**
 * Encapsulates the shared behaviors of the BankView and BullpenView
 * 
 * @author Josh Desmond
 */
public interface HexominoContainerView {

    /**
     * Registers the contents of a BullpenView or BankView using the given
     * object.
     * 
     * @param hexominoBankControllerFactory
     *            Factory which is used to add the controller to the
     *            hexominoViews.
     */
    public void registerControllers(
            HexominoBankControllerFactory hexominoBankControllerFactory);

}
