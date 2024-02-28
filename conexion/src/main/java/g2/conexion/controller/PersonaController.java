package g2.conexion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import g2.conexion.model.Persona;
import g2.conexion.service.CategoriaService;
import g2.conexion.service.PersonaService;

@Controller
public class PersonaController {
	
	private static Integer id; 
	
	@Autowired
	PersonaService personaService;
	@Autowired
	CategoriaService categoriaService;
	
	public static Integer getId() {
		return id;
	}

	@RequestMapping("/personas")
	public String listadoPersonas(Model model) {
		List<Persona> personas = personaService.getAll();
		
		model.addAttribute("listaPersonas", personas);
		
		return "personas/index";
	}
	
	@RequestMapping("/personas/add")
	public String addPersona(Model model) {
		model.addAttribute("persona", new Persona());
		model.addAttribute("listaCategorias", categoriaService.getAll());
		return "personas/add";
	}
	
	@PostMapping("/personas/save")
	public String savePersona(Persona p) {
		/*int i=personaService.save(p);
		String l ="";
		if(i==0) {
			l+="/personas/add";
		}else if(i==1) {
			l+="/index";
		}
		return l;*/
		personaService.save(p);
		return "redirect:/personas";
	}
	
	@RequestMapping("/personas/edit/{id}")
	public String editPersona(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("persona", personaService.getById(id));
		return "personas/add";
	}
	
	@RequestMapping("/personas/view/{id}")
	public String viewPersona(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("persona", personaService.getById(id));
		return "personas/view";
	}
	
	@RequestMapping("/personas/delete/{id}")
	public String deletePersona(@PathVariable("id") Integer id) {
		personaService.delete(id);
		return "redirect:/personas"; 
	}
	
	@RequestMapping("/personas/login")
	public String login(Model model) {
		model.addAttribute("persona", new Persona());
		return "personas/login";
	}
	
	@PostMapping("/personas/comp")
	public String compPersona(Persona p) {
		//boolean ok = personaService.login(p);
		id = personaService.login(p);
		String dir = " ";
		if(id>0) {
			dir = "redirect:/personas/view/"+id;
		} else {
			dir = "/personas/login";
			id = null;
		}
		return dir;
	}
}
