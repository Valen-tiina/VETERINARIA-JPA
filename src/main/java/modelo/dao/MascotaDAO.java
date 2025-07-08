package modelo.dao;

import java.util.ArrayList;
import java.util.List;

import controlador.Coordinador;
import controlador.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import modelo.dto.Mascota;

public class MascotaDAO {
	 Coordinador coordinador;
	EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

	public String registrarMascota(Mascota miMascota) {
		System.out.println("en dao");

		entityManager.getTransaction().begin();
		entityManager.persist(miMascota);
		entityManager.getTransaction().commit();

		String resp = "ok";

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
	
	public String actualizar(Mascota miMascota) {
		entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		String res;
		
		try {
			entityManager.getTransaction().begin();
			
			Mascota actualPet = entityManager.find(Mascota.class, miMascota.getIdMascota());
			if (actualPet==null) {
				res = "no existe";
				return res;
			} else {
				actualPet.setColorMascota(miMascota.getColorMascota());
				actualPet.setIdMascota(miMascota.getIdMascota());
				actualPet.setNombre(miMascota.getNombre());
				actualPet.setRaza(miMascota.getRaza());
				actualPet.setSexo(miMascota.getSexo());
				
				entityManager.getTransaction().commit();
				res = "actualizado";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			res = "Error al actualizar la mascota: " + e.getMessage();		}
	finally {
		entityManager.close();
	} return res;
}
	
	public String eliminar(Mascota miMascota) {
		entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		String res;
		
		try {
			entityManager.getTransaction().begin();
			
			Mascota actualPet = entityManager.find(Mascota.class, miMascota.getIdMascota());
			if (actualPet == null) {
				res = "no existe";
			} else {
				entityManager.remove(actualPet);
				entityManager.getTransaction().commit();
				res = "se elimino la mascota";
			}
		} catch (Exception e) {
			e.printStackTrace();
			res = "error al eliminar";
		} finally {
			entityManager.close();
		}
		return res;
	}


	public void close() {
		entityManager.close();
		JPAUtil.shutdown();
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador =coordinador;

	}

}