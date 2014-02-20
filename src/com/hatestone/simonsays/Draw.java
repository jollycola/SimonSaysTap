package com.hatestone.simonsays;

public class Draw {
	
	public static void countdown(){
		switch(Vars.countdownNumbers){
		case 3: Assets.font.draw(GameScreen.batch, "3", 540 - Assets.font.getBounds("3").width/2, 960+120-Assets.font.getBounds("3").height/2);
				break;
		case 2: Assets.font.draw(GameScreen.batch, "2", 540 - Assets.font.getBounds("2").width/2, 960+120-Assets.font.getBounds("2").height/2);
				break;
		case 1: Assets.font.draw(GameScreen.batch, "1", 540 - Assets.font.getBounds("1").width/2, 960+120-Assets.font.getBounds("1").height/2);
				break;
		}
		
	}
	
}
