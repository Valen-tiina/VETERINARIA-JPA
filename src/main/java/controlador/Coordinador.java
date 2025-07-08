package controlador;

import java.util.List;

import modelo.dao.MascotaDAO;
import modelo.dto.Mascota;
import vistas.VistaPrincipal;

public class Coordinador {
	private VistaPrincipal vistaPrincipal;
	private MascotaDAO mascotaDAO;
	private Procesos procesos;
	
	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}
	public void setMascotaDAO(MascotaDAO mascotaDAO) {
		this.mascotaDAO = mascotaDAO;
	}
	
	public void mostrarVista() {
		vistaPrincipal.setVisible(true);
	}
	public void setProcesos(Procesos procesos) {
		this.procesos=procesos;
	}
	
	
	public String registro(Mascota mascota) {
		return mascotaDAO.registrarMascota(mascota);
	}
	public Mascota consulta(Long idMascota) {
		return mascotaDAO.consultarMascota(idMascota);
	}
	public List<Mascota> lista(){
		return mascotaDAO.consultarListaMascotas();
	}
	public List<Mascota> listaSexo(String sexo){
		return mascotaDAO.consultarListaMascotasPorSexo(sexo);
	}
	public String actualizar(Mascota mascota) {
		return mascotaDAO.actualizar(mascota);
	}
	public String eliminar(Mascota mascota) {
		return mascotaDAO.eliminar(mascota);
	}
	
	//validations
	public boolean validarTextoMascota(String texto) {
		return procesos.validarTexto(texto);
	}

}
