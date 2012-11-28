import java.util.HashSet;
import java.util.Set;


/**
 * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 * @author antonio.diaz.arroyo
 *
 */

public class CribaEratostenes {

	/**
	 * Calculate the primes with the Eratosthenes Algorithm 
	 * @param n
	 * @return
	 */
	public static Set<Integer> primes(Integer n){
		Set<Integer> primes = new HashSet<Integer>();
		Set<Integer> markedItems = new HashSet<Integer>();
		for (int i = 2; i <= n; i++) {
			if (!markedItems.contains(i)){
				primes.add(i);
				/* mark all multiples. */
				int j = 1;
				while (i*j<=n) {
					markedItems.add(i*j);
					j++;
				}
			}
		}
		/*
		Integer[] myArray = (Integer[])primes.toArray(new Integer[0]);
		Arrays.sort(myArray);
		System.out.println(Arrays.toString(myArray));
		*/
		return primes;
	}
	
}
