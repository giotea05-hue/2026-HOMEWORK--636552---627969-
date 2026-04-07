package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io;
	

	public DiaDia(IOConsole i) {
		this.io=i;
		this.partita = new Partita(this.io);
		
		
	}

	public void gioca() {
		String istruzione; 
		
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);

		//System.out.println(MESSAGGIO_BENVENUTO);
		//scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	
	
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			this.io.mostraMessaggio("Comando sconosciuto");
		
		
		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
		} 
		if(this.partita.isFinita())
			return true;
		return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			Giocatore player= partita.getPlayer();
			int cfu = player.getCFU();
			
				
			player.setCFU(cfu-1);
			if(this.partita.isFinita())
				fine();
		}
		this.io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere  
	}
	
	
	public boolean prendi(String attrezzo) {
		Stanza a=this.partita.getStanzaCorrente();
		Attrezzo c=a.getAttrezzo(attrezzo);
		if(c!=null) {
		a.removeAttrezzo(c);
		Giocatore b=this.partita.getPlayer();
		
		b.getBorsa().addAttrezzo(c);
		return true;
		}
		
		this.io.mostraMessaggio("NON C'E'");
		
		
		return false;
	}
	
	public boolean posa(String attrezzo) {
		Giocatore b=this.partita.getPlayer();
		Borsa d=b.getBorsa();
		Attrezzo c=d.getAttrezzo(attrezzo);
		if(d.removeAttrezzo(c)==null)
			return false;
		
		Stanza a=this.partita.getStanzaCorrente();
		a.addAttrezzo(c);
		
		
		
		
		return true;
	}
	
	
	
	
	
	
	

	public static void main(String[] argc) {
		IOConsole io=new IOConsole();
		
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}
