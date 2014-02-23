package com.hatestone.simonsays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class TitleScreen implements Screen {
	
	SimonSays game;
	OrthographicCamera camera;
	public static SpriteBatch batch;
	Vector3 touch;
	Vector3 pointer;
	float deltaTime;
	boolean justTouched;
	boolean startbuttonPressed;
	float titleY;
	float time = 0;
	boolean pointerOverStart;
	TextButton Settings;
	public static Stage stage;
	public static TextureAtlas buttonAtlas;
	public static TextButtonStyle buttonStyle;
	public static TextButton button;
	public static Skin skin;

	public TitleScreen(SimonSays game){
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1080, 1920);
		
		batch = new SpriteBatch();
		touch = new Vector3();
		pointer = new Vector3();

		button();
		placeButton(button, 540, 900);
		Settings = new TextButton("SETTINGS", buttonStyle);
		placeButton(Settings, 540, 900+300);
		
		titleY = 320;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.95F, 0.95F, 0.95F, 0.95F);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		deltaTime = Gdx.graphics.getDeltaTime();
		
		camera.update();
		generalUpdate(touch, camera, deltaTime, pointer);
		bounce(deltaTime);
		
		stage.setCamera(camera);
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
			batch.draw(Assets.spr_bg, 0, 0);
			batch.draw(Assets.spr_title, 540-Assets.spr_title.getWidth()/2, titleY-Assets.spr_title.getHeight()/2);
			Assets.font_small.draw(batch, "(c) 2014 HateStone Games", 540-Assets.font_small.getBounds("(c)2014 HateStone Games").width/2, 1920-64-Assets.font_small.getBounds("(c) HateStone Games").height/2);
			stage.draw();
		batch.end();
	}	

	public void generalUpdate(Vector3 touch, OrthographicCamera camera, float deltaTime, Vector3 pointer){
		pointer.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		if (Gdx.input.isTouched()){
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
		}
		button.addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button){
				return true;
			}
			public void touchUp(InputEvent event, float x, float y, int pointer, int button){
				game.setScreen(SimonSays.game_screen);
			}	
		});	
	}
	
	public void bounce(float deltaTime){
		time += deltaTime;
		if (time <=1){
			titleY = 320 + (time*50);	
		} else if (time > 1){
			titleY = 320 + (1*50) - ((time-1)*50);
		}
		if (time > 2){
			time = time -2;
		}
	}
	
	public static void loadButton(){
	}
	
	public static void placeButton(TextButton name, int x, int y){
		stage.addActor(name);
		name.setY(y-name.getHeight()/2);
		name.setX(x-name.getWidth()/2);
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
	
	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}

}
