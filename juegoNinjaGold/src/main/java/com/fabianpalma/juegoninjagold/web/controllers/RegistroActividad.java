package com.fabianpalma.juegoninjagold.web.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroActividad {
	private String lugar;
	private int oro;
	private String tiempo;

	public RegistroActividad(String lugar, int oro, String tiempo) {
		this.lugar = lugar;
		this.oro = oro;
		this.tiempo = tiempo;
	}

	public String getTiempoFormatted() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM, d yyyy h:mm a");
		LocalDateTime dateTime = LocalDateTime.parse(tiempo);
		return dateTime.format(formatter);
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
}
