GROUP: SINON - SOFTWARE ENGINEERING - D TERM 2016 - HEINEMAN - FINAL IMPLEMENTATION SUBMISSION

BUILD ANY FILES IF NECESSARY

STARTING THE GAME:
- Navigate to KabasujiSinon > src > sinon.main
- Run Game.java as Java Application
- Game will start

STARTING THE LEVEL BUILDER:
- Navigate to KabasujiSinon > src > sinon.main
- Run Builder.java as Java Application
- Level Builder will start


*************************************************************
*****IMPORTANT : HOW OUR LEVELS ARE LOADED INTO THE GAME*****
*************************************************************

Our level files are stored in this project's directory. 
If you look through the file structure, you will see 15 "level#.dat" files. 
If you wish to add a new level to the game, you must overwrite these files with
the exact same name. 

For example, if you wanted to create a new level and have the Game
load it as level #1, create the level in the Builder, navigate to this
project's directory, and save it as "level1.dat".
	
	
***********************************************************
********************GENERAL INFORMATION********************
***********************************************************

Our Kabasuji DOES NOT use dragging of any sort.

- Select a hexomino in the bullpen/board/bank by clicking on it. The selected hexomino will show a cyan border.
	- When hovering on the board, a "shadow" of the selected hexomino will appear showing where it will appear on placement.
- Deselect a hexomino in the bullpen by clicking on it again, or by clicking on a different hexomino.

	
	
***********************************************************
********************HOW TO USE THE GAME********************
***********************************************************

	SELECTING A LEVEL & STARTING A LEVEL
		- Levels that are unlocked are displayed in blue and enabled.
		- Levels that are locked are displayed in black and disabled.
		
	ALL LEVEL TYPE INFORMATION:
		- Select a hexomino in the bullpen by clicking on it.
		- Deselect a hexomino in the bullpen by clicking on it again, or by clicking on a different hexomino.
		
		- Puzzle levels will return the player to the Level Select screen if they run out of moves.
		- Lightning levels will return the player to the Level Select screen if they run out of moves.
		
		- Exit a level by clicking the "Exit Level" button on the top right corner. 
		  	This button also saves any earned stars for that level.
		
		- Stars earned while playing a level will be shown on the upper right corner below the "Exit Level" button
		- Highest recorded stars for each level will be displayed directly above each levels button.
		
		BULLPEN TO BOARD MOVEMENT:
			- Select a hexomino in the bullpen
			- Click on the tile you wish to place the hexomino on.
			
		BOARD TO BOARD MOVEMENT:
			- Select a hexomino on the board.
			- Click on the tile you wish to place the hexomino on.
			
		BOARD TO BULLPEN MOVEMENT:
			- Select a hexomino on the board.
			- Click anywhere on the bullpen.
		
********************************				
*****HOW TO USE THE BUILDER*****
********************************

	LEVEL FILE OPERATIONS:
		- To create a new level:
			File > New > (Select Type)
			This will create everything needed to construct the selected level type.
		
		- To open an existing level:
			File > Open
			Navigate through your directory to select the level file you wish to open
			The builder will reconstruct all information from that saved level.
			
		- To Save a level As a new file
			File > Save As
			Navigate through your directory to select a destination for your level file.
			Enter a file name if necessary and click save.
			Your level file will now be written to disk.
			
		- To Save a level for an existing file
			File > Save
			Your level will be saved to the currently known file immediately.
			
	UNDO/REDO OPERATIONS:
		- To Undo:
			File > Undo
			
		- To Redo:
			File > Redo
			
	ADDING HEXOMINOS TO THE BULLPEN:
		- Clicking ANY hexomino in the Bank (on the right side of the builder)
			will put it in the bullpen
		
	REMOVING HEXOMINOS FROM THE BULLPEN:
	 	- Select a hexomino in the bullpen and click anywhere on the bank.
	 	
	ADDING RELEASE NUMBERS:
	    - Click on any of the numbers to select it,
	    	Click on the tile you wish to place the number on.
	   
	DELETING RELEASE NUMBERS:
		- Click on the tile that contains the release number to remove it.
			
	ENABLING/DISABLING BOARD TILES:
		- RIGHT click on the tile you wish to enable/disable.
	
	CREATING HINTS:
		- Place a hexomino on the board
		- RIGHT click the hexomino you wish to create a hint from.
		
	DELETING HINTS:
		- RIGHT click on the hint you wish to delete.
			
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		