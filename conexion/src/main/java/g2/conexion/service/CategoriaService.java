package g2.conexion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g2.conexion.model.Categoria;
import g2.conexion.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAll(){
		return categoriaRepository.findAll();
	}
	
	public void save(Categoria c) {
		categoriaRepository.saveAndFlush(c);
	}

	public void delete(String nombre) {
		categoriaRepository.deleteById(nombre);
	}

	public Categoria getById(String nombre) {
		return categoriaRepository.getOne(nombre);
	}
}
