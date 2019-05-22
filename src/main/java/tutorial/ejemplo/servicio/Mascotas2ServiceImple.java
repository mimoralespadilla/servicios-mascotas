package tutorial.ejemplo.servicio;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tutorial.ejemplo.bean.MascotasModelo;
import tutorial.ejemplo.repositorio.MascotasRepositorio;

@Service
public class Mascotas2ServiceImple implements Mascotas2Service {

	@Autowired
	private MascotasRepositorio repository;

	@Override
	public MascotasModelo comprobarId(ObjectId _id) throws NullPointerException {

		if (repository.findBy_id(_id) == null) {
			throw new NullPointerException("El valor es nulo.");
		} else {
			return repository.findBy_id(_id);
		}
	}

	@Override
	public void comprobarBorrarMascota(ObjectId _id) throws NullPointerException {
		if (repository.findBy_id(_id) == null) {
			throw new NullPointerException("El valor es nulo.");
		} else {
			repository.delete(repository.findBy_id(_id));
		}
	}

	@Override
	public MascotasModelo comprobarExistencia(MascotasModelo mascota) {
		if (mascota.getEdad() > 7) {
			mascota.setVenta("Adopción");
			return mascota;
		} else {
			mascota.setVenta("Si");
			return mascota;
		}
	}
}
