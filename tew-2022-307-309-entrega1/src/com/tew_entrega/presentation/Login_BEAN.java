package com.tew_entrega.presentation;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.tew_entrega.business.templates.Login_SERVICE;
import com.tew_entrega.infrastructure.Factories;
import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Cliente;
import com.tew_entrega.model.Usuario;



@ManagedBean(name="Login_BEAN")
@SessionScoped
public class Login_BEAN implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String login;
	
	private String password;

	private Usuario usuario = null;
	
	public Login_BEAN() {
		// TODO Auto-generated constructor stub
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String check_login() {
		
		Login_SERVICE service = Factories.services.cretaeLoginSERVICE();
		
		Usuario usuario = service.getLogin(login, password);
		
		if (usuario == null) {
			
			System.out.println("LOGOUT USUARIO_NULO-->" + usuario);
			
			return "USUARIO_NULO";
		} else {
			
			this.usuario = usuario;
			
			this.addUserToSession(usuario);
			
			if (usuario instanceof Agente) return "EXITO_AGENTE";
			if (usuario instanceof Cliente) return "EXITO_CLIENTE";
			
			return "EXITO";
		}
	}
	
	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		if (this.usuario == null) {
			System.out.println("LOGOUT ERROR -->" + usuario);
			return "ERROR";
		} else {
			System.out.println("LOGOUT EXITO -->" + usuario);
			this.removeUserFromSession(this.usuario);
			return "LOGOUT";
		}
		
	}

	private void addUserToSession(Usuario usuario) {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("USUARIO", usuario);
	}
	
	private void removeUserFromSession(Usuario usuario) {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.remove("USUARIO", usuario);
	}
	
	public void printCookies() {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		for (Map.Entry<String, Object> entry : session.entrySet()) {
		    System.out.println(entry.getKey() + "----" + entry.getValue());
		}
	}
	
	public String reset_base_de_datos() {
		try {
			Factories.services.createAgenteSERVICE().borrar_todo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return logout();
	}
	

	
}