package gestionepalestra;

import java.time.*;

public class Prenotazione
{
	private int postiOccupati;
	private LocalDateTime dal;
	private LocalDateTime al;
	private Cliente cliente;
	private Sauna sauna;
	
	public Prenotazione(int postiOccupati, LocalDateTime dal, LocalDateTime al, Cliente cliente)
	{
		if(postiOccupati <= 0)
			throw new IllegalArgumentException("PostiOccupati must be positive");
		this.postiOccupati = postiOccupati;
		if(al.isBefore(dal) || al.equals(dal))
			throw new IllegalArgumentException("Al deve essere dopo Dal");
		if(dal == null)
			throw new IllegalArgumentException("Dal cannot be null");
		this.dal = dal;
		if(al == null)
			throw new IllegalArgumentException("Al cannot be null");
		this.al = al;
		if(cliente == null)
			throw new IllegalArgumentException("Cliente cannot be null");
		this.cliente = cliente;
	}

	public Sauna getSauna()
	{
		return sauna;
	}

	public void setSauna(Sauna sauna)
	{
		if(sauna == null)
			throw new IllegalArgumentException("Sauna cannot be null");
		this.sauna = sauna;
	}

	public int getPostiOccupati()
	{
		return postiOccupati;
	}

	public LocalDateTime getDal()
	{
		return dal;
	}

	public LocalDateTime getAl()
	{
		return al;
	}

	public Cliente getCliente()
	{
		return cliente;
	}
	
	public double getNumeroOre()
	{
		double numeroOre = 0;
		Duration duration = Duration.between(dal, al);
		numeroOre = duration.getSeconds()/3600;
		return numeroOre;
	}
	
	public double getRicavoTotale()
	{
		double ricavoTotale = 0;
		ricavoTotale = sauna.getCostoOrario()*this.getNumeroOre();
		return ricavoTotale;
	}

	@Override public String toString()
	{
		return "Prenotazione [postiOccupati=" + postiOccupati + ", dal=" + dal
				+ ", al=" + al + ", cliente=" + cliente + ", sauna=" + sauna
				+ "]";
	}
}