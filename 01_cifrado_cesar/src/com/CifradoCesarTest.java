package com;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CifradoCesarTest {


	@Test
	public void testCiframe() {
		String input = "Todo lo que se preguntaba eran las mismas respuestas que buscamos el resto de nosotros. " +
				"¿De dónde vengo? ¿A dónde voy? ¿Cuánto tiempo tengo? Todo lo que pude hacer fue sentarme y ver como moría.";
		String out = "wrgr or txh vh suhjxqwded hudq odv plvpdv uhvsxhvwdv txh exvfdprv ho uhvwr gh qrvrwurv. ¿gh góqgh yhqjr? " +
				"¿d góqgh yrb? ¿fxáqwr wlhpsr whqjr? wrgr or txh sxgh kdfhu ixh vhqwduph b yhu frpr pruíd.";
		Integer desplazamiento = 3;
		assertTrue (CifradoCesar.ciframe(input, desplazamiento).equals(out));
	}

}
