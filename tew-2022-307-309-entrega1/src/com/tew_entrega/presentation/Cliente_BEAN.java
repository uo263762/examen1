package com.tew_entrega.presentation;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tew_entrega.business.templates.Cliente_SERVICE;
import com.tew_entrega.business.templates.Piso_SERVICE;
import com.tew_entrega.infrastructure.Factories;
import com.tew_entrega.model.Cliente;

@ManagedBean(name="Cliente_BEAN")
@SessionScoped
public class Cliente_BEAN extends Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	public Cliente_BEAN() {
		iniciaCliente(null);
	}
	
	public void iniciaCliente(ActionEvent event) {
		FacesContext fc = FacesContext.getCurrentInstance();
		ResourceBundle bundle = fc.getApplication().getResourceBundle(fc, "msgs");
		this.setLogin(bundle.getString("default_cliente_login"));
		this.setPassword(bundle.getString("default_cliente_password"));
		this.setNombre(bundle.getString("default_cliente_nombre"));
		this.setApellidos(bundle.getString("default_cliente_apellidos"));
		this.setEmail(bundle.getString("default_cliente_email"));
	}
	
	public void setCliente(Cliente cliente) {
		this.setId(cliente.getId());
		this.setLogin(cliente.getLogin());
		this.setPassword(cliente.getPassword());
		this.setNombre(cliente.getNombre());
		this.setApellidos(cliente.getApellidos());
		this.setEmail(cliente.getApellidos());
	}
	
	public String salvar() {
		Cliente_SERVICE service = Factories.services.createClienteSERVICE();
		Boolean resultado = false;
		try {
			if (this.getId() == null) resultado = service.save(this);
			if (this.getId() != null) resultado = service.update(this);
			//this.listado();
		} catch (Exception e) {e.printStackTrace();}
		return resultado ? "EXITO" : "ERROR";
	}

}
