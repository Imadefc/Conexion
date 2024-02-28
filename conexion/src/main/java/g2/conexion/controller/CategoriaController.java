package g2.conexion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import g2.conexion.model.Categoria;
import g2.conexion.service.CategoriaService;

@Controller
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@RequestMapping("/categorias")
	public String listadoCategorias(Model model) {
		List<Categoria> tipos = categoriaService.getAll();
		
		model.addAttribute("listaCategorias", tipos);
		
		return "categorias/index";
	}
	
	@RequestMapping("/categorias/view/{id}")
	public String viewCategoria(@PathVariable("id") String id, Model model) {
		model.addAttribute("categoria", categoriaService.getById(id));
		return "categorias/view";
	}
	
	@RequestMapping("/categorias/add")
	public String addCategoria(Model model) {
		model.addAttribute("tipo", new Categoria());
		return "categorias/add";
	}
	
	@PostMapping("/categorias/save")
	public String saveCategoria(Categoria c) {
		categoriaService.save(c);
		return "redirect:/categorias";
	}

}
