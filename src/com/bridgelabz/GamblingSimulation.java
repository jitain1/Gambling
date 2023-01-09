package com.bridgelabz;

public class GamblingSimulation {
	
	static int stake = 100;   
	static final int BET = 1;

	public static void checkWinOrLoose() {
		int random_Check = (int) (Math.random()*2);
		switch(random_Check) {
			case 1 :
				stake += BET; 
				System.out.println("Player won the bet.");
				System.out.print("Player Account balance : " + stake);
				break;
			default :
				stake -= BET;   
				System.out.println("Player loose the bet.");
				System.out.print("Player Account balance : " + stake);
		}	
	}
	
/*Gambler will resign for the day if won or lost 50% of the stake */
	public static void gambling() {
		double winningTarget = stake * 1.5;
		double loosingTarget = stake * 0.5;
	
		System.out.println("Starting with : " +stake + "    Winning target = " + winningTarget + "    Loosing target = " + loosingTarget);
		
		while(stake <= winningTarget && stake >= loosingTarget) {
			checkWinOrLoose();
			System.out.println("\n");
			
			if(stake == 150 || stake == 50) {
				System.out.println("***************************** Target Reached  *******************************");
				break;
			}
		}
	}

	public static void main(String[] args) {
		
		System.out.println("***************** WELCOME TO GAMBLING SIMULATOR PROBLEM ****************\n");
		gambling();
	}

}