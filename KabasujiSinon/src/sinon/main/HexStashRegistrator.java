package sinon.main;

import java.util.Objects;
import java.util.function.Function;

import sinon.controllers.AbstractHexStashController;
import sinon.controllers.HexominoBankController;
import sinon.controllers.HexominoBullpenController;
import sinon.models.Level;
import sinon.views.HexominoBullpenView;
import sinon.views.MainView;

/**
 * Assigns HexominoControllers to Hexominos in the Bullpen and Bank.
 * 
 * Since the BullpenView and the BankView have a dynamically changing number of
 * controllers, they will each have a HexStashRegistrator which they can use to
 * assign controllers to it.
 * 
 * To create an instance of this class, you can use one of the two public static
 * fields {@link #BANK_CONTROLLER} or {@link #BULLPEN_CONTROLLER}. These are the
 * default controllers for the Bank and Bullpen Hexominos.
 * 
 * @author Josh Desmond
 */
public class HexStashRegistrator {

	/** Function which is used for BankView registration. */
	public static final Function<NewControllerParameter, AbstractHexStashController> BANK_CONTROLLER = (
			NewControllerParameter c) -> (new HexominoBankController(c.level,
					c.mainView, c.hex));

			/** Function which is used for BullpenView registration. */
			public static final Function<NewControllerParameter, AbstractHexStashController> BULLPEN_CONTROLLER = (
					NewControllerParameter c) -> (new HexominoBullpenController(
							c.level, c.mainView, c.hex));

					/** Model which is associated with the controllers which are to be built. */
					Level level;
					/** View which is associated with the controllers which are to be built */
					MainView mainView;
					/** A function which is used in this class to register a controller. */
					Function<NewControllerParameter, AbstractHexStashController> controller;

					/**
					 * Creates a new HexStashRegistrator.
					 * 
					 * @param level
					 *            Model which is associated with the controllers which are to be
					 *            built.
					 * @param mainView
					 *            View which is associated with the controllers which are to be
					 *            built.
					 * @param controllerCreater
					 *            A function which is used in this class to register a
					 *            controller.
					 */
					public HexStashRegistrator(
							Level level,
							MainView mainView,
							Function<NewControllerParameter, AbstractHexStashController> controllerCreater) {
						this.level = Objects.requireNonNull(level);
						this.mainView = Objects.requireNonNull(mainView);
						this.controller = Objects.requireNonNull(controllerCreater);
					}

					/**
					 * Registers a Hexomino using this classes
					 * 
					 * @param hex
					 */
					public void registerHexominoView(HexominoBullpenView hex) {
						assert hex != null;
						assert level != null;
						assert mainView != null;
						NewControllerParameter c = new NewControllerParameter(level, mainView,
								hex);
						hex.addMouseListener(controller.apply(c));
						assert hex.getMouseListeners()[0] != null;
						System.out.println("Registration attempt");
						System.out.println(hex.getHexomino());
					}

					class NewControllerParameter {

						public NewControllerParameter(Level level, MainView mainView,
								HexominoBullpenView hex) {
							this.level = level;
							this.mainView = mainView;
							this.hex = hex;
						}

						public Level level;
						public HexominoBullpenView hex;
						public MainView mainView;

					}
}