package com.tew_entrega.business.implementation;

import java.util.List;

import com.tew_entrega.business.templates.Login_SERVICE;
import com.tew_entrega.infrastructure.Factories;
import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Cliente;
import com.tew_entrega.model.Usuario;
import com.tew_entrega.persistence.templates.Agente_DAO;
import com.tew_entrega.persistence.templates.Cliente_DAO;

public class Login_SERVICE_IMPL implements Login_SERVICE {

	public Login_SERVICE_IMPL() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario getLogin(String login, String password) {
		// TODO Auto-generated method stub
		Cliente_DAO service_cliente = Factories.persistance.createClientePERSISTANCE();
		Agente_DAO service_agente = Factories.persistance.createAgentePERSISTANCE();
		
		try {
			
			// Miramos si existe como cliente.
			List<Cliente> clientes = service_cliente.getClientes();
			for (Cliente cliente : clientes) {
				if (cliente.getLogin().equals(login) && cliente.getPassword().equals(password)) {
					return cliente;
				}
			}
			
			// Miramos si existe como agente.
			List<Agente> agentes = service_agente.getAgentes();
			for (Agente agente : agentes) {
				if (agente.getLogin().equals(login) && agente.getPassword().equals(password)) {
					return agente;
				}
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		// Si no existe ni como cliente ni como agente, devolvemos un objeto null.
		return null;
		
	}

}
