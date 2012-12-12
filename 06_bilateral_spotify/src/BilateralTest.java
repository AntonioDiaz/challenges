import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class BilateralTest {

	@Test
	public void testCalculateMinimalListSmall() throws IOException {
		List <Integer> representatives = Arrays.asList(new Integer[]{2011});
		InputStream inputStream = Bilateral.class.getResourceAsStream("inputSmall.txt");
		Bilateral bilateral = new Bilateral (new InputStreamReader (inputStream));
		assertEquals (representatives, bilateral.calculateMinimalList());
	}

	@Test
	public void testCalculateMinimalListNormal() throws IOException {
		List <Integer> representatives = Arrays.asList(new Integer[]{1009, 2002});
		InputStream inputStream = Bilateral.class.getResourceAsStream("input.txt");
		Bilateral bilateral = new Bilateral (new InputStreamReader (inputStream));
		assertEquals (representatives, bilateral.calculateMinimalList());
	}
	
	@Test
	public void testCalculateMinimalListNormalNew() throws IOException {
		List <Integer> representatives = Arrays.asList(new Integer[]{2000, 2001});
		InputStream inputStream = Bilateral.class.getResourceAsStream("inputNew.txt");
		Bilateral bilateral = new Bilateral (new InputStreamReader (inputStream));
		assertEquals (representatives, bilateral.calculateMinimalList());
	}
}
