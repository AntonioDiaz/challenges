import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;


public class CribaEratostenesTest {

	@Test
	public void testPrimes() {
		Integer[] primesOf2 = new Integer[]{2};
		Integer[] primesOf3 = (Integer[])ArrayUtils.addAll(primesOf2, new Integer[]{3});
		Integer[] primesOf30 = (Integer[])ArrayUtils.addAll(primesOf3, new Integer[]{ 5, 7, 11, 13, 17, 19, 23, 29});
		Integer[] primesOf120 = (Integer[])ArrayUtils.addAll(primesOf30, new Integer[]
				{ 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113});
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(primesOf2));
		Set<Integer> set3 = new HashSet<Integer>(Arrays.asList(primesOf3));
		Set<Integer> set30 = new HashSet<Integer>(Arrays.asList(primesOf30));
		Set<Integer> set120 = new HashSet<Integer>(Arrays.asList(primesOf120));
		assertTrue(CribaEratostenes.primes(2).equals(set2));
		assertTrue(CribaEratostenes.primes(3).equals(set3));
		assertTrue(CribaEratostenes.primes(30).equals(set30));
		assertTrue(CribaEratostenes.primes(120).equals(set120));
	}
}
