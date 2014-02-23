package com.hatestone.simonsays;

	public class Winner {
		public static void getWinner(int index){		
			if (Vars.firstPressFreeze == false){
				System.out.println("Winner Method called");
				Vars.firstPress = index;
				Vars.firstPressFreeze = true;
				Vars.tapped = true;
				if (Vars.open == true && Vars.firstPress == index){
					Vars.winner = index;
					System.out.println("Winner = Player "+index);
					Vars.points[index]++;
				}else if(Vars.open == false && Vars.firstPress == index){
					Vars.looser = index;
					System.out.println("Looser = Player "+index);
					Vars.points[index]--;
				}
			}
			
			if (Vars.winner == 0) {
				Vars.looser = 1;
			}else if (Vars.winner == 1){
				Vars.looser = 0;
			}
			if (Vars.looser == 0){
				Vars.winner = 1;
			}else if (Vars.looser == 1){
				Vars.winner = 0;
			}
		}
}
