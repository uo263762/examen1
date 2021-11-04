package com.tew_entrega.persistence;

import com.tew_entrega.persistence.jdbc.Agente_JDBC_DAO;
import com.tew_entrega.persistence.jdbc.Cliente_JDBC_DAO;
import com.tew_entrega.persistence.jdbc.PisoParaVisitar_JDBC_DAO;
import com.tew_entrega.persistence.jdbc.Piso_JDBC_DAO;
import com.tew_entrega.persistence.templates.Agente_DAO;
import com.tew_entrega.persistence.templates.Cliente_DAO;
import com.tew_entrega.persistence.templates.PisoParaVisitar_DAO;
import com.tew_entrega.persistence.templates.Piso_DAO;

public class Persistance_FACTORY_IMPL implements Persistance_FACTORY {

	public Persistance_FACTORY_IMPL() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Agente_DAO createAgentePERSISTANCE() {
		// TODO Auto-generated method stub
		return new Agente_JDBC_DAO();
	}

	@Override
	public Cliente_DAO createClientePERSISTANCE() {
		// TODO Auto-generated method stub
		return new Cliente_JDBC_DAO();
	}

	@Override
	public Piso_DAO createPisoPERSISTANCE() {
		// TODO Auto-generated method stub
		return new Piso_JDBC_DAO();
	}

	@Override
	public PisoParaVisitar_DAO createPisoParaVisitarPERSISTANCE() {
		// TODO Auto-generated method stub
		return new PisoParaVisitar_JDBC_DAO();
	}

}