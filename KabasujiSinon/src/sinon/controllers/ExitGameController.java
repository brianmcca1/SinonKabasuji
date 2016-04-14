package sinon.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import sinon.main.Game;
import sinon.views.game.LevelSelectView;

public class ExitGameController implements ActionListener {

    Game game;
    JPanel mainView;

    public ExitGameController(Game game, JPanel mainView) {
        this.game = game;
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.startNextPanel(mainView, new LevelSelectView(game));
    }

}
