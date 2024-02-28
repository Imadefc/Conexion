package g2.conexion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import g2.conexion.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer>{

}
