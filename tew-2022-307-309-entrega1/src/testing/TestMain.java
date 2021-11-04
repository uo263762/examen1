package testing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.tew_entrega.infrastructure.Factories;
import com.tew_entrega.model.Agente;
import com.tew_entrega.model.Cliente;
import com.tew_entrega.model.Piso;
import com.tew_entrega.model.PisoParaVisitar;
import com.tew_entrega.persistence.templates.Agente_DAO;
import com.tew_entrega.persistence.templates.Cliente_DAO;
import com.tew_entrega.persistence.templates.PisoParaVisitar_DAO;
import com.tew_entrega.persistence.templates.Piso_DAO;

public class TestMain {

	public static void main(String[] args) throws Exception {
		
		
		
		
		int id = 1;
		String login = "login_test";
		String password = "password_test";
		String nombre = "nombre_test";
		String apellidos = "apellidos_test";
		String email = "email_test";
		
		float precio = 99999;
		String direccion = "direccion_test";
		String ciudad = "ciudad_test";
		int ano = 1970;
		int estado = 4;
		
		int id_cliente = 2;
		int id_piso = 2;
		long fecha_hora_cita = 231414125;
		int estado_visita = 3;
		int id_ppv=99;
		/*
		List<Piso> pisos = Factories.persistance.createPisoPERSISTANCE().getPisosFiltroCIUDAD("vie");
		
		for (Piso p : pisos) System.out.print(p.getCiudad());
		
		
		
		String x = "1086073200000";

		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		long milliSeconds= Long.parseLong(x);
		System.out.println(milliSeconds);

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSeconds);
		System.out.println(formatter.format(calendar.getTime())); 
		
		/*
		
		List<Piso> pisos = 
				Factories.persistance.createPisoPERSISTANCE().getPisosFiltroPRECIO(211999,999999);
		
		for (Piso p : pisos) System.out.println(p.getPrecio());
		
		
		/*
		///////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////
		System.out.println("AGENTE");
		Agente_DAO a = Factories.persistance.createAgentePERSISTANCE();
		System.out.println("####################");
		for (Agente au1 : a.getAgentes()) System.out.println(au1.login);
		
		Agente aux = new Agente();
		aux.setId(id);
		aux.setLogin(login+"_agente");
		aux.setPassword(password);
		
		a.save(aux);
		System.out.println("####################");
		for (Agente au2 : a.getAgentes()) System.out.println(au2.login);
		
		aux.setLogin(login + "_updated");
		a.update(aux);
		System.out.println("####################");
		for (Agente au3 : a.getAgentes()) System.out.println(au3.login);
		
		aux = a.findById(aux.getId());
		System.out.println("####################");
		System.out.println(aux);
		
		//a.delete(aux);
		System.out.println("####################");
		for (Agente au4 : a.getAgentes()) System.out.println(au4.login);
		
		//////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////
		System.out.println("CLIENTE");
		Cliente_DAO c = Factories.persistance.createClientePERSISTANCE();
		
		System.out.println("####################");
		for (Cliente au1 : c.getClientes()) System.out.println(au1.login);
		
		Cliente aux_p = new Cliente();
		aux_p.setId(id);
		aux_p.setLogin(login+"_cliente");
		aux_p.setPassword(password);
		aux_p.setApellidos(apellidos);
		aux_p.setNombre(nombre);
		aux_p.setEmail(email);
		
		c.save(aux_p);
		System.out.println("####################");
		for (Cliente au2 : c.getClientes()) System.out.println(au2.login);
		
		aux_p.setLogin(login + "_updated");
		c.update(aux_p);
		System.out.println("####################");
		for (Cliente au3 : c.getClientes()) System.out.println(au3.login);
		
		aux_p = c.findById(aux_p.getId());
		System.out.println("####################");
		System.out.println(aux_p);
		
		c.delete(aux_p);
		System.out.println("####################");
		for (Cliente au4 : c.getClientes()) System.out.println(au4.login);
		
		//////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////
		System.out.println("PISO");
		Piso_DAO p = Factories.persistance.createPisoPERSISTANCE();
		System.out.println("####################");
		for (Piso au1 : p.getPisos()) System.out.println(au1.getDireccion());
		
		Piso aux_p1 = new Piso();
		int agente_id = 2;
		id = 21;
		aux_p1.setId(id);
		aux_p1.setId_agente(agente_id);
		aux_p1.setPrecio(precio);
		aux_p1.setDireccion(direccion);
		aux_p1.setCiudad(ciudad);
		aux_p1.setAno(ano);
		aux_p1.setEstado(estado);
		
		p.save(aux_p1);
		System.out.println("####################");
		for (Piso au2 : p.getPisos()) System.out.println(au2.getDireccion());
		
		aux_p1.setDireccion(direccion+"_updated");
		p.update(aux_p1);
		System.out.println("####################");
		for (Piso au3 : p.getPisos()) System.out.println(au3.getDireccion());
		
		aux_p1 = p.findById(aux_p1.getId());
		System.out.println("####################");
		System.out.println(aux_p1);
		
		//p.delete(aux_p1);
		System.out.println("####################");
		for (Piso au4 : p.getPisos()) System.out.println(au4.getDireccion());
		
		///////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////
		System.out.println("PISO_PARA_VISITAR");
		
		PisoParaVisitar_DAO ppv = Factories.persistance.createPisoParaVisitarPERSISTANCE();
		System.out.println("####################");
		for (PisoParaVisitar au1 : ppv.getPisosParaVisitar()) System.out.println(au1.getFecha_hora_cita());
		
		PisoParaVisitar aux_p11 = new PisoParaVisitar();
		
		aux_p11.setId(id_ppv);
		aux_p11.setId_piso(id_piso);
		aux_p11.setId_cliente(id_cliente);
		aux_p11.setFecha_hora_cita(fecha_hora_cita);
		aux_p11.setEstado_visita(estado_visita);

		
		ppv.save(aux_p11);
		System.out.println("####################");
		for (PisoParaVisitar au2 : ppv.getPisosParaVisitar()) System.out.println(au2.getFecha_hora_cita());
		
		ppv.update(aux_p11);
		System.out.println("####################");
		for (PisoParaVisitar au3 : ppv.getPisosParaVisitar()) System.out.println(au3.getFecha_hora_cita());
		
		aux_p11 = ppv.findById(aux_p11.getId());
		System.out.println("####################");
		System.out.println(aux_p11);
		
		ppv.delete(aux_p11);
		System.out.println("####################");
		for (PisoParaVisitar au4 : ppv.getPisosParaVisitar()) System.out.println(au4.getFecha_hora_cita());
		*/
		Factories.persistance.createAgentePERSISTANCE().borrar_todo();
		

	}

}
