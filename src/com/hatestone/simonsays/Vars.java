package com.hatestone.simonsays;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;


public class Vars {
	
	public static int firstPress;
	public static boolean firstPressFreeze;
	public static boolean tapped;
	public static boolean open;
	public static int winner;
	public static int looser;
	public static int[] points;
	public static float randomTime;
	public static int type;
	public static int text;
	public static int countdownNumbers;
	public static boolean countdownClosed;
	public static boolean action;
	public static boolean countdownGo;
	public static boolean nextRound;
	
	public static void initialize(){
		points = new int[2];
		tapped = false;
		firstPressFreeze = false;
		firstPress = 0;
		winner = 3;
		looser = 3;
		points[0] = 0;
		points[1] = 0;
		getRandom();
		countdownClosed = true;
		action = false;
		countdownGo = false;
		nextRound = false;
	}
	
	public static void nextRound(){
		tapped = false;
		firstPressFreeze = false;
		firstPress = 3;
		winner = 3;
		looser = 3;
		getRandom();
		Vars.getType();
		countdownClosed = false;
		nextRound = false;
		countdownNumbers = 0;
		action = false;
		text = 0;
	}
	
	public static void getRandom(){
		Random r = new Random();
		randomTime = r.nextInt(5) + r.nextFloat();
	}
	public static void getType(){
		Random r = new Random();
		type = r.nextInt(2)+1;
	}
	
	
	public static void pauseWhileWaiting(){
		countdownClosed = true;
		action = false;
	}
}
