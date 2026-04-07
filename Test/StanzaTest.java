import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	//TEST HAS ATTREZZO
	@Test
	void testHasAttrezzo_stanzaVuota() {
		Stanza vuota = new Stanza("vuota");
		assertFalse(vuota.hasAttrezzo("martello"));
	}
	@Test
	void testHasAttrezzo_trovato() {
		Stanza piena = new Stanza ("piena");
		piena.addAttrezzo(new Attrezzo("martello",10));
		assertTrue(piena.hasAttrezzo("martello"));
	}
	@Test
	void testHasAttrezzo_mancante() {
		Stanza piena = new Stanza ("piena");
		piena.addAttrezzo(new Attrezzo("martello",10));
		assertFalse(piena.hasAttrezzo("introvabile"));
	}
	
	//TEST ADD ATTREZZO
	@Test
	void testAddAttrezzo_funzionante() {
		Stanza s = new Stanza ("s");
		Attrezzo a =new Attrezzo("a",2);
		assertTrue(s.addAttrezzo(a));
	}
	@Test
	void testAddAttrezzo_hasAttrezzo() {
		Stanza s = new Stanza ("s");
		Attrezzo a =new Attrezzo("a",2);
		s.addAttrezzo(a);
		assertTrue(s.hasAttrezzo("a"));
	}
	@Test
	void testAddAttrezzo_numeroMassimoRaggiunto() {
		final Stanza piena=new Stanza("piena");
		for(int i=0; i<10; i++) {
			assertTrue(piena.addAttrezzo(new Attrezzo("attrezzo "+i, i)));
		}
		assertFalse(piena.addAttrezzo(new Attrezzo("escluso", 1)));
	}
	
	//TEST REMOVE ATTREZZO
	@Test
	void testRemoveAttrezzo_null() {
		Stanza s = new Stanza ("s");
		assertFalse(s.removeAttrezzo(null)); //va bene?
	}
	@Test
	void testRemoveAttrezzo_aggiunto() {
		Stanza s = new Stanza ("s");
		Attrezzo a =new Attrezzo("a",2);
		s.addAttrezzo(a);
		assertTrue(s.removeAttrezzo(a));
	}
	@Test
	void testRemoveAttrezzo_stanzaVuota() {
		Stanza s = new Stanza ("s");
		Attrezzo a =new Attrezzo("a",2);
		assertFalse(s.removeAttrezzo(a));
	}
}
