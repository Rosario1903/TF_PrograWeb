package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "opiniones")
public class Opinion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOpinion;
		
	@Column(name = "calificacion", length = 40, nullable = false)
	private String calificacion;

	@Column(name = "opinion", length = 40, nullable = false)
	private String opinion;
	
	@Column(name = "numProductos", length = 40, nullable = false)
	private float numProductos;

	public Opinion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Opinion(int idOpinion, String calificacion, String opinion, float numProductos) {
		super();
		this.idOpinion = idOpinion;
		this.calificacion = calificacion;
		this.opinion = opinion;
		this.numProductos = numProductos;
	}

	public int getIdOpinion() {
		return idOpinion;
	}

	public void setIdOpinion(int idOpinion) {
		this.idOpinion = idOpinion;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public float getNumProductos() {
		return numProductos;
	}

	public void setNumProductos(float numProductos) {
		this.numProductos = numProductos;
	}
	
	
	
}
