package it.polito.tdp.extflightdelays.db;

public class TestDAO {

	public static void main(String[] args) {

		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
		//System.out.println(dao.loadAllStates());
		System.out.println(dao.listAllStates());
		System.out.println(dao.getAllAdiacenze());
	}

}
