package com.hatestone.simonsays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class TitleScreen implements Screen{
	
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

	public TitleScreen(SimonSays game){
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1080, 1920);
		
		batch = new SpriteBatch();
		touch = new Vector3();
		pointer = new Vector3();
		
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
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
			batch.draw(Assets.spr_bg, 0, 0);
			if(!startbuttonPressed){
				batch.draw(Assets.spr_startbutton, 540-Assets.spr_startbutton.getWidth()/2, 960-Assets.spr_startbutton.getHeight()/2);
			} else {
				batch.draw(Assets.spr_startbutton_pressed, 540-Assets.spr_startbutton_pressed.getWidth()/2, 960-Assets.spr_startbutton_pressed.getHeight()/2);
			}
			batch.draw(Assets.spr_title, 540-Assets.spr_title.getWidth()/2, titleY-Assets.spr_title.getHeight()/2);
			Assets.font_small.draw(batch, "(c) HateStone Games", 540-Assets.font_small.getBounds("(c) HateStone Games").width/2, 1920-64-Assets.font_small.getBounds("(c) HateStone Games").height/2);
		batch.end();
	}

	public void generalUpdate(Vector3 touch, OrthographicCamera camera, float deltaTime, Vector3 pointer){
		pointer.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		if (Gdx.input.isTouched()){
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			
			if (touch.x >= 540-Assets.spr_startbutton.getWidth()/2 && touch.x <= 540+Assets.spr_startbutton.getWidth()/2 && touch.y >= 960-Assets.spr_startbutton.getHeight()/2 && touch.y <= 960+Assets.spr_startbutton.getHeight()/2){
				justTouched = true;
				startbuttonPressed = true;
			}
		}
		
		if(!Gdx.input.isTouched() && justTouched){
			game.setScreen(SimonSays.game_screen);
			startbuttonPressed = false;
		}
		
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
