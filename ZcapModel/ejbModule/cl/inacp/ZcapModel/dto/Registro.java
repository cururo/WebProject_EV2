package cl.inacp.ZcapModel.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Registro {
	private int rut;
	private String nombre;
	private String tipoSolicitud;
    private AtomicInteger num;
	private static List<Registro> registro = new ArrayList<>();
	



	public int getNum() {
		return num.getAndIncrement();
	}


	public void setNum(AtomicInteger num) {
		this.num = num;
	}


	public int getRut() {
		return rut;
	}


	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public static List<Registro> getRegistro() {
		return registro;
	}

	public static void setRegistro(List<Registro> registro) {
		Registro.registro = registro;
	}




}
