package com.tew_entrega.presentation;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.tew_entrega.business.templates.PisoParaVisitar_SERVICE;
import com.tew_entrega.business.templates.Piso_SERVICE;
import com.tew_entrega.infrastructure.Factories;
import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Cliente;
import com.tew_entrega.model.Piso;
import com.tew_entrega.model.PisoParaVisitar;

@ManagedBean(name="PisosParaVisitar_BEAN")
@SessionScoped
public class PisosParaVisitar_BEAN implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public PisosParaVisitar_BEAN() {
		// TODO Auto-generated constructor stub
	}
	
	@ManagedProperty(value="#{PisoParaVisitar_BEAN}")
	PisoParaVisitar_BEAN piso_para_visitar;
	
	
	public PisoParaVisitar_BEAN getPiso_para_visitar() {
		return piso_para_visitar;
	}


	public void setPiso_para_visitar(PisoParaVisitar_BEAN piso_para_visitar) {
		this.piso_para_visitar = piso_para_visitar;
	}

	List<PisoParaVisitar> pisos_para_visitar;

	public List<PisoParaVisitar> getPisos_para_visitar() {
		return pisos_para_visitar;
	}

	public void setPisos_para_visitar(List<PisoParaVisitar> pisos_para_visitar) {
		this.pisos_para_visitar = pisos_para_visitar;
	}


	public String listado() {
		PisoParaVisitar_SERVICE service = Factories.services.createPisoParaVisitarSERVICE();
		List<PisoParaVisitar> pisos_para_visitar = null;
		try {
			pisos_para_visitar = service.getPisosParaVisitar();
			this.pisos_para_visitar = pisos_para_visitar;
		} catch (Exception e) {e.printStackTrace();}
		return "EXITO";
	}
	
	public String listadoFiltroAgente() {
		PisoParaVisitar_SERVICE service = Factories.services.createPisoParaVisitarSERVICE();
		List<PisoParaVisitar> pisos_para_visitar = null;
		try {
			Agente a = new Agente();
			a.setId(getAgenteId());
			pisos_para_visitar = service.getPisosParaVisitarFiltroAgente(a);
			this.pisos_para_visitar = pisos_para_visitar;
		} catch (Exception e) {e.printStackTrace();}
		return "EXITO";
	}
	
	public String listadoFiltroCliente() {
		PisoParaVisitar_SERVICE service = Factories.services.createPisoParaVisitarSERVICE();
		List<PisoParaVisitar> pisos_para_visitar = null;
		try {
			Cliente c = new Cliente();
			c.setId(getClienteId());
			pisos_para_visitar = service.getPisosParaVisitarFiltroCliente(c);
			this.pisos_para_visitar = pisos_para_visitar;
		} catch (Exception e) {e.printStackTrace();}
		return "EXITO";
	}
	
	public String listadoFiltroPiso(Piso p) {
		PisoParaVisitar_SERVICE service = Factories.services.createPisoParaVisitarSERVICE();
		List<PisoParaVisitar> pisos_para_visitar = null;
		try {
			pisos_para_visitar = service.getPisosParaVisitarFiltroPiso(p);
			this.pisos_para_visitar = pisos_para_visitar;
		} catch (Exception e) {e.printStackTrace();}
		return "EXITO";
	}
	
	public String listadoFiltroHora(long hora_inferior, long hora_superior) {
		PisoParaVisitar_SERVICE service = Factories.services.createPisoParaVisitarSERVICE();
		List<PisoParaVisitar> pisos_para_visitar = null;
		try {
			pisos_para_visitar = service.getPisosParaVisitarFiltroHora(hora_inferior, hora_superior);
			this.pisos_para_visitar = pisos_para_visitar;
		} catch (Exception e) {e.printStackTrace();}
		return "EXITO";
	}
	
	public String pedirCita(Piso p) {
		PisoParaVisitar_SERVICE service = Factories.services.createPisoParaVisitarSERVICE();
		boolean resultado = false;
		try {
			PisoParaVisitar ppv = new PisoParaVisitar();
			ppv.setId_piso(p.getId());
			ppv.setId_cliente(this.getClienteId());
			ppv.setFecha_hora_cita(System.currentTimeMillis());
			ppv.setEstado_visita(1);
			resultado = service.save(ppv);
			this.listado();
		} catch (Exception e) {e.printStackTrace();}
		return resultado ? "EXITO" : "ERROR";
		
	}
	
	public String confirmarCitaAgente() {
		PisoParaVisitar_SERVICE service = Factories.services.createPisoParaVisitarSERVICE();
		Boolean resultado = false;
		try {
			// En este proceso, no hace falta obtener ningun id, pero si hay que mirar que no estemos sobreeescribeindo una cita ya definida mas haya del nivel 2.
			if (this.piso_para_visitar.getEstado_visita()>=2) return "EXITO"; // Si la cita esta en un estado mayor que 2, desechamos la operacion CRUD, pero seguimos adealnte.
			this.piso_para_visitar.setEstado_visita(2);
			if (this.piso_para_visitar.getId() == null) resultado = service.save(this.piso_para_visitar);
			if (this.piso_para_visitar.getId() != null) resultado = service.update(this.piso_para_visitar);
			this.listadoFiltroAgente();
		} catch (Exception e) {e.printStackTrace();}
		return resultado ? "EXITO" : "ERROR";
	}
	
	public String confirmarCitaCliente() {
		PisoParaVisitar_SERVICE service = Factories.services.createPisoParaVisitarSERVICE();
		Boolean resultado = false;
		try {
			// En este proceso, no hace falta obtener ningun id, pero si hay que mirar que no estemos sobreeescribeindo una cita ya definida mas haya del nivel 2.
			if (this.piso_para_visitar.getEstado_visita() < 2) return "EXITO"; // Si la cita esta en un estado mayor que 2, desechamos la operacion CRUD, pero seguimos adealnte.
			this.piso_para_visitar.setEstado_visita(3);
			resultado = service.delete(this.piso_para_visitar);
			this.listadoFiltroCliente();
		} catch (Exception e) {e.printStackTrace();}
		return resultado ? "EXITO" : "ERROR";
	}
	
	public String confirmarCitaCliente(PisoParaVisitar ppv) {
		PisoParaVisitar_SERVICE service = Factories.services.createPisoParaVisitarSERVICE();
		Boolean resultado = false;
		try {
			// En este proceso, no hace falta obtener ningun id, pero si hay que mirar que no estemos sobreeescribeindo una cita ya definida mas haya del nivel 2.
			if (ppv.getEstado_visita() < 2) return "EXITO"; // Si la cita esta en un estado mayor que 2, desechamos la operacion CRUD, pero seguimos adealnte.
			ppv.setEstado_visita(3);
			resultado = service.delete(ppv);
			this.listadoFiltroCliente();
		} catch (Exception e) {e.printStackTrace();}
		return resultado ? "EXITO" : "ERROR";
	}

	public String borrar(PisoParaVisitar ppv) {
		PisoParaVisitar_SERVICE service = Factories.services.createPisoParaVisitarSERVICE();
		Boolean resultado = false;
		try {
			resultado = service.delete(ppv);
			this.listado();
		} catch (Exception e) {e.printStackTrace();}
		return resultado ? "EXITO" : "ERROR";
	}
	
	//Este metodo, es un metodo observador.
	// Salvar mira si tiene que actualizar o crear un piso nuevo
	public String salvar() {
		PisoParaVisitar_SERVICE service = Factories.services.createPisoParaVisitarSERVICE();
		Boolean resultado = false;
		try {
			// En este proceso, no hace falta obtener ningun id, pues las citas no se crean
			this.piso_para_visitar.setId_cliente(getClienteId());
			if (this.piso_para_visitar.getId() == null) resultado = service.save(this.piso_para_visitar);
			if (this.piso_para_visitar.getId() != null) resultado = service.update(this.piso_para_visitar);
			this.listado();
		} catch (Exception e) {e.printStackTrace();}
		return resultado ? "EXITO" : "ERROR";
	}
	
	private int getClienteId() {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Cliente cliente = (Cliente) session.get("USUARIO");
		return cliente.getId();
	}
	
	private int getAgenteId() {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Agente agente = (Agente) session.get("USUARIO");
		return agente.getId();
	}
	
	@PostConstruct
	public void init() {
		
		this.piso_para_visitar = (PisoParaVisitar_BEAN) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PisoParaVisitar_BEAN");
		if (this.piso_para_visitar == null) this.piso_para_visitar = new PisoParaVisitar_BEAN(); FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PisoParaVisitar_BEAN", this.piso_para_visitar);
		
	}
}
