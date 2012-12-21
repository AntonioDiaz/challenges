import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;

/**
 * 
 * @author antonio.diaz.arroyo
 */
public class PruebasBigInteger {

	public static void mainsss(String[] args) {
		BigInteger bi = new BigInteger("56");
		System.out.println("[" + String.format("%#010x", bi) + "]");
	}
	
	public static void main(String[] args) {
		BigInteger bigInteger = new BigInteger("542");
		System.out.println(bigInteger);
		System.out.println(bigInteger.intValue());
		System.out.println(bigInteger.toString(2));
		for (byte myByte: bigInteger.toByteArray()) {
			System.out.println(myByte);
		}
		System.out.println(Math.pow(2, 3));
		int passwordSize = 5;
		//PruebasBigInteger.keysProbabilities(1, passwordSize);
		PruebasBigInteger.keysProbabilities(2, passwordSize);
		//PruebasBigInteger.keysProbabilities(3, passwordSize);
	}
	
	public static final float KEY_OK = 0.6F;
	public static final float KEY_KO = 0.4F;
	
	/**
	 * 
	 * @param pressNumber
	 * @return
	 */
	public static void keysProbabilities(int pressNumber, int passwordSize){
		double possibilities = Math.pow(2, pressNumber);
		for (int i = 0; i < possibilities; i++) {
			String keys = String.format("%0" + pressNumber + "d", new BigInteger(Integer.toBinaryString(i)));
			PasswordTry passwordTry = new PasswordTry(keys, passwordSize);
			System.out.println("keys " + keys + "-" + passwordTry.calculateKeysKeepTyping());
			System.out.println("keys " + keys + "-" + passwordTry.calculateKeysBackspace(1));
			System.out.println("keys " + keys + "-" + passwordTry.calculateKeysBackspace(2));
			System.out.println("keys " + keys + "-" + passwordTry.calculateKeysPressingEnter());
		}
	}

	
}
