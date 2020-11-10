package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name= "opiniones")
public class Opinion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOpinion;
	@NotNull(message = "El campo es obligatorio")
	
	@Column(name = "calificacion", length = 40, nullable = false)
	private String calificacion;
	
	@NotNull(message = "El campo es obligatorio")
	@Column(name = "opinion", length = 40, nullable = false)
	@Min(value = 1, message = "La calificacion varia entre 1 y 5")
	@Max(value = 5, message = "La calificacion varia entre 1 y 5")
	private int opinion;
	
	

	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "idLocal")
	private Local local;
	
	@ManyToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	public Opinion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Opinion(int idOpinion,String calificacion, int opinion,
			Cliente cliente, Local local, Product product) {
		super();
		this.idOpinion = idOpinion;
		this.calificacion = calificacion;
		this.opinion = opinion;
		this.cliente = cliente;
		this.local = local;
		this.product = product;
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

	public int getOpinion() {
		return opinion;
	}

	public void setOpinion(int opinion) {
		this.opinion = opinion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
