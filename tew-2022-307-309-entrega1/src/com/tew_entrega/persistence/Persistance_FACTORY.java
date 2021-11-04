package com.tew_entrega.persistence;

import com.tew_entrega.persistence.templates.Agente_DAO;
import com.tew_entrega.persistence.templates.Cliente_DAO;
import com.tew_entrega.persistence.templates.PisoParaVisitar_DAO;
import com.tew_entrega.persistence.templates.Piso_DAO;

public interface Persistance_FACTORY {

	Agente_DAO createAgentePERSISTANCE();
	Cliente_DAO createClientePERSISTANCE();
	Piso_DAO createPisoPERSISTANCE();
	PisoParaVisitar_DAO createPisoParaVisitarPERSISTANCE();

}
