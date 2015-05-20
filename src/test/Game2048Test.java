package test;

import static org.junit.Assert.*;
import game_2048.Game_2048;

import org.junit.Assert;
import org.junit.Test;

public class Game2048Test {

	Game_2048 g = new Game_2048(4,4);
	@Test
	public void toLefttest() {
		int [] ar = {9,0,5,0,0,7,0};
		int [] result = {9,5,7,0,0,0,0};
		Assert.assertArrayEquals(g.toLeftUnitTest(ar), result);
	}
	
	@Test
	public void mergeHelperTest() {
		int [] ar = {4,4,4,4};
		int [] result = {8,0,8,0};
		Assert.assertArrayEquals(g.mergeHelperTest(ar), result);
	}
	
	@Test
	public void mergeTest() {
		int [] ar = {4,4,4,0};
		int [] result = {8,4,0,0};
		Assert.assertArrayEquals(g.mergeTest(ar), result);
	}

}
