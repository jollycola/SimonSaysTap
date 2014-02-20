package com.hatestone.simonsays;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputListener;
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
	public static Stage stage;
	public static TextureAtlas buttonAtlas;
	public static TextButtonStyle buttonStyle;
	public static TextButton button;
	public static Skin skin;

	
	public static void initialize(){
		points = new int[2];
		tapped = false;
		firstPressFreeze = false;
		firstPress = 0;
		winner = 0;
		looser = 0;
		points[0] = 0;
		points[1] = 0;
		getRandom();
		countdownClosed = true;
		action = false;
		countdownGo = false;
	}
	
	public static void getRandom(){
		Random r = new Random();
		randomTime = r.nextInt(5) + r.nextFloat();
	}
	public static void getType(){
		Random r = new Random();
		type = r.nextInt(2)+1;
	}
	
	public static void button(){
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		
		skin = new Skin();
		buttonAtlas = new TextureAtlas("buttons/button.pack");
		skin.addRegions(buttonAtlas);
		buttonStyle = new TextButtonStyle();
		buttonStyle.up = skin.getDrawable("button");
		buttonStyle.down =  skin.getDrawable("button_pressed");
		buttonStyle.font = Assets.font_button;
		button = new TextButton("START GAME", buttonStyle);
		Gdx.input.setInputProcessor(stage);

	}
	
}
