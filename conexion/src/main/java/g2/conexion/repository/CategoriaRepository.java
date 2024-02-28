package g2.conexion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import g2.conexion.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, String>{

}
