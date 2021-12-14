package com.tew.model;

public class PisoParaVisitar {

	private Long idPiso;
	private Long idCliente;
	private Long fechaHoraCita;
	private int estado;

	public Long getidPiso() {
		return idPiso;
	}

	public void setidPiso(Long p) {
		this.idPiso = p;
	}

	public Long getidCliente() {
		return idCliente;
	}

	public void setidCliente(Long c) {
		this.idCliente = c;
	}

	public long getFechaHoraCita() {
		return fechaHoraCita;
	}

	public void setFechaHoraCita(long fechaHoraCita) {
		this.fechaHoraCita = fechaHoraCita;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
