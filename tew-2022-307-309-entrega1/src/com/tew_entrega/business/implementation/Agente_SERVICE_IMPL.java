package com.tew_entrega.business.implementation;

import java.util.ArrayList;
import java.util.List;

import com.tew_entrega.business.templates.Agente_SERVICE;
import com.tew_entrega.infrastructure.Factories;
import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Usuario;

public class Agente_SERVICE_IMPL implements Agente_SERVICE {

	public Agente_SERVICE_IMPL() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Agente> getAgentes() throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createAgentePERSISTANCE().getAgentes();
	}

	@Override
	public boolean save(Agente a) throws Exception {
		// TODO Auto-generated method stub
		
		// No pueden existir dos usuarios con el mismo login.
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.addAll(Factories.persistance.createAgentePERSISTANCE().getAgentes());
		usuarios.addAll(Factories.persistance.createClientePERSISTANCE().getClientes());
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(a.getLogin())) return false;
		}
		Factories.persistance.createAgentePERSISTANCE().save(a);
		return true;
		
	}

	@Override
	public boolean update(Agente a) throws Exception {
		// TODO Auto-generated method stub
		Factories.persistance.createAgentePERSISTANCE().update(a);
		return true;
	}

	@Override
	public boolean delete(Agente a) throws Exception {
		// TODO Auto-generated method stub
		Factories.persistance.createAgentePERSISTANCE().delete(a);
		return true;
	}

	@Override
	public Agente findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createAgentePERSISTANCE().findById(id);
	}

	@Override
	public void borrar_todo() throws Exception {
		// TODO Auto-generated method stub
		Factories.persistance.createAgentePERSISTANCE().borrar_todo();
	}
	

}
