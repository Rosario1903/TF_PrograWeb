package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "ImportDetails")
public class ImportDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImportDetails;

	@ManyToOne
	@JoinColumn(name = "idProduct", nullable = true)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "idOferta", nullable = true)
	private Oferta oferta;
	
	@ManyToOne
	@JoinColumn(name = "idDescuento", nullable = true)
	private Descuento descuento;
	
	@ManyToOne
	@JoinColumn(name = "idLocal", nullable = true)
	private Local local;
	
	@ManyToOne
	@JoinColumn(name = "idCliente", nullable = true)
	private Cliente cliente;

	@Positive(message = "El monto debe de ser positivo")
	@Column(name = "quantity", nullable = false)
	private int quantity;

	public Double calcularSubTotal() {
		return  (product.getPriceProduct()*quantity) - calculardescuento();
	}
	
	public Double calcularIGV() {
		return calcularSubTotal()*0.18;
	}
	
	public Double calculardescuento() {
	return descuento.getPreDescuento() * quantity;
	}


	public Long getIdImportDetails() {
		return idImportDetails;
	}

	public void setIdImportDetails(Long idImportDetails) {
		this.idImportDetails = idImportDetails;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public Descuento getDescuento() {
	return descuento;
	}

	public void setDescuento(Descuento descuento) {
	this.descuento = descuento;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
