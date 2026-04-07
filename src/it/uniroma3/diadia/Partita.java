package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	

	private Stanza stanzaCorrente;  
	 
	private Labirinto labirintoCorrente;
	private boolean finita;
	
	private Giocatore player;
	private IOConsole io;
	
	
	
	public Partita(IOConsole i){
		this.io=i;
		 this.labirintoCorrente= new Labirinto(null,null);
		this.labirintoCorrente.creaStanze();
		this.stanzaCorrente = labirintoCorrente.getStanzaIniziale();
		this.finita = false;
		this.player=new Giocatore(this.io);
		
		
		
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
    
	

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== labirintoCorrente.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.player.getCFU() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Giocatore getPlayer() {
		

		return this.player;
	}
	
	public Labirinto getLabirinto() {
		return this.labirintoCorrente;
	}

	
	//}	
}

