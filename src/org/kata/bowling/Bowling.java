package org.kata.bowling;

public class Bowling {

	private int[] rolls;
	private int currentRoll;
	
	
	public Bowling() {
		super();
		
		this.rolls = new int[21];
		this.currentRoll = 0;
	}

	public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }
	
	public int getScore() {
		int score = 0;
		int rollIndex = 0;
		
		for(int frame=0; frame<10; frame++) {
			if(isSpare(rollIndex)) {
				score += spareScore(rollIndex);
				rollIndex += 2;
			}
			else if(isStrike(rollIndex)) {
				score += strikeScore(rollIndex);
				rollIndex++;
			}
			else {
				score += sumRollsOfFrame(rollIndex);
				rollIndex += 2;
			}
		}
		
		return score;
	}
	
	private boolean isSpare(int roleIndex) {
		return rolls[roleIndex]+rolls[roleIndex+1] == 10;
	}
	private boolean isStrike(int roleIndex) {
		return rolls[roleIndex] == 10;
	}
	private int spareScore(int rollIndex) {
		return 10 + rolls[rollIndex+2];
	}
	private int strikeScore(int rollIndex) {
		return 10 + rolls[rollIndex+1] + rolls[rollIndex+2];
	}
	private int sumRollsOfFrame(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex+1];
	}
	
	
	public static void main(String[] args) {
		 
		
	}
}
