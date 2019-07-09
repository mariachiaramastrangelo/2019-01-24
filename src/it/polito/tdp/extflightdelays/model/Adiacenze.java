package it.polito.tdp.extflightdelays.model;

public class Adiacenze {
	private String state1;
	private String state2;
	private int numeroVoli;
	
	
	public Adiacenze(String state1, String state2, int numeroVoli) {
		super();
		this.state1 = state1;
		this.state2 = state2;
		this.numeroVoli = numeroVoli;
	}
	
	public String getState1() {
		return state1;
	}
	public void setState1(String state1) {
		this.state1 = state1;
	}
	public String getState2() {
		return state2;
	}
	public void setState2(String state2) {
		this.state2 = state2;
	}
	public int getNumeroVoli() {
		return numeroVoli;
	}
	public void setNumeroVoli(int numeroVoli) {
		this.numeroVoli = numeroVoli;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state1 == null) ? 0 : state1.hashCode());
		result = prime * result + ((state2 == null) ? 0 : state2.hashCode());
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
		Adiacenze other = (Adiacenze) obj;
		if (state1 == null) {
			if (other.state1 != null)
				return false;
		} else if (!state1.equals(other.state1))
			return false;
		if (state2 == null) {
			if (other.state2 != null)
				return false;
		} else if (!state2.equals(other.state2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return state1 + " " + state2 + " " + numeroVoli;
	}
	
	

}
