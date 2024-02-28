package g2.conexion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import g2.conexion.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
