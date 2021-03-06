package pe.com.empresa.rk.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.com.empresa.rk.service.DepartamentoService;
import pe.com.empresa.rk.service.ProvinciaService;
import pe.com.empresa.rk.view.model.DistritoViewModel;
import pe.com.empresa.rk.view.model.DepartamentoViewModel;
import pe.com.empresa.rk.view.model.PaisViewModel;
import pe.com.empresa.rk.view.model.ProvinciaViewModel;
import pe.com.empresa.rk.service.DistritoService;
import pe.com.empresa.rk.service.PaisService;

@RestController
@RequestMapping(value="/api/pais")
@CrossOrigin()
public class PaisController extends BaseController{

	@Autowired
	PaisService paisService;
	
	@Autowired
    DepartamentoService departamentoService;
	
	@Autowired
    ProvinciaService provinciaService;
	
	@Autowired
	DistritoService distritoService;
	
	private List<PaisViewModel> resultList = new ArrayList<>();

	@RequestMapping(value = "/obtenerPaises", method = RequestMethod.GET)
	public @ResponseBody List<PaisViewModel> obtenerPaises() {
		
		resultList = paisService.obtenerPaises();
		return resultList;
	}
	
	@RequestMapping(value = "/obtenerDepartamentos", method = RequestMethod.GET)
	public @ResponseBody List<DepartamentoViewModel> obtenerDepartamentos(@RequestParam(name="codigoPais")  String codigoPais) {
		List<DepartamentoViewModel> result = null;
		result = departamentoService.obtenerDepartamentosPorPais(codigoPais);
		if(result == null)
			result = new ArrayList<>();
		return result;
	}
	
	@RequestMapping(value = "/obtenerProvincias", method = RequestMethod.GET)
	public @ResponseBody List<ProvinciaViewModel> obtenerProvincias(@RequestParam(name="codigoDpto")  String codigoDpto) {
		List<ProvinciaViewModel> result = null;
		result = provinciaService.obtenerProvinciasPorDepartamento(codigoDpto);
		if(result == null)
			result = new ArrayList<>();
		return result;
	}
	
	@RequestMapping(value = "/obtenerDistritos", method = RequestMethod.GET)
	public @ResponseBody List<DistritoViewModel> obtenerDistritos(@RequestParam(name="codigoProvincia")  String codigoProvincia) {
		List<DistritoViewModel> result = null;
		result = distritoService.obtenerDistritosPorProvincia(codigoProvincia);
		if(result == null)
			result = new ArrayList<>();
		return result;
	}
	
	
	
}
