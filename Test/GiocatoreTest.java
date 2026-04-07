

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {

	//TEST BORSA
	@Test
	void testGetBorsa_nonSettata() {
		Giocatore g=new Giocatore();
		assertEquals(g.getBorsa(),null);
	}
	@Test
	void testGetBorsa_creaGiocatore() {
		Giocatore g=new Giocatore();
		g.creaGiocatore();
		assertTrue(g.getBorsa()!=null);
	}
	@Test
	void testGetBorsa_addAttrezzo() {
		Giocatore g=new Giocatore();
		g.creaGiocatore();
		Attrezzo a=new Attrezzo("a",2);
		g.getBorsa().addAttrezzo(a);
		assertEquals(g.getBorsa().getAttrezzo("a"),a);
	}
	//TEST CFU 
	@Test
	void testGetCfu_nonSettati() {
		Giocatore g=new Giocatore();
		assertEquals(g.getCFU(),0);
	}
	@Test
	void testGetCfu_Settati() {
		Giocatore g=new Giocatore();
		g.setCFU(28);
		assertEquals(g.getCFU(),28);
	}
	@Test
	void testGetCfu_creaGiocatore() {
		Giocatore g=new Giocatore();
		g.creaGiocatore();
		assertEquals(g.getCFU(),10);
	}
	
	//TEST CREA GIOCATORE
	@Test
	void testCreaGiocatore_borsa() {
		Giocatore g=new Giocatore();
		g.creaGiocatore();
		assertTrue(g.getBorsa()!=null);
	}
	@Test
	void testCreaGiocatore_CFU() {
		Giocatore g=new Giocatore();
		g.creaGiocatore();
		assertEquals(g.getCFU(),10);
	}
	@Test
	void testCreaGiocatore_CFUModificati() {
		Giocatore g=new Giocatore();
		g.creaGiocatore();
		g.setCFU(8);
		assertEquals(g.getCFU(),8);
	}
}
