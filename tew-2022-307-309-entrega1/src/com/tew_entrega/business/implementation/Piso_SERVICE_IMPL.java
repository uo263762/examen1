package com.tew_entrega.business.implementation;

import java.util.List;

import com.tew_entrega.business.templates.Piso_SERVICE;
import com.tew_entrega.infrastructure.Factories;
import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Piso;
import com.tew_entrega.persistence.Persistance_FACTORY;
import com.tew_entrega.persistence.templates.Piso_DAO;

public class Piso_SERVICE_IMPL implements Piso_SERVICE {

	public Piso_SERVICE_IMPL() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Piso> getPisos() throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createPisoPERSISTANCE().getPisos();
	}

	@Override
	public boolean save(Piso p) throws Exception {
		// TODO Auto-generated method stub
		Factories.persistance.createPisoPERSISTANCE().save(p);
		return true;
	}

	@Override
	public boolean update(Piso p) throws Exception {
		// TODO Auto-generated method stub
		Factories.persistance.createPisoPERSISTANCE().update(p);
		return true;
	}

	@Override
	public boolean delete(Piso p) throws Exception {
		// TODO Auto-generated method stub
		Factories.persistance.createPisoPERSISTANCE().delete(p);
		return true;
	}

	@Override
	public Piso findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createPisoPERSISTANCE().findById(id);
	}

	@Override
	public List<Piso> getPisosFiltroCIUDAD(String filtro) throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createPisoPERSISTANCE().getPisosFiltroCIUDAD(filtro);
	}

	@Override
	public List<Piso> getPisosFiltroPRECIO(float precio_inferior, float precio_superior) throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createPisoPERSISTANCE().getPisosFiltroPRECIO(precio_inferior, precio_superior);
	}

}
