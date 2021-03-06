package pe.com.empresa.rk.service;

import java.util.List;

import pe.com.empresa.rk.view.model.EmpleadoFilterViewModel;
import pe.com.empresa.rk.view.model.EmpleadoResultViewModel;
import pe.com.empresa.rk.view.model.HorasExtraEmpleadoFilterViewModel;
import pe.com.empresa.rk.view.model.MarcacionFilterViewModel;
import pe.com.empresa.rk.view.model.VacacionesEmpleadoFilterViewModel;
import pe.com.empresa.rk.view.model.DependienteViewModel;
import pe.com.empresa.rk.view.model.DocumentoEmpleadoViewModel;
import pe.com.empresa.rk.view.model.EducacionViewModel;
import pe.com.empresa.rk.view.model.EmpleadoViewModel;
import pe.com.empresa.rk.view.model.EquipoEntregadoViewModel;
import pe.com.empresa.rk.view.model.ExperienciaLaboralViewModel;
import pe.com.empresa.rk.view.model.HistoriaLaboralViewModel;
import pe.com.empresa.rk.view.model.HistorialLaboralViewModel;
import pe.com.empresa.rk.view.model.HorarioEmpleadoDiaViewModel;
import pe.com.empresa.rk.view.model.HorarioEmpleadoViewModel;
import pe.com.empresa.rk.view.model.HorasExtraViewModel;
import pe.com.empresa.rk.view.model.LicenciaViewModel;
import pe.com.empresa.rk.view.model.MarcacionViewModel;
import pe.com.empresa.rk.view.model.NotificacionViewModel;
import pe.com.empresa.rk.view.model.PeriodoEmpleadoViewModel;
import pe.com.empresa.rk.view.model.PermisoEmpleadoViewModel;
import pe.com.empresa.rk.view.model.QuickFilterViewModel;
import pe.com.empresa.rk.view.model.VacacionEmpleadoViewModel;

public interface EmpleadoService extends MaintenanceService<EmpleadoFilterViewModel,EmpleadoResultViewModel,EmpleadoViewModel,NotificacionViewModel, Long>,
QuickSearchService<EmpleadoResultViewModel, QuickFilterViewModel>{

	NotificacionViewModel actualizarDatosPersonales(EmpleadoViewModel empleado);
	List<HistoriaLaboralViewModel> obtenerHistoriaLaboral(Long idEmpleado);
	List<HistoriaLaboralViewModel> obtenerIdHistoriaLaboral(Long idHistorialLaboral);
	List<EmpleadoResultViewModel> busquedaEmpleado(EmpleadoFilterViewModel busquedaEmpleadoDto);
	List<MarcacionViewModel> busquedaMarcacionesEmpleado(MarcacionFilterViewModel busquedaMarcacionDto);
	List<DocumentoEmpleadoViewModel> verDocumentos(Long idEmpleado);
	List<EducacionViewModel> verEducacion(Long idEmpleado);
	List<ExperienciaLaboralViewModel> verExperienciaLaboral(Long idEmpleado);
	List<EquipoEntregadoViewModel> verEquipoEntregado(Long idEmpleado);
	List<DependienteViewModel> verDependiente(Long idEmpleado);
	List<LicenciaViewModel> verLicencia(PeriodoEmpleadoViewModel periodoEmpleado);
	List<EmpleadoViewModel> procesarMasivamenteEmpleados(List<EmpleadoViewModel> dtos);
	Long processDataUpdateEmpleado(EmpleadoViewModel dto)  throws Exception;
	HorarioEmpleadoViewModel verHorarioEmpleado(Long idEmpleado);
	List<HorarioEmpleadoDiaViewModel> obtenerHorarioEmpleadoDiasPorHorarioEmpleado(HorarioEmpleadoViewModel horarioEmpleadoDto);
	List<PeriodoEmpleadoViewModel> verPeriodoEmpleado(Long idEmpleado);
	List<PermisoEmpleadoViewModel> verPermisoEmpleado(PeriodoEmpleadoViewModel periodoEmpleado);
	List<VacacionEmpleadoViewModel> verVacacion(PeriodoEmpleadoViewModel periodoEmpleado);
	NotificacionViewModel eliminarPermisoEmpleado(Long idPermisoEmpleado);
    List<PermisoEmpleadoViewModel> obtenerCodigoPermiso(String codigo);
	List<VacacionEmpleadoViewModel> busquedaVacacionesEmpleado(VacacionesEmpleadoFilterViewModel busquedaVacacionesEmpleadoDto);
	List<MarcacionViewModel> verMarcacion(Long idEmpleado);
	List<HorasExtraViewModel> busquedaHorasExtrasEmpleado(HorasExtraEmpleadoFilterViewModel busquedaHorasExtraEmpleadoDto);
	HorasExtraViewModel informacionAdicionalHorasExtras(EmpleadoViewModel empleado);
	NotificacionViewModel registrarHorasExtra(HorasExtraViewModel horasExtraDto);
	List<EquipoEntregadoViewModel> obtenerEquiposPendientesDevolucion(Long idEmpleado);
	NotificacionViewModel countEquiposPendientesDevolucion(EmpleadoViewModel empleadoDto);
	List<HorarioEmpleadoViewModel> verHorariosEmpleado(Long idEmpleado);
	NotificacionViewModel registrarDarBajaEmpleado(EmpleadoViewModel empleado);
	NotificacionViewModel eliminarHorasExtra(Long idHorasExtra);
	NotificacionViewModel rechazarHorasExtra(HorasExtraViewModel horasExtraDto);
	NotificacionViewModel aprobarHorasExtra(HorasExtraViewModel horasExtraDto);
	List<EmpleadoViewModel> searchExport(EmpleadoFilterViewModel filterViewModel);
	EmpleadoViewModel findOneAccessJwtToken(Long idEmpleado);
	HistorialLaboralViewModel obtenerHistorialLaboralById(Long idHistorialLaboral);

	NotificacionViewModel registrarFotoEmpleado(EmpleadoViewModel empleado);
	
	EmpleadoViewModel obtenerEmpleadoEsPersonalConfianza(Long idEmpleado);
	
	EmpleadoViewModel obtenerEmpleadoCabecera(Long id);
}
