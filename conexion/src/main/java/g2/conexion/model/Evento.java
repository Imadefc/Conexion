package g2.conexion.model;

import java.util.Date;
import java.util.Set;
import java.util.StringJoiner;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Evento {

	@Id
	@GeneratedValue
	private Integer id;
	private String nombre, descripcion, hora;
	private Date date;
	private int nplazas, precio;
	
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private Persona creador;
	
	@ManyToMany
	@JoinTable(name = "EVENTOS_PARTICIPANTES",
		joinColumns = @JoinColumn(name = "PARTICIPANTES_ID", nullable = false, updatable = false),
		inverseJoinColumns = @JoinColumn(name = "EVENTOS_ID", nullable = false, updatable = false),
		foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
		inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private Set<Persona> participantes;
	
	public Evento() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNplazas() {
		return nplazas;
	}

	public void setNplazas(int nplazas) {
		this.nplazas = nplazas;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Persona getCreador() {
		return creador;
	}

	public void setCreador(Persona creador) {
		this.creador = creador;
	}

	public Set<Persona> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<Persona> participantes) {
		this.participantes = participantes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((creador == null) ? 0 : creador.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + nplazas;
		result = prime * result + ((participantes == null) ? 0 : participantes.hashCode());
		result = prime * result + precio;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (creador == null) {
			if (other.creador != null)
				return false;
		} else if (!creador.equals(other.creador))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nplazas != other.nplazas)
			return false;
		if (participantes == null) {
			if (other.participantes != null)
				return false;
		} else if (!participantes.equals(other.participantes))
			return false;
		if (precio != other.precio)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringJoiner sb = new StringJoiner("\n");
		String aux = null;
		sb.add("Nombre evento: "+nombre);
		sb.add("Hora: "+hora);
		aux = date == null?"sin programar":date.toString();
		sb.add("Fecha: "+aux);
		sb.add("Precio: "+precio);
		sb.add("Descripción: "+descripcion);
		sb.add("Organizador: "+creador);
		return sb.toString();
	}
}
