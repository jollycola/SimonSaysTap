package com.hatestone.simonsays;

import com.badlogic.gdx.Game;

public class SimonSays extends Game{

	public static GameScreen game_screen;
	public static TitleScreen title_screen;

	@Override
	public void create() {
		Assets.load();
		Vars.initialize();
		Vars.getRandom();
		Vars.getType();
		
		game_screen = new GameScreen(this);
		title_screen = new TitleScreen(this);
		
		setScreen(title_screen);		
	}
	
}
