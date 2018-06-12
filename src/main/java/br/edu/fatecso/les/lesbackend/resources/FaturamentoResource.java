package br.edu.fatecso.les.lesbackend.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecso.les.lesbackend.dto.FaturamentoDTO;
import br.edu.fatecso.les.lesbackend.resources.util.URL;
import br.edu.fatecso.les.lesbackend.services.FaturamentoService;

@RestController
@RequestMapping(value = "/faturamento")
public class FaturamentoResource {
	
	@Autowired
	private FaturamentoService service;
	
	@RequestMapping(value = "/total", method = RequestMethod.GET)
	public ResponseEntity<FaturamentoDTO> faturamentoTotal(
			@RequestParam(value = "inicio", defaultValue = "") String dataInicio,
			@RequestParam(value = "fim", defaultValue = "") String dataFim) {
		Date inicio = URL.convertDate(dataInicio, new Date(0L));
		Date fim = URL.convertDate(dataFim, new Date());
		FaturamentoDTO objDto = service.faturamentoTotal(inicio, fim);
		return ResponseEntity.ok().body(objDto);
	}
}
