package com.hatestone.simonsays;

import java.util.Random;


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
	
}
