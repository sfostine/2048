package test;

import static org.junit.Assert.*;
import game_2048.Game_2048;

import org.junit.Assert;
import org.junit.Test;

public class Game2048Test {

	Game_2048 g = new Game_2048(4,4);
	@Test
	public void toLefttest() {
		int [] ar = {4,2,0,2};
		int [] result = {4,2,2,0};
		Assert.assertArrayEquals(g.toLeftUnitTest(ar), result);
	}
	
	@Test
	public void mergeHelperTest() {
		int [] ar = {4,2,2,0};
		int [] result = {4,4,0,0};
		Assert.assertArrayEquals(g.mergeHelperTest(ar), result);
	}
	
	@Test
	public void mergeTest() {
		int [] ar = {4, 2, 0, 2};
		int [] result = {4,4,0,0};
		Assert.assertArrayEquals(g.mergeTest(ar), result);
	}

}
