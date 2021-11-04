package com.tew_entrega.business.implementation;

import java.util.ArrayList;
import java.util.List;

import com.tew_entrega.business.templates.Cliente_SERVICE;
import com.tew_entrega.infrastructure.Factories;
import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Cliente;
import com.tew_entrega.model.Piso;
import com.tew_entrega.model.Usuario;

public class Cliente_SERVICE_IMPL implements Cliente_SERVICE {

	public Cliente_SERVICE_IMPL() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Cliente> getClientes() throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createClientePERSISTANCE().getClientes();
	}

	@Override
	public boolean save(Cliente c) throws Exception {
		// TODO Auto-generated method stub
		
		// No pueden existir dos usuarios con el mismo login.
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.addAll(Factories.persistance.createAgentePERSISTANCE().getAgentes());
		usuarios.addAll(Factories.persistance.createClientePERSISTANCE().getClientes());
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(c.getLogin())) return false;
		}
		Factories.persistance.createClientePERSISTANCE().save(c);
		return true;
	}

	@Override
	public boolean update(Cliente c) throws Exception {
		// TODO Auto-generated method stub
		Factories.persistance.createClientePERSISTANCE().update(c);
		return true;
	}

	@Override
	public boolean delete(Cliente c) throws Exception {
		// TODO Auto-generated method stub
		Factories.persistance.createClientePERSISTANCE().delete(c);
		return true;
	}

	@Override
	public Cliente findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createClientePERSISTANCE().findById(id);
	}


}
