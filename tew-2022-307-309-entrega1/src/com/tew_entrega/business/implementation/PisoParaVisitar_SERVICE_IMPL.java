package com.tew_entrega.business.implementation;

import java.util.List;

import com.tew_entrega.business.templates.PisoParaVisitar_SERVICE;
import com.tew_entrega.infrastructure.Factories;
import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Cliente;
import com.tew_entrega.model.Piso;
import com.tew_entrega.model.PisoParaVisitar;

public class PisoParaVisitar_SERVICE_IMPL implements PisoParaVisitar_SERVICE {

	public PisoParaVisitar_SERVICE_IMPL() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PisoParaVisitar> getPisosParaVisitar() throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createPisoParaVisitarPERSISTANCE().getPisosParaVisitar();
	}

	@Override
	public boolean save(PisoParaVisitar ppv) throws Exception {
		// TODO Auto-generated method stub
		
		// Comprobamos si ya el cliente ya ha pedido cita antes para el piso.
		List<PisoParaVisitar> pisos_para_visitar = Factories.persistance.createPisoParaVisitarPERSISTANCE().getPisosParaVisitar();
		for (PisoParaVisitar _ppv : pisos_para_visitar) {
			if (_ppv.getId_cliente() == ppv.getId_cliente() && _ppv.getId_piso() == ppv.getId_piso()) return false;
		}
		Factories.persistance.createPisoParaVisitarPERSISTANCE().save(ppv);
		return true;
	}

	@Override
	public boolean update(PisoParaVisitar ppv) throws Exception {
		// TODO Auto-generated method stub
		Factories.persistance.createPisoParaVisitarPERSISTANCE().update(ppv);
		return true;
	}

	@Override
	public boolean delete(PisoParaVisitar ppv) throws Exception {
		// TODO Auto-generated method stub
		Factories.persistance.createPisoParaVisitarPERSISTANCE().delete(ppv);
		return true;
	}

	@Override
	public PisoParaVisitar findById(int id) throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createPisoParaVisitarPERSISTANCE().findById(id);
	}

	@Override
	public List<PisoParaVisitar> getPisosParaVisitarFiltroHora(long hora_inferior, long hora_superior)
			throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createPisoParaVisitarPERSISTANCE().getPisosParaVisitarFiltroHora(hora_inferior, hora_superior);
	}

	@Override
	public List<PisoParaVisitar> getPisosParaVisitarFiltroCliente(Cliente c) throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createPisoParaVisitarPERSISTANCE().getPisosParaVisitarFiltroCliente(c);
	}

	@Override
	public List<PisoParaVisitar> getPisosParaVisitarFiltroAgente(Agente a) throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createPisoParaVisitarPERSISTANCE().getPisosParaVisitarFiltroAgente(a);
	}

	@Override
	public List<PisoParaVisitar> getPisosParaVisitarFiltroPiso(Piso p) throws Exception {
		// TODO Auto-generated method stub
		return Factories.persistance.createPisoParaVisitarPERSISTANCE().getPisosParaVisitarFiltroPiso(p);
	}

}
