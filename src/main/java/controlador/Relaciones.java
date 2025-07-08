package controlador;

import modelo.dao.MascotaDAO;
import vistas.VistaPrincipal;

public class Relaciones {
	public Relaciones() {
		VistaPrincipal vistaPrincipal = new VistaPrincipal();
		MascotaDAO mascotaDAO = new MascotaDAO();
		Coordinador coordinador = new Coordinador();
		Procesos procesos = new Procesos();
		
		vistaPrincipal.setCoordinador(coordinador);
		mascotaDAO.setCoordinador(coordinador);
		procesos.setCoordinador(coordinador);
		
		coordinador.setMascotaDAO(mascotaDAO);
		coordinador.setVistaPrincipal(vistaPrincipal);
		coordinador.setProcesos(procesos);
		coordinador.mostrarVista();
	}
}
