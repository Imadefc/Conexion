package g2.conexion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import g2.conexion.model.Evento;
import g2.conexion.service.CategoriaService;
import g2.conexion.service.EventoService;


@Controller
public class EventoController {

	@Autowired
	EventoService eventoService;
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("/eventos")
	public String listadoEventos(Model model) {
		List<Evento> eventos = eventoService.getAll();
		model.addAttribute("listaEventos", eventos);
		
		return "eventos/index";
	}
	
	@RequestMapping("/eventos/add")
	public String addEvento(Model model) {
		model.addAttribute("evento", new Evento());
		model.addAttribute("listaCategorias", categoriaService.getAll());
		return "eventos/add";
	}
	
	@PostMapping("/eventos/save")
	public String saveEvento(Evento e) {
		e.setCreador(eventoService.buscarPersona(PersonaController.getId()));
		eventoService.save(e);
		return "redirect:/eventos";
	}
	
	@RequestMapping("/eventos/view/{id}")
	public String viewEvento(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("evento", eventoService.getById(id));
		return "eventos/view";
	}
	
	@RequestMapping("/eventos/delete/{id}")
	public String deleteEvento(@PathVariable("id") Integer id) {
		eventoService.delete(id);
		return "redirect:/eventos"; 
	}
	
	@RequestMapping("/eventos/edit/{id}")
	public String editEvento(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("evento", eventoService.getById(id));
		return "eventos/edit";
	}
	
	@RequestMapping("/eventos/participar")
	public String participarEvento(Evento e) {
		boolean ok = eventoService.participar(e.getId(), PersonaController.getId());
		String dir = " ";
		if(ok) {
			dir = "redirect:/eventos";
		} else {
			dir = "/eventos/personas";
		}
		return dir;
	}
}
