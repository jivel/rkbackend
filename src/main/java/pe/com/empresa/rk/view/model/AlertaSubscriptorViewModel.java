package pe.com.empresa.rk.view.model;

/**
 * Created by josediaz on 14/12/2016.
 */
public class AlertaSubscriptorViewModel extends AuditingEntityViewModel {

    private Long idAlertaSubscriptor;
	private Long idAlerta;
    private Long idEmpleado;
    private String nombreEmpleado;
    
    

    public Long getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(Long idAlerta) {
        this.idAlerta = idAlerta;
    }

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Long getIdAlertaSubscriptor() {
		return idAlertaSubscriptor;
	}

	public void setIdAlertaSubscriptor(Long idAlertaSubscriptor) {
		this.idAlertaSubscriptor = idAlertaSubscriptor;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	

   
}
