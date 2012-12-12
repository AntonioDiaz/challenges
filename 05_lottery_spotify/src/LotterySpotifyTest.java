import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LotterySpotifyTest {

	@Test
	public void testCalculateProbability01() {
		LotterySpotify lotterySpotify = new LotterySpotify(100, 10, 2, 1);
		assertEquals(lotterySpotify.calculateProbability(), "0.1");
	}

	@Test
	public void testCalculateProbability02() {
		LotterySpotify lotterySpotify = new LotterySpotify(100, 10, 2, 2);
		assertEquals(lotterySpotify.calculateProbability(), "0.1909090909");
	}

	@Test
	public void testCalculateProbability03() {
		LotterySpotify lotterySpotify = new LotterySpotify(10, 10, 5, 1);
		assertEquals(lotterySpotify.calculateProbability(), "1.0000000000");
	}
}
