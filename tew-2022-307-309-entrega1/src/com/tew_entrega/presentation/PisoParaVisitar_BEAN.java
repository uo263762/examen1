package com.tew_entrega.presentation;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tew_entrega.business.templates.PisoParaVisitar_SERVICE;
import com.tew_entrega.business.templates.Piso_SERVICE;
import com.tew_entrega.infrastructure.Factories;
import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Cliente;
import com.tew_entrega.model.Piso;
import com.tew_entrega.model.PisoParaVisitar;

@ManagedBean(name="PisoParaVisitar_BEAN")
@SessionScoped
public class PisoParaVisitar_BEAN extends PisoParaVisitar implements Serializable {

	private static final long serialVersionUID = 1L;

	public PisoParaVisitar_BEAN() {
		iniciaPisoParaVisitar(null);
	}

	public void iniciaPisoParaVisitar(ActionEvent event) {
		this.setId_piso(0);
		this.setId_cliente(0);
		this.setFecha_hora_cita(System.currentTimeMillis());
		this.setEstado_visita(0);
	}
	
	public void setPisoParaVisitar(PisoParaVisitar ppv) {
		this.setId(ppv.getId());
		this.setId_piso(ppv.getId_piso());
		this.setId_cliente(ppv.getId_cliente());
		this.setFecha_hora_cita(ppv.getFecha_hora_cita());
		this.setEstado_visita(ppv.getEstado_visita());
	}

	public String salvar(PisoParaVisitar ppv) {
		PisoParaVisitar_SERVICE service = Factories.services.createPisoParaVisitarSERVICE();
		Boolean resultado = false;
		try {
			// Añadimos el id del cliente que lo guarda.
			this.setId_cliente(getClienteId());
			if (this.getId() == null) resultado = service.save(this);
			if (this.getId() != null) resultado = service.update(this);
			//this.listado();
		} catch (Exception e) {e.printStackTrace();}
		return resultado ? "EXITO" : "ERROR";	
	}
	
	private int getClienteId() {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Cliente cliente = (Cliente) session.get("USUARIO");
		return cliente.getId();
	}
		
	
	


}
