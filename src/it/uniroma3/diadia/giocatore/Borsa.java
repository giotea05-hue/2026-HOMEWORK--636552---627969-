package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IOConsole;

public class Borsa {
    public final static int DEFAULT_PESO_MAX_BORSA = 10;
    private Attrezzo[] attrezzi;
    private int numeroAttrezzi;
    private int pesoMax;
    private IOConsole io;

   

    public Borsa(int pesoMax,IOConsole i) {
    	
    	this.io=i;
        this.pesoMax = pesoMax;
        this.attrezzi = new Attrezzo[10]; // speriamo bastino...
        this.numeroAttrezzi = 0;
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
        	this.io.mostraMessaggio("pesomassimo raggiunto");
            return false;
        }
        if (this.numeroAttrezzi == 10) {
        	this.io.mostraMessaggio("numero massimo raggiunto");
            return false;
        }
        
        this.attrezzi[this.numeroAttrezzi] = attrezzo;
        this.numeroAttrezzi++;
        this.io.mostraMessaggio("Aggiunto!");
        return true;
    }
    
    public Attrezzo removeAttrezzo(Attrezzo attrezzo) {//MODIFICA STRING IN ATTREZZO E RIDUCI PESO BORSA
        Attrezzo a = null;
        for(int i=0;i<this.numeroAttrezzi;i++) {
        	if(this.attrezzi[i]==attrezzo) {
        		int c=this.getPesoMax();
        		c=this.attrezzi[i].getPeso()+this.getPesoMax();
        		a=this.attrezzi[i];
        		this.attrezzi[i]=this.attrezzi[this.numeroAttrezzi-1];
        		this.attrezzi[this.numeroAttrezzi-1]=null;
        		this.numeroAttrezzi--;
        	}
        }
        return a;
    }

    public int getPesoMax() {
        return pesoMax;
    }

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        Attrezzo a = null;
        for (int i = 0; i < this.numeroAttrezzi; i++)
            if (this.attrezzi[i].getNome().equals(nomeAttrezzo))//PRENDE L'ATTREZZO DALLA BORSA
                a = attrezzi[i];

        return a;
    }

    public int getPeso() {
        int peso = 0;
        for (int i = 0; i < this.numeroAttrezzi; i++)
            peso += this.attrezzi[i].getPeso();

        return peso;
    }

    public boolean isEmpty() {
        return this.numeroAttrezzi == 0;
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.getAttrezzo(nomeAttrezzo) != null;
    }

    

    public String toString() {
        StringBuilder s = new StringBuilder();

        if (!this.isEmpty()) {
            s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
            for (int i = 0; i < this.numeroAttrezzi; i++)
                s.append(attrezzi[i].toString() + " ");
        } else
            s.append("Borsa vuota");
        
        return s.toString();
    }
}