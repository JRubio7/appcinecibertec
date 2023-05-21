package pe.edu.cibertec.appcinecibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.appcinecibertec.model.request.SalaRequest;
import pe.edu.cibertec.appcinecibertec.model.response.ResultadoResponse;
import pe.edu.cibertec.appcinecibertec.service.SalaService;

@Controller
@RequestMapping("/sala")
public class SalaController {
	
	@Autowired
	private SalaService salaService;
	
	@GetMapping("/frmsala")
	public String frmMantSala(Model model) {
		
		model.addAttribute("listaEstado", salaService.listarSala());
		return "Estado/frmMantEstado";
	}
	
	@PostMapping("/registrarSala")
	@ResponseBody //indica que va a devolver un objeto cualquiera menos un string
	public ResultadoResponse registrarSala(
			@RequestBody SalaRequest salaRequest
			){
		
		return null;
	}

}
