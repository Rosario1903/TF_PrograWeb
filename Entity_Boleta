package pe.edu.upc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "boletas")
public class Boleta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBoleta;

	@NotNull(message = "La fecha es obligatoria")
	@Past(message = "La fecha debe ser pasada")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaBoleta;
	
	@Column(name = "montoTotal", length = 40, nullable = false)
	private float montoTotal;

	@Column(name = "igv", length = 40, nullable = false)
	private float igv;

	public Boleta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boleta(int idBoleta,Date fechaBoleta,float montoTotal, float igv) {
		super();
		this.idBoleta = idBoleta;
		this.fechaBoleta = fechaBoleta;
		this.montoTotal = montoTotal;
		this.igv = igv;
	}

	public int getIdBoleta() {
		return idBoleta;
	}

	public void setIdBoleta(int idBoleta) {
		this.idBoleta = idBoleta;
	}

	public Date getFechaBoleta() {
		return fechaBoleta;
	}

	public void setFechaBoleta(Date fechaBoleta) {
		this.fechaBoleta = fechaBoleta;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public float getIgv() {
		return igv;
	}

	public void setIgv(float igv) {
		this.igv = igv;
	}
	
		
}
