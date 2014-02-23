package com.hatestone.simonsays;

public class Draw {
	
	public static void countdown(){
		switch(Vars.countdownNumbers){
		case 3: Assets.font.draw(GameScreen.batch, "3", 540 - Assets.font.getBounds("3").width/2, 960+120-Assets.font.getBounds("3").height/2);
				Assets.ffont.draw(GameScreen.batch, "3", 540 - Assets.ffont.getBounds("3").width/2, 960-120-Assets.ffont.getBounds("3").height/2);
				break;
		case 2: Assets.font.draw(GameScreen.batch, "2", 540 - Assets.font.getBounds("2").width/2, 960+120-Assets.font.getBounds("2").height/2);
				Assets.ffont.draw(GameScreen.batch, "2", 540 - Assets.ffont.getBounds("2").width/2, 960-120-Assets.ffont.getBounds("2").height/2);
				break;
		case 1: Assets.font.draw(GameScreen.batch, "1", 540 - Assets.font.getBounds("1").width/2, 960+120-Assets.font.getBounds("1").height/2);
				Assets.ffont.draw(GameScreen.batch, "1", 540 - Assets.ffont.getBounds("1").width/2, 960-120-Assets.ffont.getBounds("1").height/2);
				break;
		}
		
	}
	
	public static void player(int index, int x, int y){
		if(Vars.winner == 3){
			GameScreen.batch.draw(Assets.spr_player[index], x, y);
		}
		else if(Vars.winner == index){
			GameScreen.batch.draw(Assets.spr_player_green[index], x, y);
		}
		else if(Vars.looser == index){
			GameScreen.batch.draw(Assets.spr_player_red[index], x, y);
		}
	}
	
}
