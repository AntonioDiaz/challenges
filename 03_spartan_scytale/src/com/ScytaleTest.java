package com;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ScytaleTest {

	@Test
	public void testScytaleCode() {
		String textIn = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";
		String textOut = "Ernu  n cyna dhoocuea  on ,nqr l oudladmiau ebergM rrmaaceoe";
		Scytale scytale = new Scytale(10, 6);
		assertEquals(textOut, scytale.scytaleCode(textIn));
	}

	@Test
	public void testScytaleDecode() {
		String textIn = "Ernu  n cyna dhoocuea  on ,nqr l oudladmiau ebergM rrmaaceoe";
		String textOut = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";
		Scytale scytale = new Scytale(6, 10);
		assertEquals(textOut, scytale.scytaleCode(textIn));
	}

}
