package g2.conexion.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g2.conexion.model.Persona;
import g2.conexion.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository personaRepository;
	
	public List<Persona> getAll() {
		return personaRepository.findAll();
	}

	public int save(Persona p) {
		//System.out.println("he llegado a save" + p.getTipos());
		int i=0;
		if(comprobar(p)==false) {
			personaRepository.saveAndFlush(p);
			//System.out.println("se ha guardado" + p.getTipos());
			i=1;
		}
		return i;
	}
	private Boolean comprobar(Persona a) {
		Boolean ok=false;
		List<Persona> lis= personaRepository.findAll();
		Iterator<Persona> it = lis.iterator();
		
		if(a.getNombre().equalsIgnoreCase("") ||
				a.getApellidos().equalsIgnoreCase("") ||
				a.getContraseña().length()<6) {
			ok=true;	
			
		}
		while(it.hasNext() && ok!=true) {
			Persona n = it.next();
			if(n.getNombre().equalsIgnoreCase(a.getNombre())) {
				ok=true;
			}
		}
		return ok;
	}
	
	public int login(Persona p) {
		//boolean ok = false;
		int ok = -1;
		List<Persona> per = personaRepository.findAll();
		Iterator<Persona> it = per.iterator();
		
		boolean salir = false;
		Persona us = null;
		while(!salir && it.hasNext()) {
			us = it.next();
			if(p.getNombre().equals(us.getNombre())){
				if(p.getContraseña().equals(us.getContraseña())) {
					ok = us.getId();
				}
				salir = true;
			}
		}
		return ok;
	}

	public void delete(Integer id) {
		personaRepository.deleteById(id);
	}

	public Persona getById(Integer id) {
		return personaRepository.getOne(id);
	}
	
}
