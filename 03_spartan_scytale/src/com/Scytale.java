package com;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * http://es.wikipedia.org/wiki/Esc%C3%ADtala
 * @author antonio.diaz.arroyo
 *
 */
public class Scytale {

	public static void main(String[] args) {
		String textIn = "Ernu  n cyna dhoocuea  on ,nqr l oudladmiau ebergM rrmaaceoe";
		String textOut = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";
		Scytale scytale = new Scytale(6, 10);
		System.out.println(scytale.scytaleCode(textIn));
		System.out.println(textOut.equals(scytale.scytaleCode(textIn)));
	}
	
	private Integer width;
	private Integer height;
	
	public Scytale(Integer width, Integer height) {
		super();
		this.width = width;
		this.height = height;
	}

	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public String scytaleCode(String input){
		byte[] bytes = input.getBytes();
		byte[] newBytes = new byte[bytes.length];
		int row;
		int column;
		for (int i = 0; i < bytes.length; i++) {
			row = i / this.width;
			column = i % this.width;
			newBytes[column*this.height + row] = bytes[i];
		}
		return new String (newBytes);
	}
	
	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}	
	
}
