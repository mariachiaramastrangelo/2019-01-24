package it.polito.tdp.extflightdelays.model;

public class Evento implements Comparable<Evento>{
	private int giorno; //giorno
	private String paese; //paese dove si trovano tot turisti 
	private int numeroTuristi; //numero turisti nel paese al giorno
	
	
	public Evento(int giorno, String paese, int numeroTuristi) {
		super();
		this.giorno = giorno;
		this.paese = paese;
		this.numeroTuristi = numeroTuristi;
	}
	public int getGiorno() {
		return giorno;
	}
	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}
	public String getPaese() {
		return paese;
	}
	public void setPaese(String paese) {
		this.paese = paese;
	}
	public int getNumeroTuristi() {
		return numeroTuristi;
	}
	public void setNumeroTuristi(int numeroTuristi) {
		this.numeroTuristi = numeroTuristi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + giorno;
		result = prime * result + numeroTuristi;
		result = prime * result + ((paese == null) ? 0 : paese.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (giorno != other.giorno)
			return false;
		if (numeroTuristi != other.numeroTuristi)
			return false;
		if (paese == null) {
			if (other.paese != null)
				return false;
		} else if (!paese.equals(other.paese))
			return false;
		return true;
	}
	@Override
	public int compareTo(Evento o) {
		return this.giorno-o.getGiorno();
	}
	
	

	
	
}
