package pe.com.empresa.rk.service.impl;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.empresa.rk.domain.model.repository.jdbc.VacacionEmpleadoRepository;
import pe.com.empresa.rk.domain.model.repository.jpa.EmpleadoJpaRepository;
import pe.com.empresa.rk.domain.model.repository.jpa.PeriodoEmpleadoJpaRepository;
import pe.com.empresa.rk.domain.model.repository.jpa.VacacionJpaRepository;
import pe.com.empresa.rk.service.VacacionService;
import pe.com.empresa.rk.view.model.QuickFilterViewModel;
import pe.com.empresa.rk.view.model.VacacionResultViewModel;
import pe.com.empresa.rk.domain.model.entities.PeriodoEmpleado;
import pe.com.empresa.rk.domain.model.entities.Vacacion;
import pe.com.empresa.rk.view.model.NotificacionViewModel;
import pe.com.empresa.rk.view.model.VacacionFilterViewModel;
import pe.com.empresa.rk.view.model.VacacionViewModel;

@Service
public class VacacionServiceImpl implements VacacionService {

	@Autowired
    VacacionEmpleadoRepository vacacionEmpleadoRepository;
	
	@Autowired
    VacacionJpaRepository vacacionJpaRepository;
	
	@Autowired
    EmpleadoJpaRepository empleadoJpaRepository;
	
	@Autowired
    PeriodoEmpleadoJpaRepository periodoEmpleadoJpaRepository;
	
	@Autowired
	Mapper mapper;
	
	

	@Override
	public List<VacacionResultViewModel> search(VacacionFilterViewModel filterViewModel) {
		
		return vacacionEmpleadoRepository.busquedaVacacionesEmpleado(filterViewModel);
	}

	@Override
	public VacacionViewModel findOne(Long id) {
		// TODO Auto-generated method stub
		Vacacion vacacion=vacacionJpaRepository.findOne(id);
		VacacionViewModel vacacionViewModel=new VacacionViewModel();
		mapper.map(vacacion,vacacionViewModel);
		PeriodoEmpleado periodo=periodoEmpleadoJpaRepository.findOne(vacacion.getPeriodoEmpleado().getIdPeriodoEmpleado());
		vacacionViewModel.setIdEmpleado(periodo.getEmpleado().getIdEmpleado());
		String estado=vacacionViewModel.getEstado();
		String estadoDescripcion="";
		switch (estado) {
		case "P" :estadoDescripcion="Pendiente"; break;
		case "E" :estadoDescripcion="Enviado"; break;
		case "A" :estadoDescripcion="Aprobado"; break;
		case "R" :estadoDescripcion="Denegado"; break;
		default: estadoDescripcion=""; break;
		}
		vacacionViewModel.setNombreJefeInmediato(vacacion.getEmpleado().getApellidoPaterno()+' '+vacacion.getEmpleado().getApellidoMaterno()+' '+vacacion.getEmpleado().getNombre());
		vacacionViewModel.setEstado(estadoDescripcion);
		vacacionViewModel.setIdPeriodoEmpleado(periodo.getIdPeriodoEmpleado());
		
		return vacacionViewModel;
	}

	@Override
	public NotificacionViewModel create(VacacionViewModel manteinanceViewModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotificacionViewModel update(VacacionViewModel manteinanceViewModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotificacionViewModel delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VacacionResultViewModel> quickSearch(QuickFilterViewModel quickFilter) {
		// TODO Auto-generated method stub
		return vacacionEmpleadoRepository.busquedaRapidaVacacionesEmpleado(quickFilter);
	}

}
