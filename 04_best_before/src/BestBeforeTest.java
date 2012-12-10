import static org.junit.Assert.*;

import org.junit.Test;

public class BestBeforeTest {

	@Test
	public void testCalculateBestDate00() {
		String input = "02/4/67";
		String output = "2067-02-04";		
		assertEquals(output, BestBefore.calculateBestDate(input));
		input = "31/9/73";
		output = "31/9/73 is illegal";		
		assertEquals(output, BestBefore.calculateBestDate(input));
		input = "12/11/10";
		output = "2010-11-12";		
		assertEquals(output, BestBefore.calculateBestDate(input));
		input = "31/05/2012";
		output = "2012-05-31";		
		assertEquals(output, BestBefore.calculateBestDate(input));
		input = "2012/02/29";
		output = "2012-02-29";		
		assertEquals(output, BestBefore.calculateBestDate(input));
		input = "2013/02/29";
		output = "2013/02/29 is illegal";		
		assertEquals(output, BestBefore.calculateBestDate(input));
		input = "31/5/2012";
		output = "2012-05-31";		
		assertEquals(output, BestBefore.calculateBestDate(input));
		input = "01/01/2000";
		output = "2000-01-01";		
		assertEquals(output, BestBefore.calculateBestDate(input));
	}
}
