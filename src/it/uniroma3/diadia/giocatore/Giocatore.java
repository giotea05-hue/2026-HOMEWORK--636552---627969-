package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.IOConsole;

public class Giocatore {
	private int CFU;
	private Borsa borsa;
	private IOConsole io;
	
	
	static final private int CFU_INIZIALI = 20;
	
	public Giocatore(IOConsole i) {
		this.io = i;
        // PASSIAMO L'OGGETTO ALLA BORSA
        this.borsa = new Borsa(20,io); 
        this.CFU = CFU_INIZIALI;
	}
	
	
	
		
		
		
	
	
	
	
	public void setCFU(int c) {
		this.CFU=c;
	
	}
	
	public int getCFU() {
		return this.CFU;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	

}
