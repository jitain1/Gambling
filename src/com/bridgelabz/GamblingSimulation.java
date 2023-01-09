package com.bridgelabz;

public class GamblingSimulation {
	
	static int stake = 100;   
	static final int BET = 1;
	
/* 1 bet for win or loose */
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
	
	public static void main(String[] args) {
		
		System.out.println("***************** WELCOME TO GAMBLING SIMULATOR PROBLEM ****************\n");
		checkWinOrLoose();
	}

}