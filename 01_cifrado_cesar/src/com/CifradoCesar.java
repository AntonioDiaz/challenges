package com;

import java.util.ArrayList;
import java.util.List;

/**
 * <a hfer="http://www.solveet.com/exercises/Cifrado-Cesar/145">Cifrado Cesar</a>
 * @author antonio.diaz.arroyo
 *
 */
public class CifradoCesar {

	private static final List<Character> CHAR_LIST;
	
	/**
	 * 
	 * @param inputString
	 * @return
	 */
	public static String ciframe (String inputString, Integer desplazamiento) {
		String outputStr = "";
		inputString = inputString.toLowerCase();
		for (int i = 0; i < inputString.length(); i++) {
			int indexOf = CHAR_LIST.indexOf(inputString.charAt(i));
			Character newCharacter;
			if (indexOf != -1) {
				int newIndexOf = (indexOf + desplazamiento) % CHAR_LIST.size();
				newCharacter = CHAR_LIST.get(newIndexOf);
			} else {
				newCharacter = inputString.charAt(i);
			}
			outputStr += newCharacter.toString();
		}
		return outputStr;
	}

	/** Create the list of the characters and its position. */
	static {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
		char[] charArray = alphabet.toCharArray();
		CHAR_LIST = new ArrayList<Character>(); 
		for (int i = 0; i < charArray.length; i++) {
			CHAR_LIST.add(charArray[i]);
		}
	}
	
}
