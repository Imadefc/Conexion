package g2.conexion.service;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g2.conexion.model.Evento;
import g2.conexion.model.Persona;
import g2.conexion.repository.EventoRepository;
import g2.conexion.repository.PersonaRepository;

@Service
public class EventoService {

	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	PersonaRepository personaRepository;
	
	public List<Evento> getAll() {
		return eventoRepository.findAll();
	}

	public void save(Evento e) {
		eventoRepository.saveAndFlush(e);
	}
	
	public void delete(Integer id) {
		eventoRepository.deleteById(id);
	}
	
	public Evento getById(Integer id) {
		return eventoRepository.getOne(id);
	}

	public boolean participar(Integer id, Integer perId) {
		List<Evento> e = eventoRepository.findAll();
		//System.out.println("Que id tiene "+id);
		Iterator<Evento> it = e.iterator();
		boolean encontrado = false;
		Evento ras = null;
		while(it.hasNext() && !encontrado) {
			ras = it.next();
			if(ras.getId().equals(id)) {
				//System.out.println("He entrado");
				encontrado = true;
				if(ras.getNplazas()>0) {
					ras.getParticipantes().add(buscarPersona(perId));
					//System.out.println("Participantes: "+ras.getParticipantes());
					ras.setNplazas(ras.getNplazas()-1);
					eventoRepository.saveAndFlush(ras);
				}
			}
		}
		return encontrado;
	}

	public Persona buscarPersona(Integer id) {
		List<Persona> per = personaRepository.findAll();
		Iterator<Persona> it = per.iterator();
		boolean encontrado = false;
		Persona ras = null;
		while(it.hasNext() && !encontrado) {
			ras = it.next();
			if(ras.getId()==id) {
				encontrado = true;
			}
		}
		return ras;
	}
	
}
