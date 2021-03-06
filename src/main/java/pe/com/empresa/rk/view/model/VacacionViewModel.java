package pe.com.empresa.rk.view.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import pe.com.empresa.rk.json.JsonDateSimpleDeserializer;
import pe.com.empresa.rk.json.JsonDateSimpleSerializer;

public class VacacionViewModel extends AuditingEntityViewModel {

	private Long idVacacion;
	private Long idEmpleado;
	private Long idPeriodoEmpleado;
	private Integer diasDisponibles;
	private Integer diasCalendarios;
	private Integer diasHabiles;
	private Long idJefeInmediato;
	private String estado;
	private String comentario;
	private String comentarioResolucion;
	
	@JsonSerialize(using=JsonDateSimpleSerializer.class)
	@JsonDeserialize(using=JsonDateSimpleDeserializer.class)
	private Date fechaInicio;
	
	@JsonSerialize(using=JsonDateSimpleSerializer.class)
	@JsonDeserialize(using=JsonDateSimpleDeserializer.class)
	private Date fechaFin;
	
	private String periodo;
	private String nombreEstado;
	private Long idAtendidoPor;
	private String jefeINmediato;
	private String nombreJefeInmediato;

	public Long getIdVacacion() {
		return idVacacion;
	}

	public void setIdVacacion(Long idVacacion) {
		this.idVacacion = idVacacion;
	}

	public Long getIdPeriodoEmpleado() {
		return idPeriodoEmpleado;
	}

	public void setIdPeriodoEmpleado(Long idPeriodoEmpleado) {
		this.idPeriodoEmpleado = idPeriodoEmpleado;
	}

	public Integer getDiasDisponibles() {
		return diasDisponibles;
	}

	public void setDiasDisponibles(Integer diasDisponibles) {
		this.diasDisponibles = diasDisponibles;
	}

	public Integer getDiasCalendarios() {
		return diasCalendarios;
	}

	public void setDiasCalendarios(Integer diasCalendarios) {
		this.diasCalendarios = diasCalendarios;
	}

	public Integer getDiasHabiles() {
		return diasHabiles;
	}

	public void setDiasHabiles(Integer diasHabiles) {
		this.diasHabiles = diasHabiles;
	}

	public Long getIdJefeInmediato() {
		return idJefeInmediato;
	}

	public void setIdJefeInmediato(Long idJefeInmediato) {
		this.idJefeInmediato = idJefeInmediato;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public Long getIdAtendidoPor() {
		return idAtendidoPor;
	}

	public void setIdAtendidoPor(Long idAtendidoPor) {
		this.idAtendidoPor = idAtendidoPor;
	}

	public String getJefeINmediato() {
		return jefeINmediato;
	}

	public void setJefeINmediato(String jefeINmediato) {
		this.jefeINmediato = jefeINmediato;
	}

	public String getComentarioResolucion() {
		return comentarioResolucion;
	}

	public void setComentarioResolucion(String comentarioResolucion) {
		this.comentarioResolucion = comentarioResolucion;
	}

	public String getNombreJefeInmediato() {
		return nombreJefeInmediato;
	}

	public void setNombreJefeInmediato(String nombreJefeInmediato) {
		this.nombreJefeInmediato = nombreJefeInmediato;
	}
	
	
	
}
