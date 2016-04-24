package sinon.controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import sinon.main.Builder;
import sinon.models.Level;
import sinon.views.TileView;

public class BuilderTileController implements MouseListener{

	private Builder builder;
	
	private Level level;
	
	private TileView tileView; 

	public BuilderTileController(Builder b, TileView t, Level l){
		this.builder = b;
		this.tileView = t;
		this.level = l;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
			
		if(SwingUtilities.isRightMouseButton(e)){
			System.out.println("I AM A TILEVIEW AND I WAS JUST RIGHT CLICKED ON");
			int row = tileView.getRow();
			int column = tileView.getColumn();
			
			tileView.toggleColor();
			System.out.println("PLAYABLE BEFORE: " + tileView.getTile().isPlayable());
			tileView.getTile().togglePlayable();
			System.out.println("PLAYABLE AFTER: " + tileView.getTile().isPlayable());
		}
		else{
			System.out.println("I AM A TILEVIEW AND I WAS JUST LEFT CLICKED ON");
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

}
