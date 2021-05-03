package org.kata.bowling.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.kata.bowling.Bowling;

public class TestBowling {

	private Bowling bowling;
	
	@Before
	public void setUp() {
		this.bowling = new Bowling();
	}
	
	@Test
	public void testAllZero() {
		// le tableau rolls deja initié par des 0;
		assertEquals(0, bowling.getScore());
	}
	
	@Test
	public void testAllOne() {
		rollPins(20, 1);
		assertEquals(20, bowling.getScore());
	}
	
	@Test
	public void testAllStrike() {
		rollPins(12, 10);
		assertEquals(300, bowling.getScore());
	}
	
	@Test
	public void testAllNine() {
		rollPinsOf(9);
		assertEquals(90, bowling.getScore());
	}
	
	@Test
	public void testManySpare() {
		rollSparesOf(10, 5);
		bowling.roll(5);
		assertEquals(150, bowling.getScore());
	}
	
	public void rollPinsOf(int pinOf) {
		for(int i=0; i<20; i+=2) {
			bowling.roll(9);
		}
	}
	
	public void rollPins(int roll, int pins) {
		for(int i=0; i<roll; i++) {
			this.bowling.roll(pins);
		}
	}
	public void rollSparesOf(int numbSpare, int spareOF) {
		for(int i=0; i<numbSpare; i++) {
			bowling.roll(spareOF);
			bowling.roll(10-spareOF);
		}
	}
}
