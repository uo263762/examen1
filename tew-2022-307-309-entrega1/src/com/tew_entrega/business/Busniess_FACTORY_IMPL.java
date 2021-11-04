package com.tew_entrega.business;

import com.tew_entrega.business.implementation.Agente_SERVICE_IMPL;
import com.tew_entrega.business.implementation.Cliente_SERVICE_IMPL;
import com.tew_entrega.business.implementation.Login_SERVICE_IMPL;
import com.tew_entrega.business.implementation.PisoParaVisitar_SERVICE_IMPL;
import com.tew_entrega.business.implementation.Piso_SERVICE_IMPL;
import com.tew_entrega.business.templates.Agente_SERVICE;
import com.tew_entrega.business.templates.Cliente_SERVICE;
import com.tew_entrega.business.templates.Login_SERVICE;
import com.tew_entrega.business.templates.PisoParaVisitar_SERVICE;
import com.tew_entrega.business.templates.Piso_SERVICE;

public class Busniess_FACTORY_IMPL implements Busniess_FACTORY {

	public Busniess_FACTORY_IMPL() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Agente_SERVICE createAgenteSERVICE() {
		// TODO Auto-generated method stub
		return new Agente_SERVICE_IMPL();
	}

	@Override
	public Cliente_SERVICE createClienteSERVICE() {
		// TODO Auto-generated method stub
		return new Cliente_SERVICE_IMPL();
	}

	@Override
	public Piso_SERVICE createPisoSERVICE() {
		// TODO Auto-generated method stub
		return new Piso_SERVICE_IMPL();
	}

	@Override
	public PisoParaVisitar_SERVICE createPisoParaVisitarSERVICE() {
		// TODO Auto-generated method stub
		return new PisoParaVisitar_SERVICE_IMPL();
	}
	
	@Override
	public Login_SERVICE cretaeLoginSERVICE() {
		// TODO Auto-generated method stub
		return new Login_SERVICE_IMPL();
	}

}
