

package HomeworkA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

class PartitaTest {
	
	private IOConsole io=new IOConsole();

	//TEST GET STANZA CORRENTE 
	@Test
	void testGetStanzaCorrente_null(){
		Partita p= new Partita(io);
		p.setStanzaCorrente(null);
		assertEquals(p.getStanzaCorrente(), null);
	}
	
	@Test
	void testGetStanzaCorrente_nonSettata() {
		Partita p= new Partita(io);
		assertEquals(p.getStanzaCorrente().getNome(),"Atrio");
	}
	
	@Test
	void testGetStanzaCorrente(){
		Partita p= new Partita(io);
		Stanza s= new Stanza("s");
		p.setStanzaCorrente(s);
		assertEquals(p.getStanzaCorrente(), s);
	}
	
	//TEST VINTA
	
	@Test
	void testVinta_nonSettata(){
		Partita p= new Partita(io);
		assertFalse(p.vinta());
	}
	
	@Test
	void testVinta(){
		Partita p= new Partita(io);
		Stanza s= new Stanza("s");
		p.setStanzaCorrente(s);
		assertFalse(p.vinta());
	}
	
	@Test
	void testVinta_vinta(){
		Partita p= new Partita(io);
		Labirinto l=p.getLabirinto();
		l.creaStanze();
		p.setStanzaCorrente(l.getStanzaVincente());
		assertTrue(p.vinta());
	}
	
	//TEST IS FINITA
	@Test
	void testIsFinita_nonFinita(){
		Partita p= new Partita(io);
		assertFalse(p.isFinita());
	}
	
	@Test
	void testIsFinita_CFUFiniti(){
		Partita p= new Partita(io);
		p.getPlayer().setCFU(0);
		assertTrue(p.isFinita());
	}
	
	@Test
	void testIsFinita_settataFinita(){
		Partita p= new Partita(io);
		p.setFinita();
		assertTrue(p.isFinita());
	}
}
