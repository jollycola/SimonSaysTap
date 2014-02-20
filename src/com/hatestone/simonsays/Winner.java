package com.hatestone.simonsays;

	public class Winner {
		public static void getWinner(int index){
			
			if (Vars.firstPress == 0 && Vars.firstPressFreeze == false){
				Vars.firstPress = index;
				Vars.firstPressFreeze = true;
				Vars.tapped = true;
				if (Vars.open == true && Vars.firstPress == index){
					Vars.winner = index;
					Vars.points[0]++;
				}else if(Vars.open == false && Vars.firstPress == index){
					Vars.looser = index;
					Vars.points[0]--;
				}
			}
			
			if (Vars.winner == 1) {
				Vars.looser = 2;
			}else if (Vars.winner == 2){
				Vars.looser = 1;
			}
			if (Vars.looser == 1){
				Vars.winner = 2;
			}else if (Vars.looser == 2){
				Vars.winner = 1;
			}
		}
}
