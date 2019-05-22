package tutorial.ejemplo.servicio;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutorial.ejemplo.bean.MascotasModelo;
import tutorial.ejemplo.repositorio.MascotasRepositorio;

@Service
public class MascotasServiceImple implements MascotasService {
	@Autowired
	private MascotasRepositorio repository;

	@Autowired
	private Mascotas2Service service2;

	private int contadorNombres = 0;

	@Override
	public MascotasModelo findById(ObjectId _id) {
		return service2.comprobarId(_id);
	}

	@Override
	public List<MascotasModelo> findAll() {
		return repository.findAll();
	}

	@Override
	public List<MascotasModelo> findByNombre(String nombre) {
		return repository.findBynombre(nombre);
	}

	@Override
	public List<MascotasModelo> findByNombreAndEspecie(String especie, String mezcla) {
		return repository.findByEspecieAndMezcla(especie, mezcla);
	}

	@Override
	public MascotasModelo createMascota(MascotasModelo mascota) {
		mascota.set_id(ObjectId.get());
		service2.comprobarExistencia(mascota);
		repository.save(mascota);
		return mascota;

	}

	@Override
	public void deleteMascota(ObjectId _id) {
		service2.comprobarBorrarMascota(_id);
	}

	public String comprobarNombre(String nombre) {
		List<MascotasModelo> mascota = repository.findBynombre(nombre);
		for (int i = 0; i < mascota.size(); i++) {
			if (mascota.get(i).getName().equals("spoot")) {
				contadorNombres++;
			}
		}
		return contador(contadorNombres);

	}

	private String contador(int contadorNombres) {
		if (contadorNombres < 2) {
			return "Hay un animal llamado spoot";
		} else {
			return "Hay " + contadorNombres + " animales que se llaman spoot.";
		}
	}
}
