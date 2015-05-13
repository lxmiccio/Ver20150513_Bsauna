package gestionepalestra;

import java.util.Vector;

public class Cliente
{
	private String nome;
	private String cognome;
	private String email;
	private String codice;
	private Vector<Prenotazione> prenotazioni;
	
	public Cliente(String nome, String cognome, String email, String codice)
	{
		if(nome.length() <= 0)
			throw new IllegalArgumentException("The lenght of Nome must be positive");
		this.nome = nome;
		if(cognome == null)
			throw new IllegalArgumentException("Cognome cannot be null");
		if(cognome.length() <= 0)
			throw new IllegalArgumentException("The lenght of Cognome must be positive");
		this.cognome = cognome;
		if(email == null)
			throw new IllegalArgumentException("Email cannot be null");
		if(email.length() <= 0)
			throw new IllegalArgumentException("The lenght of Email must be positive");
		this.email = email;
		if(codice == null)
			throw new IllegalArgumentException("Codice cannot be null");
		if(codice.length() <= 0)
			throw new IllegalArgumentException("The lenght of Codice must be positive");
		this.codice = codice;
		this.prenotazioni = new Vector<Prenotazione>();
	}

	public String getNome()
	{
		return nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public String getEmail()
	{
		return email;
	}

	public String getCodice()
	{
		return codice;
	}
	
	public Vector<Prenotazione> getPrenotazioni()
	{
		return prenotazioni;
	}

	public void addPrenotazione(Prenotazione prenotazione)
	{
		if(prenotazione == null)
			throw new IllegalArgumentException("Prenotazione cannot be null");
		this.prenotazioni.addElement(prenotazione);
	}
	
	public double getNumeroOre()
	{
		int numeroOre = 0;
		for(Prenotazione p : this.prenotazioni)
			numeroOre += p.getNumeroOre();
		return numeroOre;
	}
	
	public double getRicavoTotale()
	{
		double ricavoTotale = 0;
		for(Prenotazione p : this.prenotazioni)
			ricavoTotale += p.getRicavoTotale();
		return ricavoTotale;
	}

	@Override public String toString()
	{
		return "Cliente [nome=" + nome + ", cognome=" + cognome + ", email="
				+ email + ", codice=" + codice + ", numero prenotazioni="
				+ prenotazioni.size() + "]";
	}
}