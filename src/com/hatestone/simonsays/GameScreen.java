package com.hatestone.simonsays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen{
	
	SimonSays game;
	OrthographicCamera camera;
	public static SpriteBatch batch;
	Vector3 touch;
	Vector3 pointer;
	float time = 0;
	float deltaTime;
	float countdownTime;
	float nextRoundTime = 0;

	public GameScreen(SimonSays game){
		this.game = game;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1080, 1920);
		
		batch = new SpriteBatch();
		touch = new Vector3();
		pointer = new Vector3();
		
		Vars.countdownClosed = false;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.95F, 0.95F, 0.95F, 0.95F);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		deltaTime = Gdx.graphics.getDeltaTime();
		
		camera.update();
		generalUpdate(touch, camera, deltaTime, pointer);
		countdown(deltaTime);
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
			batch.draw(Assets.spr_bg, 0, 0);
			Draw.player(0, 0, 1280);
			Draw.player(1, 0, 0);
			Assets.scoreFont.draw(batch, ""+Vars.points[0], 540 - (Assets.scoreFont.getBounds( ""+Vars.points[0]).width/2), 1920-60+Assets.scoreFont.getBounds( ""+Vars.points[0]).height/2);
			Assets.fscoreFont.draw(batch, ""+Vars.points[1], 540 - (Assets.fscoreFont.getBounds( ""+Vars.points[1]).width/2), 0+60+Assets.fscoreFont.getBounds( ""+Vars.points[1]).height/2);
			switch(Vars.text){
	        case 1: Assets.ffont.draw(batch, "Simon says: TAP!", 540 - Assets.ffont.getBounds("Simon says: TAP!").width/2, 960-120-Assets.ffont.getBounds("Simon says: TAP!").height/2);
	        		Assets.font.draw(batch, "Simon says: TAP!", 540 - Assets.font.getBounds("Simon says: TAP!").width/2, 960+120-Assets.font.getBounds("Simon says: TAP!").height/2);
	        		break;
	        case 2: Assets.ffont.draw(batch, "TAP!", 540 - Assets.ffont.getBounds("TAP!").width/2, 960-120-Assets.ffont.getBounds("TAP!").height/2);
	        		Assets.font.draw(batch, "TAP!", 540 - Assets.font.getBounds("TAP!").width/2, 960+120-Assets.font.getBounds("TAP!").height/2);
	        		break;
	        }
			Draw.countdown();
		batch.end();
		
	}
	
	public void generalUpdate(Vector3 touch, OrthographicCamera camera, float deltaTime, Vector3 pointer){
		if (Gdx.input.isTouched()){
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			camera.unproject(pointer);
			
			if (touch.x >= 0 && touch.x <= 1080 && touch.y >= 1280 && touch.y <= 1920 && Vars.firstPressFreeze == false){
				System.out.println("PLAYER 1 CLICKED");
				Winner.getWinner(0);
				Gdx.input.vibrate(400);
				Vars.nextRound = true;
				Vars.pauseWhileWaiting();
			}
			if (touch.x >= 0 && touch.x <= 1080 && touch.y >= 0 && touch.y <= 640 && Vars.firstPressFreeze == false){
				System.out.println("PLAYER 2 CLICKED");
				Winner.getWinner(1);
				Gdx.input.vibrate(400);
				Vars.nextRound = true;
				Vars.pauseWhileWaiting();
			}
		}
		
		if(Vars.action){
			time += deltaTime;
		    if (time >= Vars.randomTime) {
		    	
		    	for(int i=1; i<=2; i++){
		    		if(Vars.type == i){
		    			Vars.text = i;
		    			break;
		    		}
		    	}
		    	if(Vars.type == 1){
		    		Vars.open = true;
		    	}
		        time -= Vars.randomTime;
		    }
		}
		if(Vars.nextRound){
			nextRoundTime += deltaTime;
			if(nextRoundTime >= 2){
				Vars.nextRound();
				nextRoundTime = 0;
			}
		}
		
	}
	
	public void countdown(float deltaTime){
		if (Vars.countdownClosed == false){
			countdownTime += deltaTime;
			if(countdownTime <= 3){
				if (countdownTime <=1){
					Vars.countdownNumbers = 3;				
				} else if(countdownTime <=2 && countdownTime > 1){
					Vars.countdownNumbers = 2;	
				} else if(countdownTime <=3 && countdownTime > 2){
					Vars.countdownNumbers = 1;
				} else {
					Vars.countdownNumbers = 0;
				}
				}  else if (countdownTime >= 3){
					countdownTime = 0;
					Vars.countdownClosed = true;
					Vars.action = true;
					Vars.countdownNumbers = 0;
				} 
		}else{
			countdownTime = 0;
			Vars.countdownNumbers = 0;
			Vars.countdownClosed = true;
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
