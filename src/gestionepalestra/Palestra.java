package gestionepalestra;

import java.util.Vector;

public class Palestra
{
	private String nome;
	private Vector<Sauna> saune;
	
	public Palestra(String nome)
	{
		if(nome == null)
			throw new IllegalArgumentException("Nome cannot be null");
		this.nome = nome;
		this.saune = new Vector<Sauna>();
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void addSauna(Sauna sauna)
	{
		if(sauna == null)
			throw new IllegalArgumentException("Sauna cannot be null");
		this.saune.addElement(sauna);
	}
	
	public Vector<Sauna> getSaune()
	{
		return saune;
	}
	
	public Vector<Sauna> getSauneDisponibili(Prenotazione prenotazione)
	{
		Vector<Sauna> sauneDisponibili = new Vector<Sauna>();
		for(Sauna s : this.saune)
			if(s.getPostiDisponibili(prenotazione) >= prenotazione.getPostiOccupati())
				sauneDisponibili.addElement(s);
		return sauneDisponibili;
	}

	@Override public String toString()
	{
		return "Palestra [nome=" + nome + ", numero saune=" + saune.size() + "]";
	}
}