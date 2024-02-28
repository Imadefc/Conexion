package g2.conexion.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	
	@Id
	private String nombre;

	@ManyToMany
	@JoinTable(name = "TIPOS_USUARIOS",
		joinColumns = @JoinColumn(name = "USUARIOS_ID", nullable = false, updatable = false),
		inverseJoinColumns = @JoinColumn(name = "TIPOS_NOMBRE", nullable = false, updatable = false),
		foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
		inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private List<Persona> usuarios;
	
	@OneToMany (mappedBy = "categoria", cascade= {CascadeType.REMOVE})
	private List<Evento> eventos;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Persona> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Persona> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventos == null) ? 0 : eventos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
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
		Categoria other = (Categoria) obj;
		if (eventos == null) {
			if (other.eventos != null)
				return false;
		} else if (!eventos.equals(other.eventos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

	@Override
	public String toString() {
			return nombre;
	}
}
