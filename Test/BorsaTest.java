package HomeworkA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	private IOConsole io=new IOConsole();

	//TEST ADD ATTREZZO
	@Test
	void testAddAttrezzo_funziona() {
		Borsa b= new Borsa (10,io);
		Attrezzo a=new Attrezzo("a",3);
		assertTrue(b.addAttrezzo(a));
	}
	@Test
	void testAddAttrezzo_troppoPesante() {
		Borsa b= new Borsa (10,io);
		Attrezzo a=new Attrezzo("a",15);
		assertFalse(b.addAttrezzo(a));
	}
	@Test
	void testAddAttrezzo_PesoMassimoSuperato() {
		Borsa b= new Borsa (10,io);
		Attrezzo a=new Attrezzo("a",3);
		Attrezzo a2=new Attrezzo("a2",8);
		b.addAttrezzo(a);
		assertFalse(b.addAttrezzo(a2));
	}

	//TEST REMOVE ATTREZZO
	@Test
	void testRemoveAttrezzo_borsaVuota() {
		Borsa b= new Borsa (10,io);
		Attrezzo a=new Attrezzo("a",3);
		assertEquals(b.removeAttrezzo(a),null);
	}
	@Test
	void testRemoveAttrezzo_appenaAggiunto() {
		Borsa b= new Borsa (10,io);
		Attrezzo a=new Attrezzo("a",3);
		b.addAttrezzo(a);
		assertEquals(b.removeAttrezzo(a),a);
	}
	@Test
	void testRemoveAttrezzo_GetAttrezzo() {
		Borsa b= new Borsa (10,io);
		Attrezzo a=new Attrezzo("a",3);
		b.addAttrezzo(a);
		b.removeAttrezzo(a);
		assertEquals(b.getAttrezzo("a"),null);
	}
	
	//TEST GET PESO
	@Test
	void testGetPeso_borsaVuota() {
		Borsa b= new Borsa (10,io);
		assertEquals(b.getPeso(),0);
	}
	@Test
	void testGetPeso_attrezzoAggiunto() {
		Borsa b= new Borsa (10,io);
		Attrezzo a=new Attrezzo("a",3);
		b.addAttrezzo(a);
		assertEquals(b.getPeso(),3);
	}
	@Test
	void testGetPeso_attrezzoAggiuntoERimosso() {
		Borsa b= new Borsa (10,io);
		Attrezzo a=new Attrezzo("a",3);
		b.addAttrezzo(a);
		b.removeAttrezzo(a);
		assertEquals(b.getPeso(),0);
	}
}
