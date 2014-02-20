package com.hatestone.simonsays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Assets {
	//FONT
	public static BitmapFont font;
	public static BitmapFont ffont;
	public static BitmapFont scoreFont;
	public static BitmapFont fscoreFont;
	public static BitmapFont font_small;
	//BACKGROUND
	public static Texture texture_bg;
	public static Sprite spr_bg;
	//PLAYER1
	public static Texture texture_player1;
	public static Sprite spr_player1;
	public static Sprite spr_player1_red;
	public static Sprite spr_player1_green;
	//PLAYER2
	public static Texture texture_player2;
	public static Sprite spr_player2;
	public static Sprite spr_player2_red;
	public static Sprite spr_player2_green;
	//STARTBUTTON
	public static Texture texture_startbutton;
	public static Sprite spr_startbutton;
	public static Texture texture_startbutton_pressed;
	public static Sprite spr_startbutton_pressed;
	//TITLE
	public static Texture t_title;
	public static Sprite spr_title;
	
	public static void load(){
		
		//FONT
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("font.ttf"));
		font = gen.generateFont(110);
		font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		font.setColor(Color.WHITE);
		font.setScale(1, -1);
		ffont = gen.generateFont(110);
		ffont.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		ffont.setColor(Color.WHITE);
		ffont.setScale(-1, 1);
		
		//SCORE-FONT
		scoreFont = gen.generateFont(80);
		scoreFont.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		scoreFont.setColor(Color.WHITE);
		scoreFont.setScale(1, -1);
		fscoreFont = gen.generateFont(80);
		fscoreFont.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		fscoreFont.setColor(Color.WHITE);
		fscoreFont.setScale(-1, 1);
		
		//SMALL-FONT
		font_small = gen.generateFont(20);
		font_small.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		font_small.setColor(Color.WHITE);
		font_small.setScale(1, -1);
		
		//BACKGROUND
		texture_bg = new Texture(Gdx.files.internal("back.png"));
		texture_bg.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		spr_bg = new Sprite(texture_bg);
		spr_bg.flip(false, true);
		
		//PLAYER 1
		texture_player1 = new Texture(Gdx.files.internal("players/Player1_sheet.png"));
		texture_player1.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		spr_player1 = new Sprite(texture_player1, 0, 0, 1080, 640);
		spr_player1_red = new Sprite(texture_player1, 0, 640, 1080, 640);
		spr_player1_green = new Sprite(texture_player1, 0, 1280, 1080, 640);
		spr_player1.flip(false, true);
		spr_player1_red.flip(false, true);
		spr_player1_green.flip(false, true);
		
		//PLAYER 2
		texture_player2 = new Texture(Gdx.files.internal("players/Player2_sheet.png"));
		texture_player2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		spr_player2 = new Sprite(texture_player2, 0, 0, 1080, 640);
		spr_player2_red = new Sprite(texture_player2, 0, 640, 1080, 640);
		spr_player2_green = new Sprite(texture_player2, 0, 1280, 1080, 640);
		spr_player2.flip(false, true);
		spr_player2_red.flip(false, true);
		spr_player2_green.flip(false, true);
		
		//STARTBUTTON
		texture_startbutton = new Texture(Gdx.files.internal("titlescreen/Startbutton.png"));
		texture_startbutton.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		spr_startbutton = new Sprite(texture_startbutton);
		spr_startbutton.flip(false, true);
		texture_startbutton_pressed = new Texture(Gdx.files.internal("titlescreen/Startbutton_pressed.png"));
		texture_startbutton_pressed.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		spr_startbutton_pressed = new Sprite(texture_startbutton_pressed);
		spr_startbutton_pressed.flip(false, true);
		
		//TITLE
		t_title = new Texture(Gdx.files.internal("titlescreen/title.png"));
		t_title.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		spr_title = new Sprite(t_title);
		spr_title.flip(false, true);
	}
	
	
}
