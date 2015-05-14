package gestionepalestra;

import java.util.Vector;

public abstract class Sauna
{
	private String numero;
	private int capienzaMassima;
	private double costoOrario;
	private Vector<Prenotazione> prenotazioni;
	
	public Sauna(String numero, int capienzaMassima, double costoOrario)
	{
		if(numero == null)
			throw new IllegalArgumentException("Numero cannot be null");
		this.numero = numero;
		if(capienzaMassima <= 0)
			throw new IllegalArgumentException("CapienzaMassima must be positive");
		this.capienzaMassima = capienzaMassima;
		if(costoOrario <= 0)
			throw new IllegalArgumentException("CostoOrario must be positive");
		this.costoOrario = costoOrario;
		this.prenotazioni = new Vector<Prenotazione>();
	}

	public String getNumero()
	{
		return numero;
	}

	public int getCapienzaMassima()
	{
		return capienzaMassima;
	}

	public double getCostoOrario()
	{
		return costoOrario;
	}
	
	public int getPostiDisponibili(Prenotazione prenotazione)
	{
		int postiDisponibili = this.capienzaMassima;
		for(Prenotazione p : this.prenotazioni)
			if(!prenotazione.getDal().isAfter(p.getAl()) && !prenotazione.getAl().isBefore(p.getDal()))
				postiDisponibili -= p.getPostiOccupati();
		return postiDisponibili;
	}
	
	public void addPrenotazione(Prenotazione prenotazione)
	{
		if(prenotazione.getPostiOccupati() > this.getPostiDisponibili(prenotazione))
			throw new IllegalArgumentException("Non ci sono abbastanza posti disponibili");
		prenotazione.setSauna(this);
		this.prenotazioni.addElement(prenotazione);
	}

	public Vector<Prenotazione> getPrenotazioni()
	{
		return prenotazioni;
	}

	@Override public String toString()
	{
		return "Sauna [numero=" + numero + ", capienzaMassima="
				+ capienzaMassima + ", costoOrario=" + costoOrario
				+ ", numero prenotazioni=" + prenotazioni.size() + "]";
	}
}
