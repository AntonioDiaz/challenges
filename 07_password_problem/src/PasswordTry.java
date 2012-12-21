import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * Respresents a list of keys trying writing a password.
 * @author antonio.diaz.arroyo
 *
 */

public class PasswordTry {

	private List<Boolean> keysList;
	private Integer passwordSize;
	
	/**
	 * 
	 * @param keys
	 */
	public PasswordTry (String keys, int size){
		keysList = new ArrayList<Boolean>();
		for (int i=0; i<keys.length(); i++) {
			keysList.add(keys.charAt(i)=='1');
		}
		passwordSize = size;
	}
	
	public int trySize(){
		return keysList.size();
	}
	
	public int firstMistake(){
		int mistake = -1;
		for (int i=0; i<keysList.size() && mistake==-1; i++){
			if (!keysList.get(i)){
				mistake = i;
			}
		}
		return mistake;
	}

	public List<Boolean> getKeysList() {
		return keysList;
	}

	public void setKeysList(List<Boolean> keysList) {
		this.keysList = keysList;
	}
	
	public Integer getPasswordSize() {
		return passwordSize;
	}

	public void setPasswordSize(Integer passwordSize) {
		this.passwordSize = passwordSize;
	}

	/**
	 * Calculate the number of keystrokes needed to complete the password correctly, 
	 * following the "keep typeing" strategy.
	 * @return
	 */
	public int calculateKeysKeepTyping(){
		int keysStrokesNeeded = 0;
		keysStrokesNeeded = passwordSize - keysList.size() + 1;
		if (this.firstMistake()!=-1){
			keysStrokesNeeded += passwordSize + 1;
		} 
		return keysStrokesNeeded;
	}
	
	
	/**
	 * Calculate de number of keystrokes needed to complete the password correctly,
	 * following the "press enter right away" strategy.
	 * @return
	 */
	public int calculateKeysPressingEnter(){
		return passwordSize + 1;
	}
	
	/**
	 * Calculate de number of keystrokes needed to complete the password correctly,
	 * following the "press n times backspace key" strategy.
	 * @return
	 */
	public int calculateKeysBackspace(int backspaces){
		int keysStrokesNeeded = 0;
		keysStrokesNeeded = (backspaces * 2) + passwordSize - keysList.size() + 1; 
		/** si queda algun error. */
		if (firstMistake()!=-1 && (keysList.size() - backspaces) >= firstMistake()) {
			keysStrokesNeeded += passwordSize + 1; 
		}
		return keysStrokesNeeded;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
