package com.bridgelabz;

public class GamblingSimulation {
	
	static int stake = 100;   
	static final int BET = 1;
	static int daycount = 1;
	
	static int total_num_of_wins_in_day = 0;
	static int total_num_of_losses_in_day = 0;
	
	static int winningDaycount = 0;
	static int loosingDaycount = 0;
	
	static int previous_day_win = 0;
	static int previous_day_loss = 0;
	static int luckiest_day;
	static int unluckiest_day;
	
	static int total_amount_in_hand = 0;
	static final int total_place_bet_after_month = stake * 30;

	public static void checkWinOrLoose() {
		int random_Check = (int) (Math.random()*2);
		switch(random_Check) {
		case 1 :
			stake += BET; 
			total_num_of_wins_in_day++;
			break;
		default :
			stake -= BET;   
			total_num_of_losses_in_day++;
		}	
	}
	
/*Gambler will resign for the day if won or lost 50% of the stake */
	public static void gambling() {
		double winningTarget = stake * 1.5;
		double loosingTarget = stake * 0.5;
	
		System.out.println("Starting with : " + stake + "    Winning target = " + winningTarget + "    Loosing target = " + loosingTarget);
		
		while(stake <= winningTarget && stake >= loosingTarget) {
			checkWinOrLoose();
			if(stake == 150) {
				winningDaycount++;
				System.out.println("*** Winning day ***");
				checkLuckyday();
				total_amount_in_hand += stake;
				break;
			}	
			if(stake == 50) {
				loosingDaycount++;
				System.out.println("*** Loosing day ***");
				checkUnluckyday();
				total_amount_in_hand += stake;
				break;
			}
		}
		System.out.println("Gambler account balance : " + stake);
		System.out.println("Total number of wins in the day is : " + total_num_of_wins_in_day);
		System.out.println("Total number of loose in the day is : " + total_num_of_losses_in_day);
		System.out.println("Total amount present after day" + daycount + " is : " +total_amount_in_hand);
		
		
		
//After each days of playing this values will be assigned.
		stake = 100;
		total_num_of_wins_in_day = 0;
		total_num_of_losses_in_day = 0;
	}
	
/* Checking the day for(luckiest) and the (unluckiest) Day. */
	
	public static void checkLuckyday() {
		if(previous_day_win < total_num_of_wins_in_day) {
			previous_day_win = total_num_of_wins_in_day; 
			luckiest_day = daycount;
		}
	}
	public static void checkUnluckyday() {
		if(previous_day_loss < total_num_of_losses_in_day) {  
			previous_day_loss = total_num_of_losses_in_day; 
			unluckiest_day = daycount;
		}
	} 
	
/* After 30 days of playing the total amount won or lost. **/
	public static void checkAfterMonth() {
		while(daycount != 31) {
			System.out.println("********** DAY" + daycount + " **********");
			gambling();
			System.out.println("");
			daycount++;
		}
		System.out.println("-----------------------------------------------------");
		System.out.println("****** After the End of the month ******");
		System.out.println("Total number of winning days: " + winningDaycount);
		System.out.println("Total number of loosing days: " + loosingDaycount);
		System.out.println("-----------------------------------------------------");
		System.out.println("Luckiest day : " + luckiest_day);
		System.out.println("Un-Luckiest day : " + unluckiest_day);
		
	}
	


	public static void main(String[] args) {

		System.out.println("***************** WELCOME TO GAMBLING SIMULATOR PROBLEM ****************\n");

		checkAfterMonth();

	}

}