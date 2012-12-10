import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * http://www.spotify.com/es/jobs/tech/best-before/
 * 
 * @author antonio.diaz.arroyo
 * 
 */
public class BestBefore {

	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		System.out.println(BestBefore.calculateBestDate(s));
	}

	/**
	 * Calculate the minimun date from all posibles. 
	 * @param input
	 * @return
	 * @throws Exception 
	 */
	public static String calculateBestDate(String input) {
		Date minDate = null;
		Date maxDate = null;
		try {
			minDate = (new SimpleDateFormat("dd/MM/yyyy")).parse("01/01/2000");
			maxDate = (new SimpleDateFormat("dd/MM/yyyy")).parse("31/12/2999");
		} catch (ParseException e) {}
		Date lowestDate = null;
		String output = "";
		List<int[]> permutations = new ArrayList<int[]>();
		permutations.add(new int[]{0,1,2});
		permutations.add(new int[]{0,2,1});
		permutations.add(new int[]{1,0,2});
		permutations.add(new int[]{1,2,0});
		permutations.add(new int[]{2,0,1});
		permutations.add(new int[]{2,1,0});
		Pattern pattern = Pattern.compile("(\\d+)/(\\d+)/(\\d+)");
		Matcher matcher = pattern.matcher(input);
		if (matcher.matches()){
			String[] split = input.split("/");
			Integer[] numbers = new Integer[3];
			for (int i = 0; i < 3; i++) {
				numbers[i] = Integer.parseInt(split[i]);		
			}
			for (int[] posibilities : permutations) {
				Date myDate = BestBefore.transformDate(numbers[posibilities[0]], numbers[posibilities[1]], numbers[posibilities[2]]);
				/* Check if the date is on rage, that is between the 01/01/2000 and the 31/12/2999. */
				if (myDate!=null && myDate.compareTo(minDate)>0 && myDate.compareTo(maxDate)<0){
					if (lowestDate==null || lowestDate.compareTo(myDate)>0) {
						lowestDate = myDate;
					}
				}
			}
		}
		if (lowestDate!=null){
			output = new SimpleDateFormat("yyyy-MM-dd").format(lowestDate);			
		} else {
			output = input + " is illegal";
		}
		return output;
	}
	
	/**
	 * Calculate de date of that day / month / year
	 * year can be tuncated example 12 is 2012
	 * @param day
	 * @param mounth
	 * @param year
	 * @return
	 * @throws ParseException
	 */
	public static Date transformDate (int day, int mounth, int year) {
		Date dateParsed = null;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		if (year < 1000){
			year += 2000;
		}
		try {
			dateParsed = df.parse(String.format("%1$02d/%2$02d/%3$04d", day, mounth, year));
		} catch (ParseException e) {

		}
		return dateParsed;
	}

}
