package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import controlador.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import modelo.dto.Mascota;

public class MascotaDAO {
	// Coordinador miCoordinador;
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

	public String registrarMascota(Mascota miMascota) {
		System.out.println("entre a mascotadao");

		entityManager.getTransaction().begin();
		entityManager.persist(miMascota);
		entityManager.getTransaction().commit();

		String resp = "Mascota Registrada";

		return resp;
	}

	public Mascota consultarMascota(Long idMascota) {

		Mascota miMascota = entityManager.find(Mascota.class, idMascota);

		if (miMascota != null) {
			return miMascota;
		} else {
			return null;
		}

	}

	public List<Mascota> consultarListaMascotas() {

		List<Mascota> listaMascotas = new ArrayList<Mascota>();
		Query query = entityManager.createQuery("SELECT m FROM Mascota m");
		listaMascotas = query.getResultList();

		return listaMascotas;
	}

	public List<Mascota> consultarListaMascotasPorSexo(String sexo) {

		List<Mascota> listaMascotas = new ArrayList<Mascota>();
		String sentencia = "SELECT m FROM Mascota m WHERE m.sexo= :sexoMascota";
		Query query = entityManager.createQuery(sentencia);
		query.setParameter("sexoMascota", sexo);
		listaMascotas = query.getResultList();

		return listaMascotas;
	}




	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}

	/*public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;

	}*/

}