package HomeworkA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class LabirintoTest {

	//TEST CREA STANZE
	@Test 
	void testGetStanzaIniziale_nonModificata(){
		Labirinto l=new Labirinto(null,null);
		l.creaStanze();
		assertEquals(l.getStanzaIniziale().getNome(), "Atrio");
	}
	@Test
	void testCreaStanze_stanzaVincente() {
		Labirinto l=new Labirinto(null, null);
		l.creaStanze();
		Stanza s=l.getStanzaVincente();
		assertEquals(s.getNome(), "Biblioteca");
	}
	@Test
	void testCreaStanze_attrezzo() {
		Labirinto l=new Labirinto(null, null);
		l.creaStanze();
		Stanza s=l.getStanzaIniziale();
		Attrezzo[] a= s.getAttrezzi();
		assertEquals(a[0].getNome(), "osso");
	}
	
	//TEST GET/SET STANZA INIZIALE
	@Test 
	void testGetSetStanzaIniziale_Modificata(){
		Labirinto l=new Labirinto(null,null);
		Stanza s=new Stanza("s");
		l.setStanzaIniziale(s);
		assertEquals(l.getStanzaIniziale(), s);
	}
	@Test 
	void testGetStanzaIniziale_null(){
		Labirinto l=new Labirinto(null,null);
		assertEquals(l.getStanzaIniziale(), null);
	}
	@Test 
	void testGetStanzaIniziale_settata(){
		Stanza s=new Stanza("s");
		Labirinto l=new Labirinto(s,null);
		assertEquals(l.getStanzaIniziale(), s);
	}
	
	//TEST GET/SET STANZA VINCENTE
	@Test 
	void testGetSetStanzaVincente_Modificata(){
		Labirinto l=new Labirinto(null,null);
		Stanza s=new Stanza("s");
		l.setStanzaVincente(s);
		assertEquals(l.getStanzaVincente(), s);
	}
	@Test 
	void testGetStanzaVincente_null(){
		Labirinto l=new Labirinto(null,null);
		assertEquals(l.getStanzaIniziale(), null);
	}
	@Test 
	void testGetStanzaVincente_settata(){
		Stanza s=new Stanza("s");
		Labirinto l=new Labirinto(null,s);
		assertEquals(l.getStanzaVincente(), s);
	}
}
