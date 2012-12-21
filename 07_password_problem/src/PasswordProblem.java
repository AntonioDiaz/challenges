import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * http://code.google.com/codejam/contest/1645485/dashboard
 * 
 * @author antonio.diaz.arroyo
 *
 */
public class PasswordProblem {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStream resourceAsStream = PasswordProblem.class.getResourceAsStream("A-small-practice.in");
		InputStreamReader ir = new InputStreamReader(resourceAsStream);
		BufferedReader br = new BufferedReader(ir);
		int cases = Integer.parseInt(br.readLine());
		for (int i = 0; i < cases; i++) {
			String myInput = br.readLine() + "\n" + br.readLine();
			PasswordProblem passwordProblem = new PasswordProblem(myInput);
			Float probabilities = passwordProblem.calculateProbabilities();
			System.out.format(Locale.US, "Case #%1$d: %2$f %n", i, probabilities);
		}
	}
	
	/**
	 * Get a String with 2 lines with this format:
	 * A B //where A is the number of character typed and the total of characters in my password.
	 * p1, p2, ... pA //the probability that i typed correctly de letter. 
	 * @param input
	 */
	public PasswordProblem(String input) {
		String[] split = input.split("\n");
		passwordLength = Integer.parseInt(split[0].split(" ")[1]);
		String[] split2 = split[1].split(" ");
		probabilites = new ArrayList<Float>();		 
		for (String string : split2) {
			probabilites.add(Float.parseFloat(string));
		}	
	}
	
	public PasswordProblem(Integer myLength, List<Float> probabilities){
		this.passwordLength = myLength;
		this.probabilites = probabilities;
	}

	private List<Float> probabilites;
	private Integer passwordLength;
	
	public Float calculateProbabilities (){
		return 0f;
	}
	
	private Float keepTyping(){
		return null;
	}
	
	private float[] backSpaces(){
		return null;
	}
	
	private Float pressEnter(){
		return null;
	}
	
	
	public List<Float> getProbabilites() {
		return probabilites;
	}
	
	public void setProbabilites(List<Float> probabilites) {
		this.probabilites = probabilites;
	}
	
	public Integer getPasswordLength() {
		return passwordLength;
	}
	
	public void setPasswordLength(Integer passwordLength) {
		this.passwordLength = passwordLength;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
