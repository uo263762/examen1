package com.tew_entrega.business;

import com.tew_entrega.business.templates.Agente_SERVICE;
import com.tew_entrega.business.templates.Cliente_SERVICE;
import com.tew_entrega.business.templates.Login_SERVICE;
import com.tew_entrega.business.templates.PisoParaVisitar_SERVICE;
import com.tew_entrega.business.templates.Piso_SERVICE;

public interface Busniess_FACTORY {
	
	// Aqui van los servicios fachada que ofrecemos.
	
	Agente_SERVICE createAgenteSERVICE();
	Cliente_SERVICE createClienteSERVICE();
	Piso_SERVICE createPisoSERVICE();
	PisoParaVisitar_SERVICE createPisoParaVisitarSERVICE();
	Login_SERVICE cretaeLoginSERVICE();
	
}
