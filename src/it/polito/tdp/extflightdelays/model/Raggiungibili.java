package it.polito.tdp.extflightdelays.model;

public class Raggiungibili implements Comparable<Raggiungibili>{
	
	private String arrivo;
	private int peso;
	public Raggiungibili(String arrivo, int peso) {
		super();
		this.arrivo = arrivo;
		this.peso = peso;
	}
	public String getArrivo() {
		return arrivo;
	}
	public void setArrivo(String arrivo) {
		this.arrivo = arrivo;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivo == null) ? 0 : arrivo.hashCode());
		result = prime * result + peso;
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
		Raggiungibili other = (Raggiungibili) obj;
		if (arrivo == null) {
			if (other.arrivo != null)
				return false;
		} else if (!arrivo.equals(other.arrivo))
			return false;
		if (peso != other.peso)
			return false;
		return true;
	}
	@Override
	public int compareTo(Raggiungibili o) {
		// TODO Auto-generated method stub
		return -(this.peso-o.peso);
	}
	@Override
	public String toString() {
		return arrivo + " " + peso;
	}
	
	
	

}
