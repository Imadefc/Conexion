package g2.conexion.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Persona {

	@Id
	@GeneratedValue
	private Integer id;
	private String nombre, apellidos, contraseña, email;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date nacimiento;
	private String biografia;
	
	@ManyToMany
	@JoinTable(name = "TIPOS_USUARIOS",
		inverseJoinColumns = @JoinColumn(name = "USUARIOS_ID", nullable = false, updatable = false),
		joinColumns = @JoinColumn(name = "TIPOS_NOMBRE", nullable = false, updatable = false),
		foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
		inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private List<Categoria> tipos;
	
	@OneToMany (mappedBy = "creador", cascade= {CascadeType.REMOVE})
	private List<Evento> eventosCreados;
	
	@ManyToMany
	@JoinTable(name = "EVENTOS_PARTICIPANTES",
		inverseJoinColumns = @JoinColumn(name = "PARTICIPANTES_ID", nullable = false, updatable = false),
		joinColumns = @JoinColumn(name = "EVENTOS_ID", nullable = false, updatable = false),
		foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
		inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
	private List<Evento> eventos;
	
	public Persona() {
		
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public List<Categoria> getTipos() {
		return tipos;
	}

	public void setTipos(List<Categoria> tipos) {
		this.tipos = tipos;
	}

	public List<Evento> getEventosCreados() {
		return eventosCreados;
	}

	public void setEventosCreados(List<Evento> eventosCreados) {
		this.eventosCreados = eventosCreados;
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
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((biografia == null) ? 0 : biografia.hashCode());
		result = prime * result + ((contraseña == null) ? 0 : contraseña.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((eventos == null) ? 0 : eventos.hashCode());
		result = prime * result + ((eventosCreados == null) ? 0 : eventosCreados.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nacimiento == null) ? 0 : nacimiento.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tipos == null) ? 0 : tipos.hashCode());
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
		Persona other = (Persona) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (biografia == null) {
			if (other.biografia != null)
				return false;
		} else if (!biografia.equals(other.biografia))
			return false;
		if (contraseña == null) {
			if (other.contraseña != null)
				return false;
		} else if (!contraseña.equals(other.contraseña))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (eventos == null) {
			if (other.eventos != null)
				return false;
		} else if (!eventos.equals(other.eventos))
			return false;
		if (eventosCreados == null) {
			if (other.eventosCreados != null)
				return false;
		} else if (!eventosCreados.equals(other.eventosCreados))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nacimiento == null) {
			if (other.nacimiento != null)
				return false;
		} else if (!nacimiento.equals(other.nacimiento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipos == null) {
			if (other.tipos != null)
				return false;
		} else if (!tipos.equals(other.tipos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nombre + " " + apellidos;
	}
	
}
